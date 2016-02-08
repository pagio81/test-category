package au.com.westernpower.moduletwo;

import au.com.westernpower.ci.repository.exceptions.MalformedBeanException;
import au.com.westernpower.ci.service.MySuperService;
import au.com.westernpower.ci.service.MySuperServiceImpl;
import au.com.westernpower.ci.service.exceptios.SaveException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;

/**
 * Created by N038603 on 28/01/2016.
 */
@Category(au.com.westernpower.ci.IntegrationTest.class)
public class MySuperServiceIntegrationTest {
    @Rule
    public ExpectedException thrown= ExpectedException.none();
    MySuperService mySuperService = new MySuperServiceImpl();

    @Test
    public void testSaveInTransaction(){
        thrown.expect(SaveException.class);
        mySuperService.saveInTransaction(null,null);

    }

    @Test
    public void test2(){

    }

}
