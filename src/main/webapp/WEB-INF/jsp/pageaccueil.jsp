<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div class="row">
    <div class="col">
      <h5>Eni encheres h1</h5>
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
    <div class="col">
     <div class="card" style="width: 18rem;">
		  <img src="<%=request.getContextPath()%>/images/meilleur-pc-gamer.jpg" class="card-img-top" alt="image">
		  <div class="card-body">
		    <h5 class="card-title">Card title</h5>
		    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
		    <a href="#" class="btn btn-primary">Go somewhere</a>
		  </div>
	</div>
  </div>

</div>
	
	
</body>
</html>