package au.com.westernpower.ci.service;

import au.com.westernpower.ci.model.MyBean;
import au.com.westernpower.ci.model.MyTBean;
import au.com.westernpower.ci.repository.MyBeanRepository;
import au.com.westernpower.ci.repository.MyBeanRepositoryImpl;
import au.com.westernpower.ci.repository.MyTBeanRepository;
import au.com.westernpower.ci.repository.MyTBeanRepositoryImpl;
import au.com.westernpower.ci.service.exceptios.SaveException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by N038603 on 5/02/2016.
 */
public class MySuperServiceImpl implements MySuperService{

    private MyTBeanRepository tBeanRepository = new MyTBeanRepositoryImpl();
    private MyBeanRepository beanRepository = new MyBeanRepositoryImpl();
    private static final Logger LOG = LoggerFactory.getLogger(MySuperServiceImpl.class);

    public void saveInTransaction(MyBean bean, MyTBean tBean) {
        //TODO: no we are not in a transaction...

        if(bean == null || tBean == null){
            throw new SaveException("Beans must not be null");
        }

        boolean result = true;
        try {
            MyTBean tBean2 = tBeanRepository.save(tBean);
            MyBean bean2 = beanRepository.save(bean);
            result = tBean2.getId() != null && bean2.getId() != null;

        }
        catch (Exception e){
            //in case of exception result is false,SaveException will be rethrown
            result = false;
            LOG.error("Error!",e);
        }

        if(!result){
            throw new SaveException("Operation didn't go as planned");
        }
    }
}
