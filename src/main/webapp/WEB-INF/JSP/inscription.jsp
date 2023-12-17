<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
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
	font-size: 25px;
}

div.col2 {
	width: 700px;
	margin: 50px auto 0 auto;
}

.clear {
	clear: both;
}

.pleft {
	height: 20px;
	width: 130px;
	margin-right: 20px;
	float: left;
	text-align: left;
	vertical-align: baseline;
	padding-left: 20px;
}

.pright {
	height: 20px;
	width: 150px;
	float: left;
	text-align: left;
	vertical-align: baseline;
}

input, button {
	color: #000000;
	border-radius: 0%;
	background-color: #fcfcfc;
	filter: drop-shadow(1px 1px 0px #ababab);
	width: 150px;
}

button:hover, input:hover {
	background-color: #ffffff;
	filter: drop-shadow(2px 2px 2px #aeaeae);
}

button.btn, input.btn {
	height: 60px;
	margin: 20px 20px 0 0;
	width: 150px;
	float: left;
}
/*label {
	width : 200px;
	display: inline-block;
	text-align: center;
	
}*/
/* Autres styles */
</style>
</head>
<body>
	<div class="container">
		<div class="left-section">
			<h1>ENI-Enchères</h1>
		</div>
		<div class=header>
			<h1>Mon profil</h1>
		</div>
		<form action="ServletCreation" method="post">
			<div class="col2">
				<p class="pleft">
					<label for="pseudo">Pseudo :</label>
				</p>
				<p class="pright">
					<input type="text" id="pseudo" name="pseudo" required
						pattern="[a-zA-Z0-9]{3,}">
				</p>

				<p class="pleft">
					<label for="nom">Nom :</label>
				</p>
				<p class="pright">
					<input type="text" id="nom" name="nom" required>
				</p>

				<p class="clear pleft">
					<label for="prenom">Prénom :</label>
				</p>
				<p class="pright">
					<input type="text" id="prenom" name="prenom" required>
				</p>

				<p class="pleft">
					<label for="email">Email :</label>
				</p>
				<p class="pright">
					<input type="email" id="email" name="email" required>
				</p>

				<p class="clear pleft">
					<label for="telephone">Téléphone :</label>
				</p>
				<p class="pright">
					<input type="text" id="telephone" name="telephone" required>
				</p>

				<p class="pleft">
					<label for="rue">Rue :</label>
				</p>
				<p class="pright">
					<input type="text" id="rue" name="rue" required>
				</p>

				<p class="clear pleft">
					<label for="codePostal">Code postal :</label>
				</p>
				<p class="pright">
					<input type="text" id="codePostal" name="codePostal" required>
				</p>

				<p class="pleft">
					<label for="ville">Ville :</label>
				</p>
				<p class="pright">
					<input type="text" id="ville" name="ville" required>
				</p>

				<p class="clear pleft">
					<label for="motDePasse">Mot de passe :</label>
				</p>
				<p class="pright">
					<input type="password" id="motDePasse" name="motDePasse" required>
				</p>

				<p class="pleft">
					<label for="confirmation">Confirmation :</label>
				</p>
				<p class="pright">
					<input type="password" id="confirmation" name="confirmation"
						required>
				</p>
			</div>

			<div class="clear container" style="width: 340px; margin:" 0pxauto 0pxauto;">
				<button class="btn" type="submit">Créer</button>
				<a href="encheres"><input class="annuler btn" type="button"
					value="Annuler"></a>
			</div>
		</form>

	</div>
</body>

</html>