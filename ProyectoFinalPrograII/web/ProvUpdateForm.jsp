<%@page import="Inventory.prografinal.objects.ProvObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="Scripts/jquery-3.3.1.js" type="text/javascript"></script>
        <script src="Scripts/jquery.validate.js" type="text/javascript"></script>
        <script src="Scripts/ProvFormScript.js" type="text/javascript"></script>
        <title>Update suppliers</title>
    </head>
     <%
        ProvObj CProv = 
                (ProvObj)request.getSession().getAttribute("provs");
        
    %>
    <body>
        <h1>Update suppliers</h1>
        <br><br>
        
         <form id="myform" name="myform" action="ProvSERVLET" method="get">
            <label>Id:</label><br>
            <input type="number" id="nonId" name="nonId" value="<%= CProv.getId() %>" disabled/>
            <br><br>
            
            
            <label>Name:</label><br>
            <input type="text" id="name" name="name" value="<%= CProv.getName() %>" />
            <br><br>
            
            
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Update"/>
            <input type="hidden" id="formid" name="formid" value="5" />
            <input type="hidden" id="id" name="id" value="<%= CProv.getId() %>" />
            
        </form>
           
            <br><br>
        <a href="Proveedores.jsp">Back</a>
        <br><br>
        <a href="indexX.html">Select Page</a>
        <br><br>
        <a href="index.html">Home</a>
    </body>
</html>
