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
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Accueil</title>
<style type="text/css">

 </style>
</head>
<body>
<div class="container">
<form action="<%= request.getContextPath() %>/accueillirconnecte" method="post">
<div class="row">
    <div class="col">
         <a href = "<%= request.getContextPath() %>/accueil_servlet">
      <div> <img style = "color: red;" src="<%=request.getContextPath()%>/images/eni-logo.jpg" alt="image" width = "100px" ></div>
    </a>
    </div>
	<div class="col">
		<a href="<%=request.getContextPath()%>/accueillirconnecte">Enchères</a>
		<a href="<%=request.getContextPath()%>/vendreobjet">Vendre un article</a>
		<a href="<%=request.getContextPath()%>/afficherprofil">Mon profil</a>
		<a href="<%=request.getContextPath()%>/accueil_servlet">Déconnexion</a>
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
  </form>
  </div>
  <div class="row">
  <%! public List <Article_vendu> listArticles = null;  %>
  <%  if ((List <Article_vendu>)request.getSession().getAttribute("articleApresFiltre") == null){
	   		listArticles = (List <Article_vendu>)request.getSession().getAttribute("listeArticles");
	   		} else {
	   			listArticles = (List <Article_vendu>)request.getSession().getAttribute("articleApresFiltre");
	   		}
	   		
	   		%>
  <% if (listArticles != null) { 
	  for (int i = 0; i<listArticles.size(); i++) { %>
    <div class="col col-6">
     <div class="card" style="width: 18rem;">
		  <img src="<%=request.getContextPath()%>/images/meilleur-pc-gamer.jpg" class="card-img-top" alt="image">
		  <div class="card-body">
		    <h5 class="card-title"> <%= listArticles.get(i).getNom_Article() %></h5>
		    <p class="card-text">  
		    	Prix: <%= listArticles.get(i).getPrixVente() %> <br>
		    	Fin de l'enchère: <%= listArticles.get(i).getDateFinEncheres()%> <br>
		    	<% UtilisateurManager mger = new UtilisateurManager ();
		    	Utilisateur user = mger.selectById(listArticles.get(i).getNo_Utilisateur());
		    	 int no_article = listArticles.get(i).getNo_Article();
		    	
		    	%>
		    	Vendeur: <%= user.getPseudo() %> <br>
		    
		    </p>
		     </div>
     </div>
		    

<form action="<%= request.getContextPath() %>/encherir" method="post">
		    <button type="submit" name="idArticle" value="<%= no_article %>"> Voir les details </button> 
</form>
		  </div>
	
    <% }} %>
   


</div>
</div>
</body>
</html>