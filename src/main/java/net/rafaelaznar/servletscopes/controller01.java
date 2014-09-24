/*
 * Copyright (C) 2013 rafael aznar
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.rafaelaznar.servletscopes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 * Servlet controller01
 *
 * @author rafael aznar
 */
public class controller01 extends HttpServlet {

    String strServletUsuario;
    static Logger log = Logger.getLogger(controller01.class);

    /**
     * Inicialiación
     *
     * @param oConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig oConfig) throws ServletException {
        super.init(oConfig);
        strServletUsuario = null;
        log.info("inicializando servlet controller01");
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.info("petición al controller01");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet controller01</title>");
            out.println("</head>");
            out.println("<body>");
            String strUsuario = (String) request.getParameter("usuario");
            HttpSession oSession = request.getSession();
            ServletContext oContext = request.getSession().getServletContext();
            if (strUsuario != null && !strUsuario.isEmpty()) {
                oSession.setAttribute("strSessionUsuario", strUsuario);
                strServletUsuario = strUsuario;
                oContext.setAttribute("strContextUsuario", strUsuario);
            }
            out.println("<h1>Servlet Controller01</h1><hr/>");
            out.println("Parámetro request: " + strUsuario + "<br />");
            out.println("Parámetro session: " + (String) oSession.getAttribute("strSessionUsuario") + "<br />");
            out.println("Parámetro servlet: " + (String) strServletUsuario + "<br />");
            out.println("Parámetro context: " + (String) oContext.getAttribute("strContextUsuario") + "<br />");
            out.println("<hr /><a href=\"" + request.getContextPath() + "\">Volver a " + request.getContextPath() + "</a><br/>");
            out.println("</body>");
            out.println("</html>");
        } catch (NumberFormatException e) {
            log.error("Se ha producido una excepción: " + e.getMessage(), e);
            throw new RuntimeException("Se ha producido una excepción: " + e.getMessage(), e);
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
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
