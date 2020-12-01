<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">

<head>
<link rel="stylesheet" type="text/css" href="css/formato.css" />
<script type="text/javascript" src="js/validacion.js">
</script>
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
<script type="text/javascript">
	function validacion() {
		
	}

</script>
</head>
<%@ page import="java.util.List"%>


 
<body>
    <form action="ControladorUsuarioInsertar.do" onsubmit="return validacion();">

<fieldset><legend>Formulario alta Usuario</legend>


 
<p><label for="nombre">Nombre :</label> <input id="nombre"
	type="text" name="nombre" /></p>

<p><label for="usuario">Usuario :</label> <input
	id="usuario" type="text" name="usuario" /></p>

<p><label for="password">Contrase&ntildea :</label> <input
	id="password" type="text" name="password" /></p>


<p><label for="mail">mail :</label> <input
	id="mail" type="text" name="mail" /></p>
	
<p><input type="submit" value="Insertar" /></p>
</fieldset>
</fieldset>

</form>
</body>
</html>