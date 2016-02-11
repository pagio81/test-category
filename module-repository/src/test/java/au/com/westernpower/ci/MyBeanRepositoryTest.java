package au.com.westernpower.ci;

import au.com.westernpower.ci.model.MyBean;
import au.com.westernpower.ci.repository.MyBeanRepository;
import au.com.westernpower.ci.repository.MyBeanRepositoryImpl;
import au.com.westernpower.ci.repository.exceptions.MalformedBeanException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by N038603 on 28/01/2016.
 */
public class MyBeanRepositoryTest {
    @Rule
    public ExpectedException thrown= ExpectedException.none();
    MyBeanRepository repository = new MyBeanRepositoryImpl();

    @Test
    public void testGetInstance(){
        MyBean bean = repository.getInstance();
        Assert.assertNotNull("Bean can't be null!",bean);
    }

    @Test
    public void testSave(){
        MyBean bean = repository.getInstance();
        bean.setUsername("username");
        bean.setPassword("Password");
        bean = repository.save(bean);
        Assert.assertNotNull("Id can't be null",bean.getId());
    }

    @Test
    public void testSave2(){
        thrown.expect(MalformedBeanException.class);
        MyBean bean = repository.getInstance();
        repository.save(bean);
    }
}
