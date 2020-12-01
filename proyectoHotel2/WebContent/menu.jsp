<%-- 
    Document   : menu
    Created on : 27/9/2020
    Author     : Daniel
--%>

<%@ page session="true" %>
<style type="text/css">
legend,label {
	font-weight: bold;
}

p {
	text-align: right;
	width: 300px;
}
//< link rel ="stylesheet" type="text/css" href ="css/formato.css" />
//< script type="text/javascript" src="js/validacion.js" />

</style>
<%
String usuario = "";
HttpSession sesionOk = request.getSession();
if (sesionOk.getAttribute("usuario") == null) {
%>
<jsp:forward page="login.jsp">
<jsp:param name="error" value="Es obligatorio identificarse"/>
</jsp:forward>
<%
} else {
    usuario = (String)sesionOk.getAttribute("usuario");
}
%>
<html>
    <head><title>Proceso de login</title>
</head>
<body>
<b>PROCESO DE IDENTIFICACIÓN</b><p>
<b>Menú de administración</b><br>
<b>Usuario activo:</b> <%=usuario%><p>
<nav class="usuario">
  <ul>
	
	<li> <a href="FormularioCrearUsuario.jsp">Nuevo Usuario</a></li>
	<li> <a href="opc2.jsp">Borrar un usuario</a></li>
	<li> <a href="opc3.jsp">Cambiar clave</a></li>
 	
 </ul>
</nav>
<nav class="Reservas">
  <ul>
 	<li> <a href="mostrar.jsp">Mostrar Reserva</a> </li>
 	<li> <a href="MostrarCatalogo.jsp">Mostrar Catalogo</a> </li>
	<li> <a href="FormularioCrearReserva.jsp">Nueva Reserva</a></li>
	<li> <a href="FormularioEditarReserva.jsp">Editar Reserva</a></li>
	<li> <a href="FormularioCancelarReserva.jsp">Cancelar Reserva</a></li>
	<li> <a href="FormularioCrearFactura.jsp">Crear Factura</a></li>
	
	</ul>
</nav>
<li> <a href="cerrarsesion.jsp">Cerrar sesión</a></li>
</body>
</html>