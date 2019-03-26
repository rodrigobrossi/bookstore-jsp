import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(
		name="Soma",//Defines the WSDL port type. 
		serviceName="SomaService",// WSDL services
		targetNamespace="http://techtip.com/jaxws/sample")

public class Soma {

	public Soma(){}
	
	@WebMethod(operationName="add", action="urn:Add")
	public int add(int i , int j){
		int k = i+j; 
		System.out.println(i+ "+"+j +"="+k);
		return k;
	}
}
