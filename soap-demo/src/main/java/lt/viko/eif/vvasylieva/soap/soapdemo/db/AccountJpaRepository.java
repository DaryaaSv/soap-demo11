package lt.viko.eif.vvasylieva.soap.soapdemo.db;

import lt.viko.eif.vvasylieva.soap.soapdemo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountJpaRepository extends JpaRepository<Account,Long> {
}
