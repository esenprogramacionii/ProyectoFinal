<%@page import="java.util.Iterator"%>
<%@page import="mig.prografinal.objects.categoryObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
        <link href="styles/tableStyles.css" rel="stylesheet" type="text/css"/>
        <title>Category Form</title>
    </head>
    <%
        ArrayList<categoryObj> CArray = 
                (ArrayList<categoryObj>)request.getSession().getAttribute("categories");
        Iterator<categoryObj> iteArray = CArray.iterator();
    %>
    <body>
        <h1>Category</h1>
        <br>
        <a href="newCategory.html">New Category</a>
        <br><br>
        <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
        </tr>
        <%
            if(iteArray!=null)
            {
                categoryObj CTemp;
                while(iteArray.hasNext())
                {
                    CTemp = iteArray.next();
        %>
                <tr>
                    <td><%= CTemp.getId() %></td>
                    <td><%= CTemp.getName() %></td>
                    <td>
                        <a href="categoryServlet?formid=4&id=<%= CTemp.getId() %>">
                            update
                        </a>
                    </td>
                    
                    <td>
                        <a href="categoryServlet?formid=3&id=<%= CTemp.getId() %>">
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
