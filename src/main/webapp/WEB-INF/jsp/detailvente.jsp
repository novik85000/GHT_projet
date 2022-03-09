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
<header>
    <a href = "<%= request.getContextPath() %>/accueillirconnecte">
      <div> <img style = "color: red;" src="<%=request.getContextPath()%>/images/eni-logo.jpg" alt="image" width = "100px" ></div>
    </a>

</header>
<%Article_vendu article = null;
	article = (Article_vendu)request.getSession().getAttribute("article");
	Categorie categorie = null;
	categorie = (Categorie)request.getSession().getAttribute("libelle");
	Utilisateur user = null;
	user= (Utilisateur)request.getSession().getAttribute("userVendeur");
	int placeholder = 0;
	if (article!= null) {
		if (article.getMiseAPrix()>article.getPrixVente()) {
		placeholder = article.getMiseAPrix();
		}else {
		placeholder = article.getPrixVente();
		}
	}
%>
	<h1>ENI-ENCHERES</h1>
	<form action="<%= request.getContextPath() %>/visualiserdetail" method="post">
		<h3>Détail vente</h3>
		<p> <%=article.getNom_Article()%>
		<p>Description : <%= article.getDescription()%></p>
		<p> Categorie : <%= categorie.getLibelle() %> </p>
		<p>Meilleure offre : <%= article.getPrixVente() %> </p>
		<p> Mise à prix <%= article.getMiseAPrix()%> </p>
		<p> Fin de l'enchère : <%= article.getDateFinEncheres()%> </p>
		<p> Retrait : <%= user.getRue() %> <br><%=user.getCode_Postal() %>  <%= user.getVille() %></p>
		<p> Vendeur : <%= user.getPseudo() %></p>
		
		<span> Ma proposition </span> <input type='text' name='prixVente' value="<%=(placeholder+10)%>" required="required">  <br>
		<button class="btn btn-primary" type="submit">Enchérir</button>
	</form>


</body>

</html>