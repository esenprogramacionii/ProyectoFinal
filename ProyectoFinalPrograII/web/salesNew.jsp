<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>New Sale</title>
        <meta charset="UTF-8">
        <meta name="viewport" 
              content="width=device-width, initial-scale=1.0">
        <script src="Scripts/jquery-3.3.1.js" type="text/javascript"></script>
        <script src="Scripts/jquery.validate.js" type="text/javascript"></script>
        <script src="Scripts/salesFormScript.js" type="text/javascript"></script>
    </head>
     <%
         DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	 Date date = new Date();
         String Adate = dateFormat.format(date);
        %>
    <body>
        <h1>New Sale</h1>
        <br><br>
        
        <form id="myform" name="myform" action="SalesServlet" method="get">
            <label>First name:</label><br>
            <input type="text" id="firstname" name="firstname" />
            <br><br>
            
            <label>Last name:</label><br>
            <input type="text" id="lastname" name="lastname" />
            <br><br>
            
            <label>Date:</label><br>
            <input type="text" id="date" name="date" value="<%=Adate%>" readonly/>
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Create" onclick="return confirm('Are you sure this is the right information?')"/>
            <input type="hidden" id="formid" name="formid" value="1" />
        </form>
        
    </body>
</html>