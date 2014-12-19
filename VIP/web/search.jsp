<%--
    Document   : search
    Created on : Dec 6, 2014, 12:12:57 PM
    Author     : matthieudelaro
--%>

<%@page import="VIP.Person"%>
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
        

        <center>
            <form action="Controleur" method="POST">
                <label for="filter">Person</label>
                <input type="text" name="filter" id="filter" placeholder="filter: ${filter}">
                <input type="hidden" name="requestedPage" value="search">
                <input type="submit" value="Search">
            </form>
        </center>
            
    
        </br>
        <form action="Controleur" method="POST">
            <table style="width:100%">
                <tr>
                    <th>VIP's ID</th>
                    <th>Name</th>
                    <th>First Name</th>
                    <th>Home Phone</th>
                    <th>Mobile Phone</th>
                    <th>Professional Phone</th>
                    <th>Street</th>
                    <th>ZIP code</th>
                    <th>City</th>
                    <th>Email</th>
                </tr>
                <c:forEach items="${VIPs}" var="VIP">
                    <tr>
                        <th><input type="radio" name="ID" value="${VIP.getName()}" required></th>
                        <th>${VIP.getName()}</th>
                        <th>${VIP.getPrenom()}</th>
                        <th>${VIP.getTelDom()}</th>
                        <th>${VIP.getTelPerso()}</th>
                        <th>${VIP.getTelPro()}</th>
                        <th>${VIP.getAddress()}</th>
                        <th>${VIP.getZipCode()}</th>
                        <th>${VIP.getCity()}</th>
                        <th>${VIP.getEmail()}</th>
                    </tr>
                </c:forEach>
            </table>
            
            
            <center>
                <p style="color:blue;">
                    ${quantity == 0 && (filter == null || filter.isEmpty()) ? "The club needs VIPs !" : ""}
                </p>
                <p style="color:red;">
                    ${quantity == 0 && filter != null && !filter.isEmpty() ? "No result." : ""}
                </p>                
                <p style="color:green;">
                    ${deletion && successfullyDeleted ? "Successfully deleted VIP !" : ""}
                </p>                
                <p style="color:red;">
                    ${deletion && !successfullyDeleted ? "Error while trying to delete VIP !" : ""}
                </p>
            </center>

            <center>
                <input type="submit" value="details" name="requestedPage" >
                <input type="submit" value="delete" name="requestedPage" >
            </center>
        </form>
    </body>
</html>
