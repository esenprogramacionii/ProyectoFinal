
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
        <title>First part finished</title>
    </head>
    <%
        Integer iRowsObj = (Integer)request.getSession().getAttribute("rows");
        int iRows = iRowsObj.intValue();
        
        Integer Prod = (Integer)request.getSession().getAttribute("product");
        Integer Quantity = (Integer)request.getSession().getAttribute("quantity");

    %>
    <body>
        <h1>Generic Message</h1>
        <br><br>
        <p><%= iRows %> rows where affected</p>
        <br><br>
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        <a href="index.html">Home</a>
    </body>
</html>