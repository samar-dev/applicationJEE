<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nouveau Utilisateur</title>
  <!-- importer le fichier de style -->
         
        <link rel="stylesheet" href="style.css" media="screen" type="text/css" />
  
</head>
<body>
<div id="container">
            <!-- zone de connexion -->
            
            <form action="Ajouter" method="POST">
                <p style="color:blue">Nouveau Utilisateur</p>
          
               <label style="color:red">
                <%
            // Ceci Code JAva
            
            
            %>  </label> <BR>
                <label><b>id Utilisateur</b></label>
                <input type="text" placeholder="Entrer le id" name="iduser" required>

 <label><b>Prénom et Nom</b></label>
                <input type="text" placeholder="Entrer le nom prénom de l'utilisateur" name="username" required>
 <label><b>Login</b></label>
                <input type="text" placeholder="Entrer le nom d'utilisateur" name="login" required>

                <label><b>Mot de passe</b></label>
                <input type="password" placeholder="Entrer le mot de passe" name="password" required>

                <input type="submit" id='submit' value='Enregistrer' >
             </form>
            
        </div>
 
</body>
</html>