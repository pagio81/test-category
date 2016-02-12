package au.com.westernpower.ci.transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.*;
import javax.transaction.xa.XAResource;

/**
 * Created by N038603 on 8/02/2016.
 */
public class CustomTransactionImpl implements Transaction {

    public enum Status {
        READY(0), COMMITTED(1), ROLLED_BACK(2), TIMED_OUT(3), SYS_ERROR(4);

        private int value = 0;
        Status(int value){
            this.value = value;
        }

        public int value(){
            return value;
        }
    }

    private static final Logger LOG = LoggerFactory.getLogger(CustomTransactionImpl.class);
    private boolean rollbackOnly = false;
    private Synchronization synchronization;
    //successful
    private int status = Status.READY.value();

    @Override
    public void commit() throws RollbackException, HeuristicMixedException, HeuristicRollbackException, SecurityException, SystemException {
        checkStatus();
        if(synchronization != null){
            synchronization.beforeCompletion();
        }
        if(rollbackOnly){
            LOG.info("Rollback only, not committing here");
            status = Status.ROLLED_BACK.value();
        } else {
            //commit here

            status = Status.COMMITTED.value();
        }
        if(synchronization != null){
            synchronization.afterCompletion(getStatus());
        }
        synchronization = null;
    }

    @Override
    public boolean delistResource(XAResource xaResource, int i) throws SystemException {
        checkStatus();
        return false;
    }

    @Override
    public boolean enlistResource(XAResource xaResource) throws RollbackException,  SystemException {
        checkStatus();
        return false;
    }

    @Override
    public int getStatus() throws SystemException {
        checkStatus();
        return status;
    }

    @Override
    public void registerSynchronization(Synchronization synchronization) throws RollbackException, SystemException {
        //registering sync
        this.synchronization = synchronization;
    }

    @Override
    public void rollback() throws  SystemException {
        checkStatus();
        if(synchronization != null){
            synchronization.beforeCompletion();
        }

        //rollback here
        status = Status.ROLLED_BACK.value();

        if(synchronization != null){
            synchronization.afterCompletion(getStatus());
        }
        synchronization = null;
    }

    @Override
    public void setRollbackOnly() throws SystemException {
        checkStatus();
        rollbackOnly = true;
    }

    private void checkStatus()  throws SystemException{
        //Not allowed
        if(status > 4){
            throw new SystemException("Transaction in system error");
        }
    }

}
