<%-- 
    Document   : genericMessage
    Created on : Mar 29, 2019, 8:45:35 PM
    Author     : balbi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        Integer iRowsObj = (Integer)request.getSession().getAttribute("rows");
        int iRows = iRowsObj.intValue();
    %>
    <body>
        <h1>Primera parte de la orden completada</h1>
        <br><br>
        <p><%= iRows %> rows where affected.</p>
        <br>
        <a href="genericMessageORD.jsp">Solicitar más productos al proveedor</a>
        <br><br>
        <a href="index.html">Back Home</a>
    </body>
</html>
