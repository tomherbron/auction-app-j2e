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
    <form method="get" action="./ServletConnexionUtilisateur">
	    <div>
	   	  <label for="identifiant">Identifiant :  </label>
	      <input type="identifiant" id="identifiant" name="identifiant">
	    </div>
	    <div>
	      <label for="password">Mot de passe : </label>
	      <input type="password" id="password" name="password">
	    </div>
	    <div>
	      <input type="submit" value="Valider" />
	    </div>  
	</form>    
</body>
</html>