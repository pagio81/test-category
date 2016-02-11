package au.com.westernpower.ci;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by N038603 on 11/02/2016.
 */
@Category(au.com.westernpower.ci.IntegrationTest.class)
public class HelloWorldIntegrationTest {

    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldIntegrationTest.class);

    @Test
    public void testGet(){
        //TODO: test the servlet

        LOG.info("Testing!");
    }

}
