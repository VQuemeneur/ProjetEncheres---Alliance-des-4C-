<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ENI-Enchères - Acheteur Enchère remportée</title>

<style>
/* TODO créer une file CSS pour centraliser l'ensemble du style de l'application */
.container {
	width: 80%;
	margin: auto;
}

.header {
	text-align: center;
}

body {
	font-family: arial, sans-serif;
	letter-spacing: -0.05;
}

H1 {
	font-size: 18px;
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
	<!-- TODO  -->
	<div class="container">
		<div class="left-section">
			<h1>ENI-Enchères</h1>
		</div>
		<div class="header">
			<h1>Vous avez remporté la vente</h1>
		</div>
		<div class="left-section">
			<label for="photo">Photo de l'article :</label>
			<!--ajouter img -->
		</div>
		<div class="frmc">

			<label>#PC GAmer pour travailler</label><br /> <label
				for="description">Description :</label><br /> <label>Meilleure
				offre :### pts</label><br /> <label>Mise à prix : ### points</label><br /> <label>Retrait
				: ####</label><br /> <label>Vendeur : ####</label><br /> <label>Tel
				: ####</label><br /> <label>Ma proposition : </label><br /> <a
				href="ServletAccueilConnecte"><input style="margin-right: 0;"
				class="btn" type="button" value="Back"></a>
		</div>
	</div>
</body>
</html>

