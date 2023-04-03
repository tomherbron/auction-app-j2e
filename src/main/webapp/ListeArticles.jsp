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


	<table align="center">

		<thead>
			<tr>
				<td>Date</td>
				<td>Heure</td>
				<td>Action</td>
			</tr>
		</thead>
	
			<%
			List<ArticleVendu> uneVariable = (List<ArticleVendu>) request.getAttribute("listeArticle");
			
			
			%>
				
		<ul>
			<%
			for (ArticleVendu element : uneVariable) {
			%>
			<li><%=element%></li>
			<%
			}
			%>
		</ul>




		<%
		List<ArticleVendu> listeArticle = (List<ArticleVendu>) request.getAttribute("listeArticle");
		if (listeArticle != null && listeArticle.size() > 0) {
		%>
		<tbody>
			<%
			for (ArticleVendu articleVendu : listeArticle) {
			%>
			<tr>
				<td><%=articleVendu.getNomArticle()%></td>
				<td><%=articleVendu.getDescription()%></td>

				<td><a
					href="<%=request.getContextPath()%>/articleVendu?detail=<%=articleVendu.getNoArticle()%>">détail</a></td>
			</tr>
			<%
			if (String.valueOf(articleVendu.getNoArticle()).equals(request.getParameter("detail"))) {
			%>
			<tr>
				<td><%=articleVendu.getCategorie()%></td>

			</tr>
			<%
			}
			}
			%>
		</tbody>
		<%
		}
		%>





	</table>

</body>

</html>