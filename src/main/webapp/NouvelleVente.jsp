<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enchères-ENI | Nouvelle vente</title>
</head>
<body>
	<h1>Enchères-ENI</h1>
	<h2>Nouvelle vente</h2>
	<form method="post" action="./ServletNouvelleVente">
		<div>
			<label for="nom-article">Article : </label> <input type="text"
				id="nom-article" name="nom-article">
		</div>
		<div>
			<label for="description">Description : </label> <input type="text"
				id="description" name="description">
		</div>

		<div>
			<label for="categorie">Catégorie :</label> <select name="categorie"
				id="categorie">
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
				name="mise-a-prix" id=mise-a-prix>

				<option value="" hidden></option>


				<option value="150">150</option>
				<option value="200">200</option>
				<option value="250">250</option>
				<option value="300">300</option>
				<option value="350">350</option>
				<option value="400">400</option>
				<option value="450">450</option>
				<option value="500">500</option>

			</select>
		</div>
		<div>
			<label>Début de l'enchère : <input type="date"
				name="debut-enchere" id="debut-enchere" required
				pattern="\d{4}-\d{2}-\d{2}">
			</label>
		</div>
		<div>
			<label>Fin de l'enchère : <input type="date"
				name="fin-enchere" id="fin-enchere" required
				pattern="\d{4}-\d{2}-\d{2}">
			</label>
		</div>
		<div>
			<label for="rue">Rue : </label> <input type="text"
				id="rue" name="rue">	
		</div>
		<div>
			<label for="code-postal">Code postal : </label> <input type="text"
				id="code-postal" name="code-postal">	
		</div>
		<div>
			<label for="ville">Ville : </label> <input type="text"
				id="ville" name="ville">	
		</div>
		
		<input type="submit" value="Enregistrer">
		<input type="reset" value="Annuler">
	</form>





</body>
</html>