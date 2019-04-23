<%@page import="java.util.Iterator"%>
<%@page import="Inventory.prografinal.objects.SalesObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
        <title>Sales</title>
        <link href="Styles/tableStyle1.css" rel="stylesheet" type="text/css"/>
        
    </head>
    <%
        ArrayList<SalesObj> CArray = 
                (ArrayList<SalesObj>)request.getSession().getAttribute("sales");
        Iterator<SalesObj> iteArray = CArray.iterator();
    %>
    <body background="stock.jpg">
        <h1>Sales</h1>
        <br>
        <a href="salesNew.jsp">New Sales</a>
        <br><br>
        <table>
        <tr>
            <th>Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Date the sale was registered</th>
        </tr>
        <%
            if(iteArray!=null)
            {
                SalesObj CTemp;
                while(iteArray.hasNext())
                {
                    CTemp = iteArray.next();
        %>
                <tr>
                    <td><%= CTemp.getId() %></td>
                    <td><%= CTemp.getFirstname() %></td>
                    <td><%= CTemp.getLastname() %></td>
                    <td><%= CTemp.getDate() %></td>
                    <td>
                        <a href="SalesServlet?formid=4&id=<%= CTemp.getId() %>">
                            update
                        </a>
                    </td>
                    <td>
                        <a href="SalesServlet?formid=3&id=<%= CTemp.getId() %>">
                            delete
                        </a>
                    </td>
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
