package usf.model.bookstore;

import java.util.Map;

import usf.model.bookstore.basic.ModelBasic;

public class Client implements ModelBasic{

	private int id;
	private float price;
	private String firstName;
	private String lastName;
	private Map book;

	public Client(int id, float price, String firstName, String lastName, Map book) {
		super();
		this.id = id;
		this.price = price;
		this.firstName = firstName;
		this.lastName = lastName;
		this.book = book;
	}

	public Client(int id, float price, String firstName, String lastName) {
		super();
		this.id = id;
		this.price = price;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Client(float price, String firstName, String lastName) {
		super();
		this.price = price;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Map getBook() {
		return book;
	}

	public void setBook(Map book) {
		this.book = book;
	}

}
