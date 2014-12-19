<%-- 
    Document   : connexion
    Created on : Dec 6, 2014, 10:53:56 AM
    Author     : matthieudelaro
--%>

<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="com.sun.faces.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--Connect to data base-->
<!--Errors will be handles starting in version 2-->
<% 
    String URL = "jdbc:derby://localhost:1527/VIP";
    String USER = "efrei";
    String PASS = "efrei";
    Connection conn = DriverManager.getConnection(URL, USER, PASS); 
    Statement stmt = conn.createStatement();
%>

<!--Validates/rejects given login/password, and routes the user to search.jsp or index.jsp (with a warning message)-->
<!--Errors will be handles starting in version 2-->
<% 
    String login = request.getParameter( "login" );
    String password = request.getParameter( "password" );
    session.setAttribute( "login", login);
    
    boolean connected = false;
    ResultSet rs = stmt.executeQuery("select * from IDENTIFIANT where LOGIN='"+login+"'");
    if (rs.next()) {
       String rsLogin  = rs.getString("LOGIN");
       String rsMdp  = rs.getString("MDP");
       if (login.equals(rsLogin) && password.equals(rsMdp)) {
           connected = true;
       }
    }
    session.setAttribute( "registered", connected);
    if (connected) {
        response.sendRedirect("search.jsp");
    } else {
        session.setAttribute("signingInError", "Incorrect login/password");
        response.sendRedirect("index.jsp");
    }
%>



