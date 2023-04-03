<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="fr.eni.projetjee.TrocEncheres.bo.ArticleVendu"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Liste Article</title>

</head>

<body>


	
			<%
			List<ArticleVendu> listeArticle = (List<ArticleVendu>) request.getAttribute("listeArticle");
						
			%>
				
		<ul>
			<%
			for (ArticleVendu element : listeArticle) {
			%>
			<li><%=element.getDescription()%></li>
			<%
			}
			%>
		</ul>



	

</body>

</html>