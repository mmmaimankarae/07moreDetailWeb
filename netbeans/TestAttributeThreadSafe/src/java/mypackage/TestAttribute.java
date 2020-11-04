/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sarun
 */
public class TestAttribute extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String fooStr = request.getParameter("foo");
            String barStr = request.getParameter("bar");
            HttpSession session = request.getSession();
            //synchronized(getServletContext()) {
            //synchronized(session) {
            getServletContext().setAttribute("foo", Integer.parseInt(fooStr));
            //session.setAttribute("foo", Integer.parseInt(fooStr));
            Random rand = new Random();
            int num = rand.nextInt(10)+1;
            Thread.sleep(num * 1000);
            getServletContext().setAttribute("bar", Integer.parseInt(barStr));
            //session.setAttribute("bar", Integer.parseInt(barStr));
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestAttribute</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println(getServletContext().getAttribute("foo"));
            out.println(getServletContext().getAttribute("bar"));
            //out.println(session.getAttribute("foo"));
            //out.println(session.getAttribute("bar"));
            out.println("</body>");
            out.println("</html>");
            //}
        }
        catch (InterruptedException e) {
            
        }
        finally {
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
