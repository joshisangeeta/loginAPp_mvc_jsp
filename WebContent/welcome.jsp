<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="java.util.Date" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

           <h2 >Today is 
           
                <%=new Date() %>         
           
           </h2>
            <h3>Welcome
           <% out.println(request.getParameter("userName")); %>
            </h3>
</body>
</html>