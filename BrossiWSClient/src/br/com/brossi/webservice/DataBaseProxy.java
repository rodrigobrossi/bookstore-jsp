package br.com.brossi.webservice;

public class DataBaseProxy implements br.com.brossi.webservice.DataBase {
  private String _endpoint = null;
  private br.com.brossi.webservice.DataBase dataBase = null;
  
  public DataBaseProxy() {
    _initDataBaseProxy();
  }
  
  public DataBaseProxy(String endpoint) {
    _endpoint = endpoint;
    _initDataBaseProxy();
  }
  
  private void _initDataBaseProxy() {
    try {
      dataBase = (new br.com.brossi.webservice.DataBaseServiceLocator()).getDataBase();
      if (dataBase != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)dataBase)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)dataBase)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (dataBase != null)
      ((javax.xml.rpc.Stub)dataBase)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.com.brossi.webservice.DataBase getDataBase() {
    if (dataBase == null)
      _initDataBaseProxy();
    return dataBase;
  }
  
  public java.lang.String fetchDriver(java.lang.String driver) throws java.rmi.RemoteException{
    if (dataBase == null)
      _initDataBaseProxy();
    return dataBase.fetchDriver(driver);
  }
  
  
}