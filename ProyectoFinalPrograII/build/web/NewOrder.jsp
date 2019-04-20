<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <title>Generate new order</title>
        <meta charset="UTF-8">
        <meta name="viewport" 
              content="width=device-width, initial-scale=1.0">
    </head>
     <%
         DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	 Date date = new Date();
         String Adate = dateFormat.format(date);
        %>
    <body>
        <h1>Generar nueva orden a proveedores</h1>
        <br><br>
 
        <form id="myform" name="myform" action="OrderServlet" method="get">
            <label>Order Id:</label><br>
            <input type="number" id="id" name="id" value="0" readonly/>
            <br><br>
            
            <label>Supplier:</label><br>
            <input type="number" id="supplier" name="supplier" />
            <br><br>
            
            <label>Date:</label><br>
            <input type="text" id="date" name="date" value ="<%=Adate%>" readonly/>
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Create"/>
            <input type="hidden" id="formid" name="formid" value="1" />
        </form>
        
    </body>
</html>

