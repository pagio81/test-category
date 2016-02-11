package au.com.westernpower.ci.repository;

import au.com.westernpower.ci.web.MyTBean;
import au.com.westernpower.ci.repository.exceptions.MalformedTBeanException;

import java.util.UUID;

/**
 * Created by N038603 on 5/02/2016.
 */
public class MyTBeanRepositoryImpl implements MyTBeanRepository{

    @Override
    public MyTBean getInstance() {
        return new MyTBean();
    }

    @Override
    public MyTBean save(MyTBean tBean) {
        if(tBean.getName()==null){ 
            throw new MalformedTBeanException("Name can't be null");
        }
        tBean.setId(UUID.randomUUID().toString());
        return tBean;
    }

    @Override
    public void delete(MyTBean tBean) {
        tBean.setId(null);
    }
}
