package au.com.westernpower.ci.service;

import au.com.westernpower.ci.model.MyBean;
import au.com.westernpower.ci.model.MyBean2;
import au.com.westernpower.ci.model.MyTBean;
import au.com.westernpower.ci.model.SuperBean;
import au.com.westernpower.ci.repository.*;

/**
 * Created by N038603 on 8/02/2016.
 */
public class SuperBeanServiceImpl implements SuperBeanService {

    private MyTBeanRepository tBeanRepository = new MyTBeanRepositoryImpl();
    private MyBeanRepository beanRepository = new MyBeanRepositoryImpl();
    private MySuperService service = new MySuperServiceImpl();
    private SuperBeanRepository repository = new SuperBeanRepositoryImpl();

    @Override
    public void doSomething(SuperBean superBean) {

        MyTBean tBean = tBeanRepository.getInstance();
        MyBean bean = beanRepository.getInstance();

        tBean.setName("DoSomething");
        bean.setUsername("DoSomething");

        MyBean2 bean2 = new MyBean2();

        service.saveInTransaction(bean,tBean);

        superBean.setMyTBean(tBean);
        superBean.setMyBean2(bean2);
        superBean.setMyBean(bean);

        repository.save(superBean);
    }
}
