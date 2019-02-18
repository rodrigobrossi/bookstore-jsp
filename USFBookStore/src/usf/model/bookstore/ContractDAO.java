package usf.model.bookstore;

import java.sql.SQLException;
import java.util.List;

import usf.model.bookstore.basic.BasicDAO;
import usf.model.bookstore.basic.ModelBasic;

public class ContractDAO extends BasicDAO {

	public ContractDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		super(jdbcURL, jdbcUsername, jdbcPassword);
		// TODO Auto-generated constructor stub
	}

	public ContractDAO(String jdbcURL, String jdbcUsername, String jdbcPassword, String jdbcDriver) {
		super(jdbcURL, jdbcUsername, jdbcPassword, jdbcDriver);
		// TODO Auto-generated constructor stub
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
