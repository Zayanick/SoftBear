<%@ page
	import="co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.*"%>
<%@ page
	import="co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.*"%>
<%@ page import="java.util.*"%>



<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="ISO-8859-1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
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
				<form action="/crearVenta" method="post">
					<section class="registro"> 
						<h4>Registrar venta</h4>                                                 
                        <input class="controls" type="text" name="codigo" id="codigo" placeholder="Ingrese codigo de venta" value="${Venta.codigoVenta}">
                        <input class="controls" type="text" name="iva" id="iva" placeholder="IVA" value="${Venta.ivaVenta}">
                        <input class="controls" type="text" name="total" id="total" placeholder="Total Venta" value="${Venta.totalVenta}">
                        <input class="controls" type="text" name="valor" id="valor" placeholder="Valor Venta" value="${Venta.valorVenta}">
                        <input class="controls" type="text" name="cedulac" id="cedulac" placeholder="Ingrese Cedula Cliente" value="${Veta.clienteCedula}">
                        <input class="controls" type="text" name="cedulau" id="cedulau" placeholder="Ingrese su cedula" value="${Venta.usuarioCedula}">
                        <br>
                        <input class="botons" type="submit" value="Crear">
     
                    </section>
               </form>
			</article>
			<article id="tab2">
				<form action="/borrarCliente" method="post">
					<section class="registro"> 
						<h4>Eliminar cliente</h4>    
                        <input class="controls" type="text" name="cedula" id="cedula" placeholder="Ingrese su Cedula" value="${clientes.cedula}">
                     
                        <br>
                        <input class="botons" type="submit" value="Borrar"> 
                    </section>
               </form>
			</article>
			<article id="tab3">
				<form action="/crearCliente" method="post">
					<section class="registro"> 
						<h4>Editar Cliente</h4>    
                      <input class="controls" type="text" name="cedula" id="cedula" placeholder="Ingrese su Cedula" value="${clientes.cedula}">
                        
                        <br>
                        <input class="botons" type="submit" value="Actualizar">
                    </section>
               </form>
			</article>
			<article id="tab4">
				<form action="/crearCliente" method="post">
					<section class="registro"> 
						<h4>Buscar Cliente</h4>  						               
                      	<input class="controls" type="text" name="cedula" id="cedula" placeholder="Ingrese su Cedula" value="${clientes.cedula}">
                        <input class="botons" type="submit" value="Consultar">                       
                    </section>
               </form>
			</article>
		</div>
	</div>
	
		
</body>
</html>