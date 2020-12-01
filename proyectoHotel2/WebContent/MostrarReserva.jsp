<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="ar.com.hotel.DataBaseHelper"%>
<%@ page import="ar.com.hotel.Equipos"%>
<%@ page import="ar.com.hotel.DataBaseException"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
legend,label {
	font-weight: bold;
}

p {
	text-align: light;
	width: 300px;
}
<
link
 
rel
="stylesheet"
 
type
="text/css"
 
href
="css/formato
.css
"
/
>
</style>
<script type="text/javascript" src="js/validacion.js">
	
</script>


<script type="text/javascript">
	function buscarmodelo() {

		document.forms["mostrarEquipos"].submit();

	}
</script>


<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Consulta de Equipos InformaticaVM</title>

</head>

<body>
<form action="mostrarEquipos.jsp" method="POST">

<p><label for="categoria">Categoria:</label> <select
	name="categoria" onchange="buscarmodelo()" style="width: 300px">
	<option></option>
	<%
		List<String> listaDeCategorias = null;
		listaDeCategorias = Equipos.buscarLasCategorias();
		for (String categoria : listaDeCategorias) {
	%>
	<option value="<%=categoria%>" onclick="buscarmodelo"><%=categoria%>
	</option>
	<%
		}
	%>
</select></p>
<p><label for="mod">Modelo:</label> <select name="modelo"
	style="width: 300px">
	<option value=></option>
	<%
		List<String> listaDemarcas = null;
		listaDemarcas = Equipos.buscarmarca();
		for (String categoria : listaDemarcas) {
	%>
	<option value="<%=categoria%>"><%=categoria%></option>
	<%
		}
	%>
</select></p>
<p><label for="tec">Técnico:</label> <select name="tecnicos"
	style="width: 300px">
	<option value=></option>
	<%
		List<String> listaDetecnicos = null;
		listaDetecnicos = Equipos.buscartecnico();
		for (String categoria : listaDetecnicos) {
	%>
	<option value="<%=categoria%>"><%=categoria%></option>
	<%
		}
	%>
</select></p>
<p><label for="org">Organismo :</label> <select name="organismo"
	style="width: 300px">
	<option value=></option>
	<%
		List<String> listaDeorganismos = null;
		listaDeorganismos = Equipos.buscarorganismo();
		for (String categoria : listaDeorganismos) {
	%>
	<option value="<%=categoria%>"><%=categoria%></option>
	<%
		}
	%>
</select></p>
<p><label for="serie">Serie:</label> <input type="text" id="serial"
	name="serial" style="width: 300px"></p>
<p><input type="submit" id="filtro" name="filtrar" value="Filtrar" /></p>
<%
	List<Equipos> listaDeEquipos = null;
	if ((request.getParameter("categoria") == null)
			|| (request.getParameter("modelo") == null)
			|| (request.getParameter("organismo") == null)
			|| (request.getParameter("organismo") == null)
			|| (request.getParameter("serial") == null)) {
		listaDeEquipos = Equipos.buscarTodos();
	} else {

		listaDeEquipos = Equipos.buscar(
				request.getParameter("categoria"),
				request.getParameter("modelo"),
				request.getParameter("organismo"),
				request.getParameter("tecnicos"),
				request.getParameter("serial"));
	}
%>
<table border="2">
	<tr>
		<td>Categoria</td>
		<td>Serie</td>
		<td>Modelo</td>
		<td>Organismo</td>
		<td>Estado</td>
		<td>Técnico</td>
		<td>Borrar</td>
		<td>Editar</td>
	</tr>
	<%
		for (Equipos libro : listaDeEquipos) {
	%>
	<tr>
		<td><%=libro.getcategoria()%></td>
		<td><%=libro.getserie()%></td>
		<td><%=libro.getmodelo()%></td>
		<td><%=libro.getorganismo()%></td>
		<td><%=libro.getestado()%></td>
		<td><%=libro.gettecnico()%></td>
		<td><a
			href="mostrarEquipos.jsp?idequipo=<%=libro.getidequipo()%>">Borrar</a></td>
		<td><a
			href="FormularioEditar.jsp?idequipo=<%=libro.getidequipo()%>">Editar</a></td>


		<%
			}
		%>
	
</table>
</form>
</body>