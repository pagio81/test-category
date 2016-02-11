package au.com.westernpower.ci;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.junit.Assert;
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
    HttpClient client = new HttpClient();
    private static final String GET_SERVLET = "/module-web/HelloWorld";

    @Test
    public void testGet(){

        String base_url = System.getProperty("base-url") == null ? "http://localhost:8080" : System.getProperty("base-url");

        //TODO: test the servlet
        HttpMethod get = new GetMethod(base_url + GET_SERVLET);
        try{
            client.executeMethod(get);
            Assert.assertEquals("Expected status code 200",200,get.getStatusCode());

            String response = get.getResponseBodyAsString();
            Assert.assertTrue(response.contains("Super Bean saved"));
        } catch (Exception e){
            LOG.error("Exception while calling %s%s",base_url,GET_SERVLET);
            Assert.fail("Exception here...");
        }

    }

}
