<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enchères ENI | Inscription</title>
</head>
<body>
	<fieldset>
    <legend>Inscription</legend>
    <form method="post" action="./ServletInscription">
	    <div>
	      <br>
	      <br>
	   	  <label for="pseudo-utilisateur">Pseudo :  </label>
	      <input type="pseudo-utilisateur" id="pseudo-utilisateur" name="pseudo-utilisateur">
	    </div>
	    <div>
	      <label for="nom-utilisateur">Nom : </label>
	      <input type="nom-utilisateur" id="nom-utilisateur" name="nom-utilisateur">
	    </div>
	   	<div>
	      <label for="prenom-utilisateur">Prénom : </label>
	      <input type="prenom-utilisateur" id="prenom-utilisateur" name="prenom-utilisateur">
	    </div>
	   	<div>
	      <label for="email-utilisateur">E-mail : </label>
	      <input type="email-utilisateur" id="email-utilisateur" name="email-utilisateur">
	    </div>
	   	<div>
	      <label for="telephone-utilisateur">Téléphone : </label>
	      <input type="telephone-utilisateur" id="telephone-utilisateur" name="telephone-utilisateur">
	    </div>
	    <div>
	      <label for="rue-utilisateur">Rue : </label>
	      <input type="rue-utilisateur" id="rue-utilisateur" name="rue-utilisateur">
	    </div>
	   	<div>
	      <label for="cpo-utilisateur">Code Postal : </label>
	      <input type="cpo-utilisateur" id="cpo-utilisateur" name="cpo-utilisateur">
	    </div>
	   	<div>
	      <label for="ville-utilisateur">Ville : </label>
	      <input type="ville-utilisateur" id="ville-utilisateur" name="ville-utilisateur">
	    </div>
	   	<div>
	      <label for="mdp-utilisateur">Mot de passe : </label>
	      <input type="mdp-utilisateur" id="mdp-utilisateur" name="mdp-utilisateur">
	    </div>
	   	<div>
	      <label for="confirmation-mdp">Confirmation : </label>
	      <input type="confirmation-mdp" id="confirmation-mdp" name="confirmation-mdp">
	    </div>
	    <div>
	      <input type="submit" value="Créer" />
	    </div>  
	</form>    
</fieldset>
</body>
</html>