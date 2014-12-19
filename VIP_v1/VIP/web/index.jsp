<%-- 
    Document   : index
    Created on : 6 déc. 2014, 11:14:30
    Author     : adrien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--Checks for a warning message related to authentication,
    makes it available to display it later on the page,
    and delete it from session's attributes if it exist.-->
<% 
    String signingInError = (String) session.getAttribute( "signingInError" );
    signingInError = signingInError == null ? "" : signingInError;
    session.setAttribute( "signingInError", null);
%>

<html>
    <head>
        <title>VIP - Secured Gate</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>VIP - Secured Gate</h1>
        
        <p style="color: red;">
            <%--<%= session.getAttribute( "signingInError" ) != null ? session.getAttribute( "signingInError" ) : "" %>--%>
            <!--${signingInError}-->
            <%= signingInError %>
            <%--${signingInError}--%>
        </p>
        
        <p>Please Sign In :</p>
        <form action="connexion.jsp">
            <label for="login">Login</label><input type="text" name="login" id="login"><br>
            <label for="Password">Password</label><input type="password" name="password" id="password"><br>
            <input type="submit" value="Sign In">
        </form>
    </body>
</html>