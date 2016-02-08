package au.com.westernpower.moduletwo;

import au.com.westernpower.ci.model.MyBean;
import au.com.westernpower.ci.model.MyTBean;
import au.com.westernpower.ci.service.MySuperService;
import au.com.westernpower.ci.service.MySuperServiceImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by N038603 on 28/01/2016.
 */
public class MySuperServiceUnitTest {

    MySuperService service = new MySuperServiceImpl();

    @Test
    public void testSaveInTransaction(){

        MyBean bean = new MyBean();
        bean.setUsername("Test");
        bean.setPassword("SuperTest123");

        MyTBean tBean = new MyTBean();
        tBean.setName("Test");
        tBean.setDescription("This is a description");

        service.saveInTransaction(bean,tBean);

        Assert.assertNotNull("Bean ID must not be null",bean.getId());
        Assert.assertNotNull("T Bean ID must not be null",tBean.getId());

    }


}
