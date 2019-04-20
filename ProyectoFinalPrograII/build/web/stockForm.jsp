<%@page import="java.util.Iterator"%>
<%@page import="zepe.proyectofinal.objects.StockViewObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
        <title>STOCK</title>
        <link href="styles/tableStyles.css" rel="stylesheet" type="text/css"/>
    </head>
    <%
        ArrayList<StockViewObj> CArray = 
                (ArrayList<StockViewObj>)request.getSession().getAttribute("stock");
        Iterator<StockViewObj> iteArray = CArray.iterator();
    %>
    <body>
        <h1>Availability of products</h1>
        <table>
        <tr>
            <th>Transaction #</th>
            <th>Product Name</th>
            <th>Store Name</th>
            <th>Stock</th>
        </tr>
        <%
            if(iteArray!=null)
            {
                StockViewObj CTemp;
                while(iteArray.hasNext())
                {
                    CTemp = iteArray.next();
        %>
                <tr>
                    <td><%= CTemp.getTrans() %></td>
                    <td><%= CTemp.getprod() %></td>
                    <td><%= CTemp.getstore() %></td>
                    <td><%= CTemp.getStock() %></td>
                </tr>
        <%
                }
            }
        %>
        
        </table>
    </body>
</html>
