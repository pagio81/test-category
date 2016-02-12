package au.com.westernpower.ci.transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.*;

/**
 * Created by N038603 on 8/02/2016.
 */
public class CustomTransactionManagerImpl implements TransactionManager{

    static final Logger LOG = LoggerFactory.getLogger(CustomTransactionManagerImpl.class);
    private Transaction current;
    private int timeout;

    @Override
    public void begin() throws NotSupportedException, SystemException {
        if(current == null){
            current = getTransaction();
        }
    }

    @Override
    public void commit() throws RollbackException, HeuristicMixedException, HeuristicRollbackException, SecurityException, SystemException {
        current.commit();
        current = null;
    }

    @Override
    public int getStatus() throws SystemException {
        if(current == null){
            return 0;
        }
        return current.getStatus();
    }

    @Override
    public Transaction getTransaction() throws SystemException {
        return new CustomTransactionImpl();
    }

    @Override
    public void resume(Transaction transaction) throws InvalidTransactionException, SystemException {
        //resume
        LOG.info("Resuming transaction");
    }

    @Override
    public void rollback() throws SecurityException, SystemException {
        current.rollback();
        current = null;
    }

    @Override
    public void setRollbackOnly() throws SystemException {
        current.setRollbackOnly();
    }

    @Override
    public void setTransactionTimeout(int i) throws SystemException {
        timeout = i;
    }

    @Override
    public Transaction suspend() throws SystemException {
        //suspending
        LOG.info("Suspending transaction");
        return current;
    }
}
