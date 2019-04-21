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
        <title>Resumen</title>
    </head>
    <%
        Integer iRows = (Integer)request.getSession().getAttribute("rows");
        int iRowsObj = iRows.intValue();
    %>
    <body>
        <h1>Resumen de lo hecho:</h1> 
        <br><br>
        
        <p><%= iRowsObj %> dato(s) fueron afectados. </p>
        <a href="index.html">Go to home page</a>
       
    </body>
</html>
