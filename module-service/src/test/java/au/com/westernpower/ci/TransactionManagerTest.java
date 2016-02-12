package au.com.westernpower.ci;

import au.com.westernpower.ci.transaction.CustomSynchronization;
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

        Assert.assertEquals("Status must not be in error",0,manager.getStatus());

    }


}
