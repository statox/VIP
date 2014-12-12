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
    // Handle VIP's deletion

    String IdToDelete = request.getParameter("ID");
    if (IdToDelete != null)
    {
        stmt.executeUpdate("DELETE from UTILISATEUR where NOM='"+IdToDelete+"'");
    }
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
                <th>Home Phone</th>
                <th>Mobile Phone</th>
                <th>Professional Phone</th>
                <th>Street</th>
                <th>ZIP code</th>
                <th>City</th>
                <th>Email</th>
            </tr>
            <%
                for(Person VIP : VIPs) {
                    out.print("<tr>");
                        out.print("<td>");
                            out.print("<input type=\"radio\" name=\"ID\" value=\""+VIP.getName()+"\">");
                        out.print("</td>");
                        out.print("<td>");
                            out.print(VIP.getName());
                        out.print("</td>");
                        out.print("<td>");
                            out.print(VIP.getPrenom());
                        out.print("</td>");
                        out.print("<td>");
                            out.print(VIP.getTelDom());
                        out.print("</td>");
                        out.print("<td>");
                            out.print(VIP.getTelPerso());
                        out.print("</td>");
                        out.print("<td>");
                            out.print(VIP.getTelPro());
                        out.print("</td>");
                        out.print("<td>");
                            out.print(VIP.getAddress());
                        out.print("</td>");
                        out.print("<td>");
                            out.print(VIP.getZipCode());
                        out.print("</td>");
                        out.print("<td>");
                            out.print(VIP.getCity());
                        out.print("</td>");
                        out.print("<td>");
                            out.print(VIP.getEmail());
                        out.print("</td>");
                    out.print("</tr>");
                }
            %>
        </table>

        <center>
            <input type="submit" value="details" formaction="details.jsp">
            <input type="submit" value="delete"  >
        </center>
        </form>
    </body>
</html>
