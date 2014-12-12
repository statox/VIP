<%-- 
    Document   : details
    Created on : 6 déc. 2014, 10:53:27
    Author     : adrien
--%>

<%@page import="VIP.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VIP - Details</title>
    </head>
    <body> 
        <h1>VIP's Details</h1>
        
        <p style="display:${empty error ? "block" : "none"};">
    
            Nom :    <input type="text" value="${myPerson.name}" readonly> 
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
            Adresse email : <input type="text" value="${myPerson.email}" readonly>    </br>
        </p>
        
        <p style="color:red; display:${empty error ? "none" : "block"};">
            Error : ${error}
        </p>
        
        <form action="Controleur" method="POST">
            <input type="hidden" name="requestedPage" value="search" id="hiddenAction">
            <input type="submit" value="retour" >
        </form>
    </body>
</html>
