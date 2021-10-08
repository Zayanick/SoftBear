<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page import="co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Autenticación</title>
</head>
<body>

<form action="/auth" method="post">
<h1> Autenticación de usuario</h1>
<div>
<label>Usuario</label>
<input type="text" name="nombre" id="nombre" value="${usuario.nombre}">
</div>
<div>
<label>Contraseña</label>
<input type="password" name="contrasena" id="contrasena" value="${usuario.contrasena }">
</div>
<input type="submit" value="Ingresar">

</form>

<c:choose>
<c:when test="${usuario.rol != null}">
<label>Bienvenido, ${usuario.nombre}</label>
<label>Su rol es: ${usuario.rol}</label>
</c:when>
</c:choose>
<div style="color: red">${error}</div>
</body>
</html>