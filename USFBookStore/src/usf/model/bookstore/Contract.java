package usf.model.bookstore;

import usf.model.bookstore.basic.ModelBasic;

public class Contract implements ModelBasic {
	
	private int id;
	
	private int clientId;
	
	private int bookId;

	@Override
	public int getId() {
		return this.id;
	}

	public Contract(int clientId, int bookId) {
		super();
		this.clientId = clientId;
		this.bookId = bookId;
	}

	public Contract(int id, int clientId, int bookId) {
		super();
		this.id = id;
		this.clientId = clientId;
		this.bookId = bookId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public void setId(int id) {
		this.id = id;
	} 
	
	
	

}
