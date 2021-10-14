<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.*" %>
<%@ page import="co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.*" %>
<%@ page import="java.util.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>

<title>Lista de Clientes</title>
</head>
<body>
<label>Lista de Clientes</label>
<%
ClientesController controller = new ClientesController(); 
		controller.consultarClientes();
		ArrayList<ClientesVO> lista = controller.getListaClientes();
%>
	
	<table class="table table-striped">
	<th>
		<td scope="col">Cedula</td>
		<td scope="col">Direccion</td>
		<td scope="col">Email</td>
		<td scope="col">Nombres</td>
		<td scope="col">Telefono</td>
	
	</th>
	<% 
		for(ClientesVO dto : lista){ 
	%>
	<tr>
		<td></td>
		<td><%= dto.getCedula() %></td>
		<td><%= dto.getDireccion() %></td>		
		<td><%= dto.getEmail() %></td>
		<td><%= dto.getNombre() %></td>			
		<td><%= dto.getTelefono() %></td>	
			
	</tr>
	<% } %>
	</table>

</body>
</html>