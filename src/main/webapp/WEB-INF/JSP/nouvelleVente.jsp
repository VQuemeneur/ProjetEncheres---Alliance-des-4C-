<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Nouvelle vente - ENI-Enchères</title>
<style>
/* TODO créer une file CSS pour centraliser l'ensemble du style de l'application */
body {
	font-family: Arial, sans-serif;
	background: #f4f4f4;
	margin: 0;
	padding: 0;
}

.container {
	width: 60%;
	margin: 2em auto;
	background: #fff;
	padding: 2em;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.h1 {
	text-align: left;
}

.form-group {
	margin-bottom: 1em;
}

.form-group label {
	display: block;
	margin-bottom: .5em;
}

.form-group input[type="text"], .form-group input[type="number"],
	.form-group input[type="date"], .form-group select, .form-group textarea
	{
	width: 100%;
	padding: .5em;
	margin-bottom: 1em;
	border: 1px solid #ddd;
	border-radius: 4px;
}

.form-group input[type="submit"], .form-group input[type="button"] {
	padding: .5em 1em;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

.form-group input[type="submit"] {
	background-color: #5cb85c;
	color: white;
}

.form-group input[type="button"] {
	margin-left: .5em;
}

.form-group input[type="submit"]:hover, .form-group input[type="button"]:hover
	{
	background-color: #4cae4c;
}

fieldset {
	border: 1px solid #ddd;
	padding: .5em 2em;
	margin-top: 1em;
}

legend {
	font-size: 1.2em;
	margin-bottom: .5em;
}

.image-example {
	text-align: center;
	margin-bottom: 1em;
}

.image-example img {
	max-width: 100%;
	height: auto;
	border: 1px solid #ddd;
	border-radius: 4px;
	padding: .5em;
	background: #fff;
}
</style>
</head>
<body>
	<div class="container">

		<h1>ENI-Enchères</h1>
		<header class="header" style="text-align: center;">
			<p>
				<a href="ServletNouvelleVente"></a>
			</p>
			<h2>Nouvelle vente</h2>
		</header>
		<form action="ServletNouvelleVente" method="post">

			<div class="form-group">
				<label for="article">Article :</label> <input type="text"
					id="article" name="article" required>
			</div>
			<div class="form-group">
				<label for="description">Description :</label>
				<textarea id="description" name="description" rows="5" required></textarea>
			</div>
			<div class="form-group">
				<label for="categorie">Catégorie :</label> <select id="categorie"
					name="categorie">

					<option value="1">Informatique</option>
					<option value="2">Ameublement</option>
					<option value="3">Vétements</option>
					<option value="4">Sports et loisirs</option>

				</select>
			</div>
			<div class="form-group">
				<label for="photo">Photo de l'article :</label> <input type="file"
					id="photo" name="photo" accept="image/*">
				<!-- TODO insérer et lier une photo à chaque article  -->
			</div>
			<div class="image-example">
				<img src="example.jpg" alt="Photo de l'article" />
			</div>
			<div class="form-group">
				<label for="prixInitial">Mise à prix :</label> <input type="number"
					id="prixInitial" name="prixInitial" min="0" value="150" required>
			</div>
			<div class="form-group">
				<label for="auctionStart">Début de l'enchère :</label> <input
					type="date" id="auctionStart" name="auctionStart" required>
			</div>
			<div class="form-group">
				<label for="auctionEnd">Fin de l'enchère :</label> <input
					type="date" id="auctionEnd" name="auctionEnd" required>
			</div>
			<fieldset>
				<legend>Retrait</legend>
				<div class="form-group">
					<label for="rue">Rue :</label> <input type="text" id="rue"
						name="rue" value="${userConnected.rue}" required>
				</div>
				<div class="form-group">
					<label for="codePostal">Code postal :</label> <input type="text"
						id="codePostal" name="codePostal"
						value="${userConnected.codePostal}" required>
				</div>
				<div class="form-group">
					<label for="ville">Ville :</label> <input type="text" id="ville"
						name="ville" value="${userConnected.ville}" required>
				</div>
			</fieldset>
			<div class="form-group" style="text-align: center;">
				<input type="submit" value="Enregistrer"> <input
					type="button" value="Annuler" onclick="history.back();">
			</div>
			<input type="hidden" id="noUtilisateur" name="noUtilisateur"
				value="${userConnected.noUtilisateur}"><br /> <br />
		</form>
	</div>
</body>
</html>