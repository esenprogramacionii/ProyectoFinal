
<%@page import="Inventory.prografinal.objects.categoryObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Category</title>
    </head>
    <%
        categoryObj CCategory = 
                (categoryObj)request.getSession().getAttribute("category");
    %>
    <body>
        <h1>Update Store</h1>
        <br><br>
        
        <form id="myform" name="myform" action="categoryServlet" method="get">
            <label>Id:</label><br>
            <input type="number" id="idnon" name="idnon" value="<%= CCategory.getId() %>" disabled/>
            <br><br>
            
            <label>Name:</label><br>
            <input type="text" id="name" name="name" value="<%= CCategory.getName() %>" />
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Create"/>
            <input type="hidden" id="formid" name="formid" value="5" />
            <input type="hidden" id="id" name="id" value="<%= CCategory.getId() %>" />
        </form>
        
        <br><br>
        <a href="categoryForm.jsp">Back</a>
         <br><br>
        <a href="indexX.html">Select Page</a>
        <br><br>
        <a href="index.html">Home</a>
    </body>
</html>
