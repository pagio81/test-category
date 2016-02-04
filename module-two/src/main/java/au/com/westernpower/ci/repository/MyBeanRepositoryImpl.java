package au.com.westernpower.ci.repository;

import au.com.westernpower.ci.model.MyBean;
import au.com.westernpower.ci.repository.exceptions.MalformedBeanException;

import java.util.UUID;

/**
 * Created by N038603 on 3/02/2016.
 */
public class MyBeanRepositoryImpl implements MyBeanRepository{

    public MyBean getInstance() {
        return new MyBean();
    }

    public MyBean save(MyBean bean) {
        if(bean.getUsername()==null) {
            throw new MalformedBeanException("Username can't be null");
        }
        bean.setId(UUID.randomUUID().toString());
        return bean;
    }

    public void delete(MyBean bean) {
        bean.setId(null);
    }
}
