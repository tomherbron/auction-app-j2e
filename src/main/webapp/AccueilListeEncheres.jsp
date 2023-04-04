<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<%@page import="fr.eni.projetjee.TrocEncheres.bo.ArticleVendu"%>
<%@page import="fr.eni.projetjee.TrocEncheres.bo.Categorie"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<html>
<head>
<meta charset="UTF-8">
<title>Enchères-ENI | Accueil</title>
</head>
<body>
	<%
	List<ArticleVendu> listeArticle = (List<ArticleVendu>) request.getAttribute("listeArticle");
	ArrayList<Categorie> listeCategorie = (ArrayList) request.getAttribute("listeCategorie");
	%>

	<h1>
		<a href="AccueilListeEncheres.jsp">Enchères-ENI</a>
	</h1>

	<nav>
		<a href="FormulaireInscription.jsp">S'inscrire</a> <a
			href="SeConnecter.jsp">Se Connecter</a> <a href="NouvelleVente.jsp">Vendre
			un article</a> <a href="./ServletAffichageProfilUtilisateurCourant">Modifier
			mon profil</a> <a href="">Se déconnecter</a>
	</nav>

	<div>Liste des enchères</div>



	<div>

			<form action="post" action="./ServletListeEncheres">
				<label for="site-search">Filtres :</label> 
				<input type="text" name="query" placeholder="Le nom de l'article contient" /> 
					<br>
					<label for="categories">Catégories:</label>
					<select name="categories">
						<option value="toutes">toutes</option>
							<%
							for (int i = 0; i < listeCategorie.size(); i++) {
								String libelle = listeCategorie.get(i).getLibelle();
							%>
							<option value="<%=libelle%>"><%=libelle%></option>
							<%
							}
							%>
				</select> <input type="submit"/>
			</form>




		</div>

	<%
	for (ArticleVendu articleCourant : listeArticle) {
	%>

	<br>
	<p>-----------------------------------------------</p>
	<a href="./ServletDetailVente?id=<%=articleCourant.getNoArticle()%>"><%=articleCourant.getNomArticle()%></a>
	<br>
	<p>
		Prix :
		<%=articleCourant.getMiseAPrix()%>
		points
	</p>
	<p>
		Fin de l'enchère :
		<%=articleCourant.getDateFinEnchere()%></p>
	<br>
	<p>
		Vendeur :
		<%=articleCourant.getUtilisateur().getPseudo()%></p>

	<%
	session.setAttribute("articleCourant", articleCourant);
	}
	%>


</body>
</html>