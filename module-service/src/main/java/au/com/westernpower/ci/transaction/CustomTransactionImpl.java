package au.com.westernpower.ci.transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.*;
import javax.transaction.xa.XAResource;

/**
 * Created by N038603 on 8/02/2016.
 */
public class CustomTransactionImpl implements Transaction {

    private static final Logger LOG = LoggerFactory.getLogger(CustomTransactionImpl.class);
    private boolean rollbackOnly = false;
    private Synchronization synchronization;
    //successful
    private int status = 0;
    private boolean systemError;

    public void commit() throws RollbackException, HeuristicMixedException, HeuristicRollbackException, SecurityException, IllegalStateException, SystemException {
        checkStatus();
        if(synchronization != null){
            synchronization.beforeCompletion();
        }
        if(rollbackOnly){
            LOG.info("Rollback only, not committing here");
        } else {
            //commit here
        }
        if(synchronization != null){
            synchronization.afterCompletion(getStatus());
        }

        synchronization = null;
    }

    public boolean delistResource(XAResource xaResource, int i) throws IllegalStateException, SystemException {
        checkStatus();
        return false;
    }

    public boolean enlistResource(XAResource xaResource) throws RollbackException, IllegalStateException, SystemException {
        checkStatus();
        return false;
    }

    public int getStatus() throws SystemException {
        if(systemError){
            throw new SystemException("Transaction in system error");
        }
        return status;
    }

    public void registerSynchronization(Synchronization synchronization) throws RollbackException, IllegalStateException, SystemException {
        //registering sync
        this.synchronization = synchronization;
    }

    public void rollback() throws IllegalStateException, SystemException {
        checkStatus();
        if(synchronization != null){
            synchronization.beforeCompletion();
        }

        //rollback here

        if(synchronization != null){
            synchronization.afterCompletion(getStatus());
        }
        synchronization = null;
    }

    public void setRollbackOnly() throws IllegalStateException, SystemException {
        checkStatus();
        rollbackOnly = true;
    }

    private void checkStatus()  throws IllegalStateException, SystemException{
        if(systemError){
            throw new SystemException("Transaction in system error");
        }
        else if(getStatus()!=0){
            throw new IllegalStateException("Transaction in status:"+getStatus());
        }
    }

}
