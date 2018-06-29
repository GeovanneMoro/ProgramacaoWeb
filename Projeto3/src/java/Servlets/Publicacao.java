package Servlets;

import Configurations.ConfigurationsMySQL;
import Database.Database;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Publicacao", urlPatterns = {"/Publicacao"})
public class Publicacao extends HttpServlet {

    private final Database db = new Database(new ConfigurationsMySQL());
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String name = (String) request.getSession().getAttribute("login");
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
            out.println("<script src = \"http://cloud.tinymce.com/stable/tinymce.min.js\"></script>");
            out.println("<script>tinymce.init({selector: 'textarea',   plugins: \"image\",\n" +"  menubar: \"insert\",\n" +"  toolbar: \"image\",});</script>");
            out.println("   </head>");
            out.println("   <body>");
            out.println("       <div class=\"background\">");
            out.println("          <a href=\"/Projeto2/Cadastro\"> <div <div class=\"right-menu\">Cadastrar</div> </a>");
            out.println("           <a href=\"/Projeto2/Publicacao\"> <div class=\"right-menu\">Publicar textos</div> </a>");
            out.println("           <a href=\"/Projeto2/Busca\"> <div class=\"right-menu\">Buscar </div> </a>");
            out.println("           <a href=\"/Projeto2/Main\"> <div class=\"right-menu\">Home </div> </a>");
            out.println("           <div class = \"icon\"></div>");
            out.println("           <div class=\"left-menu\"><b>Alpha</b> by Pixelarity</div>");
            out.println("       <p class = \"fontesup1\">Textos diversos</p>");
            if (name != null) {
                out.println("       <p class = \"fontesup2\">Olá " +name+ "! <a href = \"/Projeto2/Logout\">Sair da sessão </a></p> ");
            }
            out.println("           <table class = \"tabela-botao\">");
            out.println("               <tr>");
            out.println("                   <td class = \"firstelement\"><a href = \"/Projeto2/Login\"> Logar </a></td>");
            out.println("                   <td class = \"secondelement\"><a href = \"/Projeto2/Publicacao\"> Criar texto </a></td>");
            out.println("               </tr>");
            out.println("           </table>");
            out.println("       </div>");
            out.println("       <div class=\"central1\">");
            out.println("           <div class=\"header\">");
            if (name == null) {
                out.println("<p>Apenas usuarios cadastrados podem publicar textos, faça seu login<a href = \"/Projeto2/Login\">!</a></p>");
            }else{
                out.println("               <h1>Publicação</h1>");
                out.println("               <form method = \"POST\" action = \"/Projeto2/Publicacao\">");
                out.println("                   Titulo<br>");
                out.println("                   <input type = \"text\" size = \"40\" name = title>");
                out.println("                   <br><br> ");
                out.println("                   <textarea rows=\"20\" cols=\"50\" name = text></textarea>");
                out.println("                   <br><br>");
                out.println("                   <input type = \"submit\" name = \"submit\" value = \"Publicar\" id = \"button\">");
                out.println("               </form>");
            }
                out.println("       </div>");
                out.println("   </body>");
                out.println("</html>");
            }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String titulo = request.getParameter("titulo");
        String texto = request.getParameter("texto");
        
        String name = (String) request.getSession().getAttribute("login");
        int var = 0;
        ResultSet rs;
        try{
            rs = db.query("SELECT * FROM users WHERE user_name = '"+name+"'");
            while(rs.next()){
                var = rs.getInt("user_id");
            }
        }
        catch(SQLException e){
            
        }
        if(var == 0){
                response.sendRedirect("Login");
        }
        db.execute("INSERT INTO posts (post_title, post_text, user_id) "
            + "VALUES (?,?,?)", titulo, texto, var);
        
        try (PrintWriter out = response.getWriter()) {  
            out.println("<br><br>");
            out.println("Texto inserido com sucesso!");
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
