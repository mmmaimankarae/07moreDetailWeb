<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        Cookie[] allCookies = request.getCookies();
        Cookie thisCookie = null;
        if (allCookies != null) {
            for(int i = 0; i < allCookies.length; i++) {
                if (allCookies[i].getName().equals("usernameCookie")) {
                    thisCookie = allCookies[i];
                }
            }
        }
    %>
    <body>
        <form name="main" action="login2.jsp" method="POST">
            <%
               if (thisCookie != null) {
            %>
            <input type="text" name="username" value="<%=thisCookie.getValue()%>" size="12" />
            <br/>
            <% } else { %>
                <input type="text" name="username" value="" size="12" /><br/>
                <%}%>
                <input type="password" name="password" value="" size="20" />
                <input type="submit" value="Enter System" name="submit" />
                <br/>
        </form>
    </body>
</html>
