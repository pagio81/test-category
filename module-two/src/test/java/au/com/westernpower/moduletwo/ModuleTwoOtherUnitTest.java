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
public class ModuleTwoOtherUnitTest {

    MySuperService service = new MySuperServiceImpl();

    @Test
    public void test1(){

        MyBean bean = new MyBean();
        bean.setUsername("Test");
        bean.setPassword("SuperTest123");

        MyTBean tBean = new MyTBean();
        tBean.setName("Test");
        tBean.setDescription("This is a description");

        service.saveInTransaction(bean,tBean);

        Assert.assertNotNull(bean.getId());
        Assert.assertNotNull(tBean.getId());

        System.out.println("Running a unit test / 1");
    }

    @Test
    public void test2(){
        System.out.println("Running a unit test / 2");
        System.out.println("other bug fix!");

    }



}
