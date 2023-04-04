<%@page
	import="fr.eni.projetjee.TrocEncheres.bll.SingletonArticleVenduManager"%>
<%@page import="fr.eni.projetjee.TrocEncheres.bll.ArticleVenduManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  page import="fr.eni.projetjee.TrocEncheres.bo.ArticleVendu"%>
<%@  page import="fr.eni.projetjee.TrocEncheres.bo.Utilisateur"%>
<%@  page import="fr.eni.projetjee.TrocEncheres.bo.Retrait"%>
<%@  page import="fr.eni.projetjee.TrocEncheres.bo.Categorie"%>
<%@  page import="fr.eni.projetjee.TrocEncheres.bo.Enchere"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://unpkg.com/@picocss/pico@1.*/css/pico.min.css">
<meta charset="UTF-8">
<title>Détail de la vente</title>
</head>
<body>
<div class ="container">
	<h1>
		<a href="./ServletListeEnchere">Enchères-ENI</a>
	</h1>
	<h2>Détail vente</h2>

	<%
		ArticleVendu article = (ArticleVendu) request.getAttribute("article");
		out.print(article);
	%>

	<p>Nom :</p>
	<%=article.getNomArticle()%>
	<p>Description :</p>
	<%=article.getDescription()%>
	<p>Catégorie :</p>
	<%=article.getCategorie()%>
	<p>Meilleure offre :</p>
	<%=article.getMiseAPrix()%>
	<p>Fin de l'enchère :</p>
	<%=article.getDateFinEnchere()%>
	<p>Retrait :</p>
	<%=article.getRetrait().getRue()%>
	<%=article.getRetrait().getCodePostal()%>
	<%=article.getRetrait().getVille()%>
	<%=article.getUtilisateur().getPseudo()%>

	<form action="<%=request.getContextPath()%>/ServletDetailVente"
		method="post">
		<label for="tentacles">Ma proposition :</label> <input type="number"
			id="tentacles" name="proposition" min="10" max="2000">

	</form>
</div>
</body>
</html>