package demoservlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.security.Principal;

/**
 * This servlet sends an image to the client.
 */
@WebServlet(name = "SendImage", urlPatterns = {"/logo"})
public class SendImage extends HttpServlet {

    /**
     * Processes requests for  HTTP <code>GET</code> method.
     * returns an image to the client.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException  if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // this is a useful object that knows the path of our application
        // so we get access to the image located under "web" folder
        ServletContext sc = getServletContext();

        // resource stream will be automatically closed
        try (InputStream is = sc.getResourceAsStream("/images/space.jpg")) {

            OutputStream os = response.getOutputStream();

            // somehow unconventionally, we use the response stream for different purposes/content types
            if (is == null) {
                response.setContentType("text/plain");
                new PrintWriter(os).println("No image found");
            } else {
                response.setContentType("image/jpeg");
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = is.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
            }
            os.close();
        }
    }
}
