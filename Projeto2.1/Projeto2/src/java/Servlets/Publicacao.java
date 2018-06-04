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

/**
 *
 * @author Aluno
 */
@WebServlet(name = "Publicacao", urlPatterns = {"/Publicacao"})
public class Publicacao extends HttpServlet {

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
            out.println("   </head>");

            out.println("   <body>");
            out.println("       <a href=\"/Projeto2/Cadastro\"> <div style=\"border: 2px solid white; \"class=\"right-menu\">Signup</div> </a>");
            out.println("       <div class=\"background\">");
            out.println("           <a href=\"/Projeto2/Publicacao\"> <div class=\"right-menu\">Criar textos</div> </a>");
            out.println("           <a href=\"/Projeto2/Index\"> <div class=\"right-menu\">Home </div> </a>");
            out.println("           <div class = \"icon\"></div>");
            out.println("           <div class=\"left-menu\"><b>Alpha</b> by Pixelarity</div>");
            if (name != null) {
                out.println("       <p class = \"fontesup1\">Textos diversos</p>");
                out.println("       <p class = \"fontesup2\">Olá " +name+ "!</p>");
            }
            else{
                out.println("       <p class = \"fontesup1\">Textos diversos</p>");
                out.println("       <p class = \"fontesup2\">Seja bem vindo!</p>");
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
            out.println("               <h1>Publicação</h1>");
            out.println("               <form method = \"POST\" action = \"/Projeto2/Publicacao\">");
            out.println("                   Titulo<br>");
            out.println("                   <input type = \"text\" size = \"40\" name = title>");
            out.println("                   <br><br> ");
            out.println("                   <textarea rows = \"25\" cols = \"50\" name = \"text\">");
            out.println("                       Escreva o texto aqui...");
            out.println("                   </textarea>");
            out.println("                   <br>");
            out.println("                   Escolha um arquivo para upload");
            out.println("                   <input type=\"file\" name=\"pic\" accept=\"image/*\" class = \"button\">");
            out.println("                   <br><br>");
            out.println("                   <input type = \"submit\" name = \"submit\" value = \"Publicar\" id = \"button\">");
            out.println("               </form>");
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
        String name = (String) request.getSession().getAttribute("login");
        
        /*FUNÇÃO PARA ARMAZENAR O TEXTO DO USUÁRIO JUNTO COM O TITULO
        PROTÓTIPO:
        
        Database db = new Database();
            db.execute("INSERT INTO text (title, txt) "
                + "VALUES (?,?), ", request.getParameter("titulo"), request.getParameter("texto"), 
                request.getParameter("password"));
        
        */
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
            if (name != null) {
                out.println("       <p class = \"fontesup1\">Textos diversos</p>");
                out.println("       <p class = \"fontesup2\">Olá " +name+ "!</p>");
            }
            else{
                out.println("       <p class = \"fontesup1\">Textos diversos</p>");
                out.println("       <p class = \"fontesup2\">Seja bem vindo!</p>");
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
            out.println("               Texto inserido com sucesso!");
            out.println("               <br><br>");
            out.println("               Conteudo do texto: "+request.getParameter("text"));
            out.println("               <br><br>");
            out.println("               <a href=\"/Projeto2/index.html\">Voltar a pagina inicial</a>");
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
