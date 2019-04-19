
<%@page import="java.util.Iterator"%>
<%@page import="mig.prografinal.objects.categoryObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Trip</title>
    </head>
    <%
        ArrayList<categoryObj> CCategoryArray = 
                (ArrayList<categoryObj>)request.getSession().getAttribute("category");
        Iterator<categoryObj> iteCategoryArray = CCategoryArray.iterator();
    %>
    
    <body>
        <h1>Products</h1>
         <br><br>
         
        <form id="myform" name="myform" action="ProductServlet" method="get">
            <label>Model:</label><br>
            <input type="text" id="name" name="name" />
            <br><br>
            
            <label>Brand:</label><br>
            <input type="text" id="brand" name="brand" />
            <br><br>
            
            <label>Description:</label><br>
            <input type="text" id="description" name="description" />
            <br><br>
            
            <label>Year:</label><br>
            <input type="number" id="year" name="year" />
            <br><br>
            
            <label>Price:</label><br>
            <input type="number" id="price" name="price" />
            <br><br>
            
            <label>Category:</label><br>
            <select id="category" name="category">
                <option id="category0" name="category0" value="0"></option>                
                <%
                    if(iteCategoryArray!=null)
                    {
                        categoryObj CCategoryTemp;
                        while(iteCategoryArray.hasNext())
                        {
                            CCategoryTemp = iteCategoryArray.next();
                %>
                            <option id="category<%= CCategoryTemp.getId() %>" 
                                    name="category<%= CCategoryTemp.getId() %>" 
                                    value="<%= CCategoryTemp.getId() %>">
                                <%= CCategoryTemp.getName() %>
                            </option>
                <%
                        }
                    }
                %>
            </select>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Create"/>
            <input type="hidden" id="formid" name="formid" value="1" />
        </form>
    </body>
</html>

