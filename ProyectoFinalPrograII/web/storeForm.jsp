<%@page import="java.util.Iterator"%>
<%@page import="mig.prografinal.objects.storeObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
        <link href="Styles/tablecss.css" rel="stylesheet" type="text/css"/>
        <title>Store Form</title>
    </head>
    <%
        ArrayList<storeObj> CArray = 
                (ArrayList<storeObj>)request.getSession().getAttribute("stores");
        Iterator<storeObj> iteArray = CArray.iterator();
    %>
    <body>
        <h1>Store</h1>
        <br>
        <a href="newStore.html">New Store</a>
        <br><br>
        <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
        </tr>
        <%
            if(iteArray!=null)
            {
                storeObj CTemp;
                while(iteArray.hasNext())
                {
                    CTemp = iteArray.next();
        %>
                <tr>
                    <td><%= CTemp.getId() %></td>
                    <td><%= CTemp.getName() %></td>
                    <td>
                        <a href="storeServlet?formid=4&id=<%= CTemp.getId() %>">
                            update
                        </a>
                    </td>
                    
                    <td>
                        <a href="storeServlet?formid=3&id=<%= CTemp.getId() %>">
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
