package lt.viko.eif.vvasylieva.soap.soapdemo.Responds;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lt.viko.eif.vvasylieva.soap.soapdemo.modelDTO.AccountDTO;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GetAllAccountsRespond {
    @XmlElement(name = "account")
    private List<AccountDTO> accountList;

    public GetAllAccountsRespond() {
        accountList = new ArrayList<>();
    }

    public List<AccountDTO> getAccounts() {
        return accountList;
    }

    public void setAccounts(List<AccountDTO> accounts) {
        this.accountList = accounts;
    }
}
