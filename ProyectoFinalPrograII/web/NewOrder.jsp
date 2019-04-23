<%@page import="Inventory.prografinal.objects.ProvObj"%>
<%@page import="Inventory.prografinal.objects.ProvObj"%>
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
        <script src="Scripts/jquery-3.3.1.js" type="text/javascript"></script>
        <script src="Scripts/jquery.validate.js" type="text/javascript"></script>
        <script src="Scripts/newOrderScript.js" type="text/javascript"></script>
        <link href="Styles/tableStyle1.css" rel="stylesheet" type="text/css"/>
        
    </head>
     <%
         DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	 Date date = new Date();
         String Adate = dateFormat.format(date);
         
        ArrayList<BStoreObj> BArray = 
                (ArrayList<BStoreObj>)request.getSession().getAttribute("bystore");
        Iterator<BStoreObj> itArray = BArray.iterator();
        
        ArrayList<ProvObj> PrArray = 
                (ArrayList<ProvObj>)request.getSession().getAttribute("supplier");
        Iterator<ProvObj> PArray = PrArray.iterator();
        
        
    %>
        
    <body>
        <h1>New order for supplier</h1>
        <br><br>
 
        <form id="myform" name="myform" action="OrderServlet" method="get">
            <label>Order Id:</label><br>
            <input type="number" id="id" name="id" value="0" readonly/>
            <br><br>
            
            <label>Supplier:</label><br>
           <select id="supplier" name="supplier">
                <option id="supplier0" name="supplier0" value="0"></option>                
                <%
                    if(PArray!=null)
                    {
                        ProvObj PTemp;
                        while(PArray.hasNext())
                        {
                            PTemp = PArray.next();
                %>
                            <option id="supplier<%= PTemp.getId()%>" 
                                    name="supplier<%= PTemp.getId() %>" 
                                    value="<%= PTemp.getId() %>">
                                
                                <%= PTemp.getId()%> - <%= PTemp.getName()%>
                            </option>
                <%
                        }
                    }
                %>
            </select>
            <br><br>
            <label>Date:</label><br>
            <input type="text" id="date" name="date" value ="<%=Adate%>" readonly/>
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Create" onclick="return confirm('Are you sure this is the right supplier for the order?')"/>
            <input type="hidden" id="formid" name="formid" value="1" />
        </form>
            
        
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
            
        <br><br>
        <a href="indexX.html">Select Page</a>
        <br><br>
        <a href="index.html">Home</a>
  
    </body>
</html>

