package lt.viko.eif.vvasylieva.soap.soapdemo.WebService;

import jakarta.jws.WebService;
import lt.viko.eif.vvasylieva.soap.soapdemo.modelDTO.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@WebService(endpointInterface = "WebService.AccountService")
public class AccountServiceImpl implements AccountService {
    private List<AccountDTO> accountsDTO;
    @Autowired
    private AccountJpaRepository accountJpaRepository;

    @Autowired
    public AccountServiceImpl(AccountJpaRepository accountJpaRepository){
        this.accountJpaRepository = accountJpaRepository;
    }

    public AccountServiceImpl() {
        List<Account> accounts = accountJpaRepository.findAll();
        accountsDTO = accounts.stream()
                .map(account -> {
                    return new AccountDTO(account);
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
        return accountsDTO;
    }
}
