package usf.controller.bookstore.login;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

import usf.model.bookstore.basic.ModelBasic;
import usf.model.bookstore.login.Login;
import usf.model.bookstore.login.LoginDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login/*")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private LoginDAO loginDAO = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/*
	 * Used to init LoginDAO object (non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#init()
	 */
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		String jdbcDriver = getServletContext().getInitParameter("jdbcDriver");

		loginDAO = new LoginDAO(jdbcURL, jdbcUsername, jdbcPassword, jdbcDriver);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

		String action = ((HttpServletRequest) request).getPathInfo();

		response.getWriter().append("Action taken: ").append(action);

		if (action == null) {
			return;
		}

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditUser(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			case "/list":
				listUser(request, response);
				break;
			default:
				defaultCommnad(request, response);
				break;
			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void defaultCommnad(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			
			String lgn = request.getParameter("login");
			String passwd = request.getParameter("password");
			
			Login login = new Login(lgn,passwd);
			
			
			if(loginDAO.authenticate(login)){
				
				Session session = (Session) request.getSession();
				session.getSession().setAttribute("auth", true);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/main.jsp");
				dispatcher.forward(request, response);
			}else{
				throw new Error("Whe were not able to login using login:"+login.getLogin()); 
			}
			
			
			response.getWriter().append("Served at: ").append("This will be the login action");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException {
		try {
			List<ModelBasic> listBook = loginDAO.listAll();
			request.setAttribute("listUsers", listBook);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/adm/login/LoginList.jsp");
			dispatcher.forward(request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException {
		try {
			
			int id = Integer.parseInt(request.getParameter("id"));
			String lgn = request.getParameter("login");
			String passwd = request.getParameter("passwd");
			int perm = Integer.parseInt(request.getParameter("perm"));

			Login login = new Login(id, lgn, passwd, perm);
			
			loginDAO.update(login);
			response.sendRedirect("list");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void showEditUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			ModelBasic existingUser = loginDAO.getRecord(id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/adm/login/LoginForm.jsp");
			request.setAttribute("login", existingUser);
			dispatcher.forward(request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			Login login = new Login(id);
			loginDAO.delete(login);
			response.sendRedirect("list");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException {
		try {

			String login = request.getParameter("login");
			String pwd = request.getParameter("passwd");
			int perm = Integer.parseInt(request.getParameter("perm"));

			Login newUser = new Login(login, pwd, perm);

			loginDAO.insert(newUser);
			
			response.sendRedirect("list");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/adm/login/LoginForm.jsp");
			dispatcher.forward(request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
