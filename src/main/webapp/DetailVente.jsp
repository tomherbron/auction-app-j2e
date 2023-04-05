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
	<div class="container">
		<article>
			<header>
				<h1>
					<a href="./ServletListeEnchere">Enchères-ENI</a>
				</h1>
			</header>
			<h2>Détail vente</h2>

			<%
			ArticleVendu article = (ArticleVendu) request.getAttribute("article");
			%>

			<p>
				Nom de l'article :
				<%=article.getNomArticle()%></p>
			<p>
				Description :
				<%=article.getDescription()%></p>
			<p>
				Catégorie :
				<%=article.getCategorie().getLibelle()%></p>
			<p>Prix initital : 
				<%=article.getMiseAPrix()%> points</p>
			
			<% 
			if (article.getPrixDeVente() == 0) { 
			%>	
			<p>
				Meilleure offre : pas d'offre
			</p>
			<%} else { %>
			<p>
				Meilleure offre :
				<%=article.getPrixDeVente()%>
				points
			</p>
							
			<%}%>
			<p>
				Fin de l'enchère :
				<%=article.getDateFinEnchere()%></p>
			<p>
				Retrait :
				<%=article.getRetrait().getRue()%>
				<%=article.getRetrait().getCodePostal()%>
				<%=article.getRetrait().getVille()%></p>
			<p>
				Vendu par :
				<%=article.getUtilisateur().getPseudo()%></p>
				
				<%
				 session.setAttribute("article", article);
				%>

			<form action="<%=request.getContextPath()%>/ServletDetailVente"
				method="post">
				<label for="tentacles">Ma proposition :</label>
				<br> 
				<input type="number" id="tentacles" name="proposition" min="10" max="2000">	
				<input type="submit" value="Enchérir" />		
			</form>
		</article>
	</div>
</body>
</html>