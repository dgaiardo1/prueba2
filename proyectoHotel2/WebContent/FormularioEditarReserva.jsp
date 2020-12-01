<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@page import="ar.com.hotel.Reserva"%>
<%@page import="ar.com.hotel.Cliente"%>
<%@ page import="ar.com.hotel.DataBaseHelper" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario Editar Reserva</title>
</head>
<body>
<form id="formularioEdicion" action="Salvar.jsp">
<fieldset>
<legend>Formulario Editar Reserva</legend>
<p><label for="idReserva">idReserva:</label>

<input type="text" id="idReserva" name="idReserva" value=" "/></p>
<p><label for="fechaEntrada">fecha de Entrada:</label><input type="text" id="fechaEntrada" name="fechaEntrada"
value=" " /></p>
<p><label for="fechaSalida">fecha de Salida:</label><input type="text" id="fechaSalida" name="fechaSalida"
value=" " /></p>

<p><label for="tipo">Tipo de Habitacion :</label>
<select name="tipo">
</select>
<p><label for="cliente">Cliente :</label>
<select name="cliente">
<%
List<Reserva> listaDeClientes=null;
//listaDeClientes=reserva..buscarTodosLosClientes();
//for(Cliente cliente:listaDeClientes) {
	
//} %>
</select>
<br/>
</p>
<p><input type="submit" value="Salvar" /></p>
</fieldset>
</form>
</body>
</html>