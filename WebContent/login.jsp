<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
 <head>
       <meta charset="utf-8">
        <!-- importer le fichier de style -->
         
        <link rel="stylesheet" href="style.css" media="screen" type="text/css" />
    </head>
    <body>
        <div id="container">
            <!-- zone de connexion -->
            
            <form action="Authentifier" method="Post">
                <h1>Connexion</h1>
          
               <label style="color:red">
                <%
            // Ceci Code JAva
            // declarartion des varaible
                String msg ="";
          if (request.getAttribute("msgErreur")!= null) 
        	  msg = request.getAttribute("msgErreur").toString();
            
            
            // 2 solution
             if (session.getAttribute("msgErreur_session")!= null)
            	msg = request.getAttribute("msgErreur_session").toString();
            out.println(msg);
            
            %>  </label> <BR>
                <label><b>Nom d'utilisateur</b></label>
                <input type="text" placeholder="Entrer le nom d'utilisateur" name="username" required>

                <label><b>Mot de passe</b></label>
                <input type="password" placeholder="Entrer le mot de passe" name="password" required>

                <input type="submit" id='submit' value='LOGIN' >
             </form>
            
        </div>
    </body>
</html>