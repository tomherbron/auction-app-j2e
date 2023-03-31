<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>A Web Page</title>
</head>
<body>

	<h1>ENI-Encheres</h1>
	
<nav>
	<a href="/Inscription.jsp">S'inscrire</a>
	 <a href="/LoginUtilisateur.jsp">Se Connecter</a> 
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
		<button>rechercher</button>
	</div>
</form>

<map name="resultatRecherche1">
    <area shape="rect" coords="0,0,350,150"
          href="https://developer.mozilla.org"
          alt="premier résultat"/>
</map>
<img usemap="#resultatRecherche1" src="https://via.placeholder.com/350x150" alt="MDN infographic">

<br>

<map name="resultatRecherche2">
    <area shape="rect" coords="0,0,350,150"
          href="https://developer.mozilla.org"
          alt="premier résultat"/>
</map>
<img usemap="#resultatRecherche2" src="https://via.placeholder.com/350x150" alt="MDN infographic">

<br>

<map name="resultatRecherche3">
    <area shape="rect" coords="0,0,350,150"
          href="https://developer.mozilla.org"
          alt="premier résultat"/>
</map>
<img usemap="#resultatRecherche3" src="https://via.placeholder.com/350x150" alt="MDN infographic">

<br>

<map name="resultatRecherche4">
    <area shape="rect" coords="0,0,350,150"
          href="https://developer.mozilla.org"
          alt="premier résultat"/>
</map>
<img usemap="#resultatRecherche4" src="https://via.placeholder.com/350x150" alt="MDN infographic">

<br>











</body>
</html>