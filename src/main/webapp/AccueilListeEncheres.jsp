<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

	<h1>Enchères-ENI</h1>
	
<nav>
	 <a href="FormulaireInscription.jsp">S'inscrire</a>
	 <a href="SeConnecter.jsp">Se Connecter</a> 
	 <a href="NouvelleVente.jsp">Vendre un article</a> 
	 <a href= "./ServletAffichageProfilUtilisateurCourant">Modifier mon profil</a>
	 <a href= "">Se déconnecter</a>
</nav>
	
	<div>
		Liste des enchères
	</div>


<form action="post" action="./ServletAccueilListeEncheres">
	<div>
		<label for="site-search">Filtres :</label> <input type="search" placeholder="Le nom de l'article contient"
			id="site-search" name="q">
				<label for="categories">Catégories:</label>
			<select name="categories" id="categories">
				<option value="cat1">cat1</option>
				<option value="cat2">cat2</option>
				<option value="cat3">cat3</option>
				<option value="cat4">cat4</option>
			</select>
		<button>Rechercher</button>
	</div>
</form>

			
		<%
			List<ArticleVendu> listeArticle = (List<ArticleVendu>) request.getAttribute("listeArticle");
								
			for (ArticleVendu element : listeArticle) {
			%>
			<a href= "./ServletDetailVente"><%=element.getNomArticle()%></a>'
			<p><%=element.getDescription()%></p>
			<%
			}
			%>	


</body>
</html>