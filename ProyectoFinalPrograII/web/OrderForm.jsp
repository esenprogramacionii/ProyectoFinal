<%@page import="java.util.Iterator"%>
<%@page import="zepe.proyectofinal.objects.OrderObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
        <title>Generated Orders</title>
        <link href="styles/tableStyles.css" rel="stylesheet" type="text/css"/>
        
    </head>
    <%
        ArrayList<OrderObj> CArray = 
                (ArrayList<OrderObj>)request.getSession().getAttribute("orders");
        Iterator<OrderObj> iteArray = CArray.iterator();
    %>
    <body>
        <h1>Generated orders</h1>
        <br>
        <a href="NewOrder.jsp">New Order</a>
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

                </tr>
        <%
                }
            }
        %>
       
        </table>
        <br><br>
        <a href="DetailServlet?formid=2">See more details</a>
    </body>
</html>
