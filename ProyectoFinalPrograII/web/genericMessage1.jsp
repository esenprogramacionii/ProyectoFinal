
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
        <link href="Styles/tableStyle1.css" rel="stylesheet" type="text/css"/>
        <title>Success</title>
    </head>
    <%
        Integer iRowsObj = (Integer)request.getSession().getAttribute("rows");
        int iRows = iRowsObj.intValue();
    %>
    <body>
        <h1>Success</h1>
        <br><br>
        <p><%= iRows %> rows where affected.</p>
        <br><br>
        <a href="OrderServlet?formid=2">Order more product</a>
        <br><br>
        <a href="indexX.html">Select Page</a>
        <br><br>
        <a href="index.html">Home</a>
    </body>
</html>
