<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ENI-Enchères - détail Vente</title>

<style>
/* TODO créer une file CSS pour centraliser l'ensemble du style de l'application */
.container {
	width: 80%;
	margin: auto;
}

.header {
	text-align: center;
}

.search-bar {
	/* Styles pour votre barre de recherche */
	
}

.auction-item {
	/* Styles pour les articles d'enchère */
	
}

/* Autres styles */
body {
	font-family: arial, sans-serif;
	letter-spacing: -0.05;
}

H1 {
	font-size: 25px;
}

form {
	text-align: left;
}

div.frmc {
	width: 350px;
	margin: 50px auto 0 auto;
}

label {
	display: inline-block;
	text-align: left;
	height: 50px;
}
</style>
</head>

<body>
	<div class="container">
		<div class="left-section">
			<h1>ENI-Enchères</h1>
		</div>
		<div class="header">
			<h1>Détail vente</h1>
		</div>
		<div class="left-section">

			<div class="image-example">
				<img src="example.jpg" alt="Photo de l'article" />
				<!-- TODO insérer et lier une photo à chaque article  -->
			</div>

			<div class="frmc">
				<form method="post"
					action="ServletDetailVente?noUtilisateur=${user.noUtilisateur}&noArticle=${article.noArticle}">

					<div class="main">

						<label>Nom : ${article.nomArticle}</label><br /> <label
							for="description">Description : ${article.description} </label><br />

						<label>Catégorie : ${article.categorie}</label><br />
						<!-- TODO modifier le numéro de la catégorie par son libéllé  -->
						<label>Meilleure offre :${article.prixVente} points par
							Bob</label><br />
						<!-- TODO actualiser le nom du meilleur enchérisseur  -->
						<label>Mise à prix : ${article.miseAPrix} points</label><br /> <label>Fin
							de l'enchère : ${article.dateFinEncheres}</label><br />
						<!-- TODO modifier l'affichage de la date en dd/MM/yyyy  -->
						<label>Retrait : ${user.rue}<br>${user.codePostal}
							${user.ville}
						</label><br /> <label>Vendeur : ${user.pseudo}</label><br /> <label>Mon
							crédit : ${userConnected.credit} points</label><br /> <label>Ma
							proposition : </label> <input type="number"
							value="${article.prixVente+1}" name="montantEnchere"
							min="${article.prixVente+1}" max="" step="1"> points <input
							type="submit" value="Enchérir">

						<c:if test="${!empty messageError}">
							<p style="color: red">${messageError}</p>
						</c:if>
						<c:if test="${empty messageError}">
						</c:if>

						<c:if test="${!empty messageOK}">
							<p style="color: green">${messageOK}</p>
						</c:if>
						<c:if test="${empty messageOK}">
						</c:if>
					</div>
				</form>
			</div>
		</div>
</body>
</html>

