<%-- 
    Document   : Padaria.jsp
    Created on : 28/02/2020, 22:18:04
    Author     : davi
--%>

<%@page import="java.util.logging.Logger"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
   
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
        <script src="js/jquery-3.3.1.slim.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="css/bootstrap.min.css"></script>
       
        <title>Padaria</title>
    </head>
    <body>
        <%@include file="cabecalho.jsp"%>
        <a href="menu.jsp">Inicio</a>
        
         <%
             String driver = "org.apache.derby.jdbc.ClientDriver";
            String url = "jdbc:derby://localhost:1527/padaria";
            String username = "root";
            String password = "3636";
            Connection connection = null;
                 
             try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, username, password);
                Statement statement = connection.createStatement();

               String query="select * from categoria_produto";
               ResultSet resultados=statement.executeQuery(query);

               while(resultados.next()){
                   out.println("<a href=\"categoria_produto.jsp?cod_cat=");
                   out.println(resultados.getString("codigo_categoria")+"\">");
                   out.println(resultados.getString("nome_categoria")+"</a>");
                   
               }
               connection.close();
               
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
           %>
      
           <a href="carrinho.jsp">Meu Carrinho</a><br/>
    
           
    </body>
</html>
