<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div class="row">
    <div class="col">
      <h5>Eni enchéres</h5>
    </div>
    <div class="col">
		<a href="<%=request.getContextPath()%>/encherir">Enchères</a>
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
      <input type="text" class="form-control" placeholder="Le nom de l'article contient" aria-label="Username" aria-describedby="basic-addon1">
    </div>
  </form>
</nav>
<div class="dropdown">
  <span class="h5">Categorie: </span> <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
    Toutes
  </button>
  <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
    <li><a class="dropdown-item" href="#">Action</a></li>
    <li><a class="dropdown-item" href="#">Another action</a></li>
    <li><a class="dropdown-item" href="#">Something else here</a></li>
  </ul>
</div>
    </div>
    <div class="col">
      <button type="button" class="btn btn-primary btn-lg">Rechercher</button>
    </div>
  </div>
  <div class="row">
  	<div class="col col-3">
  			<div class="form-check">
			  <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
			  <label class="form-check-label" for="flexRadioDefault1">
			    Achats
			  </label>
			</div>
			<div class="form-check">
			  <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault" checked>
			  <label class="form-check-label" for="flexCheckDefault">
			    enchères ouvertes
			  </label>
			</div>
			<div class="form-check">
			  <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked">
			  <label class="form-check-label" for="flexCheckChecked">
			    mes enchères
			  </label>
			</div>
			<div class="form-check">
			  <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked">
			  <label class="form-check-label" for="flexCheckChecked">
			    mes enchères remportées
			  </label>
			</div>
			
  	</div>
  	<div class="col col-3">
  		<div class="form-check">
			  <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" checked>
			  <label class="form-check-label" for="flexRadioDefault2">
			    Mes ventes
			  </label>
			</div>
			<div class="form-check">
			  <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault" checked>
			  <label class="form-check-label" for="flexCheckDefault">
			    mes ventes en cours
			  </label>
			</div>
			<div class="form-check">
			  <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked">
			  <label class="form-check-label" for="flexCheckChecked">
			    ventes non débutées
			  </label>
			</div>
			<div class="form-check">
			  <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked">
			  <label class="form-check-label" for="flexCheckChecked">
			    ventes terminées
			  </label>
			</div>
  	</div>
  </div>
  <div class="row">
    <div class="col">
     <div class="card" style="width: 18rem;">
		  <img src="<%=request.getContextPath()%>/images/meilleur-pc-gamer.jpg" class="card-img-top" alt="image">
		  <div class="card-body">
		    <h5 class="card-title">Nom d'article</h5>
		    <p class="card-text">
		    	Prix: <br>
		    	Fin de l'enchere <br>
		    	Vendeur: <br>
		    </p>
		    <a href="#" class="btn btn-primary">Afficher plus</a>
		  </div>
	</div>
  </div>

</div>
	
	
</body>
</html>