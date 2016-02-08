package au.com.westernpower.ci;

import au.com.westernpower.ci.model.SuperBean;
import au.com.westernpower.ci.service.SuperBeanService;
import au.com.westernpower.ci.service.SuperBeanServiceImpl;
import org.junit.Assert;

/**
 * Created by N038603 on 8/02/2016.
 */
public class SuperBeanServiceTest {

    SuperBeanService service = new SuperBeanServiceImpl();

    public void testDoSomething(){

        SuperBean bean = new SuperBean();
        service.doSomething(bean);

        Assert.assertNotNull("Bean must have been saved",bean.getId());

    }

}
