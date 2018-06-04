/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Database.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




@WebServlet(name = "Cadastro", urlPatterns = {"/Cadastro"})
public class Cadastro extends HttpServlet {

    String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private Pattern pattern = Pattern.compile(emailPattern);
    private Matcher matcher;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");  
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        try (PrintWriter out = response.getWriter()){
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
        out.println("               <h1>Cadastro de usuário</h1><br><br>");
        out.println("               <form method=\"POST\" action = \"/Projeto2/Cadastro\" >");
        out.println("               Email <br>");
        out.println("               <input type = \"text\" size = \"40\" name = email><br>");
        out.println("               Nome do usuario <br>");
        out.println("               <input type = \"text\" size = \"40\" name = login  >");
        out.println("               <br>");
        out.println("               Senha <br>");
        out.println("               <input type = \"text\" size = \"40\" name = password  >");
        out.println("               <br><br>");
        out.println("               <input type = \"submit\" name = \"submit\" value = \"Cadastrar\" />");
        out.println("               </form>");
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
        
        String email = request.getParameter("email");
        matcher = pattern.matcher(email);
        
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
            out.println("                   <td class = \"secondelement\"><a href = \"/Projeto2/indexPublicacao.html\"> Criar texto </a></td>");
            out.println("               </tr>");
            out.println("           </table>");
            out.println("       </div>");
            out.println("       <div class=\"central1\">");
            out.println("           <div class=\"header\">");          
        //verifica se todos os campos estão preenchidos corretamente para escrever no banco de dados
        if(!matcher.matches()){
            out.println("               Email invalido!");
            out.println("               <br><br>");
            out.println("               <a href=\"/Projeto2/Cadastro\">Voltar a pagina de cadastro</a>");
        }
        else if(request.getParameter("login").equals("")){
        out.println("                   Campo nome não pode ficar vazio!");
        out.println("                   <br><br>");
        out.println("                   <a href=\"/Projeto2/indexCadastro.html\">Voltar a pagina de cadastro</a>");
        }
        else if(request.getParameter("email").equals("")){
            out.println("               Campo sobrenome não pode ficar vazio!");
            out.println("               <br><br>");
            out.println("               <a href=\"/Projeto2/Cadastro\">Voltar a pagina de cadastro</a>");
        }
        else if(request.getParameter("password").equals("")){
            out.println("               Campo rua não pode ficar vazio!");
            out.println("               <br><br>");
            out.println("               <a href=\"/Projeto2/Cadastro\">Voltar a pagina de cadastro</a>");
        }
        else if(matcher.matches() && !request.getParameter("login").equals("") && !request.getParameter("email").equals("")
        && !request.getParameter("password").equals("")){
            Database db = new Database();
            db.execute("INSERT INTO user (login, email, password) "
                + "VALUES (?,?,?), ", request.getParameter("login"), request.getParameter("email"), 
                request.getParameter("password"));
            
            out.println("               Cadastro realizado com sucesso!");
            out.println("               <br><br>");
            out.println("               <a href=\"/Projeto2/Login\">Realizar Login</a>");
        }
        out.println("           </div>");
        out.println("       </div>");
        out.println("   </body>");
        out.println("</html>");
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
