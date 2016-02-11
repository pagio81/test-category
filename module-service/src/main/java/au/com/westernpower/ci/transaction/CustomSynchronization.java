package au.com.westernpower.ci.transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Synchronization;

/**
 * Created by N038603 on 11/02/2016.
 */
public class CustomSynchronization implements Synchronization {

    public enum Status{
        INITIAL, BEFORE_COMPLETION_SUCCESSFUL,ERROR,SUCCESSFUL
    }

    private static final Logger LOG = LoggerFactory.getLogger(CustomSynchronization.class);
    private Status status = Status.INITIAL;

    @Override
    public void beforeCompletion() {
        LOG.info("Before Completion");

        status = Status.BEFORE_COMPLETION_SUCCESSFUL;
    }

    @Override
    public void afterCompletion(int result) {
        LOG.info("After Completion");
        if(result == 0){
            status = Status.SUCCESSFUL;
        } else {
            status = Status.ERROR;
        }
    }

}
