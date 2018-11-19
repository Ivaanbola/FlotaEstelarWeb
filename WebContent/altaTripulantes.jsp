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
				<form name="usuario" action="GTripulantes" method="post">
					<ul>
						<li><label>Nombre:</label><input type="text" 
							name="nombre" id="nombre" required>
						<li><label>Cargo:</label><input type="text"
							name="cargo" id="cargo" required>
						<li><label>Sexo:</label><input type="number" 
							name="sexo" id="sexo" required>
						<li><label>Experiencia:</label><input type="number"
							maxlength="50" name="experiencia" id="experiencia" required>
						<li><label>Origen:</label><input type="text"
							name="origen" id="origen" required>
						<li><label>Raza:</label><input type="text" 
							name="raza" id="raza" required>
						<li><label>Edad:</label><input type="number" 
							name="edad" id="edad" required>
						<li><label>Foto:</label><input type="file" 
							name="foto" id="foto">
						<li><label>Nave:</label><input type="number"
							name="nave" id="nave" required> 
						<li>	<input type="submit"  name="enviar" value="Guardar">
					</ul>
				</form>
				<a href="tripulantes.jsp">Volver a la lista</a>
			</div>

		</section>
		<%@include file="/includes/aside.inc.jsp"%>
		<%@include file="/includes/footer.inc.jsp"%>
	</div>
</body>
</html>
