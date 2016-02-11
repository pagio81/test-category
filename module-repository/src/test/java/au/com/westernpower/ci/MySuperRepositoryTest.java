package au.com.westernpower.ci;

import au.com.westernpower.ci.web.SuperBean;
import au.com.westernpower.ci.repository.SuperBeanRepository;
import au.com.westernpower.ci.repository.SuperBeanRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by N038603 on 8/02/2016.
 */

public class MySuperRepositoryTest {

    SuperBeanRepository repository = new SuperBeanRepositoryImpl();

    @Test
    public void testSave(){
        SuperBean superBean = new SuperBean();
        repository.save(superBean);

        Assert.assertNotNull("Bean ID must not be null",superBean.getId());
    }

}
