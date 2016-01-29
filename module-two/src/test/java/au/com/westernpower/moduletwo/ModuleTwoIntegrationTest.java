package au.com.westernpower.moduletwo;

import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * Created by N038603 on 28/01/2016.
 */
@Category(au.com.westernpower.ci.IntegrationTest.class)
public class ModuleTwoIntegrationTest {

    @Test
    public void test1(){
        System.out.println("Running an integration test / 1!");
    }

    @Test
    public void test2(){
        System.out.println("Running an integration test / 2!");
    }

}
