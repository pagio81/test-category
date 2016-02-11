package au.com.westernpower.ci.model;

import au.com.westernpower.ci.service.SuperBeanService;
import au.com.westernpower.ci.service.SuperBeanServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by N038603 on 11/02/2016.
 */
@SuppressWarnings("serial")
@WebServlet("/HelloWorld")
public class HelloWorldServlet extends HttpServlet {

    private static final String PAGE_HEADER = "<html><head><title>Hello World!</title></head><body>";
    private static final String PAGE_FOOTER = "</body></html>";

    SuperBeanService service = new SuperBeanServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println(PAGE_HEADER);

        SuperBean bean = new SuperBean();
        service.doSomething(bean);

        writer.println("<h1>Super Bean saved: " + bean.getId() + "</h1>");

        writer.println(PAGE_FOOTER);
        writer.close();
    }


}
