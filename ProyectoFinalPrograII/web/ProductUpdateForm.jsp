

<%@page import="Inventory.prografinal.objects.ProductObj"%>
<%@page import="java.util.Iterator"%>
<%@page import="Inventory.prografinal.objects.categoryObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Product</title>
    </head>
  
    <%
        ProductObj CProduct = 
                (ProductObj)request.getSession().getAttribute("product");
        
        categoryObj CCategory =
                (categoryObj)request.getSession().getAttribute("category");
    %>
        
    
    <body>
        <h1>Update Product</h1>
        
        <form id="myform" name="myform" action="ProductServlet" method="get">
             <label>Id:</label><br>
            <input type="number" id="idnon" name="idnon" value="<%= CProduct.getId() %>" disabled/>
            <br><br>
            
            <label>Model:</label><br>
            <input type="text" id="name" name="name" value="<%= CProduct.getName() %>"/>
            <br><br>
            
            <label>Brand:</label><br>
            <input type="text" id="brand" name="brand" value="<%= CProduct.getBrand()%>"/>
            <br><br>
            
            <label>Description:</label><br>
            <input type="text" id="description" name="description" value="<%= CProduct.getDescription()%>"/>
            <br><br>
            
            <label>Year:</label><br>
            <input type="number" id="year" name="year" value="<%= CProduct.getYear()%>"/>
            <br><br>
            
            <label>Price:</label><br>
            <input type="number" id="price" name="price" value="<%= CProduct.getPrice()%>" />
            <br><br>
            
            <label>Category:</label><br>
            <input id="category" name="category" value="<%= CProduct.getCategory() %> ">
             
                
                
            
                
            <input type="submit" id="mysubmit" name="mysubmit" value="Create"/>
            <input type="hidden" id="formid" name="formid" value="5" />
            <input type="hidden" id="id" name="id" value="<%= CProduct.getId() %>" />
            
        </form>
        
    </body>
</html>
