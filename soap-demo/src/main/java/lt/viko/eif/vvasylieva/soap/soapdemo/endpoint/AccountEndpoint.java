package lt.viko.eif.vvasylieva.soap.soapdemo.endpoint;

import lt.viko.eif.vvasylieva.soap.soapdemo.service.AccountService;
import lt.viko.eif.vvasylieva.springsoap.gen.GetStudentRequest;
import lt.viko.eif.vvasylieva.springsoap.gen.GetStudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class AccountEndpoint {
	private static final String NAMESPACE_URI = "http://eif.viko.lt/vvasylieva/springsoap/gen";

	private AccountService studentSevice;

	@Autowired
	public AccountEndpoint(AccountService accountService) {
		this.studentSevice = accountService;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getStudentRequest")
	@ResponsePayload
	public GetStudentResponse getStudent(@RequestPayload GetStudentRequest request) {
		GetStudentResponse response = new GetStudentResponse();
//		response.setStudent(StudentService.findStudent(request.getName()));

		return response;
	}
}
