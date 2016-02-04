package au.com.westernpower.ci.repository;

import au.com.westernpower.ci.model.MyBean;

/**
 * Created by N038603 on 3/02/2016.
 */
public interface MyBeanRepository {

    MyBean getInstance();

    MyBean save(MyBean bean);

    void delete(MyBean bean);
}
