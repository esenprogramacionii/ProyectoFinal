<%-- 
    Document   : ProvUpdateForm.jsp
    Created on : Apr 18, 2019, 3:48:00 PM
    Author     : Luis Rivera
--%>
<%@page import="Objects.ProvObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Proveedores</title>
    </head>
     <%
        ProvObj CProv = 
                (ProvObj)request.getSession().getAttribute("provs");
        
    %>
    <body>
        <h1>Actualizar Proveedores</h1>
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
    </body>
</html>
