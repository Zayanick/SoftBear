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

<title>Ventas Por Clientes</title>
</head>
<body>
<label>Total de ventas por cliente</label>
<%
ClientesController controller = new ClientesController(); 
		controller.consultarVentas();
		ArrayList<VentasVO> lista = controller.getlistaVentas();
%>
	
	<table class="table table-striped">
	<th>
		<td scope="col">Codigo De Venta</td>
		<td scope="col">Iva Venta</td>
		<td scope="col">Total Venta</td>
		<td scope="col">Valor Venta</td>
		<td scope="col">Clientes Cedula</td>
		<td scope="col">Usuarios Cedula</td>
	
	</th>
	<% 
		for(VentasVO dto : lista){ 
	%>
	<tr>
		<td></td>
		<td><%= dto.getCodigoVenta() %></td>
		<td><%= dto.getIvaVenta() %></td>		
		<td><%= dto.getTotalVenta() %></td>
		<td><%= dto.getValorVenta() %></td>			
		<td><%= dto.getClienteCedula() %></td>
		<td><%= dto.getUsuarioCedula() %></td>
			
	</tr>
	<% } %>
	</table>

</body>
</html>