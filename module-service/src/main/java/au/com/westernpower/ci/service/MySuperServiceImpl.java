package au.com.westernpower.ci.service;

import au.com.westernpower.ci.model.MyBean;
import au.com.westernpower.ci.model.MyTBean;
import au.com.westernpower.ci.transaction.CustomTransactionManagerImpl;
import au.com.westernpower.ci.repository.MyBeanRepository;
import au.com.westernpower.ci.repository.MyBeanRepositoryImpl;
import au.com.westernpower.ci.repository.MyTBeanRepository;
import au.com.westernpower.ci.repository.MyTBeanRepositoryImpl;
import au.com.westernpower.ci.service.exceptios.SaveException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.TransactionManager;

/**
 * Created by N038603 on 5/02/2016.
 */
public class MySuperServiceImpl implements MySuperService{

    private MyTBeanRepository tBeanRepository = new MyTBeanRepositoryImpl();
    private MyBeanRepository beanRepository = new MyBeanRepositoryImpl();
    private static final Logger LOG = LoggerFactory.getLogger(MySuperServiceImpl.class);
    private TransactionManager transactionManager = new CustomTransactionManagerImpl();

    @Override
    public void saveInTransaction(MyBean bean, MyTBean tBean) {
        if(bean == null || tBean == null){
            throw new SaveException("Beans must not be null");
        }
        try {
            transactionManager.begin();
            tBeanRepository.save(tBean);
            beanRepository.save(bean);
            transactionManager.commit();
            return;
        }
        catch (Exception e){
            LOG.error("Error!",e);
            //in case of exception rollback
            try {
                transactionManager.rollback();
            }
            catch (Exception ex){
                LOG.error("Error rolling back!",ex);
            }
            throw new SaveException("Beans must not be null");
        }
    }
}
