/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restapi;

import demoservlets.Dummy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import java.util.Vector;
import javax.servlet.annotation.WebServlet;
import javax.json.*;
import java.io.OutputStream;
/**
 *
 * @author solangekarsenty
 */
@WebServlet( name="JsonServlet", urlPatterns = "/JsonServlet"  )
public class JsonServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> and <code>POST</code> method to return a JSON object.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     *
     * the servlet output:
     * {
     *     "value": "55",
     *     "name": "Dummy number 55"
     * }
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // very important:
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // we build some random data to demonstrate JSON
        // { "name":"...", "value": "..." }

        Dummy d = new Dummy(55);
        // return d as JSON
        JsonObjectBuilder builder = Json.createObjectBuilder();
        builder.add("name", d.getName());
        builder.add("value", d.getDummyInt());

        JsonObject jsonObject = builder.build();

        try (OutputStream out = response.getOutputStream()) {
            JsonWriter jsonw = Json.createWriter(out);
            jsonw.writeObject(jsonObject);
            jsonw.close();
        }
    }

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
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
