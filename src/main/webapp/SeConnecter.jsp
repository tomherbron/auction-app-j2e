<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://unpkg.com/@picocss/pico@1.*/css/pico.min.css">
<meta charset="UTF-8">
<title>Enchères-ENI | Connexion</title>
</head>
<body>
	<div class ="container">
		<h1>
			<a href="./ServletListeEnchere">Enchères-ENI</a>
		</h1>
		<h2>Se connecter</h2>
		<form method="post" action="./ServletConnexion">
			<div>
				<label for="identifiant">Identifiant : </label> <input type="text"
					id="identifiant" name="pseudo-utilisateur">
			</div>
			<div>
				<label for="password">Mot de passe : </label> <input type="password"
					id="password" name="mdp-utilisateur">
			</div>
			<div>
				<input type="submit" value="Valider" />
			</div>
		</form>
		<div>

			<a href="./FormulaireInscription.jsp" role="button" name= "btn-creercompte">Créer un compte</a>
		</div>
	</div>
</body>
</html>