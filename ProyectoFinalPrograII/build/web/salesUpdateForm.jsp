<%@page import="Inventory.prografinal.objects.SalesObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Sales</title>
    </head>
    <%
        SalesObj CSales = 
                (SalesObj)request.getSession().getAttribute("sales");
        
    %>
    <body>
        <h1>Update Sale</h1>
        <br><br>
        
        <form id="myform" name="myform" action="SalesServlet" method="get">
            <label>Id:</label><br>
            <input type="number" id="nonId" name="nonId" value="<%= CSales.getId() %>" disabled/>
            <br><br>
            
            
            <label>First Name:</label><br>
            <input type="text" id="firstname" name="firstname" value="<%= CSales.getFirstname() %>" />
            <br><br>
            
            <label>Last Name:</label><br>
            <input type="text" id="lastname" name="lastname" value="<%= CSales.getLastname() %>" />
            <br><br>
            
            
            
            <label>Date:</label><br>
            <input type="text" id="date" name="date" value="<%= CSales.getDate() %>" readonly/>
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Update"/>
            <input type="hidden" id="formid" name="formid" value="5" />
            <input type="hidden" id="id" name="id" value="<%= CSales.getId() %>" />
        </form>
        
        <br><br>
        <a href="salesForm.jsp">Back</a>
         <br><br>
        <a href="indexX.html">Select Page</a>
        <br><br>
        <a href="index.html">Home</a>
    </body>
</html>
