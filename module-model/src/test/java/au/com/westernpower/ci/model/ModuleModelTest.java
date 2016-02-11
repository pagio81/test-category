package au.com.westernpower.ci.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by N038603 on 28/01/2016.
 */
public class ModuleModelTest {

    @Test
    public void testModel(){
        SuperBean superBean = new SuperBean();
        MyTBean myTBean = new MyTBean();
        MyBean2 myBean2 = new MyBean2();
        MyBean myBean = new MyBean();
        Bean4 bean4 = new Bean4();


        superBean.setMyTBean(myTBean);
        superBean.setMyBean2(myBean2);
        superBean.setMyBean(myBean);
        superBean.setBean4(bean4);

        Assert.assertNull("By default ID must be null",superBean.getId());
        Assert.assertNotNull("myBean must not be null",superBean.getMyBean());
        Assert.assertNotNull("bean4 must not be null",superBean.getBean4());
        Assert.assertNotNull("myBean2 must not be null",superBean.getMyBean2());

    }

}
