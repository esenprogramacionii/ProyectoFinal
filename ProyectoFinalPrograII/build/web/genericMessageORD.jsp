

<%@page import="java.util.Iterator"%>
<%@page import="Inventory.prografinal.objects.ProductView"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        Integer iRowsObj = (Integer)request.getSession().getAttribute("rows");
        int iRows = iRowsObj.intValue();
        
        Integer OrderId = (Integer)request.getSession().getAttribute("lastid");
        
        ArrayList<ProductView> PArray = 
                (ArrayList<ProductView>)request.getSession().getAttribute("product");
        Iterator<ProductView> itePArray = PArray.iterator();
        
    %>
    <body >
        <h1>Primera parte de la orden completada: ORDEN <%= OrderId %></h1>
        <br><br>
        <p><%= iRows %> rows where affected. First part of the order completed. Now detail more the order</p>
        <br>
        
        <h2>Order Details</h2>
        <form id="form" name="form" action="DetailServlet" method="get">
            <label>Order detail Id:</label><br>
            <input type="number" id="id" name="id" value="0" readonly/>
            <br><br>
            
            <label>What product do we need?:</label><br>
            <select id="product" name="product">
                <option id="product0" name="product0" value="0"></option>                
                <%
                    if(itePArray!=null)
                    {
                        ProductView PTemp;
                        while(itePArray.hasNext())
                        {
                            PTemp = itePArray.next();
                %>
                            <option id="product<%= PTemp.getId()%>" 
                                    name="product<%= PTemp.getId() %>" 
                                    value="<%= PTemp.getId() %>">
                                
                                <%= PTemp.getId()%> - <%= PTemp.getName()%>
                            </option>
                <%
                        }
                    }
                %>
            </select>
            
            <br><br>
            <label>Quantity:</label><br>
            <input type="number" id="quantity" name="quantity" />
            <br><br>
            
            <label>Related orden Id:</label><br>
            <input type="number" id="order" name="order" value="<%= OrderId %>" readonly/>
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Create" onclick="return confirm('Are you sure this is the right information?')"/>
            <input type="hidden" id="formid" name="formid" value="1" />
        </form>

        
        <br><br>
        <a href="index.html">Back Home</a>
    </body>
</html>
