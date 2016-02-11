package au.com.westernpower.ci.service;

import au.com.westernpower.ci.model.MyBean;
import au.com.westernpower.ci.model.MyTBean;

/**
 * Created by N038603 on 5/02/2016.
 */
public interface MySuperService {

    void saveInTransaction(MyBean bean, MyTBean tBean);

}
