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
        //Recibir parámetros de la session
        Integer iRowsObj = (Integer)request.getSession().getAttribute("rows");
        int iRows = iRowsObj.intValue();
        
        Integer prod = (Integer)request.getSession().getAttribute("product");
        Integer stock = (Integer)request.getSession().getAttribute("stock");

    %>
    <body>
        <h1>Primera parte de la orden completada</h1>
        <br><br>
        <p><%= iRows %> rows where affected.</p>
        <br>
        <p>Has ordenado <%= stock %> elementos del producto <%= prod %> </p>
        <br><br>
        <h2>Where will be the order delivered?</h2>
        <form id="form" name="form" action="StockServlet" method="get">       
            <label>Product ID:</label><br>
            <input type="number" id="product" name="product" value="<%= prod %>" readonly/>
            <br><br>
            
            <label>Quantity ordered:</label><br>
            <input type="number" id="quantity" name="quantity" value="<%= stock %>" readonly/>
            <br><br>
            
            <label>Store where the order should be delivered:</label><br>
            <input type="number" id="store" name="store" />
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Create" onclick="return confirm('Are you sure this store?')"/>
            <input type="hidden" id="formid" name="formid" value="3" />
            <input type="hidden" id="transaction" name="transaction" value="0" />
        </form>
        
    </body>
</html>
