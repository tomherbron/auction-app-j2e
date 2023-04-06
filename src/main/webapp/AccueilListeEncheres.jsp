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


<%
if (session.getAttribute("utilisateur") == null) {
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

						<li><a href="./ServletInscriptionUtilisateur">S'inscrire</a>
						</li>
						<li><a href="./ServletConnexion">Se Connecter</a></li>



					</ul>
				</nav>
			</header>



			<div>
				<h2>Liste des enchères</h2>
			</div>

			<div>

				<form method="post" action="ServletListeEnchere">

					<label for="site-search">Filtres :</label> <input type="text"
						name="query" placeholder="Le nom de l'article contient" /> <br>
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
				Description
				<%=articleCourant.getDescription()%>
				
			</p>
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






<%
} else {
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


						<li><a href="./ServletNouvelleVente">Vendre un article</a></li>
						<li><a href="./ServletAffichageProfilUtilisateurCourant">Modifier
								mon profil</a></li>
						<li><a href="./ServletDeconnexion">Se déconnecter</a></li>



					</ul>
				</nav>
			</header>



			<div>
				<h2>Liste des enchères</h2>
			</div>

			<div>

				<form method="post" action="ServletListeEnchere">

					<fieldset>
						<label for="achats"> 
							<input type="radio" id="achats"	name="radioAchatVente" value="achats" checked onselect=uncheck/>Achats</label>
											<fieldset>
							  					 <div>
												      <input type="checkbox" id="ench_ouv" name="ench_ouv" value="ench_ouv" >
												      <label for="ench_ouv">enchères ouvertes</label>
												 </div>
													<div>
												      <input type="checkbox" id="mes_encheres" name="mes_encheres" value="mes_encheres" >
												      <label for="mes_encheres">mes enchères</label>
											 		</div>	
												 		<div>
													      <input type="checkbox" id="mes_ench_remp" name="mes_ench_remp" value="mes_ench_remp">
													      <label for="mes_ench_remp">mes enchères remportées</label>
													 </div>		
											</fieldset>																				 
						<label for="mes-ventes"> 
							<input type="radio" id="mes-ventes" name="radioAchatVente" value="ventes"/>Mes ventes</label>
							  				<fieldset>
							  					 <div>
												      <input type="checkbox" id="en_cours" name="en_cours" value="en_cours" >
												      <label for="en_cours">mes ventes en cours</label>
												 </div>
													<div>
												      <input type="checkbox" id="non_debutee" name="non_debutee" value="non_debutee" >
												      <label for="non_debutee">ventes non debutées</label>
											 		</div>	
												 		<div>
													      <input type="checkbox" id="terminee" name="terminee" value="terminee" >
													      <label for="terminee">ventes terminées</label>
													 </div>		
											</fieldset>	  					
							  						
					</fieldset>
						
					<label for="site-search">Filtres :</label>
						<input type="text" name="query" placeholder="Le nom de l'article contient"/> 
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
						</select> 
							<input type="submit" value="Rechercher" />
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
						Description
						<%=articleCourant.getDescription()%>
						
					</p>
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
<%
}					
%>