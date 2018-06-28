package Servlets;

import Configurations.ConfigurationsMySQL;
import Database.Database;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author igorv
 */
@WebServlet(name = "Index", urlPatterns = {"/Index"})
public class Index extends HttpServlet {
    private final Database db = new Database(new ConfigurationsMySQL());
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {   
        String name = (String) request.getSession().getAttribute("login");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            if (name != null) {
                out.println("       <p class = \"fontesup2\">Olá " +name+ "! <a href = \"/Projeto2/Logout\">Sair da sessão </a></p> ");
            }
            
            ResultSet rs = db.query("SELECT * FROM posts");
            while(rs.next()){
                out.println("           "+rs.getString("post_title"));
                out.println("           "+rs.getString("post_text"));
                out.println("           <br><br>");
                out.println("           <hr>");
                out.println("           <br><br>");               
            }                                 
        } catch (SQLException ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
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
