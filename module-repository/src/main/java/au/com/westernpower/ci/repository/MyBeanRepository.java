package au.com.westernpower.ci.repository;

import au.com.westernpower.ci.web.MyBean;
import au.com.westernpower.ci.web.MyTBean;

/**
 * Created by N038603 on 3/02/2016.
 */
public interface MyBeanRepository {

    MyBean getInstance();

    MyTBean getTInstance();

    MyBean save(MyBean bean);

    void delete(MyBean bean);
}
