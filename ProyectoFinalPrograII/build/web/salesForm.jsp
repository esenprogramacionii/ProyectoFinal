<%@page import="java.util.Iterator"%>
<%@page import="sales.objects.SalesObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
        <title>Sales</title>
        <link href="styles/tableStyles.css" rel="stylesheet" type="text/css"/>
        <script src="Scripts/jquery-3.3.1.js" type="text/javascript"></script>
        <script src="Scripts/jquery.validate.js" type="text/javascript"></script>
        <script src="Scripts/salesFormScript.js" type="text/javascript"></script>
    </head>
    <%
        ArrayList<SalesObj> CArray = 
                (ArrayList<SalesObj>)request.getSession().getAttribute("sales");
        Iterator<SalesObj> iteArray = CArray.iterator();
    %>
    <body>
        <h1>Sales</h1>
        <br>
        <a href="salesNew.jsp">New Sales</a>
        <br><br>
        <table>
        <tr>
            <th>Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Date</th>
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
    </body>
</html>
