package au.com.westernpower.ci;

import au.com.westernpower.ci.model.MyTBean;
import au.com.westernpower.ci.repository.MyTBeanRepository;
import au.com.westernpower.ci.repository.MyTBeanRepositoryImpl;
import au.com.westernpower.ci.repository.exceptions.MalformedTBeanException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by N038603 on 28/01/2016.
 */
public class MyTBeanRepositoryTest {

    MyTBeanRepository repository = new MyTBeanRepositoryImpl();
    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Test
    public void testGetInstance(){
        MyTBean myTBean = repository.getInstance();

        Assert.assertNotNull("My TBean should not be null",myTBean);
    }

    @Test
    public void testSaveNoException(){
        MyTBean myTBean = repository.getInstance();
        myTBean.setName("TBean");
        myTBean.setDescription("this is a bit of desc");
        myTBean = repository.save(myTBean);

        Assert.assertNotNull("My TBean should not be null",myTBean);
        Assert.assertNotNull("ID should be not null",myTBean.getId());
        Assert.assertNotNull("Description should not be null",myTBean.getDescription());
    }

    @Test
    public void testSaveWithException(){
        thrown.expect(MalformedTBeanException.class);
        MyTBean myTBean = repository.getInstance();
        repository.save(myTBean);
    }

    @Test
    public void testSaveDelete() {
        MyTBean myTBean = repository.getInstance();
        myTBean.setName("TBean");
        myTBean.setDescription("this is a bit of desc");
        myTBean = repository.save(myTBean);

        Assert.assertNotNull("ID should be not null", myTBean.getId());

        repository.delete(myTBean);

        Assert.assertNull("ID should be null", myTBean.getId());
    }
}
