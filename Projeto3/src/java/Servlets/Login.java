package Servlets;

import Configurations.ConfigurationsMySQL;
import Database.Database;
import java.sql.ResultSet;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
    }
    private final Database db = new Database(new ConfigurationsMySQL());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);    
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    
        String name = request.getParameter("login");
        String password = request.getParameter("password");
        ResultSet rs = null;        
                
    try (PrintWriter out = response.getWriter()) {
            if(name.equals("")){
            out.println("       <div class=\"central1\">");
            out.println("           <div class=\"header\">");
            out.println("               <br><br>");
            out.println("               Campo nome não pode ficar vazio!");
            out.println("               <br><br>");
            out.println("               <a href=\"login.html\">Voltar a pagina de login</a>");
            out.println("           </div>");
            out.println("       </div>");
            out.println("   </body>");
            out.println("</html>");
    }
    else if(password.equals("")){
            out.println("       <div class=\"central1\">");
            out.println("           <div class=\"header\">");
            out.println("               <br><br>");
            out.println("               Campo senha não pode ficar vazio!");
            out.println("               <br><br>");
            out.println("               <a href=\"login.html\">Voltar a pagina de cadastro</a>");
            out.println("           </div>");
            out.println("       </div>");
            out.println("   </body>");
            out.println("</html>");
        } 
    else{
        rs = this.db.query("SELECT user_name,user_password FROM users WHERE "
        +"user_name='"+name+"' AND user_password='"+password+"'");
    
    if (name != null && rs.isBeforeFirst()!=false) {
        out.println("       </div>");
        out.println("       <div class=\"central1\">");
        out.println("           <div class=\"header\">");
        request.getSession().setAttribute("login", name);
        out.println("               <h1>Login</h1>");
        out.println("               <br><br>");
        out.println("               <p>Usuário logado!<p>");
    }
    else{
        out.println("       </div>");
        out.println("       <div class=\"central1\">");
        out.println("           <div class=\"header\">");
        out.println("Usuário não encontrado!");
        out.println("<br><br>");
        out.println("<a href=\"login.html\">Voltar à página de login</a>");
    }
        out.println("           </div>");
        out.println("       </div>");
        out.println("   </body>");
        out.println("</html>");
    }
    }       catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
