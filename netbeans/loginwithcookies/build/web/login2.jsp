<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Cookie[] allCookies = request.getCookies();
        Cookie thisCookie = null;
        if (allCookies != null) {
            for(int i = 0; i < allCookies.length; i++) {
                if (allCookies[i].getName().equals("usernameCookie")) {
                    thisCookie = allCookies[i];
                }
            }
        }
        Cookie c = new Cookie("usernameCookie", username);
        if (thisCookie != null) {
            String cookieValue = thisCookie.getValue();
            if (cookieValue.compareTo(username) != 0) {
                c.setMaxAge(60 * 60 * 24 * 30);
                response.addCookie(c);
            }
        }
        else {
            c.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(c);
        }
        %>
        <%
            if (username.equals("myid") && password.equals("mypassword")) {
                out.print("Welcome " + username + " to the club <br/>");
                out.print("<a href=\"login3.jsp\"> click for cookie information </a>");
            }
            else {
                out.print("wrong password, please try again <br/>");
                out.print("<a href=\"index.jsp\"> Login  </a>");
            }
        %>             
    </body>
</html>
