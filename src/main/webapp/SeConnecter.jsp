<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enchères ENI | Connexion</title>
</head>
<body>
    <h1>Authentification</h1>
    <form method="post" action="./ServletConnexion">
	    <div>
	   	  <label for="identifiant">Identifiant :  </label>
	      <input type="text" id="identifiant" name="pseudo-utilisateur">
	    </div>
	    <div>
	      <label for="password">Mot de passe : </label>
	      <input type="password" id="password" name="mdp-utilisateur">
	    </div>
	    <div>
	      <input type="submit" value="Valider" />
	    </div>  
	</form>    
</body>
</html>