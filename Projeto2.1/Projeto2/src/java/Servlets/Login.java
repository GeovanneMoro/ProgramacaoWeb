package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
        out.println("               <h1>Login</h1>");
        out.println("               <br><br>");
        out.println("               <form action = \"/Projeto2/Login\" method = \"POST\"> <br>");
        out.println("               Usuario <br>");
        out.println("               <input type = \"text\" name = \"login\" value = \"\"> <br>");
        out.println("               Senha <br>");
        out.println("               <input type = \"text\" name = \"password\" value = \"\"><br><br>");
        out.println("               <input type = \"submit\" value = \"Entrar\"><br><br>");
        out.println("               <a href = \"/Projeto2/indexCadastro.html\">Ainda não possui conta? Cadastre-se clicando aqui! </a>");
        out.println("           </div>");
        out.println("       </div>");
        out.println("   </body>");
        out.println("</html>");
            }
    
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    
        String name = request.getParameter("login");
        String password = request.getParameter("password");
        
                
    try (PrintWriter out = response.getWriter()) {
    if(name.equals("igor")){
        request.getSession().setAttribute("login", name);
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
    out.println("           <p class = \"fontesup2\">Bem vindo " +name+"!</p>");
    out.println("           <table class = \"tabela-botao\">");
    out.println("               <tr>");
    out.println("                   <td class = \"firstelement\"><a href = \"/Projeto2/Login\"> Logar </a></td>");
    out.println("                   <td class = \"secondelement\"><a href = \"/Projeto2/Publicacao\"> Criar texto </a></td>");
    out.println("               </tr>");
    out.println("           </table>");
    out.println("       </div>");
    out.println("       <div class=\"central1\">");
    out.println("           <div class=\"header\">");
    out.println("               <h1>Login</h1>");
    out.println("               <br><br>");
    out.println("               <p>Usuário logado!<p>");
    out.println("           </div>");
    out.println("       </div>");
    out.println("   </body>");
    out.println("</html>");
    }
    else{
        response.sendRedirect("Index");
    }
}
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
