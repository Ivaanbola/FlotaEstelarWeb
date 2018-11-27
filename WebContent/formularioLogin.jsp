<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/estilos.css" rel="stylesheet" type="text/css" />
<title>Login</title>
</head>
<body>
	<div id="contenedor">
		<header>
			<div class="cabder">
				<div class="logo">
					<img src="img/descarga.png" alt="nasa" title="espacio">
				</div>
			</div>
			<div class="cabizq">
				<div class="logosredes">
					<ul>
						<li><a target="_blank" href="https://www.facebook.com/NASA/"><img
								src="img/descarga (1).png"> </a></li>
						<li><a target="_blank" href="https://www.instagram.com/nasa/">
								<img src="img/insta.png">
						</a></li>
						<li><a target="_blank" href="https://twitter.com/NASA"><img
								src="img/twitter.png"> </a></li>
						<li><a target="_blank"
							href="https://www.youtube.com/user/NASAtelevision"><img
								src="img/arton49.png"> </a></li>
					</ul>
				</div>
				<div class="telefono">Telefono: 91 000 000</div>
			</div>
		</header>

		<%@include file="/includes/nav.inc.jsp"%>
		<section>
			<div class="login">
				<form action="GTripulantes" method="post">
				<h3>Login</h3>
					<ul>
						<li><label>Nombre :</label><input type="text" name="nombre"
							id="nombre" required>
						<li><label>Contraseña:</label><input type="password"
							name="contrasena" id="contrasena" required>
						<li><input type="submit" name="enviar" value="Login">
							<input type="hidden" name="opcion" value="4">
					</ul>
				</form>
			</div>
		</section>

	</div>
</body>
</html>