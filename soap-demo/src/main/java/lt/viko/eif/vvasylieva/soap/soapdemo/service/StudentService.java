package lt.viko.eif.vvasylieva.soap.soapdemo.service;

import lt.viko.eif.vvasylieva.soap.soapdemo.db.AccountJpaRepository;
import lt.viko.eif.vvasylieva.soap.soapdemo.model.Account;
import org.hibernate.mapping.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StudentService {
    @Autowired
    private AccountJpaRepository accountRepository;
    @Autowired
    private ModelMapper modelMapper;
//    public lt.viko.eif.vvasylieva.springsoap.gen.Account findStudent(String name)
//    {
//        Account account;
//        account = this.list().stream().filter(st->st.getFirstName().equals(name)).findFirst().get();
//        return convertToDto(account);
//    }
//    public List<Account> list(){
//        return studentRepository.findAll();
//    }
//    public lt.viko.eif.vvasylieva.springsoap.gen.Student convertToDto(Student student){
//        lt.viko.eif.vvasylieva.springsoap.gen.Student studentDto = modelMapper.map(student,lt.viko.eif.vvasylieva.springsoap.gen.Student.class );
//        return studentDto;
//    }

}
