<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
    <legend>Connexion</legend>
    <form method="get" action="./ServletConnexionUtilisateur">
	    <div>
	      <br>
	      <br>
	   	  <label for="identifiant">Identifiant :  </label>
	      <input type="identifiant" id="identifiant" name="identifiant" value="identifiant">
	    </div>
	    <div>
	      <label for="password">Mot de passe : </label>
	      <input type="password" id="password" name="password" value="password">
	    </div>
	    <div>
	      <input type="submit" value="Valider" />
	    </div>  
	</form>    
</fieldset>
</body>
</html>