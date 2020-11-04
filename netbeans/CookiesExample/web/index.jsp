<%-- 
    Document   : index
    Created on : Jul 24, 2011, 8:02:54 PM
    Author     : sarun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Cookie cookie = new Cookie("username", "sarun");
            cookie.setMaxAge(3600);
            response.addCookie(cookie);
            
        %>
        <h1>Cookie is created</h1>
        <a href="showCookie.jsp">Click to show Cookie Information</a>
    </body>
</html>
