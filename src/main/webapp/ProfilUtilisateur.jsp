<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ENI Enchères | Mon profil</title>
</head>
<body>
	<h1>Enchères-ENI</h1>
	<div>
		<h2>Mon profil</h2>
		<p>Pseudo : ${pseudo}</p>
		<p>Nom : ${nom} </p>
		<p>Prénom : ${prenom}</p>
		<p>Email : ${email}</p>
		<p>Téléphone : ${telephone}</p>
		<p>Rue : ${rue}</p>
		<p>Code postal : ${cpo}</p>
		<p>Ville : ${ville}</p>
		<p>Crédit : ${credit}</p>
	</div>
	<div>
		<button name ="btn-modifierUtilisateur" type="button"><a href="./ServletGestionProfilUtilisateur">Modifier</a></button>
	</div>
</body>
</html>