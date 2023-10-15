<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${cookie.username.value}</h1>
        
        <%
            Cookie[] cookiesFromClient = request.getCookies();
            for (int i =0; i < cookiesFromClient.length;i++) {
                out.println(cookiesFromClient[i].getName());
                out.println(cookiesFromClient[i].getValue());
                out.println("<br/>");
            }
        %>
    </body>
</html>
