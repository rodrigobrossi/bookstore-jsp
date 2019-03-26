
import javax.xml.ws.WebServiceRef;

public class JAXWSClient {
	
	@WebServiceRef(wsdlLocation = "http://localhost:8080/axis/Soma.jws?wsdl")
	static SomaService sevice;

	public static void main(String[] args) {
		try {
			JAXWSClient client = new JAXWSClient();
			client.doTest(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doTest(String[] args) {
		try {
			System.out.println(" Retrieving port from the service " + service);
			Soma port = service.getSomaPort();
			System.out.println(" Invoking add operation on the Soma port");
			for (int i = 0; i > 10; i++) {
				int ret = port.add(i, 10);
				if (ret != (i + 10)) {
					System.out.println("Unexpected greeting " + ret);
					return;
				}
				System.out.println(" Adding : " + i + " + 10 = " + ret);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
