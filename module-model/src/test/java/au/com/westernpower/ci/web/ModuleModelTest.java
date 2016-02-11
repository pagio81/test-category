package au.com.westernpower.ci.web;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by N038603 on 28/01/2016.
 */
public class ModuleModelTest {

    @Test
    public void testSuperBean(){
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

    @Test
    public void testMyTBean(){
        MyTBean myTBean = new MyTBean();

        myTBean.setDescription("desc");
        myTBean.setName("name");

        Assert.assertNull("By default ID must be null",myTBean.getId());
        Assert.assertNotNull("desc must not be null",myTBean.getDescription());
        Assert.assertNotNull("name must not be null",myTBean.getName());

    }

    @Test
    public void testMyBean2(){
        MyBean2 myBean2 = new MyBean2();
        AnotherBean anotherBean = new AnotherBean();
        MyTBean myTBean = new MyTBean();


        myBean2.setMyTBean(myTBean);
        myBean2.setAnotherBean(anotherBean);
        myBean2.setUsername("test");
        myBean2.setPassword("aaaa");

        Assert.assertNull("By default ID must be null",myBean2.getId());
        Assert.assertNotNull("username must not be null",myBean2.getUsername());
        Assert.assertNotNull("password must not be null",myBean2.getPassword());
        Assert.assertNotNull("myTBean must not be null",myBean2.getMyTBean());

    }

    @Test
    public void testBean4(){
        Bean4 bean4 = new Bean4();
        MyTBean myTBean = new MyTBean();

        bean4.setMyTBean(myTBean);
        bean4.setProperty("property");

        Assert.assertNull("By default ID must be null",myTBean.getId());
        Assert.assertNotNull("property must not be null",bean4.getProperty());
        Assert.assertNotNull("myTBean must not be null",bean4.getMyTBean());

    }


    @Test
    public void testMyBean(){
        MyBean myBean = new MyBean();
        myBean.setUsername("test");
        myBean.setPassword("aaaa");

        Assert.assertNull("By default ID must be null",myBean.getId());
        Assert.assertNotNull("username must not be null",myBean.getUsername());
        Assert.assertNotNull("password must not be null",myBean.getPassword());

    }
}
