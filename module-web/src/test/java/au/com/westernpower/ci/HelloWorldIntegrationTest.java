package au.com.westernpower.ci;

import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * Created by N038603 on 11/02/2016.
 */
@Category(au.com.westernpower.ci.IntegrationTest.class)
public class HelloWorldIntegrationTest {

    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldIntegrationTest.class);
    HttpClient client = new HttpClient();
    private static final String GET_SERVLET = "/module-web/HelloWorld";
    private static final String BASE_URL_DEFAULT = "http://192.168.56.1:8080";
    private static final String PWD = "pxKPWpt/nsZ8Vjte1GkMmw==";
    private static final String USR = "7BWbRA4GhfE=";

    @Test
    @Ignore("Don't have credentials for another user that is authenticated but not authorized")
    public void test403(){
        String base_url = System.getProperty("base-url") == null ? BASE_URL_DEFAULT : System.getProperty("base-url");
        //TODO: test the servlet
        client.getParams().setAuthenticationPreemptive(true);

        Credentials credentials = new UsernamePasswordCredentials("N00000", "pwd");
        client.getState().setCredentials(new AuthScope("192.168.56.1", 8080, AuthScope.ANY_REALM), credentials);

        HttpMethod get = new GetMethod(base_url + GET_SERVLET);
        get.setDoAuthentication(true);

        try{
            client.executeMethod(get);
            Assert.assertEquals("Expected status code 403",403,get.getStatusCode());
        } catch (Exception e){
            LOG.error("Exception while calling %s%s",base_url,GET_SERVLET);
            Assert.fail("Exception here...");
        }
    }

    @Test
    public void test401() throws GeneralSecurityException,IOException {

        String base_url = System.getProperty("base-url") == null ? BASE_URL_DEFAULT : System.getProperty("base-url");
        //TODO: test the servlet
        HttpMethod get = new GetMethod(base_url + GET_SERVLET);
        Credentials credentials = new UsernamePasswordCredentials(ProtectedConfigFile.decrypt(USR), "PWD");
        client.getState().setCredentials(new AuthScope("192.168.56.1", 8080, AuthScope.ANY_REALM), credentials);

        try{
            client.executeMethod(get);
            Assert.assertEquals("Expected status code 401",401,get.getStatusCode());
        } catch (Exception e){
            LOG.error("Exception while calling %s%s",base_url,GET_SERVLET);
            Assert.fail("Exception here...");
        }
    }

    @Test
    public void test404(){
        String base_url = System.getProperty("base-url") == null ? BASE_URL_DEFAULT : System.getProperty("base-url");
        //TODO: test the servlet
        HttpMethod get = new GetMethod(base_url + GET_SERVLET + "Fake");
        try{
            client.executeMethod(get);
            Assert.assertEquals("Expected status code 404",404,get.getStatusCode());
        } catch (Exception e){
            LOG.error("Exception while calling %s%s",base_url,GET_SERVLET);
            Assert.fail("Exception here...");
        }
    }

    @Test
    public void test200() throws GeneralSecurityException,IOException{
        String base_url = System.getProperty("base-url") == null ? BASE_URL_DEFAULT : System.getProperty("base-url");
        //TODO: test the servlet
        HttpMethod get = new GetMethod(base_url + GET_SERVLET);

        Credentials credentials = new UsernamePasswordCredentials(ProtectedConfigFile.decrypt(USR), ProtectedConfigFile.decrypt(PWD));
        client.getState().setCredentials(new AuthScope("192.168.56.1", 8080, AuthScope.ANY_REALM), credentials);
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
