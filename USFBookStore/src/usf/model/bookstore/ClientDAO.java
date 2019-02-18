package usf.model.bookstore;

import java.sql.SQLException;
import java.util.List;

import usf.model.bookstore.basic.BasicDAO;
import usf.model.bookstore.basic.ModelBasic;

public class ClientDAO extends BasicDAO{

	public ClientDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		super(jdbcURL, jdbcUsername, jdbcPassword);
	}

	@Override
	public boolean insert(ModelBasic model) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ModelBasic> listAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(ModelBasic model) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ModelBasic model) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ModelBasic getRecord(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
