<%-- 
    Document   : index
    Created on : 6 déc. 2014, 11:14:30
    Author     : adrien
--%>

<html>
    <head>
        <title>VIP - Secured Gate</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body style="text-align: center; ">
        <h1>VIP - Secured Gate</h1>
        
        <p style="color: red; display:${empty signingInError ? "none" : "block"};">
            Error : ${signingInError}
        </p>
        
        <p>Please Sign In :</p>
        <form action="Controleur" method="POST">
            <label for="login">Login :  </label><input type="text" name="login" id="login"><br><br>
            <label for="Password">Password :  </label><input type="password" name="password" id="password"><br><br>
            <input type="hidden" name="requestedPage" value="connexion">
            <input type="submit" value="Sign In">
        </form>
    </body>
</html>