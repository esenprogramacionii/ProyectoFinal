
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Inventory.prografinal.objects.ProductView"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Styles/tableStyles.css" rel="stylesheet" type="text/css"/>
        
        <title>Product Form</title>
    </head>
    <%
        ArrayList<ProductView> CArray = 
                (ArrayList<ProductView>)request.getSession().getAttribute("productcatview");
        Iterator<ProductView> iteArray = CArray.iterator();
    %>    
    <body>
        <h1>Product Form</h1>
        <br>
        <a href="ProductServlet?formid=6" allign="right">New Product</a>
        <br><br>
        <table>
        <tr>
            <th>Id</th>
            <th>Product</th>
            <th>Brand</th>
            <th>Category</th>
            <th>Description</th>
            <th>Year</th>
            <th>Price</th>
        </tr>
        <%
            if(iteArray!=null)
            {
                ProductView CTemp;
                while(iteArray.hasNext())
                {
                    CTemp = iteArray.next();
        %>
                <tr>
                    <td><%= CTemp.getId() %></td>
                    <td><%= CTemp.getName() %></td>
                    <td><%= CTemp.getBrand() %></td>
                    <td><%= CTemp.getCategory() %></td>
                    <td><%= CTemp.getDescription() %></td>
                    <td><%= CTemp.getYear() %></td>
                    <td>$<%= CTemp.getPrice() %></td>
                    <td>
                        <a href="ProductServlet?formid=7<%= CTemp.getId() %>">
                            update
                        </a>
                    </td>
                    <td>
                        <a href="ProductServlet?formid=3&id=<%= CTemp.getId() %>">
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