package au.com.westernpower.ci.repository;

import au.com.westernpower.ci.model.MyBean;
import au.com.westernpower.ci.model.MyBean2;
import au.com.westernpower.ci.model.MyTBean;
import au.com.westernpower.ci.model.SuperBean;
import au.com.westernpower.ci.service.MySuperService;
import au.com.westernpower.ci.service.MySuperServiceImpl;

/**
 * Created by N038603 on 5/02/2016.
 */
public class MySuperBeanRepositoryImpl implements MySuperBeanRepository {

    private MyTBeanRepository tBeanRepository = new MyTBeanRepositoryImpl();
    private MyBeanRepository beanRepository = new MyBeanRepositoryImpl();
    private MySuperService service = new MySuperServiceImpl();

    @Override
    public void doSomething(SuperBean superBean) {

        MyTBean tBean = tBeanRepository.getInstance();
        MyBean bean = beanRepository.getInstance();

        tBean.setName("DoSomething");
        bean.setUsername("DoSomething");

        MyBean2 bean2 = new MyBean2();

        service.saveInTransaction(bean,tBean);

        superBean.setBean(tBean);
        superBean.setBean2(bean2);
        superBean.setMyBean(bean);

        //TODO: save
    }
}
