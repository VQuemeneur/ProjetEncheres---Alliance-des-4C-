<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ENI-Enchères - Login</title>

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

form {
	text-align: center;
}

div.frmc {
	width: 350px;
	margin: 50px auto 0 auto;
}

.clear {
	clear: both;
}

.pleft {
	height: 20px;
	width: 150px;
	margin-right: 20px;
	float: left;
	text-align: left;
	vertical-align: baseline;
}

.pright {
	height: 20px;
	width: 150px;
	float: left;
	text-align: left;
	vertical-align: baseline;
}

.zero {
	width: auto;
	margin-right: 5px;
}

input {
	color: #000000;
	border-radius: 0%;
	background-color: #fcfcfc;
	filter: drop-shadow(1px 1px 0px #ababab);
}

input:hover {
	background-color: #ffffff;
	filter: drop-shadow(2px 2px 2px #aeaeae);
}

input.cnx {
	height: 60px;
	margin: 20px 20px 0 0;
	width: 150px;
	float: left;
}

input.crt {
	height: 100px;
	width: 350px;
	margin-top: 50px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="left-section">
			<h1>ENI-Enchères</h1>
		</div>
	</div>

	<div>
		<form method="post" action="ServletLogin">
			<c:if test="${!empty messageError}">
				<p style="color: red">${messageError}</p>
			</c:if>
			<c:if test="${empty messageError}">
			</c:if>

			<div class="frmc">
				<p class="pleft">Identifiant :</p>
				<p class="pright">
					<input type="text" name="pseudo"
						value="${session.getAttribute(lastPseudo)}">
				</p>

				<p class="clear pleft">Mot de passe :</p>
				<p class="pright">
					<input type="password" name="motDePasse">
				</p>

				<p class="clear">
					<input class="cnx" type="submit" value="Connexion" />
				</p>

				<p class="pright zero">
					<input type="checkbox" id="saveLogin" name="saveLogin" />
				</p>
				<p class="pright">
					<!-- TODO options se souvenir et mot de passe oublié  -->
					<label for="saveLogin">Se souvenir de moi</label><br> <a
						href="">Mot de passe oublié</a><br>
				</p>

				<p class="clear">
					<a href="ServletCreation"><input class="crt creationCompte"
						type="button" value="Créer un compte"></a>
				</p>
			</div>
		</form>
	</div>
</body>
</html>


