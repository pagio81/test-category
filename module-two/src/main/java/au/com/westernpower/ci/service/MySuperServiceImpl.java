package au.com.westernpower.ci.service;

import au.com.westernpower.ci.model.MyBean;
import au.com.westernpower.ci.model.MyTBean;
import au.com.westernpower.ci.repository.MyBeanRepository;
import au.com.westernpower.ci.repository.MyBeanRepositoryImpl;
import au.com.westernpower.ci.repository.MyTBeanRepository;
import au.com.westernpower.ci.repository.MyTBeanRepositoryImpl;
import au.com.westernpower.ci.service.exceptios.SaveException;

/**
 * Created by N038603 on 5/02/2016.
 */
public class MySuperServiceImpl implements MySuperService{

    MyTBeanRepository tBeanRepository = new MyTBeanRepositoryImpl();
    MyBeanRepository beanRepository = new MyBeanRepositoryImpl();


    public void saveInTransaction(MyBean bean, MyTBean tBean) {

        if(bean == null || tBean == null){
            throw new SaveException("Beans must not be null");
        }

        //TODO: no we are not in a transaction...
        tBean = tBeanRepository.save(tBean);
        bean = beanRepository.save(bean);

        boolean result = tBean.getId() != null && bean.getId() != null;

        if(!result){
            throw new SaveException("Operation didn't go as planned");
        }
    }
}
