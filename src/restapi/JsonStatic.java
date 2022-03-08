package restapi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * access this servlet with: http://localhost:8080/json
 * this servlet is only for serving a static file that contain the ajax code
 * we could as well access directly the html file with http://localhost:8080/json.html 
 */
@WebServlet(name = "JsonStatic", urlPatterns = "/json")
public class JsonStatic extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("json.html").include(request, response);
    }
}
