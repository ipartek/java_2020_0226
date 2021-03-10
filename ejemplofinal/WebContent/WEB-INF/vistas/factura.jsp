<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<fmt:setLocale value="es-ES" />

<style>
/*
#productos tbody tr td:last-child, #productos tfoot tr td:last-child {
	font-weight: bold;
}

#productos tr th, #productos tr td {
	text-align: right;
}

#productos tr th:nth-child(2), #productos tr td:nth-child(2) {
	text-align: left;
}

#factura {
	text-align: right;	
}
*/
</style>

<div id="factura">

	<div class="row">
		<table id="vendedor">
			<caption>Vendedor</caption>

			<tbody>
				<tr>
					<th scope="row">Nombre</th>
					<td>Supermercados Ejemplo Final</td>
				</tr>
				<tr>
					<th scope="row">CIF</th>
					<td>B95123123</td>
				</tr>

			</tbody>
		</table>

		<table id="cliente" class="ml-auto">
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
				<%--<tr>
				<th scope="row">Fecha de nacimiento</th>
				<td>${factura.cliente.fechaNacimiento}</td>
			</tr> --%>
			</tbody>
		</table>
	</div>

	<div class="row">

		<fmt:parseDate value="${factura.fecha}" pattern="yyyy-MM-dd"
			var="fecha" type="date" />

		<div class="text-right">
			Número de factura: ${factura.codigo}<br />
			Fecha de factura:
			<fmt:formatDate value="${fecha}" dateStyle="long" />
		</div>

		<table id="productos"
			class="table table-striped table-bordered table-hover table-sm text-right">
			<caption>Productos</caption>
			<thead class="thead-dark">
				<tr>
					<th scope="col">Id</th>
					<th scope="col" class="text-left">Nombre</th>
					<th scope="col">Cantidad</th>
					<th scope="col">Precio unidad</th>
					<th scope="col">Total</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${factura.detallesFactura}" var="linea">
					<tr>
						<th scope="row">${linea.producto.id}</th>
						<td class="text-left">${linea.producto.nombre}</td>
						<td>${linea.cantidad}</td>
						<td><fmt:formatNumber value="${linea.producto.precio}"
								type="currency" /></td>
						<td class="font-weight-bold"><fmt:formatNumber
								value="${linea.total}" type="currency" /></td>
					</tr>
				</c:forEach>
			</tbody>

			<tfoot>
				<tr>
					<th scope="row" colspan="4">Total</th>
					<td class="font-weight-bold"><fmt:formatNumber
							value="${factura.total}" type="currency" /></td>
				</tr>
				<tr>
					<th scope="row" colspan="4">IVA (21%)</th>
					<td class="font-weight-bold"><fmt:formatNumber
							value="${factura.iva}" type="currency" /></td>
				</tr>
				<tr>
					<th scope="row" colspan="4">Total (IVA incluído)</th>
					<td class="font-weight-bold"><fmt:formatNumber
							value="${factura.totalConIva}" type="currency" /></td>
				</tr>
			</tfoot>
		</table>
	</div>
</div>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
