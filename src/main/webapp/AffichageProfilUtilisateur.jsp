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
				<h2>Profil de  ${user.pseudo }</h2>
				<p>Pseudo :  ${user.pseudo}</p>
				
				<p>Nom : ${user.nom}</p>
				<p>Prénom : ${user.prenom}</p>
				<p>Email : ${user.email}</p>
				<p>Téléphone : ${user.telephone}</p>
				<p>Rue : ${user.rue}</p>
				<p>Code postal : ${user.codePostal}</p>
				<p>Ville : ${user.ville}</p>
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