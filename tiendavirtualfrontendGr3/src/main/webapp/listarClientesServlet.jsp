<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.*" %>
<%@ page import="co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.controller.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="clienteServlet" method="get">
<input type="submit" value="Buscar">
<%if(request.getAttribute("listaClientes")!= null){
	ArrayList<ClientesVO> listaClientes = (ArrayList<ClientesVO>)request.getAttribute("listaClientes");
	%>
	<table class="table table-striped">
	<th>
		<td scope="col">Nombres</td>
		<td scope="col">Email</td>
		<td scope="col">Telefono</td>
		
	</th>
	<% 
		for(ClientesVO dto : listaClientes){ 
	%>
	<tr>
		<td></td>
		<td><%= dto.getNombre() %></td>		
		<td><%= dto.getEmail() %></td>		
		<td><%= dto.getTelefono() %></td>		
				
	</tr>
<% 
		}
		} %>
</form>

</body>
</html>