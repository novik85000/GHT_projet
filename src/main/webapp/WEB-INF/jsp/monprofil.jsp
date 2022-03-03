<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
    
<%@page import = "fr.eni.ghtprojet.bo.Utilisateur" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon Profil</title>
</head>
<body>
<p> Pseudo: ${user.getPseudo()} </p>
<p> Nom: ${user.getNom()}</p>
<p> Prénom:${user.getPrenom()} </p>
<p> Email: ${user.getEmail()}</p>
<p> Téléphone: ${user.getTelephone()}</p>
<p> Rue: ${user.getRue()}</p>
<p> Code postal: ${user.getCode_Postal()}</p>
<p> Ville: ${user.getVille()}</p>

</body>
</html>