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
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");

                out.println("<head>");
                    out.println("<meta charset=\"utf-8\" />");
                    out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
                    out.println("<title> - ALPHA - </title>");
                    out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
                    out.println("<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"style.css\" />");
                    out.println("<script src=\"main.js\"></script>");
                out.println("</head>");

                out.println("<body>");
                    out.println("<a href=\"/Projeto2/indexCadastro.html\"> <div style=\"border: 2px solid white; \"class=\"right-menu\">Signup</div> </a>");
                    out.println("<div class=\"background\">");
                        out.println("<a href=\"/Projeto2/indexPublicacao.html\"> <div class=\"right-menu\">Criar textos</div> </a>");
                        out.println("<a href=\"/Projeto2/index.html\"> <div class=\"right-menu\">Home </div> </a>");
                        out.println("<div class = \"icon\"></div>");
                                out.println("<div class=\"left-menu\"><b>Alpha</b> by Pixelarity</div>");
                                out.println("<p class = \"fontesup1\">Alpha 1</p>");
                                out.println("<p class = \"fontesup2\">Consectetur adipiscing elit.</p>");
                                out.println("<table class = \"tabela-botao\">");
                                out.println("<tr>");
                                out.println("<td class = \"firstelement\"> Criar texto </td>");
                                out.println("<td class = \"secondelement\"> Botão 2 </td>");
                                out.println("</tr>");
                                out.println("</table>");
                        out.println("</div>");

                    out.println("<div class=\"central1\">");
                        out.println("<div class=\"header\">");
                        
                        out.println("Texto inserido com sucesso!");
                        out.println("<br><br>");
                        out.println("Conteudo do texto: "+request.getParameter("text"));
                        out.println("<br><br>");
                        out.println("<a href=\"/Projeto2/index.html\">Voltar a pagina inicial</a>");

                    out.println("</div>");

                    out.println("</body>");

            out.println("</html>");
           
        }      

    }

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
        
        try (PrintWriter out = response.getWriter()) {
        
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
