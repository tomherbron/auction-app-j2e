<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<%@page import="fr.eni.projetjee.TrocEncheres.bo.ArticleVendu"%>
<%@page import="fr.eni.projetjee.TrocEncheres.bo.Categorie"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>


<%
ArrayList<Categorie> listeCategorie = (ArrayList) request.getAttribute("listeCategorie");

%>



<html>
<head>
<link rel="stylesheet"
	href="https://unpkg.com/@picocss/pico@1.*/css/pico.min.css">
<meta charset="UTF-8">
<title>Enchères-ENI | Accueil</title>
</head>
<body>
	<div class="container">
		<article>

			<header>


				<h1>
					<a href="./ServletListeEnchere">Enchères-ENI</a>
				</h1>
				<nav aria-label="breadcrumb">
					<ul>
						<%
						if (session.getAttribute("utilisateur") == null) {
						%>
						<li><a href="./ServletInscriptionUtilisateur">S'inscrire</a>
						</li>
						<li><a href="./ServletConnexion">Se Connecter</a></li>
						<%
						} else {
						%>

						<li><a href="./ServletNouvelleVente">Vendre un article</a></li>
						<li><a href="./ServletAffichageProfilUtilisateurCourant">Modifier
								mon profil</a></li>
						<li><a href="./ServletDeconnexion">Se déconnecter</a></li>
						<%
						}
						%>


					</ul>
				</nav>
			</header>



			<div>
				<h2>Liste des enchères</h2>
			</div>

			<div>

				<form method="post" action="ServletListeEnchere">
					
					<fieldset>
						<label for="achats"> <input type="radio" id="achats"
							name="condition" value="achats" checked> Achats
						</label> <label for="mes-ventes"> <input type="radio"
							id="mes-ventes" name="condition" value="mes-ventes"> Mes
							ventes
						</label>
					</fieldset>
					
					<label for="site-search">Filtres :</label> 
					<input type="text" name="query" placeholder="Le nom de l'article contient" /> <br>
					<label for="categories">Catégories:</label> <select
						name="categories">
						<option value="toutes">toutes</option>
						<%
						for (int i = 0; i < listeCategorie.size(); i++) {
							String libelle = listeCategorie.get(i).getLibelle();
						%>
						<option value="<%=libelle%>"><%=libelle%></option>
						<%
						}
						%>
					</select> <input type="submit" value="Rechercher" />
				</form>

			</div>


			<%
			List<ArticleVendu> listeArticle = (List<ArticleVendu>) request.getAttribute("listeArticle");
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



		</article>
	</div>
</body>
</html>