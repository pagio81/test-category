package au.com.westernpower.ci.model.transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.*;
import javax.transaction.xa.XAResource;

/**
 * Created by N038603 on 8/02/2016.
 */
public class CustomTransactionManagerImpl implements TransactionManager{

    static final Logger LOG = LoggerFactory.getLogger(CustomTransactionManagerImpl.class);
    private Transaction current;
    private int timeout;

    public void begin() throws NotSupportedException, SystemException {
        if(current == null){
            current = getTransaction();
        }
    }

    public void commit() throws RollbackException, HeuristicMixedException, HeuristicRollbackException, SecurityException, IllegalStateException, SystemException {
        current.commit();
        current = null;
    }

    public int getStatus() throws SystemException {
        return 0;
    }

    public Transaction getTransaction() throws SystemException {
        return new CustomTransactionImpl();
    }

    public void resume(Transaction transaction) throws InvalidTransactionException, IllegalStateException, SystemException {
        //resume
        LOG.info("Resuming transaction");
    }

    public void rollback() throws IllegalStateException, SecurityException, SystemException {
        current.rollback();
        current = null;
    }

    public void setRollbackOnly() throws IllegalStateException, SystemException {
        current.setRollbackOnly();
    }

    public void setTransactionTimeout(int i) throws SystemException {
        timeout = i;
    }

    public Transaction suspend() throws SystemException {
        //suspending
        LOG.info("Suspending transaction");
        return current;
    }
}
