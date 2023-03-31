<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="fr.eni.projetjee.TrocEncheres.bo.ArticleVendu"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Recherche Article</title>

</head>

<body>

	<table align="center">

		<h2 align="center">Liste Articles</h2>

		<tr>

			<th>nom article</th>

			<th>vide</th>

			<th>Category</th>

		</tr>

		<tr>
			<%
				List<ArticleVendu> listeArticles = (List<ArticleVendu>) request.getAttribute("listeArticles");
				if(listeArticles!=null)
				{
					for(int i=0;i<listeArticles.size();i++){
						ArticleVendu article=listeArticles.get(i);
			
			%>
			<td><%=article.getNomArticle() %></td>


			<%

				}
			}
			
			else {
			
			%>
			
			Pas d'articles disponilbles !
			
			<%
			}
			%>
		
	</table>

</body>

</html>