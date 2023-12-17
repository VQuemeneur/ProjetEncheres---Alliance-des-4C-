<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profil</title>
<style>
body {font-family:arial, sans-serif; letter-spacing:-0.05;}
.container {
    width: 80%;
    margin: auto;
}
.header {
    text-align: center;
}
.clear {clear:both;}

.pleft {height:20px; 
		width:130px; 
		margin-right:20px; 
		float:left; 
		text-align:left;
		vertical-align:baseline;
		padding-left:20px;}

.pright {height:20px; 
		width:150px; 
		float:left; 
		text-align:left;
		vertical-align:baseline;}
		
div.frmc {width:350px; margin:50px auto 0 auto;}

.btn{text-align:center;}
H1 {font-size:18px; }
</style>

</head>

<body>
  <div class="container">
    <div class="left-section">
        <h1>ENI-Enchères</h1>
    </div>
  </div>

	<div class="container">
		<div class="frmc ">
		<c:if test="${!empty user}">
			<p class="pleft">Pseudo : </p><p class="pright">${user.pseudo}</p>
			<p class="pleft clear">Nom : </p><p class="pright">${user.nom}</p>
			<p class="pleft clear">Prénom : </p><p class="pright">${user.prenom}</p>
			<p class="pleft clear">Email : </p><p class="pright">${user.email}</p>
			<p class="pleft clear">Téléphone : </p><p class="pright">${user.telephone}</p>
			<p class="pleft clear">Rue : </p><p class="pright">${user.rue}</p>
			<p class="pleft clear">Code postal : </p><p class="pright">${user.codePostal}</p>
			<p class="pleft clear">Ville :</p> <p class="pright">${user.ville}</p>
		</c:if>
		<c:if test="${empty user}">
			<p>Utilisateur n'existe pas</p>
		</c:if>
		</div>
		<p class="clear btn"><a href="ServletAccueilConnecte"><input class="annuler"
			type="button" value="Retour"></a></p>

	</div>
</body>
</html>