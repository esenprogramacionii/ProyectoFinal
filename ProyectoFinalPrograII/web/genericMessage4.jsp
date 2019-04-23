<%@page import="Inventory.prografinal.objects.storeObj"%>
<%@page import="java.util.Iterator"%>
<%@page import="Inventory.prografinal.objects.ProvObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
        <link href="Styles/tableStyle1.css" rel="stylesheet" type="text/css"/>
        <title>First part finished</title>
    </head>
    <%
        Integer iRowsObj = (Integer)request.getSession().getAttribute("rows");
        int iRows = iRowsObj.intValue();
        
        Integer Prod = (Integer)request.getSession().getAttribute("product");
        Integer Quantity = (Integer)request.getSession().getAttribute("quantity");
        
        ArrayList<storeObj> SArray = 
                (ArrayList<storeObj>)request.getSession().getAttribute("Store");
        Iterator<storeObj> iteSArray = SArray.iterator();

    %>
   <body>
        <h1>First part of the purchase completed</h1>
        <br><br>
        <p><%= iRows %> rows where affected.</p>
        <br>
        <p>You bought <%= Quantity %> elements of the product <%= Prod %> </p>
        <br><br>
        <h2>Where did the person buy?</h2>
        <form id="form" name="form" action="SalesDetailServlet" method="get">       
            <label>Product ID:</label><br>
            <input type="number" id="prod" name="prod" value="<%= Prod %>" readonly/>
            <br><br>
            
            <label>Quantity ordered:</label><br>
            <input type="number" id="quant" name="quant" value="<%= Quantity %>" readonly/>
            <br><br>
            
            <label>Store where the sale was done:</label><br>
            <select id="Sstore" name="Sstore">
                <option id="store0" name="store0" value="0"></option>                
                <%
                    if(iteSArray!=null)
                    {
                        storeObj PTemp;
                        while(iteSArray.hasNext())
                        {
                            PTemp = iteSArray.next();
                %>
                            <option id="supplier<%= PTemp.getId()%>" 
                                    name="supplier<%= PTemp.getId() %>" 
                                    value="<%= PTemp.getId() %>">
                                
                                <%= PTemp.getId()%> - <%= PTemp.getName()%>
                            </option>
                <%
                        }
                    }
                %>
            </select>
            <br><br>
            <input type="submit" id="mysubmit" name="mysubmit" value="Create" onclick="return confirm('Are you sure this is the right information?')"/>
            <input type="hidden" id="formid" name="formid" value="2" />
            <input type="hidden" id="salesd" name="salesd" value="0" />
        </form>
        
            
        <br><br>
        <a href="indexX.html">Select Page</a>
        <br><br>
        <a href="index.html">Home</a>
    </body>
</html>

