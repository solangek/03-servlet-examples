/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoservlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
/**
 * this second version of the Servlet shows you that it can handle the GET as well
 * no external HTML page is necessary, the Servlet displays it
 * @author solangekarsenty
 */
@WebServlet( name="BookReview2", urlPatterns = "/BookReview2"  )
public class BookReview2 extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* Set the "content type" header of the response so that
        the browser knows we are sending HTML and not just raw text.
        If you don't do this then the HTML tags will not be interpreted.
         */
        response.setContentType("text/html");
        //Get the response's PrintWriter to return text to the client.
        PrintWriter toClient = response.getWriter();

        String fName = request.getParameter("fname");
        String chp = request.getParameter("favchap");
        String writeServlet = request.getParameter("writeservlet");

        // Respond to client with a thank you
        // we generate a full html page to be displayed by the browser
        toClient.println("<HTML>");
        toClient.println("<head><TITLE>Book Review Response</TITLE></head><body>");
        toClient.print(fName);
        toClient.println(", thank you for your feedback.<BR>");
        toClient.print("Your favorite chapter so far is chapter ");
        toClient.println(chp + ".<br/>");
        toClient.println("<hr/>");
        toClient.println("You are ");
        if (writeServlet == null) {
            toClient.print("not ");
        }
        toClient.println("planning to write a servlet.");
        toClient.println("</body></html>");
        // Close the writer; the response is done. 
        // if we don't close the browser expects more data (spinning!)
        toClient.close();
    }
    /**
     * the GET request simply displays the HTML form
     * note that in this case we do NOT reveal to the user the path of the HTML file bookreview.html
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // this is how we include an external HTML file in our response
        request.getRequestDispatcher("bookreview.html").include(request, response);

        // instead of doing this:

//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter toClient = response.getWriter();
//        toClient.println("<html>\n" +
//"    <head>\n" +
//"        <title>TODO supply a title</title>\n" +
//"        <meta charset=\"UTF-8\">\n" +
//"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
//"    </head>\n" +
//"    <body>\n" +
//"        <H1>Book Review</H1>\n" +
//"        <form action=\"BookReview2\" method=\"POST\">\n" +
//"            What is your first name?\n" +
//"            <input type=\"text\" name=\"fname\">\n" +
//"             \n" +
//"            <BR><BR>Check if you are planning to write a servlet\n" +
//"            <input type=\"checkbox\" name=\"writeservlet\">\n" +
//"             \n" +
//"            <BR><BR>What was your favorite chapter so far?<BR>\n" +
//"            <input type=radio name=favchap value=1>chap 1 <br/>\n" +
//"            <input type=radio name=favchap value=2>chap 2 <br/>\n" +
//"            <input type=radio name=favchap value=3>chap 3 <br/>\n" +
//"            <input type=radio name=favchap value=4>chap 4 <br/>\n" +
//"            <input type=radio name=favchap value=5>chap 5 <br/>\n" +
//"            <input type=radio name=favchap value=6>chap 6 <br/>\n" +
//"            <BR><BR><input type=\"submit\"><input type=\"reset\">\n" +
//"        </form>\n" +
//"    </body>\n" +
//"</html>");
//        toClient.close();

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "The book review demo";
    }

}
