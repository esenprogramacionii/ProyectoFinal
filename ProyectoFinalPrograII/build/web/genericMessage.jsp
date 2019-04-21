<<<<<<< HEAD

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
=======
<%-- 
    Document   : genericMessage
    Created on : Mar 29, 2019, 8:45:35 PM
    Author     : balbi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

>>>>>>> ABC1
<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
<<<<<<< HEAD
        <title>First part finished</title>
=======
        <title>JSP Page</title>
>>>>>>> ABC1
    </head>
    <%
        Integer iRowsObj = (Integer)request.getSession().getAttribute("rows");
        int iRows = iRowsObj.intValue();
    %>
    <body>
        <h1>Generic Message</h1>
        <br><br>
        <p><%= iRows %> rows where affected</p>
        <br><br>
        <a href="index.html">Home</a>
    </body>
<<<<<<< HEAD
</html>
=======
</html>
>>>>>>> ABC1
