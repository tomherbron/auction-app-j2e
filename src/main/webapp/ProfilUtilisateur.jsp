<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ENI Enchères | Mon profil</title>
<link rel="stylesheet"
	href="https://unpkg.com/@picocss/pico@1.*/css/pico.min.css">
</head>
<body>
	<div class="container">
		<article>
			<header>
				<h1>
					<a href="./ServletListeEnchere">Enchères-ENI</a>
				</h1>
			</header>
			<div>
				<form action="./ServletDeconnexion" method="GET">
					<button type="submit">Se déconnecter</button>
				</form>
			</div>
			<div>
				<h2>Mon profil</h2>
				<p>Pseudo : ${pseudo}</p>
				<p>Nom : ${nom}</p>
				<p>Prénom : ${prenom}</p>
				<p>Email : ${email}</p>
				<p>Téléphone : ${telephone}</p>
				<p>Rue : ${rue}</p>
				<p>Code postal : ${cpo}</p>
				<p>Ville : ${ville}</p>
				<p>Crédit : ${credit}</p>
			</div>
			<div>
				<button name="btn-modifierUtilisateur" type="button">
					<a href="ModifierProfilUtilisateur.jsp">Modifier</a>
				</button>
			</div>
		</article>
	</div>
</body>
</html>