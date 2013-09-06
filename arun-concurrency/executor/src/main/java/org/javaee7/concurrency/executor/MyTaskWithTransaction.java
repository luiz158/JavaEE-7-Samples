package org.javaee7.concurrency.executor;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 * @author Arun Gupta
 */
public class MyTaskWithTransaction implements Runnable {
    
    private int id;

    public MyTaskWithTransaction() {
    }

    public MyTaskWithTransaction(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    @Resource UserTransaction tx;

    @Override
    public void run() {
        
        try {
            InitialContext context = new InitialContext();
            UserTransaction tx = (UserTransaction)context.lookup("java:comp/UserTransaction");
            
            try {
                System.out.format("%d (transaction): tx.start", id);
                tx.begin();
                System.out.format("%d (transaction): running", id);
                tx.commit();
                System.out.format("%d (transaction): tx.commit", id);
            } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
                Logger.getLogger(MyTaskWithTransaction.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NamingException ex) {
            Logger.getLogger(MyTaskWithTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
