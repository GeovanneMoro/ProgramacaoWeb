/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

@WebServlet(name = "Busca", urlPatterns = {"/Busca"})
public class Busca extends HttpServlet {

    private final Database db = new Database(new ConfigurationsMySQL());
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        try (PrintWriter out = response.getWriter()) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("   <head>");
        out.println("       <meta charset=\"utf-8\" />");
        out.println("       <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
        out.println("       <title> - ALPHA - </title>");
        out.println("       <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
        out.println("       <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"style.css\" />");
        out.println("       <script src=\"main.js\"></script>");
        out.println("   </head>");

        out.println("   <body>");
        out.println("       <a href=\"/Projeto2/Cadastro\"> <div style=\"border: 2px solid white; \"class=\"right-menu\">Signup</div> </a>");
        out.println("       <div class=\"background\">");
        out.println("           <a href=\"/Projeto2/Publicacao\"> <div class=\"right-menu\">Criar textos</div> </a>");
        out.println("           <a href=\"/Projeto2/Index\"> <div class=\"right-menu\">Home </div> </a>");
        out.println("           <div class = \"icon\"></div>");
        out.println("           <div class=\"left-menu\"><b>Alpha</b> by Pixelarity</div>");
        out.println("           <p class = \"fontesup1\">Textos diversos</p>");
        out.println("           <table class = \"tabela-botao\">");
        out.println("               <tr>");
        out.println("                   <td class = \"firstelement\"><a href = \"/Projeto2/Login\"> Logar </a></td>");
        out.println("                   <td class = \"secondelement\"><a href = \"/Projeto2/Publicacao\"> Criar texto </a></td>");
        out.println("               </tr>");
        out.println("           </table>");
        out.println("       </div>");
        out.println("       <div class=\"central1\">");
        out.println("           <div class=\"header\">");
        out.println("               <h1>Buscar Texto</h1><br><br>");
        out.println("               <form method=\"POST\" action = \"/Projeto2/Busca\" >");
        out.println("               Digite o título do texto <br>");
        out.println("               <input type = \"text\" size = \"40\" name = title><br>");
        out.println("               <input type = \"submit\" name = \"submit\" value = \"Buscar\" />");
        out.println("               </form>");
        out.println("           </div>");
        out.println("       </div>");
        out.println("   </body>");
        out.println("</html>");
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
        processRequest(request, response);
        try (PrintWriter out = response.getWriter()) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("   <head>");
        out.println("       <meta charset=\"utf-8\" />");
        out.println("       <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
        out.println("       <title> - ALPHA - </title>");
        out.println("       <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
        out.println("       <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"style.css\" />");
        out.println("       <script src=\"main.js\"></script>");
        out.println("   </head>");

        out.println("   <body>");
        out.println("       <a href=\"/Projeto2/Cadastro\"> <div style=\"border: 2px solid white; \"class=\"right-menu\">Signup</div> </a>");
        out.println("       <div class=\"background\">");
        out.println("           <a href=\"/Projeto2/Publicacao\"> <div class=\"right-menu\">Criar textos</div> </a>");
        out.println("           <a href=\"/Projeto2/Index\"> <div class=\"right-menu\">Home </div> </a>");
        out.println("           <div class = \"icon\"></div>");
        out.println("           <div class=\"left-menu\"><b>Alpha</b> by Pixelarity</div>");
        out.println("           <p class = \"fontesup1\">Textos diversos</p>");
        out.println("           <table class = \"tabela-botao\">");
        out.println("               <tr>");
        out.println("                   <td class = \"firstelement\"><a href = \"/Projeto2/Login\"> Logar </a></td>");
        out.println("                   <td class = \"secondelement\"><a href = \"/Projeto2/Publicacao\"> Criar texto </a></td>");
        out.println("               </tr>");
        out.println("           </table>");
        out.println("       </div>");
        out.println("       <div class=\"central1\">");
        out.println("           <div class=\"header\">");
        ResultSet rs = db.query("SELECT * FROM posts WHERE post_title LIKE '%"+ request.getParameter("title")+"%'");
        while(rs.next()){
            out.println("           "+rs.getString("post_title"));
            out.println("           <hr>");
            out.println("           "+rs.getString("post_text"));
            out.println("           <br><br>");
        }
        out.println("               </form>");
        out.println("           </div>");
        out.println("       </div>");
        out.println("   </body>");
        out.println("</html>");
            
    }   
        catch (SQLException ex) {
            Logger.getLogger(Busca.class.getName()).log(Level.SEVERE, null, ex);
        }
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
