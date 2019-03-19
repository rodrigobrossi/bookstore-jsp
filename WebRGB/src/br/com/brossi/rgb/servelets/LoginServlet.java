package br.com.brossi.rgb.servelets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	public LoginServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.processRequest(req, resp);
	}

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String login = req.getParameter("login");
		String password = req.getParameter("passwd");


		try (PrintWriter out = resp.getWriter()) {
			out.println("<html><head>");
			out.println("<title>RGB Login</title>");
			out.println("</head><body>");
			out.println("<h1>Confirmação de informação</h1>");
			out.println("<br>Login:"+login);
			out.println("<br>PWD:"+password);
			out.println("</body>"
					+ "</html>");
		} finally {
			//TODO Do something here.
		}
	}

}
