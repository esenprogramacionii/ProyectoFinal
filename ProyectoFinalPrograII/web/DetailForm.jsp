<%@page import="zepe.proyectofinal.objects.DetailViewObj"%>
<%@page import="java.util.Iterator"%>
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
        
        </table>
    </body>
</html>
