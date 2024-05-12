package lt.viko.eif.vvasylieva.soap.soapdemo.WebService;

import jakarta.xml.bind.JAXBElement;
import lt.viko.eif.vvasylieva.soap.soapdemo.Requests.GetAllAccountsRequest;
import lt.viko.eif.vvasylieva.soap.soapdemo.Responds.GetAllAccountsRespond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.namespace.QName;

@Endpoint
@ComponentScan(basePackages = "lt.viko.eif.vvasylieva.soap.soapdemo.WebService.AccountService")
public class AccountEndpoint {

	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
	@Autowired
	private AccountService accountService;

	@Autowired
	public AccountEndpoint(AccountService accountService) {
		this.accountService = accountService;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllAccountsRequest")
	@ResponsePayload
	public JAXBElement<GetAllAccountsRespond> getAllAccounts(@RequestPayload JAXBElement<GetAllAccountsRequest> request) {
		GetAllAccountsRespond response = new GetAllAccountsRespond();
		response.getAccounts().addAll(accountService.getAllAccounts());

		QName qName = new QName(NAMESPACE_URI, "getAllAccountsResponse");
		JAXBElement<GetAllAccountsRespond> jaxbResponse = new JAXBElement<>(qName, GetAllAccountsRespond.class, response);

		return jaxbResponse;
	}

}
