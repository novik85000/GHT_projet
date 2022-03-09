<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="fr.eni.ghtprojet.bo.Utilisateur"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon Profil</title>
</head>
<body>
    <a href = "<%= request.getContextPath() %>/accueillirconnecte">
      <div> <img style = "color: red;" src="<%=request.getContextPath()%>/images/eni-logo.jpg" alt="image" width = "100px" ></div>
    </a>
	<p>Pseudo: ${user.getPseudo()}</p>
	<p>Nom: ${user.getNom()}</p>
	<p>Prénom: ${user.getPrenom()}</p>
	<p>Email: ${user.getEmail()}</p>
	<p>Téléphone: ${user.getTelephone()}</p>
	<p>Rue: ${user.getRue()}</p>
	<p>Code postal: ${user.getCode_Postal()}</p>
	<p>Ville: ${user.getVille()}</p>

	<a href="<%= request.getContextPath() %>/modifierprofil">
		<button type="button">Modifier</button>
	</a>

</body>
</html>