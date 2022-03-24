package demoservlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet demo on how to get parameters from the servlet container.
 */
@WebServlet(name = "ServletParams", urlPatterns = {"/params/*"}, initParams={@WebInitParam(name="country", value="Israel")})
public class ServletParams extends HttpServlet {

    private String coutryName, appName;

    /**
     * Initialize the servlet with the servlet context and config parameters.
     * A servlet has a zero-argument constructor. We must implement this method
     * to initialize the servlet and call the superclass implementation.
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // application wide parameter stored in web.xml
        appName = this.getServletContext().getInitParameter("appname");
        // servlet init parameter defined above with annotation @WebInitParam
        coutryName = this.getServletConfig().getInitParameter("country");
        // servlet init parameter defined in web.xml
        getServletContext().setAttribute("myquestions", "Java, C#, C++");

    }

    /**
     * Process the HTTP GET request.
     * Display the servlet parameters in a HTML page.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter toClient = response.getWriter();

        //Object o = getServletContext().getAttribute("myquestions");

        toClient.println("<HTML>");
        toClient.println("<head><title>Book Review Response</title></head><body>");
        toClient.println("Country = " +  coutryName + "<br/>");
        toClient.println("App = " + appName  +  "<br/>");

        toClient.println("</body></html>");
        toClient.close();
    }
}
