<%--
    Document   : search
    Created on : Dec 6, 2014, 12:12:57 PM
    Author     : matthieudelaro
--%>

<%@page import="VIP.Person"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="com.sun.faces.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    // Being signed in is mandatory.
    // Thus, make sure the user loged in :
    Boolean connected = (Boolean) session.getAttribute( "registered");
    if (connected ==null || !connected) {
        session.setAttribute("signingInError", "Please login to access the list of VIPs.");
        response.sendRedirect("index.jsp");
    }
%>

<%
    // Connect to database
    String URL = "jdbc:derby://localhost:1527/VIP";
    String USER = "efrei";
    String PASS = "efrei";
    Connection conn = DriverManager.getConnection(URL, USER, PASS);
    Statement stmt = conn.createStatement();
%>

<%
    // TODO : Handle VIP's deletion
    // delete in db
    // redirect to search.jsp
%>

<%
    // TODO : Handle research criteria (~ LIKE session.getParameter("filter"))
    int quantity = 0;
    ResultSet rs = stmt.executeQuery("select * from UTILISATEUR");
    List<Person> VIPs = new LinkedList();
    while (rs.next()) {
       VIPs.add(new Person(rs));
       quantity++;
    }
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VIP - Search</title>
        <style>
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
            }
            th,td {
                padding: 15px;
            }
        </style>
    </head>
    <body>
        <h1>VIP - Search</h1>
        <p>There are <%= quantity %> VIPs.</p>

        <form>
        <center>
            Client <input type="text" name="searchedName" > <input type="submit"  >
        </center>
    
        </br>
    
        <table style="width:100%">
            <tr>
                <th>VIP's ID</th>
                <th>Name</th>
                <th>Firstname</th>
                <th>Phone</th>
                <th>Mobile Phone</th>
                <th>Street</th>
                <th>ZIP code</th>
                <th>City</th>
                <th>Email</th>
            </tr>
            <c:forEach items="pageScope.VIPs" var="VIP">
                <tr>
                    <%--<td><%= VIPs.toString() %></td>--%>
                    <td>${VIP}</td>
                    <td>Jackson</td>
                    <td>94</td>
                </tr>
            </c:forEach>
        </table>

        <center>
            <input type="submit" value="details" formaction="details.jsp">
            <input type="submit" value="delete" >
        </center>
        </form>
    </body>
</html>
