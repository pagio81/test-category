package au.com.westernpower.ci;

import au.com.westernpower.ci.model.MyBean;
import au.com.westernpower.ci.model.MyTBean;
import au.com.westernpower.ci.service.MySuperService;
import au.com.westernpower.ci.service.MySuperServiceImpl;
import au.com.westernpower.ci.service.exceptios.SaveException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;

/**
 * Created by N038603 on 28/01/2016.
 */

public class MySuperServiceTest {

    @Rule
    public ExpectedException thrown= ExpectedException.none();
    MySuperService mySuperService = new MySuperServiceImpl();

    @Test
    public void testSaveInTransaction(){
        thrown.expect(SaveException.class);
        mySuperService.saveInTransaction(null,null);
    }


    @Test
    public void testSaveInTransaction2(){
        thrown.expect(SaveException.class);
        MyBean bean = new MyBean();
        MyTBean tBean = new MyTBean();
        mySuperService.saveInTransaction(bean,tBean);
    }

    @Test
    public void testSaveSuccesfullyInTransaction(){
        MyBean bean = new MyBean();
        bean.setUsername("Test");
        bean.setPassword("SuperTest123");

        MyTBean tBean = new MyTBean();
        tBean.setName("Test");
        tBean.setDescription("This is a description");

        mySuperService.saveInTransaction(bean,tBean);

        Assert.assertNotNull("Bean ID must not be null",bean.getId());
        Assert.assertNotNull("T Bean ID must not be null",tBean.getId());

    }
}
