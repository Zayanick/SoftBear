<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page import="co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.*" %>
    
<!DOCTYPE html>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>SoftBear | Subir Archivo</title>
		<link rel="stylesheet" href="css/uploadMaster.css">
	</head>

<body>
	<div class="login-box">
		<img class="avatar" src="img/logo.png" alt="Logo SoftBear">
		<img class="subirArchivo" src="img/Subir Archivo.png" alt="subirArchivo SoftBear">
		<h2>Seleccione un archivo para importar a la base de datos:</h2>
		
		
			<form method="post" enctype="multipart/form-data"action="/uploadCSVFile">
  				<input type="file" name="file" accept=".csv" />
  				<input type="submit" name="submit" value="Cargar Archivo" />
			</form> 
			
	<div style="color: red">${errorCargarArchivo}</div>
	<div style="color: red">${cargaArchivo}</div>
	</div>
</body>

</html>