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
<form action="estudianteServlet" method="get">
<input type="submit" value="Buscar">
<%if(request.getAttribute("listaEstudiantes")!= null){
	ArrayList<EstudianteVO> listaEstudiantes = (ArrayList<EstudianteVO>)request.getAttribute("listaEstudiantes");
	%>
	<table class="table table-striped">
	<th>
		<td scope="col">Nombres</td>
		<td scope="col">Email</td>
		<td scope="col">Nombre</td>
		<td scope="col">Apellidos</td>
	</th>
	<% 
		for(EstudianteVO dto : listaEstudiantes){ 
	%>
	<tr>
		<td></td>
		<td><%= dto.getNombres() %></td>		
		<td><%= dto.getCorreoInstitucional() %></td>		
		<td><%= dto.getNombres() %></td>		
		<td><%= dto.getApellidos() %></td>		
	</tr>
<% 
		}
		} %>
</form>

</body>
</html>