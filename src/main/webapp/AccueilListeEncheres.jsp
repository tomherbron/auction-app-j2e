<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<%@page import="fr.eni.projetjee.TrocEncheres.bo.ArticleVendu"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<html>
<head>
<meta charset="UTF-8">
<title>Enchères-ENI | Accueil</title>
</head>
<body>

	<h1>
		<a href="AccueilListeEncheres.jsp">Enchères-ENI</a>
	</h1>

	<nav>
		<a href="./ServletInscriptionUtilisateur">S'inscrire</a> 
		<a href="./ServletConnexion">Se Connecter</a> 
		<a href="./ServletNouvelleVente">Vendre un article</a> 
		<a href="./ServletAffichageProfilUtilisateurCourant">Modifier mon profil</a>
		<a href="./ServletDeconnexion">Se déconnecter</a>
	</nav>

	<div>Liste des enchères</div>

	<form action="post" action="./ServletAccueilListeEncheres">
		<div>
			<label for="site-search">Filtres :</label> <input type="search"
				placeholder="Le nom de l'article contient" id="site-search" name="q">
			<label for="categories">Catégories:</label> <select name="categories"
				id="categories">
				<option value="informatique">informatique</option>
				<option value="bricolage">bricolage</option>
				<option value="electromenager">electromenager</option>
				<option value="textile">textile</option>
				<option value="armement">armement</option>

			</select>
		<button>Rechercher</button>
	</div>
</form>

		

	
	
	

		
		
		
			
<%
List<ArticleVendu> listeArticle = (List<ArticleVendu>) request.getAttribute("listeArticle");
for (ArticleVendu articleCourant : listeArticle) {
%>

<br>
<p>-----------------------------------------------</p>
<a href="./ServletDetailVente?id=<%=articleCourant.getNoArticle()%>"><%=articleCourant.getNomArticle()%></a>
<br>
<p>Prix : <%=articleCourant.getMiseAPrix()%> points</p>
<p>Fin de l'enchère : <%=articleCourant.getDateFinEnchere()%></p>
<br>
<p>Vendeur : <%=articleCourant.getUtilisateur().getPseudo()%></p>

	<%
	session.setAttribute("articleCourant", articleCourant);
	}
	%>

</body>
</html>