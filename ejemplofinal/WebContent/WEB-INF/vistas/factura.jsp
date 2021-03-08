<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<table>
	<caption>Cliente</caption>
	
	<tbody>
		<tr>
			<th scope="row">Id</th>
			<td>${factura.cliente.id}</td>
		</tr>
		<tr>
			<th scope="row">Nombre</th>
			<td>${factura.cliente.nombre}</td>
		</tr>
		<tr>
			<th scope="row">Apellidos</th>
			<td>${factura.cliente.apellidos}</td>
		</tr>
		<tr>
			<th scope="row">CIF</th>
			<td>${factura.cliente.cif}</td>
		</tr>
		<tr>
			<th scope="row">Fecha de nacimiento</th>
			<td>${factura.cliente.fechaNacimiento}</td>
		</tr>
	</tbody>
</table>

<table class="table">
	<caption>Productos</caption>
	<thead>
		<tr>
			<th scope="col">Id</th>
			<th scope="col">Nombre</th>
			<th scope="col">Cantidad</th>
			<th scope="col">Precio unidad</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${factura.detallesFactura}" var="linea">
		<tr>
			<th scope="row">${linea.producto.id}</th>
			<td>${linea.producto.nombre}</td>
			<td>${linea.cantidad}</td>
			<td>${linea.producto.precio}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>
