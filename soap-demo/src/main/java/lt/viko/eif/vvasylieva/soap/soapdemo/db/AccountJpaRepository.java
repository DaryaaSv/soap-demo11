package lt.viko.eif.vvasylieva.soap.soapdemo.db;

import lt.viko.eif.vvasylieva.soap.soapdemo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *  This interface extends the JpaRepository interface, which provides generic CRUD methods
 *  for working with entities. It specifies the Account entity type and the type of its primary key.
 */
@Repository
public interface AccountJpaRepository extends JpaRepository<Account,Long> {
}
