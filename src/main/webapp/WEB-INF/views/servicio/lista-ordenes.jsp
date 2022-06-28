<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>Ordenes</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/components/navbar.jsp" %>
	<div class="container">
	<h1 class="mt-5">Ordenes de listas</h1>		
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>Telefono</th>
					<th>Direccion</th>
					<th>Descripcion</th>
					<th>Estado</th>
					<th>electrodomestico</th>
					<th>Fecha Solicitud</th>
					<th>Fecha Actualización</th>
					
				</tr>
			</thead>
			<tbody>
			<c:forEach var="orden" items="${ordenes}">
				<tr>
					<td><c:out value="${orden.id}"/></td>
					<td><c:out value="${orden.nombre}"/></td>
					<td><c:out value="${orden.telefono}"/></td>
					<td><c:out value="${orden.direccion}"/></td>
					<td><c:out value="${orden.descripcion}"/></td>
					<td><c:out value="${orden.estado}"/></td>
					<td><c:out value="${orden.electrodomestico}"/></td>
					<td><c:out value="${orden.fechaSolicitud}"/></td>
					<td><c:out value="${orden.fechaActualizacion}"/></td>
					<td>
						<a class="btn btn-warning" href="${pageContext.request.contextPath}/orden?seleccion=editar&amp;id=${orden.id}">Editar Estado</a> <%-- contextPath en este caso es /cft-web --%>
						<a class="btn btn-danger" href="${pageContext.request.contextPath}/orden?seleccion=eliminar&amp;id=${orden.id}">Eliminar</a> <%-- contextPath en este caso es /cft-web --%>
					</td>
				</tr>
			</c:forEach>			
			</tbody>
		</table>
		<a class="btn btn-success" href="/reparacion/orden?seleccion=solicitar">Crear</a>
		</div>
		<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>