<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Uso de formularios</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> </head>
</head>
<body>
<h1>Bienvenidos a la Tienda Generica</h1>
FORMULARIO 
 <form action="" method="get"> 
 	 	<h2>Usuario:&nbsp;</h2> 
 	 	<input type="text" name="nombreUsuario" id="nombreUsuario" size="20" maxlength="50" /> 
 	 	<br /> 
 	 	<h2>Contraseña:&nbsp;</h2> 
 	 	<input type="password" name="contraseña" id ="contraseña" size="10" maxlength="25" /> 
 	 	<br /> 
input type="submit" id="botonAceptar" name="botonAceptar" value="Aceptar" /> 
 	 	&nbsp;&nbsp; 
 	 	<input type="reset" id="botonCancelar" value="Cancelar" /> 
</form>

</body>
</html>