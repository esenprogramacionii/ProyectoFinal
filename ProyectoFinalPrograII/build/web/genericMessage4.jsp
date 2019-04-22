<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
        <title>First part finished</title>
    </head>
    <%
        Integer iRowsObj = (Integer)request.getSession().getAttribute("rows");
        int iRows = iRowsObj.intValue();
        
        Integer Prod = (Integer)request.getSession().getAttribute("product");
        Integer Quantity = (Integer)request.getSession().getAttribute("quantity");

    %>
   <body>
        <h1>Primera parte de la compra completada</h1>
        <br><br>
        <p><%= iRows %> rows where affected.</p>
        <br>
        <p>Has comprado <%= Quantity %> elementos del producto <%= Prod %> </p>
        <br><br>
        <h2>Where did the person buy?</h2>
        <form id="form" name="form" action="SalesDetailServlet" method="get">       
            <label>Product ID:</label><br>
            <input type="number" id="prod" name="prod" value="<%= Prod %>" readonly/>
            <br><br>
            
            <label>Quantity ordered:</label><br>
            <input type="number" id="quant" name="quant" value="<%= Quantity %>" readonly/>
            <br><br>
            
            <label>Store where the sale was done:</label><br>
            <input type="number" id="Sstore" name="Sstore" />
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Create" onclick="return confirm('Are you sure this is the right information?')"/>
            <input type="hidden" id="formid" name="formid" value="2" />
            <input type="hidden" id="salesd" name="salesd" value="0" />
        </form>
        
    </body>
</html>

