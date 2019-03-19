package usf.model.bookstore.login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

import usf.model.bookstore.basic.BasicDAO;
import usf.model.bookstore.basic.ModelBasic;

/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table book in the database.
 * 
 * @author rbrossi
 *
 */
public class LoginDAO extends BasicDAO {

	public LoginDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		super(jdbcURL, jdbcUsername, jdbcPassword);
	}

	public LoginDAO(String jdbcURL, String jdbcUsername, String jdbcPassword, String jdbcDriver) {
		super(jdbcURL, jdbcUsername, jdbcPassword, jdbcDriver);

	}

	public boolean insert(ModelBasic model) throws SQLException {
		Login login = (Login) model;
		String sql = "INSERT INTO login (login, passwd, perm) VALUES (?, ?, ?)";
		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, login.getLogin());
		statement.setString(2, login.getPasswd());
		statement.setInt(3, login.getPermissions());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}

	public List<ModelBasic> listAll() throws SQLException {
		List<ModelBasic> listBook = new ArrayList<>();

		String sql = "SELECT * FROM login";

		connect();

		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			int id = resultSet.getInt("login_id");
			String log = resultSet.getString("login");
			String pwd = resultSet.getString("passwd");
			int perm = resultSet.getInt("perm");
			// Administration purposes
			Login login = new Login(id, log, pwd, perm);
			listBook.add((ModelBasic) login);
		}

		resultSet.close();
		statement.close();

		disconnect();

		return listBook;
	}

	public boolean delete(ModelBasic book) throws SQLException {
		String sql = "DELETE FROM login where login_id = ?";

		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, book.getId());

		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;
	}

	public boolean update(ModelBasic model) throws SQLException {
		// Cast elements
		Login login = (Login) model;

		String sql = "UPDATE login SET login = ?, passwd = ?, perm = ?";
		sql += " WHERE login_id = ?";
		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, login.getLogin());
		statement.setString(2, login.getPasswd());
		statement.setFloat(3, login.getPermissions());
		statement.setInt(4, login.getId());

		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;
	}

	public ModelBasic getRecord(String login, String passwd) throws SQLException, LoginException {
		Login lgn = null;

		String sql = "SELECT * FROM login WHERE login = ? and passwd = ? ";

		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, login);
		statement.setString(2, Login.getPassword(passwd, ILogin.SHA_256));

		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			int objId = resultSet.getInt("login_id");
			String objLogin = resultSet.getString("login");
			String objPwd = resultSet.getString("password");
			int objPerm = resultSet.getInt("perm");

			lgn = new Login(objId, objLogin, objPwd, objPerm);
		} else {
			throw new LoginException("Invalid login or password");
		}

		resultSet.close();
		statement.close();

		if (lgn == null) {
			throw new NullPointerException(
					"Was not possible to get the Login information, please contact your system administrator");
		}
		
		disconnect();
		return lgn;
	}

	@Override
	public ModelBasic getRecord(int id) throws SQLException {
		Login lgn = null;

		String sql = "SELECT * FROM login WHERE login_id = ?";

		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			int objId = resultSet.getInt("login_id");
			String objLogin = resultSet.getString("login");
			String objPwd = resultSet.getString("passwd");
			int objPerm = resultSet.getInt("perm");

			lgn = new Login(objId, objLogin, objPwd, objPerm);
		} else {
			try {
				throw new LoginException("Invalid login or password");
			} catch (LoginException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		resultSet.close();
		statement.close();

		if (lgn == null) {
			throw new NullPointerException(
					"Was not possible to get the Login information, please contact your system administrator");
		}

		return lgn;
	}
}