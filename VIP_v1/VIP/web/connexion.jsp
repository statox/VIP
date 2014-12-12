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
//    RequestDispatcher d;
//    if (connected) {
//        d = request.getRequestDispatcher("/search.jsp");
//    } else {
//        d = request.getRequestDispatcher("/index.jsp");
//        session.setAttribute("error", "Incorrect login/password");
//    }
//    d.forward(request, response);
    if (connected) {
        response.sendRedirect("search.jsp");
    } else {
        session.setAttribute("signingInError", "Incorrect login/password");
        response.sendRedirect("index.jsp");
    }
%>



