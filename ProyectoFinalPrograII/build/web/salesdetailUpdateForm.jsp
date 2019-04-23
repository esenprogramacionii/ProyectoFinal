<%@page import="sd.objects.SalesDetailObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Sales Detail</title>
    </head>
    <%
        SalesDetailObj CSalesDetail = 
                (SalesDetailObj)request.getSession().getAttribute("salesdetail");
        
    %>
    <body>
        <h1>Update Sales Detail</h1>
        <br><br>
        
        <form id="myform" name="myform" action="SalesDetailServlet1" method="get">
            <label>Id:</label><br>
            <input type="number" id="nonId" name="nonId" value="<%= CSalesDetail.getId() %>" disabled/>
            <br><br>
            
            
            <label>Product:</label><br>
            <input type="number" id="product" name="product" value="<%= CSalesDetail.getProduct() %>" />
            <br><br>
            
            <label>Sales:</label><br>
            <input type="number" id="sales" name="sales" value="<%= CSalesDetail.getSales() %>" />
            <br><br>
            
            <label>Quantity:</label><br>
            <input type="number" id="quantity" name="quantity" value="<%= CSalesDetail.getQuantity() %>" />
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Update"/>
            <input type="hidden" id="formid" name="formid" value="5" />
            <input type="hidden" id="id" name="id" value="<%= CSalesDetail.getId() %>" />
        </form>
        
        <br><br>
        <a href="salesdetailForm.jsp">Back</a>
         <br><br>
        <a href="indexX.html">Select Page</a>
        <br><br>
        <a href="index.html">Home</a>
    </body>
</html>