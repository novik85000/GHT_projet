<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscription</title>
</head>
<body>
<%!private String erreur = ""; %>

 <% if (request.getAttribute("messageErreur")!=null){
	 	erreur = (String) request.getAttribute("messageErreur");
 }%>
<h1>ENI-ENCHERES</h1>
	    <form action="<%= request.getContextPath() %>/inscrire" method="post">
	        <div class="form-control">
	         <label for="pseudo">Pseudo:</label> 
	        <input type='text' name='pseudo'> <br>
	         <label for="prenom">prénom:</label> 
	        <input type='text' name='prenom'><br>
	         <label for="telephone">telephone:</label>
	        <input type='text' name='telephone'><br>
	         <label for="code_postal">code postal:</label> 
	        <input type='text' name='code_postal'><br>
	         <label for="mdp">mot de passe:</label> 
	        <input type='password' name='mdp'><br>
	         <label for="nom">nom</label> 
	        <input type='text' name='nom'><br>
	         <label for="email">email</label> 
	        <input type='email' name='email'><br>
	         <label for="rue">rue:</label> 
	        <input type='text' name='rue'><br>
	         <label for="ville">ville:</label> 
	        <input type='text' name='ville'><br>
	         <label for="confirmation">confirmation:</label> 
	        <input type='password' name='confirmation'><br>
	        </div>
	        <button type="submit">Créer</button><br>
	         <button type="reset">Annuler</button>
   	 	</form> 
   	 	<h3> <%=erreur%> </h3>
   	 	
   	
 
</body>
</html>