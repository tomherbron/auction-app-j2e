<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enchères-ENI | Mon profil</title>
</head>
<link rel="stylesheet"
	href="https://unpkg.com/@picocss/pico@1.*/css/pico.min.css">
<body>
	<div class="container">
		<article>
			<header>
				<h1>
					<a href="./ServletListeEnchere">Enchères-ENI</a>
				</h1>
			</header>
			<h2>Modifier mon profil</h2>
			<form method="post" action="./ServletGestionProfilUtilisateur">
				<div>
					<label for="pseudo-utilisateur">Pseudo : </label> <input
						type="text" id="pseudo-utilisateur" name="pseudo-utilisateur"
						pattern="^[a-zA-Z0-9]{4,16}$">
				</div>
				<div>
					<label for="nom-utilisateur">Nom : </label> <input type="text"
						id="nom-utilisateur" name="nom-utilisateur"
						pattern="^[a-zA-Z]+(?:\s+[a-zA-Z]+)*$">
				</div>
				<div>
					<label for="prenom-utilisateur">Prénom : </label> <input
						type="text" id="prenom-utilisateur" name="prenom-utilisateur"
						pattern="^[a-zA-Z]+(?:\s+[a-zA-Z]+)*$">
				</div>
				<div>
					<label for="email-utilisateur">E-mail : </label> <input
						type="email" id="email-utilisateur" name="email-utilisateur">
				</div>
				<div>
					<label for="telephone-utilisateur">Téléphone : </label> <input
						type="text" id="telephone-utilisateur"
						name="telephone-utilisateur" pattern="^[0-9]{10}$">
				</div>
				<div>
					<label for="rue-utilisateur">Rue : </label> <input type="text"
						id="rue-utilisateur" name="rue-utilisateur">
				</div>
				<div>
					<label for="cpo-utilisateur">Code Postal : </label> <input
						type="text" id="cpo-utilisateur" name="cpo-utilisateur"
						pattern="^[0-9]{5}(?:-[0-9]{4})?$">
				</div>
				<div>
					<label for="ville-utilisateur">Ville : </label> <input type="text"
						id="ville-utilisateur" name="ville-utilisateur">
				</div>
				<div>
					<label for="mdp-utilisateur">Mot de passe actuel : </label> <input
						type="password" id="mdp-utilisateur" name="mdp-utilisateur-actuel"
						pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,16}$">
				</div>
				<div>
					<label for="mdp-utilisateur">Nouveau mot de passe : </label> <input
						type="password" id="mdp-utilisateur" name="mdp-utilisateur"
						pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,16}$">
				</div>
				<div>
					<label for="confirmation-mdp">Confirmation : </label> <input
						type="password" id="confirmation-mdp" name="confirmation-mdp"
						pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,16}$">
				</div>
				<div>
					<input type="submit" value="Enregistrer" />
				</div>
			</form>
			<div>
				<form action="./ServletSuppressionUtilisateur" method="GET">
					<button type="submit">Supprimer mon compte</button>
				</form>
			</div>
		</article>
	</div>
</body>
</html>