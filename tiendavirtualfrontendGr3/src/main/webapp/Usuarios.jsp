<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<title>Menu</title>
	<link rel="stylesheet" href="estilos.css">
	<link rel="stylesheet" href="font-awesome.css">

	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script src="main.js"></script>
</head>
<body>

	<ul class="menu">
		<li><a href="http://localhost:8082/Usuarios.jsp">Usuarios</a></li>
		<li><a href="http://localhost:8082/Clientes.jsp">Clientes</a></li>
		<li><a href="http://localhost:8082/Proveedores.jsp">Proveedores</a></li>
		<li><a href="http://localhost:8082/uploadFile.jsp">Productos</a></li>
		<li><a href="http://localhost:8082/Ventas.jsp">Ventas</a></li>
		<li><a href="http://localhost:8082/Reportes.jsp">Reportes</a></li>
	</ul>
	<div class="wrap">
		<ul class="tabs">
			<li><a href="#tab1"><span class="fa fa-home"></span><span class="tab-text">Crear </span></a></li>
			<li><a href="#tab2"><span class="fa fa-group"></span><span class="tab-text">Eliminar</span></a></li>
			<li><a href="#tab3"><span class="fa fa-briefcase"></span><span class="tab-text">Editar </span></a></li>
			<li><a href="#tab4"><span class="fa fa-bookmark"></span><span class="tab-text">Buscar </span></a></li>
		</ul>

		<div class="secciones">
			<article id="tab1">
				<form action="/crearUsuario" method="post">
					<section class="registro"> 
						<h4>Registrar Usuario</h4>    
                        <input class="controls" type="text" name="cedula" id="cedula" placeholder="Ingrese su Cedula" value="${Usuario.cedula}">
                        <input class="controls" type="text" name="email" id="email" placeholder="Ingrese su Correo" value="${Usuario.email}">
                        <input class="controls" type="text" name="nombre" id="nombre" placeholder="Ingrese su Nombre" value="${Usuario.nombre}">
                        <input class="controls" type="text" name="usuario" id="usuario" placeholder="Ingrese su Usuario" value="${Usuario.usuario}">  
                        <input class="controls" type="password" name="password" id="password" placeholder="Ingrese su Contrase�a" value="${Usuario.Password}">
                        <br>
                        <input class="botons" type="submit" value="Crear">
     
                    </section>
               </form>
			</article>
			<article id="tab2">
				<form action="/crearCliente" method="post">
					<section class="registro"> 
						<h4>Eliminar Usuario</h4>    
                         <input class="controls" type="text" name="cedula" id="cedula" placeholder="Ingrese su Cedula" value="${Usuario.cedula}">
                        <br>
                        <input class="botons" type="submit" value="Borrar"> 
                    </section>
               </form>
			</article>
			<article id="tab3">
				<form action="/crearCliente" method="post">
					<section class="registro"> 
						<h4>Editar Usuario</h4>    
                         <input class="controls" type="text" name="cedula" id="cedula" placeholder="Ingrese su Cedula" value="${Usuario.cedula}">
                        <br>
                        <input class="botons" type="submit" value="Actualizar">
                    </section>
               </form>
			</article>
			<article id="tab4">
				<form action="/crearCliente" method="post">
					<section class="registro"> 
						<h4>Buscar Usuario</h4>  
                         <input class="controls" type="text" name="cedula" id="cedula" placeholder="Ingrese su Cedula" value="${Usuario.cedula}">
 
                        <br>
                        <input class="botons" type="submit" value="Consultar">                       
                    </section>
               </form>
			</article>
			
		</div>
	</div>
</body>
</html>