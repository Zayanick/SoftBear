<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page import="co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.*" %>
<%@ page import="co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.controller.*" %>
<%@ page import="java.util.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Guardar Cliente</title>
</head>
<body>
<form action="/crearCliente" method="post">
<h1>Ingresar Cliente</h1>
<label>cedula</label>
<input type="text" name="cedula" id="cedula" value="${clientes.cedula}">
<div>
<label>direccion</label>
<input type="text" name="direccion" id="direccion" value="${clientes.direccion} "></div>
<div><label>email</label>
<input type="text" name="email" id="email" value="${clientes.email} "></div>
<div><label>nombre</label>
<input type="text" name="nombre" id="nombre" value="${clientes.nombre} "></div>
<div><label>telefono</label>
<input type="text" name="telefono" id="telefono" value="${clientes.telefono} "></div>
<input type="submit" value="Guardar">
</form>



</body>
</html>