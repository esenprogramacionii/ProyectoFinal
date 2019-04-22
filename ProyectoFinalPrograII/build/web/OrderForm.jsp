<%@page import="java.util.Iterator"%>
<%@page import="Inventory.prografinal.objects.OrderObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
        <title>Generated Orders</title>
        <link href="Styles/tableStyles.css" rel="stylesheet" type="text/css"/>
    </head>
    <%
        ArrayList<OrderObj> CArray = 
                (ArrayList<OrderObj>)request.getSession().getAttribute("orders");
        Iterator<OrderObj> iteArray = CArray.iterator();
    %>
    <body>
        <h1>Generated orders</h1>
        <br>
        <a href="StockServlet?formid=4">New Order</a>
        <br><br>
        <a href="index.html">Go to home page</a>
        <br><br>
        <table>
        <tr>
            <th>Order Id</th>
            <th>Supplier Id</th>
            <th>Date</th>
        </tr>
        <%
            if(iteArray!=null)
            {
                OrderObj CTemp;
                while(iteArray.hasNext())
                {
                    CTemp = iteArray.next();
        %>
                <tr>
                    <td><%= CTemp.getid() %></td>
                    <td><%= CTemp.getSupplier() %></td>
                    <td><%= CTemp.getdate() %></td>
                    <td>
                        <a href="OrderServlet?formid=4&id=<%= CTemp.getid() %>">
                            Update Order
                        </a>
                    </td>
                    <td>
                        <a href="OrderServlet?formid=3&id=<%= CTemp.getid() %>">
                            Delete Order
                        </a>
                    </td>
                </tr>
        <%
                }
            }
        %>
       
        </table>
        <br><br>
        <a href="DetailServlet?formid=2">See more details about the orders</a>
    </body>
</html>
