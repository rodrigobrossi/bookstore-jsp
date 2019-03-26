package br.com.brossi.webservice.client;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import br.com.brossi.webservice.DataBase;
import br.com.brossi.webservice.DataBaseServiceLocator;

public class DataBaseClient {

	public static void main(String[] args) {

		DataBaseServiceLocator locator = new DataBaseServiceLocator();

		DataBase dataBase;
		try {
			dataBase = locator.getDataBase();

			String results = dataBase.fetchDriver("Test");

			System.out.println("Results: " + results);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
