<%-- 
    Document   : genericMessage
    Created on : Mar 29, 2019, 8:45:35 PM
    Author     : balbi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        Integer iRowsObj = (Integer)request.getSession().getAttribute("rows");
        int iRows = iRowsObj.intValue();
        
        Integer OrderId = (Integer)request.getSession().getAttribute("lastid");
    %>
    <body >
        <h1>Primera parte de la orden completada: ORDEN <%= OrderId %></h1>
        <br><br>
        <p><%= iRows %> rows where affected. First part of the order completed. Now detail the order</p>
        <br>
        
        <h2>Order Details</h2>
        <form id="form" name="form" action="DetailServlet" method="get">
            <label>Order detail Id:</label><br>
            <input type="number" id="id" name="id" value="0" readonly/>
            <br><br>
            
            <label>What product do we need?:</label><br>
            <input type="number" id="product" name="product" />
            <br><br>
            
            <label>Quantity:</label><br>
            <input type="number" id="quantity" name="quantity" />
            <br><br>
            
            <label>Related orden Id:</label><br>
            <input type="number" id="order" name="order" value="<%= OrderId %>" readonly/>
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Create"/>
            <input type="hidden" id="formid" name="formid" value="1" />
        </form>

        
        <br><br>
        <a href="index.html">Back Home</a>
    </body>
</html>
