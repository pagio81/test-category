package au.com.westernpower.ci.repository;

import au.com.westernpower.ci.model.SuperBean;

import java.util.UUID;

/**
 * Created by N038603 on 5/02/2016.
 */
public class SuperBeanRepositoryImpl implements SuperBeanRepository {


    @Override
    public SuperBean save(SuperBean superBean) {
        superBean.setId(UUID.randomUUID().toString());
        return superBean;
    }
}
