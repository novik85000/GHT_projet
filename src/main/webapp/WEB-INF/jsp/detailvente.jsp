<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="fr.eni.ghtprojet.bo.Article_vendu"%>
     <%@page import="fr.eni.ghtprojet.bo.Categorie"%>
     <%@page import="fr.eni.ghtprojet.bo.Utilisateur"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="refresh" content="10; "<%=request.getContextPath()%>/visualiserdetail">
<title>Détail Vente</title>
</head>
<body>
<header>

<%if ((String)request.getSession().getAttribute("messageEnchere") != null){
			message = (String)request.getAttribute("messageEnchere");
		}
		%>
		<span style = "color: red;"> <%=message%> </span>

		<%if (message.equals("Votre enchere a passe avec succes, vous allez être redirigez sur page d'accueil")){ %>
		<script>
		setTimeout(function(){
		window.location.href = "<%= request.getContextPath() %>/accueillirconnecte";
		}, 5000);
		</script>
		<%}%>


    <a href = "<%= request.getContextPath() %>/accueillirconnecte">
      <div> <img style = "color: red;" src="<%=request.getContextPath()%>/images/eni-logo.jpg" alt="image" width = "100px" ></div>
    </a>

</header>
<%! public String message = " "; %>
<%Article_vendu article = null;
	article = (Article_vendu)request.getAttribute("article");
	Categorie categorie = null;
	categorie = (Categorie)request.getAttribute("libelle");
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
	<form action="<%= request.getContextPath() %>/encherir" method="post">
		<h3>Détail vente</h3>
		<p> <%=article.getNom_Article()%>
		<p>Description : <%= article.getDescription()%></p>
		<p> Categorie : <%= categorie.getLibelle() %> </p>
		<p>Meilleure offre : <%= article.getPrixVente() %> </p>
		<p> Mise à prix <%= article.getMiseAPrix()%> </p>
		<p> Fin de l'enchère : <%= article.getDateFinEncheres()%> </p>
		<p> Retrait : <%= user.getRue() %> <br><%=user.getCode_Postal() %>  <%= user.getVille() %></p>
		<p> Vendeur : <%= user.getPseudo() %></p>
		
		<span> Ma proposition </span> <input type='number' name='prixVente' value="<%=(placeholder+10)%>" required="required">  <br>
		<button class="btn btn-primary" type="submit" ">Enchérir</button>
		<a href="<%=request.getContextPath()%>/accueillirconnecte" > <button class="btn btn-primary" type="button">Back</button> </a>
	</form>
		
</body>

</html>