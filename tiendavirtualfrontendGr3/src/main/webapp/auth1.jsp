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
<input type="text" name="nombre" id="nombre" value="${usuarios.nombre}">
</div>
<div>
<label>Contraseña</label>
<input type="password" name="password" id="spassword" value="${usuarios.password}">
</div>
<input type="submit" value="Ingresar">

</form>

<c:choose>
<c:when test="${usuarios.email != null}">
<label>Bienvenido, ${usuarios.nombre}</label>
<label>Su rol es: ${usuarios.password}</label>
</c:when>
</c:choose>
<div style="color: red">${error}</div>
</body>
</html>