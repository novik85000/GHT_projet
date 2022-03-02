<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Se connecter</title>
</head>
<body>
<%!private String erreur = ""; %>

 <% if (request.getAttribute("messageError")!=null){
	 	erreur = (String) request.getAttribute("messageError");
 }%>
<h1>ENI-ENCHERES</h1>
	    <form action="<%= request.getContextPath() %>/connecter" method="post">
	        <div class="form-control">
	         <label for="identifiant">Identifiant:</label>
	        <input type='text' name='identifiant'> <br>
	         <label for="mdp">Mot de passe:</label> 
	        <input type='password' name='mdp'>
	        </div>
	        <button type="submit">Connexion</button>
   	 	</form> 
   	 
   	 
   	 <a href="<%= request.getContextPath() %>/inscription">
	   	 <button type="button"> 
	   	 	Créer un compte
	   	 </button>
   	 </a>
   	 <h3> <%=erreur%> </h3>
</body>
</html>