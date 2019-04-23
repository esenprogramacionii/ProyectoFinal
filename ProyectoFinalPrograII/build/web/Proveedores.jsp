<%-- 
    Document   : ClientForm
    Created on : Mar 29, 2019, 7:47:07 PM
    Author     : Luis Rivera
--%>
<%@page import="java.util.Iterator"%>
<%@page import="Inventory.prografinal.objects.ProvObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Styles/tableStyle1.css" rel="stylesheet" type="text/css"/>
        <title>Suppliers</title>
    </head>
    <%
        ArrayList<ProvObj> CArray = 
                (ArrayList<ProvObj>)request.getSession().getAttribute("provs");
        Iterator<ProvObj> iteArray = CArray.iterator();
    %>
    <body>
        <h1>Suppliers</h1>
        <br>
        <a href="newProv.html">Add a new supplier</a>
        <br><br>

        <table style="width:60%" border="1px">
          <tr>
              <th>ID</th>
              <th>Name</th>
           
          </tr>
          <%
            if(iteArray!=null)
            {
                ProvObj CTemp;
                while(iteArray.hasNext())
                {
                    CTemp = iteArray.next();
        %>
                <tr>
                    <td><%= CTemp.getId() %></td>
                    <td><%= CTemp.getName() %></td>
                    
                    <td>
                        <a href="ProvSERVLET?formid=4&id=<%= CTemp.getId() %>">
                            update
                        </a>
                    </td>
                    <td>
                        <a href="ProvSERVLET?formid=3&id=<%= CTemp.getId() %>">
                            delete
                        </a>
                    </td>
                </tr>
        <%
                }
            }
        %>
        </table>
        
        <a href="index.html">Back Home</a>
        
    </body>
</html>
