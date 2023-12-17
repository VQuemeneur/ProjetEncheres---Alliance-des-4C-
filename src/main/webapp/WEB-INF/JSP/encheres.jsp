<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<title>Accueil ENI-Enchères</title>
<style>
/* TODO créer une file CSS pour centraliser l'ensemble du style de l'application */
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background: #f4f4f4;
}

.container {
	width: 90%;
	margin: auto;
	padding: 10px;
	background: #fff;
}

.header, .search-section, .auction-list {
	margin-bottom: 20px pardding: 30px;
}

.header {
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.search-section h2 {
	text-align: center;
	margin: 0;
	padding: 5px 0;
}

.search-bar {
	display: flex;
	align-items: center;
	margin-bottom: 20px;
}

.search-bar input[type="text"] {
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 50px;
	margin-right: 10px;
}

.search-bar select {
	padding: 10px;
	margin-right: 10px;
}

.search-bar input[type="submit"] {
	padding: 15px 30px;
	background-color: #4CAF50; /* Green */
	border: none;
	color: white;
	cursor: pointer;
	font-size: 1em;
	margin-left: auto;
}

.auction-list {
	display: grid;
	grid-template-columns: repeat(2, 1fr);
	grid-gap: 20px;
}

.auction-item {
	border: 1px solid #ddd;
	padding: 10px;
	text-align: left;
}

.auction-item img {
	width: 100%;
	height: auto;
	margin-bottom: 10px;
}

.auction-item h2 {
	margin-top: 0;
	font-size: 18px;
}

.auction-item p {
	margin: 5px 0;
}
</style>
</head>
<body>
	<div class="container">
		<header class="header">
			<h1>ENI-Enchères (Alliance des 4C)</h1>
			<a href="ServletLogin">S'inscrire - Se connecter</a>
		</header>
		<section class="search-section">

			<h2>Liste des enchères</h2>
			<div style="margin-bottom: 60px;"></div>
			<form action="encheres" method="post" class="search-bar">
				<label for="filtres" style="margin: 0 50px;"><b>Filtres</b>
					:</label> <input type="text" id="filtre" name="filtre"
					placeholder="Le nom de l'article contient"> <label
					for="categorie" style="margin: 0 10px;">Catégorie :</label> <select
					id="categorie" name="categorie">
					<option value="0">Toutes</option>
					<option value="1">Informatique</option>
					<option value="2">Ameublement</option>
					<option value="3">Vêtement</option>
					<option value="4">Sport & Loisirs</option>
				</select> <input type="submit" value="Rechercher">
			</form>
		</section>

		<div style="margin-bottom: 40px;"></div>

		<section class="auction-list">
			<c:forEach var="a" items="${liste}">
				<div class="auction-item">
					<img src="#" alt="Item Image">
					<!-- Place pour image -->
					<h2>${a.nomArticle}</h2>
					<p>Prix : ${a.prixVente} points</p>
					<p>Fin de l'enchère : ${a.dateFinEncheres}</p>
					<p>Vendeur : ${a.vendeur}</p>
				</div>
			</c:forEach>
		</section>
	</div>
</body>
</html>