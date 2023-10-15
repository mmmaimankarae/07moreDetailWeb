/* Servlet */
package mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestListener extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* อ่านAttribute ที่ถูกsetมาจากMyServletContextListener */
            Dog dog = (Dog) getServletContext().getAttribute("dog");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestListener</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Dog's breed is " + dog.getBreed() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally { 
            out.close();
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
