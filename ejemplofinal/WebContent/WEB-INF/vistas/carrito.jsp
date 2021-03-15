<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table
	class="table table-striped table-bordered table-hover table-sm text-right">
	<caption>Carrito</caption>
	<thead>
		<tr>
			<th scope="col">Id</th>
			<th scope="col" class="text-left">Nombre</th>
			<th scope="col">Cantidad</th>
			<th scope="col">Precio unidad</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${carrito.lineas}" var="linea">
			<tr>
				<th scope="row">${linea.producto.id}</th>
				<td class="text-left">${linea.producto.nombre}</td>
				<td>${linea.cantidad}</td>
				<td><fmt:formatNumber value="${linea.producto.precio}"
						type="currency" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<a class="btn btn-primary" href="confirmar-compra">Confirmar compra</a>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
