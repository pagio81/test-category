package au.com.westernpower.ci;

import au.com.westernpower.ci.transaction.CustomSynchronization;
import au.com.westernpower.ci.transaction.CustomTransactionImpl;
import au.com.westernpower.ci.transaction.CustomTransactionManagerImpl;
import org.junit.Assert;
import org.junit.Test;

import javax.transaction.Synchronization;
import javax.transaction.Transaction;
import javax.transaction.TransactionManager;

/**
 * Created by N038603 on 11/02/2016.
 */
public class TransactionManagerTest {

    TransactionManager manager = new CustomTransactionManagerImpl();

    @Test
    public void testCommit() throws Exception{
        manager.begin();
        Transaction transaction = manager.getTransaction();
        Synchronization synchronization = new CustomSynchronization();
        transaction.registerSynchronization(synchronization);
        manager.commit();

        Assert.assertEquals("Status must not be in error",CustomTransactionImpl.Status.COMMITTED.value(),manager.getStatus());

    }

    @Test
    public void testRollback() throws Exception{
        manager.begin();
        Transaction transaction = manager.getTransaction();
        Synchronization synchronization = new CustomSynchronization();
        transaction.registerSynchronization(synchronization);
        manager.rollback();

        Assert.assertEquals("Status must not be in error", CustomTransactionImpl.Status.ROLLED_BACK.value(),manager.getStatus());

    }


    @Test
    public void testRollbackOnly() throws Exception{
        manager.begin();
        manager.setRollbackOnly();
        manager.commit();

        Assert.assertEquals("Status must not be in error",CustomTransactionImpl.Status.ROLLED_BACK.value(),manager.getStatus());

    }

}
