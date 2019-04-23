
<%@page import="Inventory.prografinal.objects.ProductView"%>
<%@page import="java.util.Iterator"%>
<%@page import="Inventory.prografinal.objects.ProductObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" 
              content="width=device-width, initial-scale=1.0">
         <script src="Scripts/jquery-3.3.1.js" type="text/javascript"></script>
        <script src="Scripts/jquery.validate.js" type="text/javascript"></script>
        <script src="Scripts/productNewScript.js" type="text/javascript"></script>
        <link href="Styles/tableStyle1.css" rel="stylesheet" type="text/css"/>
        <title>First part finished</title>
    </head>
    <%
         Integer iRowsObj = (Integer)request.getSession().getAttribute("rows");
        int iRows = iRowsObj.intValue();
        Integer SalesId = (Integer)request.getSession().getAttribute("lastsale");
        

        ArrayList<ProductView> PArray = 
                (ArrayList<ProductView>)request.getSession().getAttribute("product");
        Iterator<ProductView> itePArray = PArray.iterator();

    %>
    <body>
        <h1>First part finished</h1>
        <br><br>
        <p><%= iRows %> rows where affected</p>
        <br>
        
      <h2>Sale order</h2>
      <form id="sform" name="sform" action="SalesDetailServlet" method="get">
            
            <label>Which product do you want to buy?:</label><br>
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
            
            <label>Related Sales Id:</label><br>
            <input type="number" id="sale" name="sale" value="<%= SalesId %>" readonly/>
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Create" onclick="return confirm('Are you sure this is the right information?')"/>
            <input type="hidden" id="formid" name="formid" value="1" />
        </form>

        <br><br>
        <a href="indexX.html">Select Page</a>
        <br><br>
        <a href="index.html">Home</a>
    </body>
</html>
