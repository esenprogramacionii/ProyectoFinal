
<%@page import="java.util.Iterator"%>
<%@page import="Inventory.prografinal.objects.ProductObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        Integer iRowsObj = (Integer)request.getSession().getAttribute("rows");
        int iRows = iRowsObj.intValue();
        Integer SalesId = (Integer)request.getSession().getAttribute("lastsale");
   
         ArrayList<ProductObj> CProductArray = 
                (ArrayList<ProductObj>)request.getSession().getAttribute("product");
        Iterator<ProductObj> iteProductArray = CProductArray.iterator();
    %>
    
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
        <title>First part finished</title>
    </head>
    
    <body>
        <h1>Generic Message</h1>
        <br><br>
        <p><%= iRows %> rows where affected</p>
        <br>
        
      <h2>What did the person buy?</h2>
      <form id="sform" name="sform" action="SalesDetailServlet" method="get">
            
            <label>What product do you want to buy?:</label><br>
            <select id="product" name="product">
                <option id="product0" name="product0" value="0"></option>                
                <%
                    if(iteProductArray!=null)
                    {
                        ProductObj CProductTemp;
                        while(iteProductArray.hasNext())
                        {
                            CProductTemp = iteProductArray.next();
                %>
                            <option id="product<%= CProductTemp.getId() %>" 
                                    name="product<%= CProductTemp.getId() %>" 
                                    value="<%= CProductTemp.getId() %>">
                                
                              <%= CProductTemp.getId()%> - <%= CProductTemp.getName() %>
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
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Create"/>
            <input type="hidden" id="formid" name="formid" value="1" />
        </form>

        <a href="index.html">Home</a>
    </body>
</html>
