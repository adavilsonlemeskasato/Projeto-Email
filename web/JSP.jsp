<%-- 
    Document   : JSP
    Created on : 28/02/2020, 21:00:10
    Author     : davi
--%>

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
        <title>JSP Page</title>
    </head>
    <body>
        olá, <%= request.getParameter("nome")%>.<br/>
        Seja bem-vindo
        
        <h1>Hello World!</h1>
    </body>
</html>
