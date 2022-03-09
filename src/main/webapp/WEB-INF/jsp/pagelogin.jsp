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
<%session.setMaxInactiveInterval(20); %>
<%session.getMaxInactiveInterval(); %>

 <% if (request.getAttribute("messageError")!=null){
	 	erreur = (String) request.getAttribute("messageError");
 }%>
<h1>ENI-ENCHERES</h1>
	    <form action="<%= request.getContextPath() %>/connecter" method="post">
	        <div class="form-control">
	         <label for="identifiant">Identifiant:</label>
	        <input type='text' name='identifiant' required="required"> <br>
	         <label for="mdp">Mot de passe:</label> 
	        <input type='password' name='mdp' required="required">
	        </div>
	                <label class="checkbox">
                <input type="checkbox" name="remember"> Se souvenir de moi
                <span class="pull-right"> <a href="#"> Mot de passe oublié?</a></span>
            </label><br>
	        <button type="submit">Connexion</button>
   	 	</form> 
   	 
   	 
   	 <a href="<%= request.getContextPath() %>/inscrire">
	   	 <button type="button"> 
	   	 	Créer un compte
	   	 </button>
   	 </a>
   	 <h3> <%=erreur%> </h3>
</body>
</html>