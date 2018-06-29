package Servlets;

import Configurations.Configurations;
import Configurations.ConfigurationsMySQL;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




@WebServlet(name = "Cadastro", urlPatterns = {"/Cadastro"})
public class Cadastro extends HttpServlet {

    String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    String passwordPattern = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{4,}$";
    String usernamePattern = "^[a-z0-9_-]{3,15}$";
    private Pattern ppattern = Pattern.compile(passwordPattern);
    private Pattern upattern = Pattern.compile(usernamePattern);
    private Pattern pattern = Pattern.compile(emailPattern);
    private Matcher matcher;
    private Matcher umatcher;
    private Matcher pmatcher;
    
    private final Database db = new Database(new ConfigurationsMySQL());
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");  
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
        int ckpUser = 0;
        int ckpEmail = 0;
        String email = request.getParameter("email");
        String username = request.getParameter("nome");
        String password = request.getParameter("senha");
        String address = request.getParameter("endereco");
        System.out.println("Email: "+email);
        System.out.println("Usuario: "+username);
        System.out.println("Endereco: "+address);
        System.out.println("Password: "+password);
        umatcher = upattern.matcher(username);
        pmatcher = ppattern.matcher(password);
        matcher = pattern.matcher(email);
        ResultSet rs;
                
        rs = db.query("SELECT user_name FROM users WHERE user_name='"+request.getParameter("login")+"'");
        try{ 
        if(rs.isBeforeFirst()!=false){
                ckpUser=1;          
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        rs = db.query("SELECT user_email FROM users WHERE user_email='"+request.getParameter("email")+"'");
        try {
            if(rs.isBeforeFirst()!=false){
                ckpEmail=1;          
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try (PrintWriter out = response.getWriter()) {         
        //verifica se todos os campos estão preenchidos corretamente para escrever no banco de dados
        if(!matcher.matches()){
            out.println("               <br><br>");
            out.println("               Email invalido!");
            out.println("               <br><br>");
            out.println("               <a href=\"cadastro.html\">Voltar a pagina de cadastro</a>");
        }
        else if(!umatcher.matches()){
            out.println("               <br><br>");
            out.println("               Nome de usuario invalido! O nome deve ter no minimo 3 letras e no maximo 15, apenas os caracteres especiais '-' e '_' sao permitidos");
            out.println("               <br><br>");
            out.println("               <a href=\"cadastro.html\">Voltar a pagina de cadastro</a>");
        }
        else if(!pmatcher.matches()){
            out.println("               <br><br>");
            out.println("               Senha invalida! A senha deve conter no minimo 4 caracteres e deve conter uma letra e um número");
            out.println("               <br><br>");
            out.println("               <a href=\"cadastro.html\">Voltar a pagina de cadastro</a>");
        }
        else if(request.getParameter("nome").equals("")){
            out.println("               <br><br>");
            out.println("                   Campo nome não pode ficar vazio!");
            out.println("                   <br><br>");
            out.println("                   <a href=\"cadastro.html\">Voltar a pagina de cadastro</a>");
        }
        else if(request.getParameter("email").equals("")){
            out.println("               <br><br>");
            out.println("               Campo email não pode ficar vazio!");
            out.println("               <br><br>");
            out.println("               <a href=\"cadastro.html\">Voltar a pagina de cadastro</a>");
        }
        else if(request.getParameter("senha").equals("")){
            out.println("               <br><br>");
            out.println("               Campo senha não pode ficar vazio!");
            out.println("               <br><br>");
            out.println("               <a href=\"cadastro.html\">Voltar a pagina de cadastro</a>");
        }
        else if(ckpEmail == 1){
            out.println("               <br><br>");
            out.println("               Email já existente, faça outro cadastro!");
            out.println("               <br><br>");
            out.println("               <a href=\"cadastro.html\">Voltar a pagina de cadastro</a>");
        }
        else if(ckpUser == 1){
            out.println("               <br><br>");
            out.println("               Nome já existente, faça outro cadastro!");
            out.println("               <br><br>");
            out.println("               <a href=\"cadastro.html\">Voltar a pagina de cadastro</a>");
        }
        else if(matcher.matches()){
               boolean ok = 
               db.execute("INSERT INTO users (user_name, user_address, user_email, user_password) "
                    + "VALUES (?,?,?,?)",username, address, email, password); //verifica se retorna algo do bd
            if(ok){
                out.println("               <br><br>");
                out.println("               Cadastro realizado com sucesso!");
                out.println("               <br><br>");
                out.println("               <a href=\"login.html\">Realizar Login</a>");
                //cadastro realizado com sucesso
            }
            else{
                out.println("               <br><br>");
                out.println("               Falha ao fazer conexão com o banco de dados!");
                out.println("               <br><br>");
                out.println("               <a href=\"login.html\">Tentar novamente</a>");
                //retornar erro na conexão com o banco de dados
            } 
        }
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
