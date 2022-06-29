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
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/components/navbar.jsp"%>
	<div class="container">
		<div class="row mt-5">
			<div class="col mt-5">
				<p class="fs-3 text-center">Estado de servicio</p>
				
				<div class="card">
				  <div class="card-body">
				    <p class="card-title h5">Orden numero N° <span><c:out value="${orden.id}"/></span></p>
				    <p class="card-text"><span><c:out value="${orden.nombre}"/></span>, le informamos que su <span><c:out value="${orden.electrodomestico}"/></span>, se encuentra en el siguiente estado: <span><c:out value="${orden.estado}"/></span></p>
				    <p class="card-text"><small class="text-muted">Fecha de actualización <span><c:out value="${orden.fechaActualizacion}"/></span></small></p>
				  </div>
				  <img src="https://www.cronista.com/files/image/421/421970/61e859118ddd4.jpg" class="card-img-bottom" alt="reparacion">
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>