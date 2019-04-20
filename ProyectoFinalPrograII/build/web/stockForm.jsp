<%@page import="zepe.proyectofinal.objects.BStoreObj"%>
<%@page import="java.util.Iterator"%>
<%@page import="zepe.proyectofinal.objects.FinalObj"%>
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
        ArrayList<FinalObj> CArray = 
                (ArrayList<FinalObj>)request.getSession().getAttribute("stock");
        Iterator<FinalObj> iteArray = CArray.iterator();
        
        ArrayList<BStoreObj> BArray = 
                (ArrayList<BStoreObj>)request.getSession().getAttribute("stock1");
        Iterator<BStoreObj> itArray = BArray.iterator();

    %>
    <body>
        <h1>Total Availability of products</h1>
        <table>
        <tr>
            <th>Product Name</th>
            <th>Product ID</th>
            <th>Total Stock</th>
        </tr>
        <%
            if(iteArray!=null)
            {
                FinalObj CTemp;
                while(iteArray.hasNext())
                {
                    CTemp = iteArray.next();
        %>
                <tr>
                    <td><%= CTemp.getProd() %></td>
                    <td><%= CTemp.getProdID() %></td>
                    <td><%= CTemp.getStock() %></td>
                </tr>
        <%
                }
            }
        %>
        
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
