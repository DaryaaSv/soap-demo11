package lt.viko.eif.vvasylieva.soap.soapdemo.WebService;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import lt.viko.eif.vvasylieva.soap.soapdemo.modelDTO.AccountDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    @WebMethod
    List<AccountDTO> getAllAccounts();
}