package au.com.westernpower.moduleone;

import au.com.westernpower.ci.model.MyTBean;
import au.com.westernpower.ci.repository.MyTBeanRepository;
import au.com.westernpower.ci.repository.MyTBeanRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * Created by N038603 on 28/01/2016.
 */
@Category(au.com.westernpower.ci.IntegrationTest.class)
public class ModuleOneIntegrationTest {

    MyTBeanRepository repository = new MyTBeanRepositoryImpl();

    @Test
    public void test1(){
        MyTBean myTBean = repository.getInstance();

        Assert.assertNotNull("My TBean should not be null",myTBean);
    }

    @Test
    public void test2(){
        MyTBean myTBean = repository.getInstance();
        myTBean.setName("TBean");
        myTBean.setDescription("this is a bit of desc");

        myTBean = repository.save(myTBean);

        Assert.assertNotNull("My TBean should not be null",myTBean);
        Assert.assertNotNull("ID should be not null",myTBean.getId());
        Assert.assertNotNull("Description should not be null",myTBean.getDescription());
    }

    @Test
    public void test3() {
        MyTBean myTBean = repository.getInstance();
        myTBean.setName("TBean");
        myTBean.setDescription("this is a bit of desc");

        myTBean = repository.save(myTBean);
        Assert.assertNotNull("ID should be not null", myTBean.getId());

        repository.delete(myTBean);
        Assert.assertNull("ID should be null", myTBean.getId());
    }
}
