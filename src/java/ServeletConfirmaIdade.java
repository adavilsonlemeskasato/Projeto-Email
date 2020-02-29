/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author davi
 */
@WebServlet(urlPatterns = {"/ServeletConfirmaIdade"})
public class ServeletConfirmaIdade extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        try (PrintWriter out = response.getWriter()) {
            String driver = "org.apache.derby.jdbc.ClientDriver";
            String url = "jdbc:derby://localhost:1527/email";
            String username = "root";
            String password = "3636";
            Connection connection = null;
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, username, password);
                Statement statement = connection.createStatement();

                String login = request.getParameter("login");

                String senha = request.getParameter("senha");

                String query = "SELECT nome, senha FROM usuario WHERE login='" + login + "'";
                ResultSet resultados = statement.executeQuery(query);

                if (resultados.next()) {
                    String nome = resultados.getString("nome");
                    String senha2 = resultados.getString("senha");

                    if (senha2.equals(senha)) {
                         out.println("Bem vindo "+ nome);
                    } else {
                       out.println("senha incorreta");
                    }

                } else {
                    out.println("usuario não encontrado");
                }

               

            } catch (ClassNotFoundException cnfe) {

                out.println("Error loading driver" + cnfe);
            } catch (SQLException sqle) {

                out.println("Error with connection" + sqle);

            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }

                } catch (SQLException ex) {
                   
                }
            }
        }

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
