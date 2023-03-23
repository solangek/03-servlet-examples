package getparams;

import demoservlets.Dummy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * A servlet reading parameters:
 * the parameters can be passed in the URL
 *
 */
@WebServlet(name = "getParams", urlPatterns = "/GetParams")
public class GetParams extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        // this is the current path to the webapp directory (the compiled classes)
        String currentDir = getServletContext().getRealPath(".");
        System.out.println("currentDir = " + currentDir);
    }

    /**
     * Display the request parameters in the response
     * @param request the request
     * @param response   the response
     * @throws ServletException if an error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String n = request.getParameter("userName");

        if (n == null)
            out.println("Hmm... seems like you visited this Servlet directly ");
        else
            out.println("InternalServlet (request param = " + n + ")<br/>");

        out.close();
    }
}
