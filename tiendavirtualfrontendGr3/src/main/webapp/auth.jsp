<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page import="co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>SoftBear | Inicio De Sesion</title>
		<link rel="stylesheet" href="css/master.css">
	</head>
	
<body>
	<div class="login-box">
		<img class="avatar" src="img/logo.png" alt="Logo SoftBear">
		<h1>Iniciar Sesion</h1>
		<form action="/auth" method="post">
			<!-- Usuario -->
			<label for="nombre de usuario">Nombre De Usuario</label>
			<input type="text" name="nombre" id="nombre" placeholder="Digite su usuario" value="${usuario.usuario}">
			
			
			<!-- Contraseña -->
			<label for="contraseña">Contraseña</label>
			<input type="password" name="password" id="password" placeholder="Digite su contraseña" value="${usuario.password}">
			
			
			<input type="submit" value="Ingresar">
		</form>
	</div>
	<c:choose>
<c:when test="${usuarios.email != null}">
<label>Bienvenido, ${usuario.usuario}</label>
<label>Su rol es: ${usuario.password}</label>
</c:when>
</c:choose>
<div style="color: red">${error}</div>
</body>

</html>