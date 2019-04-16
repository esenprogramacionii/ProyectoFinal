<%-- 
    Document   : genericMessage
    Created on : Mar 29, 2019, 8:45:38 PM
    Author     : Luis Rivera
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        Integer iRows = (Integer)request.getSession().getAttribute("rows");
    %>
    <body>
        <h1>Generic Message</h1> <br><br>
        
        <p><%= iRows.intValue() %>rows were affected </p>
        <a href="Proveedores.jsp">Regresar a Proveedores</a>
       
    </body>
</html>
