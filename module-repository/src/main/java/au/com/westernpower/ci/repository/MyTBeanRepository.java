package au.com.westernpower.ci.repository;

import au.com.westernpower.ci.web.MyTBean;

/**
 * Created by N038603 on 5/02/2016.
 */
public interface MyTBeanRepository {

    MyTBean getInstance();

    MyTBean save(MyTBean tBean);

    void delete(MyTBean tBean);
}
