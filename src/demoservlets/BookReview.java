/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoservlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author solangekarsenty
 */
@WebServlet(name = "BookReview", urlPatterns = {"/BookReview"} )
public class BookReview extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method. Produces
     * a summary of the user input as a HTML page.
     *
     * @param request servlet http request
     * @param response servlet http response
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
        response.setContentType("text/html;charset=UTF-8");
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
        toClient.println(", thank you for your feedback.<br/>");
        toClient.print("Your favorite chapter so far is chapter ");

        toClient.println(chp + ".<br/>");
        toClient.println("You are ");
        if (writeServlet == null) {
            toClient.print("not ");
        }
        toClient.println("planning to write a servlet.<br/>");

        toClient.println("</body></html>");
        // The servlet container closes the stream
        // toClient.close();
    }

    /**
     * in case the user loads this url with GET, will be redirected to form:
     * the URL page "/bookreview.html"
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("/bookreview.html");
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
