<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/estilos.css" rel="stylesheet" type="text/css" />
<title>Formulario Nave</title>
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
						<li><label>Capitan:</label><input type="text" maxlength="50"
							name="capitan" id="capitan" required>
						<li><label>Matricula:</label><input type="text" maxlength="50"
							name="matricula" id="matricula" required>
						<li><label>Tipo:</label><input type="text"
							maxlength="50" name="tipo" id="tipo" required>
						<li><label>Foto:</label><input type="file" maxlength="50"
							name="foto" id="foto" required>
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