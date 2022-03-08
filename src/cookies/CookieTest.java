/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cookies;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
/**
 * a Servlet that simply displays current cookies for that domain
 * and writes a cookie at each request
 * @author solangekarsenty
 */
@WebServlet( name="CookieTest", urlPatterns = "/CookieTest"  )
public class CookieTest extends HttpServlet {

    /**
     * Processes requests for  HTTP <code>GET</code>
     * displays current cookies for that domain and also
     * writes a cookie at each request.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {

        // on first visit we create a cookie
        Cookie visit = new Cookie("visited", "true");
        visit.setMaxAge(60*60*24); // 1 day
        response.addCookie(visit);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html><html>" + "<head><title>Active Cookies</title></head>"
                + "<body><h1>Active Cookies</h1><table border=1 ><TR><th>Cookie Name</th><th>Cookie Value</th>");
        Cookie[] cookies = request.getCookies();
        // print out all cookies
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                out.println("<tr><td>" + cookie.getName() + "</td><td>" + cookie.getValue() + "</td></tr>");
            }
        } else {
            out.println("<tr><th colspan=2>No cookies");
        }
        out.println("</table></body></html>");
    }
}
