<%-- 
    Document   : details
    Created on : 6 déc. 2014, 10:53:27
    Author     : adrien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="VIP.*"%>

<jsp:useBean scope="request" class="VIP.Person" id="myPerson" />
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="com.sun.faces.*"%>

<% 
    String URL = "jdbc:derby://localhost:1527/VIP";
    String USER = "efrei";
    String PASS = "efrei";
    Connection conn = DriverManager.getConnection(URL, USER, PASS); 
    Statement stmt = conn.createStatement();
%>


<%
    String ID = request.getParameter("ID");
    ResultSet rs = stmt.executeQuery("select * from UTILISATEUR where NOM='" + ID + "'");
    

    if (rs.next()){
        myPerson.inflate(rs);
  
    }
        
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Details du membre</title>
    </head>
    <body>
        <h1>Detail d'un membre du club EFREI/M1/IL/JEE</h1>
        
        <p>
    
            nom :    <input type="text" value="${myPerson.name}" readonly> 
            Prenom : <input type="text" value="${myPerson.prenom}" readonly> </br>
            </br>
            <b>Numeros de telephone</b> </br>
            Domicile :       <input type="text" value="${myPerson.telDom}" readonly>     </br>
            Portable :       <input type="text" value="${myPerson.telPerso}" readonly>   </br>
            Professionnel :  <input type="text" value="${myPerson.telPro}" readonly>     </br>
            </br>
            Adresse :       <input type="text" value="${myPerson.address}" readonly>    </br>
            Code Postal :   <input type="text" value="${myPerson.zipCode}" readonly>  
            Ville :         <input type="text" value="${myPerson.city}" readonly>       </br>
            adresse email : <input type="text" value="${myPerson.email}" readonly>    </br>
        </p>
        
        <form action="search.jsp">
            <input type="submit" value="retour" >
        </form>
        
        
    </body>
</html>
