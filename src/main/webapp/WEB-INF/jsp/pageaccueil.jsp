<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="fr.eni.ghtprojet.bo.Article_vendu"%>
<%@page import="fr.eni.ghtprojet.bo.Utilisateur"%>
<%@page import="fr.eni.ghtprojet.bll.UtilisateurManager"%>
<%@page  import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Accueil</title>
<style type="text/css">

 </style>
</head>
<body>
<div class="container">
<form action="<%= request.getContextPath() %>/accueil_servlet" method="post">
<div class="row">
    <div class="col">
    <a href = "<%= request.getContextPath() %>/accueil_servlet">
      <div> <img style = "color: red;" src="<%=request.getContextPath()%>/images/eni-logo.jpg" alt="image" width = "100px" ></div>
    </a>
    </div>
    <div class="col">
       <h5><a href="<%=request.getContextPath()%>/connecter">S'inscrire - Se connecter</a></h5>
    </div>
  </div>
<div class="row">
    <div  class="col col-12 h1" style="text-align: center;">
     Liste de encheres
    </div>
  </div>
  
  <div class="row">
    <div class="col">
     <nav class="navbar navbar-light bg-light">
  <form class="container-fluid">
    <div class="input-group">
      <span class="input-group-text" id="basic-addon1">&#128270</span>
      <input type="text" class="form-control" placeholder="Le nom de l'article contient" aria-label="Username" aria-describedby="basic-addon1" name="recherche">
    </div>
  </form>
</nav>
<div class="dropdown">
  <span class="h5">Categorie: </span> 
  <select class="h5" name = "categorie">
    <option class="dropdown-item" value = "0" >Toutes</option>
    <option class="dropdown-item" value = "1" >Informatique</option>
    <option class="dropdown-item" value = "2" >Ameublement</option>
    <option class="dropdown-item" value = "3" >Vêtements</option>
    <option class="dropdown-item" value = "4" >Sport et Loisirs</option>
  </select>
</div>
    </div>
    <div class="col">
      <button type="submit" class="btn btn-primary btn-lg">Rechercher</button>
    </div>
  </div>
  <div class="row">
  <%! public List <Article_vendu> listeArticles = null;
  public List <Article_vendu> listeArticlesApresFiltre = null;%>
  <%  listeArticles = (List <Article_vendu>)request.getAttribute("listeArticles"); %>
  <% if (listeArticles != null) { 
	  for (int i = 0; i<listeArticles.size(); i++) { %>
    <div class="col col-6">
     <div class="card" style="width: 18rem;">
		  <img src="<%=request.getContextPath()%>/images/imageAuction.png" class="card-img-top" alt="image" style="width: 5vw;">
		  <div class="card-body">
		    <h5 class="card-title"> <%= listeArticles.get(i).getNom_Article() %></h5>
		    <p class="card-text">  
		    	Prix: <%= listeArticles.get(i).getPrixVente() %> <br>
		    	Fin de l'enchère: <%= listeArticles.get(i).getDateFinEncheres()%> <br>
		    	<% UtilisateurManager mger = new UtilisateurManager ();
		    	Utilisateur user = mger.selectById(listeArticles.get(i).getNo_Utilisateur());
		    	
		    	
		    	%>
		    	Vendeur: <%= user.getPseudo() %> <br>
		    
		    </p>
		    <h6> S'inscrire pour voir les details </h6>
		  </div>
	 </div>
     </div>
    <% }} %>
   
</div>
</form>
</div>
	
</body>
</html>