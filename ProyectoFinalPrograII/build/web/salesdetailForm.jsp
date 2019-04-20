<%@page import="java.util.Iterator"%>
<%@page import="sd.objects.SalesDetailObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
        <title>Client</title>
        <link href="Styles/tableStyles.css" rel="stylesheet" type="text/css"/>
        
    </head>
    <%
        ArrayList<SalesDetailObj> CArray = 
                (ArrayList<SalesDetailObj>)request.getSession().getAttribute("salesdetails");
        Iterator<SalesDetailObj> iteArray = CArray.iterator();
    %>
    <body>
        <h1>Sales Details</h1>
        <br>
        <a href="salesdetailNew.html">New Sales Detail</a>
        <br><br>
        <table>
        <tr>
            <th>Id</th>
            <th>Product</th>
            <th>Sales</th>
            <th>Quantity</th>
        </tr>
        <%
            if(iteArray!=null)
            {
                SalesDetailObj CTemp;
                while(iteArray.hasNext())
                {
                    CTemp = iteArray.next();
        %>
                <tr>
                    <td><%= CTemp.getId() %></td>
                    <td><%= CTemp.getProduct() %></td>
                    <td><%= CTemp.getSales() %></td>
                    <td><%= CTemp.getQuantity() %></td>
                    <td>
                        <a href="SalesDetailServlet?formid=4&id=<%= CTemp.getId() %>">
                            update
                        </a>
                    </td>
                    <td>
                        <a href="SalesDetailServlet?formid=3&id=<%= CTemp.getId() %>">
                            delete
                        </a>
                    </td>
                </tr>
        <%
                }
            }
        %>
        
        </table>
    </body>
</html>
