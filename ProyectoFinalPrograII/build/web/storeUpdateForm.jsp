<%-- 
    Document   : storeUpdateForm
    Created on : Apr 18, 2019, 2:05:30 PM
    Author     : Rhina Marin
--%>

<%@page import="Inventory.prografinal.objects.storeObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Store</title>
    </head>
    <%
        storeObj CStore = 
                (storeObj)request.getSession().getAttribute("store");
    %>
    <body>
        <h1>Update Store</h1>
        <br><br>
        
        <form id="myform" name="myform" action="storeServlet" method="get">
            <label>Id:</label><br>
            <input type="number" id="idnon" name="idnon" value="<%= CStore.getId() %>" disabled/>
            <br><br>
            
            <label>Name:</label><br>
            <input type="text" id="name" name="name" value="<%= CStore.getName() %>" />
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Create"/>
            <input type="hidden" id="formid" name="formid" value="5" />
            <input type="hidden" id="id" name="id" value="<%= CStore.getId() %>" />
        </form>
        
        <br><br>
        <a href="storeForm.jsp">Back</a>
         <br><br>
        <a href="indexX.html">Select Page</a>
        <br><br>
        <a href="index.html">Home</a>
    </body>
</html>
