package au.com.westernpower.ci.model.transaction;

import javax.transaction.*;
import javax.transaction.xa.XAResource;

/**
 * Created by N038603 on 8/02/2016.
 */
public class CustomTransactionImpl implements Transaction {

    boolean rollbackOnly = false;

    public void commit() throws RollbackException, HeuristicMixedException, HeuristicRollbackException, SecurityException, IllegalStateException, SystemException {
        //commit
    }

    public boolean delistResource(XAResource xaResource, int i) throws IllegalStateException, SystemException {
        return false;
    }

    public boolean enlistResource(XAResource xaResource) throws RollbackException, IllegalStateException, SystemException {
        return false;
    }

    public int getStatus() throws SystemException {
        return 0;
    }

    public void registerSynchronization(Synchronization synchronization) throws RollbackException, IllegalStateException, SystemException {
        //registering sync
    }

    public void rollback() throws IllegalStateException, SystemException {
        //rollback
    }

    public void setRollbackOnly() throws IllegalStateException, SystemException {
        rollbackOnly = true;
    }
}
