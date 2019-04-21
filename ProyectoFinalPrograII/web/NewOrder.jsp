<%@page import="java.util.Iterator"%>
<%@page import="Inventory.prografinal.objects.BStoreObj"%>
<%@page import="java.util.ArrayList"%>
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
        <link href="styles/tableStyles.css" rel="stylesheet" type="text/css"/>
    </head>
     <%
         DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	 Date date = new Date();
         String Adate = dateFormat.format(date);
         
        ArrayList<BStoreObj> BArray = 
                (ArrayList<BStoreObj>)request.getSession().getAttribute("bystore");
        Iterator<BStoreObj> itArray = BArray.iterator();
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
            
       </table>
        
        <h2>Availability of products by Store</h2>
        <table>
        <tr>
            <th>Product Name</th>
            <th>Store Name</th>
            <th>Stock</th>
        </tr>
        
        <%
            if(itArray!=null)
            {
                BStoreObj BTemp;
                while(itArray.hasNext())
                {
                    BTemp = itArray.next();
        %>
                <tr>
                    <td><%= BTemp.getName() %></td>
                    <td><%= BTemp.getSName() %></td>
                    <td><%= BTemp.getSstock() %></td>
                </tr>
        <%
                }
            }
        %>
        
        </table>
            
  
    </body>
</html>

