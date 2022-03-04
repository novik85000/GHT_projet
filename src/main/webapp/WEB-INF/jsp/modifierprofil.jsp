<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier profil</title>
</head>
<body>
<h1>ENI-ENCHERES</h1>
	    <form action="<%= request.getContextPath() %>/modifierprofil" method="post">
	        <div class="form-control">
	         <label for="pseudo">Pseudo:</label> 
	        <input type='text' name ='pseudo' > <br>
	         <label for="prenom">prénom:</label> 
	        <input type='text' name='prenom' ><br>
	         <label for="telephone">telephone:</label>
	        <input type='text' name='telephone'><br>
	         <label for="code_postal">code postal:</label> 
	        <input type='text' name='code_postal' ><br>
	         <label for="mdp">mot de passe actuel:</label> 
	        <input type='password' name='mdp' required="required"><br>
	        <label for="mdp">Nouveau mot de passe :</label> 
	        <input type='password' name='mdpnew'><br>
	         <label for="nom">nom</label> 
	        <input type='text' name='nom' ><br>
	         <label for="email">email</label> 
	        <input type='email' name='email' ><br>
	         <label for="rue">rue:</label> 
	        <input type='text' name='rue' ><br>
	         <label for="ville">ville:</label> 
	        <input type='text' name='ville' ><br>
	         <label for="confirmation">confirmation:</label> 
	        <input type='password' name='confirmation'><br>
	        <p>Crédit : ${user.getCredit()}</p>
	        
	        </div>
	        <button type="submit">Enregistrer</button><br>
	         <a href="<%=request.getContextPath()%>/supprimerprofil"><button type="button" name ="IsSupprimer" value="true">Supprimer mon compte</button></a>
   	 	</form>
 
  <h3> ${messageErreur} </h3>
</body>
</html>