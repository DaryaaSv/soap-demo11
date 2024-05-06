package lt.viko.eif.vvasylieva.soap.soapdemo.service;

import lt.viko.eif.vvasylieva.soap.soapdemo.db.AccountJpaRepository;
import lt.viko.eif.vvasylieva.soap.soapdemo.model.Account;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountJpaRepository accountRepository;
    @Autowired
    private ModelMapper modelMapper;
    public Account findAccount(String username) {
        Account account;
        account = this.list().stream().filter(st->st.getUserName().equals(username)).findFirst().get();
        return convertToDto(account);
    }
    public List<Account> list(){
        return accountRepository.findAll();
    }
    public Account convertToDto(Account account){
        Account accountDto = modelMapper.map(account, Account.class);
        return accountDto;
    }

}
