<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ENI Enchères | Mon profil</title>
<link rel="stylesheet"
	href="https://unpkg.com/@picocss/pico@1.*/css/pico.min.css">
		<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Kaushan+Script&display=swap" rel="stylesheet">
</head>
<body>
	<div class="container">
		<article>
			<header>
				<h1 style = "font-family: 'Kaushan Script', cursive;">
					<a href="./ServletListeEnchere">Enchères-ENI</a>
				</h1>
			</header>
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
				<form action="ModifierProfilUtilisateur.jsp" method="GET">
					<button type="submit">Modifier</button>
				</form>
			</div>
			<div>
				<form action="./ServletDeconnexion" method="GET">
					<button type="submit">Se déconnecter</button>
				</form>
					<form action="./ServletListeEnchere" method="GET">
					<button type="submit">Retour</button>
				</form>
			</div>
		</article>
	</div>
</body>
</html>