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

.header nav a {
	margin-left: 20px;
	color: blue;
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

.search-bar {
	display: flex;
	flex-direction: column;
	align-items: flex-start;
}

.search-bar>div {
	margin-bottom: 10px;
}

.search-bar fieldset {
	border: none;
	padding: 0;
}

.search-row {
	display: flex;
	align-items: center;
}

.search-row>label {
	margin-right: 10px;
}

.search-row>input[type="text"], .search-row>select {
	margin-right: 20px;
}

.checkbox-row, .radio-row {
	display: flex;
	align-items: center;
	flex-wrap: wrap;
}

.checkbox-row>label, .radio-row>label {
	margin: 0 10px 0 5px;
}

.checkbox-row {
	display: flex;
	flex-direction: column;
}

.checkbox-row>div {
	margin-bottom: 5px;
}
</style>
</head>
<body>
	<div class="container">
		<header class="header">

			<h1>ENI-Enchères (Alliance des 4C)</h1>
			<nav>

				<a href="ServletNouvelleVente">Vendre un article</a> <a
					href="ServletModificationProfil?noUtilisateur=${userConnected.noUtilisateur}">Mon
					profil</a> <a href="encheres">Déconnecter</a>


			</nav>
		</header>
		<section class="search-section">

			<h2>Liste des enchères</h2>
			<div style="margin-bottom: 60px;"></div>
			<form action="ServletAccueilConnecte" method="post"
				class="search-bar">
				<div class="search-row">
					<label for="ServeltAccueilConnecte"><b>Filtres</b> :</label> <input
						type="text" id="filtre" name="filtre"
						placeholder="Le nom de l'article contient"> <label
						for="categorie">Catégorie :</label> <select id="categorie"
						name="categorie">
						<option value="0">Toutes</option>
						<option value="1">Informatique</option>
						<option value="2">Ameublement</option>
						<option value="3">Vêtement</option>
						<option value="4">Sport & Loisirs</option>
					</select>
				</div>
				<!-- TODO  rendre fonctionnel les tris des achats et des ventes   -->
				<div style="margin-bottom: 20px;"></div>
				<fieldset>
					<div class="checkbox-row">
						<div class="radio-option">
							<input type="radio" id="achats" name="transactionType"
								value="achats"> <label for="achats">Achats</label>
						</div>
						<div class="checkboxes achats-checkboxes">
							<input type="checkbox" id="enchères-ouvertes"
								name="enchères-ouvertes" checked> <label
								for="enchères-ouvertes">enchères ouvertes</label><br> <input
								type="checkbox" id="mes-enchères-en-cours"
								name="mes enchères en cours"><label
								for="mes-enchères-en-cours">mes enchères en cours</label><br>
							<input type="checkbox" id="mes-enchères-remportées"
								name="mes enchères remportées"> <label
								for="mes-enchères-remportées">mes enchères remportées</label>
						</div>
					</div>
					<div class="checkbox-row">
						<div class="radio-option">
							<input type="radio" id="mes-ventes" name="transactionType"
								value="mes-ventes"> <label for="mes-ventes">Mes
								ventes</label>
						</div>
						<div class="checkboxes ventes-checkboxes">
							<input type="checkbox" id="mes-ventes-en-cours"
								name="mes ventes en cours"> <label
								for="mes-ventes-en-cours">mes ventes en cours</label><br> <input
								type="checkbox" id="ventes-non-débutées"
								name="ventes non débutées"> <label
								for="ventes-non-débutées">ventes non débutées</label><br> <input
								type="checkbox" id="ventes-terminées" name="ventes terminées">
							<label for="ventes-terminées">ventes terminées</label>
						</div>
					</div>
				</fieldset>

				<input type="submit" value="Rechercher">
			</form>
		</section>
		<div style="margin-bottom: 40px;"></div>
		<section class="auction-list">
			<c:forEach var="a" items="${liste}">
				<div class="auction-item">
					<img src="#" alt="Item Image">
					<!-- TODO  insérer et lier une photo à chaque article  -->
					<h2>
						<a
							href="ServletDetailVente?noArticle=${a.noArticle}&noUtilisateur=${a.noUtilisateur}">${a.nomArticle}</a>
					</h2>
					<p>Prix : ${a.prixVente} points</p>
					<p>Fin de l'enchère : ${a.dateFinEncheres}</p>
					<!-- TODO  modifier l'affichage de la date en dd/MM/yyyy   -->
					<p>
						Vendeur : <a href="ServletProfil?noUtilisateur=${a.noUtilisateur}">${a.vendeur}</a>
						<!-- TODO  remplacer le numéro d'utilisateur par son pseudo  -->
					</p>
				</div>
			</c:forEach>
		</section>

	</div>
</body>
</html>