<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page
	import="fr.eni.projetjee.TrocEncheres.bll.SingletonUtilisateurManager"%>
<%@  page import="fr.eni.projetjee.TrocEncheres.bo.ArticleVendu"%>
<%@  page import="fr.eni.projetjee.TrocEncheres.bo.Utilisateur"%>
<%@  page import="fr.eni.projetjee.TrocEncheres.bo.Retrait"%>
<%@  page import="fr.eni.projetjee.TrocEncheres.bo.Categorie"%>
<%@  page import="fr.eni.projetjee.TrocEncheres.bo.Enchere"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ENI Enchères | Mon profil</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Kaushan+Script&display=swap" rel="stylesheet">
<link rel="stylesheet"
	href="https://unpkg.com/@picocss/pico@1.*/css/pico.min.css">
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
				<h2>Profil de  ${user.pseudo }</h2>
				<p><strong>Pseudo :  </strong>${user.pseudo}</p>
				
				<p><strong>Nom : </strong> ${user.nom}</p>
				<p><strong>Prénom : </strong>${user.prenom}</p>
				<p><strong>Email : </strong>${user.email}</p>
				<p><strong>Téléphone : </strong>${user.telephone}</p>
				<p><strong>Rue : </strong> ${user.rue}</p>
				<p><strong>Code postal : </strong> ${user.codePostal}</p>
				<p><strong>Ville : </strong> ${user.ville}</p>
			</div>

			<div>
				<form action="./ServletListeEnchere" method="GET">
					<button type="submit">Retour</button>
				</form>
			</div>
		</article>
	</div>
</body>
</html>