<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/estilos.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>Tripulantes</title>


</head>
<body>
	<div id="contenedor">

		<%@include file="/includes/header.inc.jsp"%>
		<%@include file="/includes/nav.inc.jsp"%>

		<section>

			<div class="formulario">
				<h3>Insertar</h3>
				<form name="usuario" action="/GTripulantes" method="post"
					enctype="multipart/form-data">
					<ul>
						<li><label>Nombre:</label><input type="text" maxlength="50"
							name="nombre" id="nombre" required>
						<li><label>Cargo:</label><input type="text" maxlength="50"
							name="cargo" id="cargo" required>
						<li><label>Sexo:</label><input type="text" maxlength="50"
							name="sexo" id="sexo" required>
						<li><label>Experiencia:</label><input type="text"
							maxlength="50" name="experiencia" id="experiencia" required>
						<li><label>Origen:</label><input type="text" maxlength="50"
							name="origen" id="origen" required>
						<li><label>Raza:</label><input type="text" maxlength="50"
							name="raza" id="raza" required>
						<li><label>Edad:</label><input type="text" maxlength="50"
							name="edad" id="edad" required>
						<li><label>Foto:</label><input type="file" maxlength="50"
							name="foto" id="foto" required>
						<li><label>Nave:</label><input type="text" maxlength="50"
							name="nave" id="nave" required> 
						<li>	<input type="submit"
							maxlength="50" name="enviar" value="Guardar" required>
					</ul>
				</form>
			</div>

		</section>
		<%@include file="/includes/aside.inc.jsp"%>
		<%@include file="/includes/footer.inc.jsp"%>
	</div>
</body>
</html>
