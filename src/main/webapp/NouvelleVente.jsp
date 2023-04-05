<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enchères-ENI | Nouvelle vente</title>
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
			<h2>Nouvelle vente</h2>
			<form method="post" action="./ServletNouvelleVente">
				<div>
					<label for="nom-article">Article : </label> <input type="text"
						id="nom-article" name="nom-article" required>
				</div>
				<div>
					<label for="description">Description : </label> <input type="text"
						id="description" name="description" required>
				</div>

				<div>
					<label for="categorie">Catégorie :</label> <select name="categorie"
						id="categorie" required>
						<option value="">--Choisissez une catégorie--</option>
						<option value="informatique">Informatique</option>
						<option value="bricolage">Bricolage</option>
						<option value="electromenager">Electromenager</option>
						<option value="textile">Textile</option>
						<option value="armement">Armement</option>
					</select>
				</div>
				<!--<div>
			<label for="image">Photo de l'article:</label> <input
				type="file" id="image" name="image" accept="image/png, image/jpeg">
		</div>-->

				<div>
					<label for="mise-a-prix">Mise à prix :</label><select
						name="mise-a-prix" id=mise-a-prix required>

						<option value="" hidden></option>


						<option value="10">10</option>
						<option value="20">20</option>
						<option value="30">30</option>
						<option value="40">40</option>
						<option value="50">50</option>
						<option value="60">60</option>
						<option value="70">70</option>
						<option value="80">80</option>

					</select>
				</div>
				<div>
					<label>Début de l'enchère : <input type="date"
						name="debut-enchere" id="debut-enchere" required
						pattern="\d{4}-\d{2}-\d{2}" >
					</label>
				</div>
				<div>
					<label>Fin de l'enchère : <input type="date"
						name="fin-enchere" id="fin-enchere" required
						pattern="\d{4}-\d{2}-\d{2}">
					</label>
				</div>
				<div>
					<label for="rue">Rue : </label> <input type="text" id="rue"
						name="rue">
				</div>
				<div>
					<label for="code-postal">Code postal : </label> <input type="text"
						id="code-postal" name="code-postal">
				</div>
				<div>
					<label for="ville">Ville : </label> <input type="text" id="ville"
						name="ville">
				</div>

				<input type="submit" value="Enregistrer"> 
				<input type="reset" value="Effacer">	
			</form>
		</article>
	</div>
</body>
</html>