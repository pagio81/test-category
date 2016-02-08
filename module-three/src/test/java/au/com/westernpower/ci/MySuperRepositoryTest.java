package au.com.westernpower.ci;

import au.com.westernpower.ci.model.SuperBean;
import au.com.westernpower.ci.repository.MySuperBeanRepository;
import au.com.westernpower.ci.repository.MySuperBeanRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by N038603 on 8/02/2016.
 */

public class MySuperRepositoryTest {

    MySuperBeanRepository repository = new MySuperBeanRepositoryImpl();

    @Test
    public void testDoSomething(){
        SuperBean superBean = new SuperBean();
        repository.doSomething(superBean);

        Assert.assertNotNull("Bean must not be null",superBean.getBean());
    }

}
