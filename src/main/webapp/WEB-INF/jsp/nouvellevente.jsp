<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nouvelle Vente</title>
</head>
<body>
    <a href = "<%= request.getContextPath() %>/accueillirconnecte">
      <div> <img style = "color: red;" src="<%=request.getContextPath()%>/images/eni-logo.jpg" alt="image" width = "100px" ></div>
    </a>
<h1>Nouvelle Vente </h1>
<form action="<%= request.getContextPath() %>/vendreobjet" method="post">
	        <div class="form-control">
	        <label for="Article">Article:</label> 
	        <input type='text' name ='Article' required="required"> <br>
	        
	        
	        <div class="control-form">
                <label for="Description">Description</label>
                <textarea name="Description" id="description" cols="30" rows="10"></textarea>
            </div>
                <br>
			<div class="control-form">
                <label for="categories">Categories</label>
                <select name="categories" id="categories">
                    <option value="1">Informatique</option>
                    <option value="2">Ameublement</option>
                    <option value="3">Vêtements</option>
                    <option value="4">Sport et Loisirs </option>
                </select>
            </div>
                <br>
            <div class="control-form">
           		<label for="charger">Photos articles</label>
           		<button type="button">Charger</button><br>
            </div>
            	<br>
            <div class="control-form">
                <label for="prixDepart">Mise à Prix </label>
                <input type="number" id="prixDepart" name="prixDepart">
            </div>
                <br>
                
       		<div class="control-form">
                <label for="dateDebut">Début de l'enchère</label>
                <input type="date" id="dateDebut" name="dateDebut">
            </div>
                <br>
             <div class="control-form">
                <label for="dateFin">Fin de l'enchère</label>
                <input type="date" id="dateFin" name="dateFin">
            </div>
                <br>
            <div class="control-form">
            <fieldset><p> Retrait : <p>
                <label for="rue">Rue</label>
                <input type="text" id="rue" name="rue" placeholder="${user.getRue()}"><br>
                <label for="code_postal">Code Postal</label>
                <input type="text" id="code_postal" name="code_postal" placeholder="${user.getCode_Postal()}"><br>
                <label for="ville">Ville</label>
                <input type="text" id="ville" name="ville" placeholder="${user.getVille()}">  <br>
            </fieldset>            
            </div>
                <br>     
	        <button type="submit">Enregistrer</button><br>
	        <button type="reset">Annuler</button>
   	 	</form> 
</body>
</html>