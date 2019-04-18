<%@page import="java.util.Iterator"%>
<%@page import="bal.travelsyswebapp.objects.StockObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
        <title>Client</title>
        <link href="styles/tableStyles.css" rel="stylesheet" type="text/css"/>
    </head>
    <%
        ArrayList<StockObj> CArray = 
                (ArrayList<StockObj>)request.getSession().getAttribute("stock");
        Iterator<StockObj> iteArray = CArray.iterator();
    %>
    <body>
        <h1>Así tenemos la disponnbilidad de productos</h1>
        <table>
        <tr>
            <th>Product ID</th>
            <th>Store ID</th>
            <th>Available</th>
        </tr>
        <%
            if(iteArray!=null)
            {
                StockObj CTemp;
                while(iteArray.hasNext())
                {
                    CTemp = iteArray.next();
        %>
                <tr>
                    <td><%= CTemp.getid() %></td>
                    <td><%= CTemp.getSid() %></td>
                    <td><%= CTemp.getStock() %></td>
                </tr>
        <%
                }
            }
        %>
        
        </table>
    </body>
</html>
