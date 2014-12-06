<%-- 
    Document   : connexion
    Created on : Dec 6, 2014, 10:53:56 AM
    Author     : matthieudelaro
--%>

<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="com.sun.faces.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    String URL = "jdbc:derby://localhost:1527/VIP";
    String USER = "efrei";
    String PASS = "efrei";
    Connection conn = DriverManager.getConnection(URL, USER, PASS); 
    Statement stmt = conn.createStatement();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <% 
            String login = request.getParameter( "login" );
            String password = request.getParameter( "password" );
            ResultSet rs = stmt.executeQuery("select * from IDENTIFIANT where LOGIN='"+login+"'");
            while (rs.next()) {
               String nom  = rs.getString("LOGIN");
               String prenom  = rs.getString("MDP");
               out.println("<li>"+nom+" "+prenom+"</li>");
            }
        %>
    </body>
</html>


