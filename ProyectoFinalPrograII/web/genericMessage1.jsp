
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
        <br><br>
        <p><%= iRows %> rows where affected.</p>
        <br><br>
        <a href="genericMessageORD.jsp">Order more product to the same supplier</a>
        <br><br>
        <a href="index.html">Back Home</a>
    </body>
</html>
