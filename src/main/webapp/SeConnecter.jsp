<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Kaushan+Script&display=swap" rel="stylesheet">
<link rel="stylesheet"
	href="https://unpkg.com/@picocss/pico@1.*/css/pico.min.css">
<meta charset="UTF-8">
<title>Enchères-ENI | Connexion</title>
</head>
<body>
	<div class="container">
		<article>
			<header>
				<h1 style = "font-family: 'Kaushan Script', cursive;">
					<a href="./ServletListeEnchere">Enchères-ENI</a>
				</h1>
			</header>
			<h2>Se connecter</h2>
			<form method="post" action="./ServletConnexion">
				<div>
					<label for="identifiant">Identifiant : </label> <input type="text"
						id="identifiant" name="pseudo-utilisateur">
				</div>
				<div>
					<label for="password">Mot de passe : </label> <input
						type="password" id="password" name="mdp-utilisateur">
				</div>
				<div>
					<input type="submit" value="Valider" />
				</div>


			</form>
			<%
			if (request.getAttribute("erreur") != null) {
			%>
			<strong>Erreur dans la saisie, veuillez réessayer</strong>
			<%
			}
			%>



			<footer>
				<div dir="rtl">

					<a href="./FormulaireInscription.jsp" role="button"
						name="btn-creercompte">Créer un compte</a>
				</div>


			</footer>
		</article>
	</div>
</body>
</html>