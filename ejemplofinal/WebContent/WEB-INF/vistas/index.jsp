<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<div
	class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5">
	<c:forEach items="${productos}" var="producto">
		<div class="col mb-4">
			<div class="card h-100">
				<img src="${producto.urlImagen}" class="card-img-top" alt="">
				<div class="card-body">
					<h5 class="card-title">${producto.nombre}</h5>
					<p class="card-text">${producto.descripcion}</p>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>
