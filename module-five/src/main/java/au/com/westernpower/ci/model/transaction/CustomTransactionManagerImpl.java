package au.com.westernpower.ci.model.transaction;

import javax.transaction.*;

/**
 * Created by N038603 on 8/02/2016.
 */
public class CustomTransactionManagerImpl implements TransactionManager{

    public void begin() throws NotSupportedException, SystemException {

    }

    public void commit() throws RollbackException, HeuristicMixedException, HeuristicRollbackException, SecurityException, IllegalStateException, SystemException {

    }

    public int getStatus() throws SystemException {
        return 0;
    }

    public Transaction getTransaction() throws SystemException {
        return null;
    }

    public void resume(Transaction transaction) throws InvalidTransactionException, IllegalStateException, SystemException {

    }

    public void rollback() throws IllegalStateException, SecurityException, SystemException {

    }

    public void setRollbackOnly() throws IllegalStateException, SystemException {

    }

    public void setTransactionTimeout(int i) throws SystemException {

    }

    public Transaction suspend() throws SystemException {
        return null;
    }
}
