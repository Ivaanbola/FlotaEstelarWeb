<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/estilos.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>Nave</title>
<script>
	function pinchaboton() {
		alert("No toques las cosas de tocar");
	}
</script>

</head>
<body>
	<div id="contenedor">

		<jsp:include page="/includes/header.inc.jsp"></jsp:include>
		<jsp:include page="/includes/nav.inc.jsp"></jsp:include>

		<!--  <section>
                <form name="contacto" action="mailto:ivaanbola@gmail.com" method="post">
                    <div class="arriba">
                        <label>Nombre: </label><input type="text" name="nombre" required="required">
                        <label>E-mail: </label><input type="email" name="email" >
                    </div>
                    <div class="abajo">
                        <label>Comentario: </label><textarea name="comentario" cols="80" rows="15"></textarea>     
                       <button class="submit" type="submit">Enviar mensaje</button>
             </div>
                </form>
            </section>
            -->
		<section>

			<div class="formulario">
				<form name="documentacion" action="recepciondatos.php" method="post"
					enctype="multipart/form-data">

					<ul class="col1">
						<li><label>Titulo</label><input type="text" name="titulo"
							maxlength="100" minlength="2" required size="25"
							placeholder="titulo"></li>
						<li><label>Fecha</label><input type="date" name="fecha"></li>
						<li><label>Satisfaccion</label><input type="range"
							name="satisfaccion"></li>
						<li><label>Color</label><input type="color" name="color"></li>
						<li><label>Categoria</label><input type="text"
							name="categoria" maxlength="100" minlength="2" required></li>
						<br>
						<select name="cat">
							<option value="0">...</option>
							<option value="1">Legal</option>
							<option value="2">Formulario</option>
							<option value="3">Informacion</option>
							<option value="4">Seguros</option>
						</select>

					</ul>
					<ul class="col2">
						<li><textarea name="descripcion"></textarea></li>
						<li><label>chequeada</label><input type="checkbox"
							name="chequed" value="si" checked></li>
						<li><label>Calidad</label> <input type="radio" name="calidad"
							value="buena">Buena <input type="radio" name="calidad"
							value="media">Media</li>
						<!--<li><label>Subir archivo</label><input type="file" name="archivo"</li>-->
						<li><input type="button" onclick="pinchaboton()"
							value="No tocar"></li>
						<li><input type="submit" value="Enviar"></li>
					</ul>

				</form>
			</div>

		</section>
		<jsp:include page="/includes/aside.inc.jsp"></jsp:include>
		<jsp:include page="/includes/footer.inc.jsp"></jsp:include>
	</div>
</body>
</html>
