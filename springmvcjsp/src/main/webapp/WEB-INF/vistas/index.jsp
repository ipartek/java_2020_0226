<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Ejemplo de Spring MVC con JSP</title>
</head>
<body>
	<c:forEach begin="1" end="6" var="c">
		<h${c}>Hola ${c}</h${c}>
	</c:forEach>
	
	<form method="post">
		<input name="nombre" placeholder="Nombre" />
		<button>Aceptar</button>
	</form>
	
	<c:if test="nombre != null">
		Hola ${nombre}
	</c:if>
</body>
</html>