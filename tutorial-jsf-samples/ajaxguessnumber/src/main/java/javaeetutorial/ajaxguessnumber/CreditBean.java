
package javaeetutorial.ajaxguessnumber;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Masudul Haque
 */
@Named
@SessionScoped
public class CreditBean implements Serializable{
    private static final long serialVersionUID = 4089690593342390488L;
    private  int credit;
    private  int debit;
    public void changeCredit(){
        credit=0;
    }
    public void changeDebit(){
        debit=0;
    }
    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getDebit() {
        return debit;
    }

    public void setDebit(int debit) {
        this.debit = debit;
    }
    
}
