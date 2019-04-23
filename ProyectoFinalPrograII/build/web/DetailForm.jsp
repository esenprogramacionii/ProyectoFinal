<%@page import="Inventory.prografinal.objects.DetailViewObj"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
        <title>Generated Orders</title>
        <link href="Styles/tableStyle1.css" rel="stylesheet" type="text/css"/>
        
    </head>
    <%
        ArrayList<DetailViewObj> CArray = 
                (ArrayList<DetailViewObj>)request.getSession().getAttribute("detail");
        Iterator<DetailViewObj> iteArray = CArray.iterator();
    %>
    <body>
        <h1>See more detailed orders</h1>
        <br><br>
        <table>
        <tr>
            <th>Detail ID</th>
            <th>Product Name</th>
            <th>Product ID</th>
            <th>Product Price</th>
            <th>Order size</th>
            <th>Order Total</th>
            <th>Order Id</th>
        </tr>
        <%
            if(iteArray!=null)
            {
                DetailViewObj CTemp;
                while(iteArray.hasNext())
                {
                    CTemp = iteArray.next();
        %>
                <tr>
                    <td><%= CTemp.getId() %></td>
                    <td><%= CTemp.getName() %></td>
                    <td><%= CTemp.getpiId() %></td>
                    <td>$<%= CTemp.getprice() %></td>
                    <td><%= CTemp.getiQ() %></td>
                    <td>$<%= CTemp.gettotal() %></td>
                    <td><%= CTemp.getiorder() %></td>   
                </tr>
        <%
                }
            }
        %>
        <a href="OrderForm.jsp">Back</a>
                <br><br>
        <a href="indexX.html">Select Page</a>
        <br><br>
        <a href="index.html">Home</a>
        </table>
    </body>
</html>
