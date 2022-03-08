<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Détail Vente</title>
</head>
<body>
	<h1>ENI-ENCHERES</h1>
	<form action="<%= request.getContextPath() %>/encherir" method="post">
		<h3>Détail vente</h3>
		<p>${Articles_vendus.getnomArticle()}</p>
		<p>Description : </p>
		<p>Catégorie : </p>
		<p>Meilleure offre : </p>
		<p> Mise à prix </p>
		<p> Fin de l'enchère : </p>
		<p> Retrait : </p>
		<p> Vendeur : </p>
		<span> Ma proposition </span> <input type='text' name='prixVente' required="required">  <br>
		<button class="btn btn-primary" type="submit">Enchérir</button>
	</form>


</body>

</html>