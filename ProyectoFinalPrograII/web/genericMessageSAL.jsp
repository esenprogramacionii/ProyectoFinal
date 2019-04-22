
<%@page import="java.util.Iterator"%>
<%@page import="Inventory.prografinal.objects.ProductObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" 
              content="width=device-width, initial-scale=1.0">
         <script src="Scripts/jquery-3.3.1.js" type="text/javascript"></script>
        <script src="Scripts/jquery.validate.js" type="text/javascript"></script>
        <script src="Scripts/productNewScript.js" type="text/javascript"></script>
        <title>First part finished</title>
    </head>
    <%
         Integer iRowsObj = (Integer)request.getSession().getAttribute("rows");
        int iRows = iRowsObj.intValue();
        Integer SalesId = (Integer)request.getSession().getAttribute("lastsale");
    %>
    <body>
        <h1>Generic Message</h1>
        <br><br>
        <p><%= iRows %> rows where affected</p>
        <br>
        
      <h2>Sale order</h2>
      <form id="sform" name="sform" action="SalesDetailServlet" method="get">
            
            <label>What product do you want to buy?:</label><br>
            <input type="text" id="product" name="product" />
            <br><br>
            
            <label>Quantity:</label><br>
            <input type="number" id="quantity" name="quantity" />
            <br><br>
            
            <label>Related Sales Id:</label><br>
            <input type="number" id="sale" name="sale" value="<%= SalesId %>" readonly/>
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Create"/>
            <input type="hidden" id="formid" name="formid" value="1" />
        </form>

        <a href="index.html">Home</a>
    </body>
</html>
