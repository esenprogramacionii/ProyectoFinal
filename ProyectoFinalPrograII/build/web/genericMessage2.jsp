<%-- 
    Document   : genericMessage
    Created on : Mar 29, 2019, 8:45:35 PM
    Author     : balbi
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Inventory.prografinal.objects.storeObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
        <link href="Styles/tableStyle1.css" rel="stylesheet" type="text/css"/>
        <title>Success</title>
    </head>
    <%
        //Recibir parámetros de la session
        Integer iRowsObj = (Integer)request.getSession().getAttribute("rows");
        int iRows = iRowsObj.intValue();
        
        Integer prod = (Integer)request.getSession().getAttribute("product");
        Integer stock = (Integer)request.getSession().getAttribute("stock");
        
        ArrayList<storeObj> SArray = 
                (ArrayList<storeObj>)request.getSession().getAttribute("store");
        Iterator<storeObj> iteSArray = SArray.iterator();

    %>
    <body>
        <h1>First part of the order completed</h1>
        <br><br>
        <p><%= iRows %> rows where affected.</p>
        <br>
        <p>You have ordered <%= stock %> elements of the product <%= prod %> </p>
        <br><br>
        <h2>Where will be the order delivered?</h2>
        <form id="form" name="form" action="StockServlet" method="get">       
            <label>Product ID:</label><br>
            <input type="number" id="product" name="product" value="<%= prod %>" readonly/>
            <br><br>
            
            <label>Quantity ordered:</label><br>
            <input type="number" id="quantity" name="quantity" value="<%= stock %>" readonly/>
            <br><br>
            
            <label>Store where the order should be delivered:</label><br>
             <select id="store" name="store">
                <option id="store0" name="store0" value="0"></option>                
                <%
                    if(iteSArray!=null)
                    {
                        storeObj PTemp;
                        while(iteSArray.hasNext())
                        {
                            PTemp = iteSArray.next();
                %>
                            <option id="store<%= PTemp.getId()%>" 
                                    name="store<%= PTemp.getId() %>" 
                                    value="<%= PTemp.getId() %>">
                                
                                <%= PTemp.getId()%> - <%= PTemp.getName()%>
                            </option>
                <%
                        }
                    }
                %>
            </select>
            <br><br>
            <input type="submit" id="mysubmit" name="mysubmit" value="Create" onclick="return confirm('Are you sure this store?')"/>
            <input type="hidden" id="formid" name="formid" value="3" />
            <input type="hidden" id="transaction" name="transaction" value="0" />
        </form>
        
         <br><br>
        <a href="indexX.html">Select Page</a>
        <br><br>
        <a href="index.html">Home</a>
    </body>
</html>
