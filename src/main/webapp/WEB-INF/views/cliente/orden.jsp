<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>Client Order</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/components/navbar.jsp"%>
	<div class="container">
		<div class="row mt-5 d-flex justify-content-center">
			<h1 class="text-center">Solicitud de reparación</h1>
			<div class="col">
				<form action="/reparacion/orden" class="row g-3" method="POST">
					<input type="hidden" name="id">
					<div class="col-md-12">
						<label for="nombre" class="form-label">Nombre completo: </label> 
						<input type="text" class="form-control" id="nombre" name="nombre">
					</div>
					<div class="col-md-8">
						<label for="direccion" class="form-label">Dirección: </label> 
						<input type="text" class="form-control" id="direccion" placeholder="ej: Bilbao #1234" name="direccion">
					</div>
					<div class="col-md-4">
						<label for="telefono" class="form-label">Telefono: </label> 
						<input type="text" class="form-control" id="telefono" name="telefono">
					</div>
					<div class="col-md-8">
						<label for="descripcion">Descripcion: </label> 
						<textarea  class="form-control" id="descripcion" name="descripcion"></textarea>
					</div>
					<div class="col-md-4">
						<label for="electrodomestico" class="form-label">Electrodomestico</label> 
						<select id="electrodomestico" class="form-select" name="electrodomestico">
							<option selected>Choose...</option>
							<option value="tele">tele</option>
							<option value="celular">celular</option>
						</select>
					</div>
					<div class="col-md-2">
						<label for="estado" class="form-label">Estado: </label> <input
							type="text" class="form-control" id="estado" name="estado">
					</div>
					<div class="col-12">
						<button type="submit" class="btn btn-primary">Crear orden</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>