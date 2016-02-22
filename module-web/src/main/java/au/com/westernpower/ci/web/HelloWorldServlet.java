package au.com.westernpower.ci.web;

import au.com.westernpower.ci.model.SuperBean;
import au.com.westernpower.ci.service.SuperBeanService;
import au.com.westernpower.ci.service.SuperBeanServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

/**
 * Created by N038603 on 11/02/2016.
 */
@SuppressWarnings("serial")
@WebServlet("/HelloWorld")
//@ServletSecurity(@HttpConstraint(rolesAllowed = { "Hudson-admin" }))
@ServletSecurity(@HttpConstraint(rolesAllowed = {"Hudson-admin"}))
public class HelloWorldServlet extends HttpServlet {

    private static final String PAGE_HEADER = "<html><head><title>Hello World!</title></head><body>";
    private static final String PAGE_FOOTER = "</body></html>";

    private transient final SuperBeanService service = new SuperBeanServiceImpl();
    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        try{
            PrintWriter writer = resp.getWriter();
            writer.println(PAGE_HEADER);

            Principal principal = req.getUserPrincipal();
            

            SuperBean bean = new SuperBean();
            service.doSomething(bean);

            writer.println("<h1>Super Bean saved: " + bean.getId() + "</h1>");
            writer.println("<h2>User: " + principal.getName() + "</h2>");

            writer.println(PAGE_FOOTER);
            writer.close();
        } catch (IOException io){
               LOG.error("I/O problem",io);
        }
    }


}
