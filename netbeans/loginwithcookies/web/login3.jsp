<%-- 
    Document   : login3
    Created on : Aug 21, 2012, 2:02:29 PM
    Author     : sarun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
   <% Cookie[] allCookies = request.getCookies();
        Cookie thisCookie = null;
        if (allCookies != null) {
            for(int i = 0; i < allCookies.length; i++) {
                if (allCookies[i].getName().equals("usernameCookie")) {
                    thisCookie = allCookies[i];
                }
            }
        }
        
    %>
    <%
        if (thisCookie == null) { 
            out.print("Please login first  <a href=\"index.jsp\"> Login  </a>"); 
        }
        else { 
            out.print("Cookie information <br/>");
            out.print("Cookie version: " + thisCookie.getVersion() + " <br/>");
            out.print("Cookie name: " + thisCookie.getName() + " <br/>");
            out.print("Cookie value: " + thisCookie.getValue() + " <br/>");    
        } 
    %>
    </body>
</html>
