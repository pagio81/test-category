package au.com.westernpower.ci.web;

/**
 * Created by N038603 on 5/02/2016.
 */
public class MyBean2 extends MyAbstractBean{

    private AnotherBean anotherBean;
    private MyTBean myTBean;

    public AnotherBean getAnotherBean() {
        return anotherBean;
    }

    public void setAnotherBean(AnotherBean anotherBean) {
        this.anotherBean = anotherBean;
    }

    public MyTBean getMyTBean() {
        return myTBean;
    }

    public void setMyTBean(MyTBean myTBean) {
        this.myTBean = myTBean;
    }
}
