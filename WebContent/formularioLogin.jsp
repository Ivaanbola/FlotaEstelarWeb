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
	<%@include file="/includes/nav.inc.jsp"%>

	<section class="listados">

		<form action="GTripulantes" method="post">
			<ul>
				<li><label>Nombre :</label><input type="text" name="nombre"
					id="nombre" required>
				<li><label>Contraseña:</label><input type="password"
					name="contrasena" id="contrasena" required>
				<li><input type="submit" name="enviar" value="Login"> <input
					type="hidden" name="opcion" value="4">
			</ul>
		</form>

	</section>


</body>
</html>