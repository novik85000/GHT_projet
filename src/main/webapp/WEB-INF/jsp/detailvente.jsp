<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="fr.eni.ghtprojet.bo.Article_vendu"%>
     <%@page import="fr.eni.ghtprojet.bo.Categorie"%>
     <%@page import="fr.eni.ghtprojet.bo.Utilisateur"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Détail Vente</title>
</head>
<body>
<%Article_vendu article = null;
	article = (Article_vendu)request.getSession().getAttribute("article");
	Categorie categorie = null;
	categorie = (Categorie)request.getSession().getAttribute("libelle");
	Utilisateur user = null;
	user= (Utilisateur)request.getSession().getAttribute("userVendeur");
%>
	<h1>ENI-ENCHERES</h1>
	<form action="<%= request.getContextPath() %>/encherir" method="post">
		<h3>Détail vente</h3>
		<p> <%= article.getNom_Article()%>
		<p>Description : <%= article.getDescription()%></p>
		<p> Categorie : <%= categorie.getLibelle() %> </p>
		<p>Meilleure offre : <%= article.getPrixVente() %> </p>
		<p> Mise à prix <%= article.getMiseAPrix()%> </p>
		<p> Fin de l'enchère : <%= article.getDateFinEncheres()%> </p>
		<p> Retrait : <%= user.getRue() %> <br><%=user.getCode_Postal() %>  <%= user.getVille() %></p>
		<p> Vendeur : <%= user.getPseudo() %></p>
		<span> Ma proposition </span> <input type='text' name='prixVente' required="required">  <br>
		<button class="btn btn-primary" type="submit">Enchérir</button>
	</form>


</body>

</html>