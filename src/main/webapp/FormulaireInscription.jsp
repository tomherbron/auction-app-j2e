<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enchères ENI | Inscription</title>
</head>
<body>
	<h1>Inscription</h1>
    <form method="post" action="./ServletInscriptionUtilisateur">
	    <div>
	   	  <label for="pseudo-utilisateur">Pseudo :  </label>
	      <input type="text" id="pseudo-utilisateur" name="pseudo-utilisateur" pattern = "^[a-zA-Z0-9]{4,16}$">
	    </div>
	    <div>
	      <label for="nom-utilisateur">Nom : </label>
	      <input type="text" id="nom-utilisateur" name="nom-utilisateur" pattern = "^[a-zA-Z]+(?:\s+[a-zA-Z]+)*$">
	    </div>
	   	<div>
	      <label for="prenom-utilisateur">Prénom : </label>
	      <input type="text" id="prenom-utilisateur" name="prenom-utilisateur" pattern = "^[a-zA-Z]+(?:\s+[a-zA-Z]+)*$">
	    </div>
	   	<div>
	      <label for="email-utilisateur">E-mail : </label>
	      <input type="email" id="email-utilisateur" name="email-utilisateur">
	    </div>
	   	<div>
	      <label for="telephone-utilisateur">Téléphone : </label>
	      <input type="text" id="telephone-utilisateur" name="telephone-utilisateur"  pattern = "^[0-9]{10}$">
	    </div>
	    <div>
	      <label for="rue-utilisateur">Rue : </label>
	      <input type="text" id="rue-utilisateur" name="rue-utilisateur">
	    </div>
	   	<div>
	      <label for="cpo-utilisateur">Code Postal : </label>
	      <input type="text" id="cpo-utilisateur" name="cpo-utilisateur" pattern = "^[0-9]{5}(?:-[0-9]{4})?$">
	    </div>
	   	<div>
	      <label for="ville-utilisateur">Ville : </label>
	      <input type="text" id="ville-utilisateur" name="ville-utilisateur">
	    </div>
	   	<div>
	      <label for="mdp-utilisateur">Mot de passe : </label>
	      <input type="password" id="mdp-utilisateur" name="mdp-utilisateur"  pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,16}$">
	    </div>
	   	<div>
	      <label for="confirmation-mdp">Confirmation : </label>
	      <input type="password" id="confirmation-mdp" name="confirmation-mdp" pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,16}$">
	    </div>
	    <div>
	      <input type="submit" value="Créer" />
	    </div>  
	</form>    
</body>
</html>