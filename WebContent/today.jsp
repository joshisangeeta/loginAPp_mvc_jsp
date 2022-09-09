<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  import = "java.util.Date"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

            
    
    
             Today is :
             
             <div>
               <%= new Date() %>
               <% out.println(request.getParameter("userName")); %>
             </div>

</body>
</html>