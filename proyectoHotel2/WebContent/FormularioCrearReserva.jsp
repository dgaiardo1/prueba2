<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<link rel="stylesheet" type="text/css" href="css/formato.css" />
<script type="text/javascript" src="js/validacion.js" >
</script>
<style type="text/css">
legend,label {
font-weight:bold;
}
p {
text-align:right;
width:300px;
}
<link rel="stylesheet" type="text/css" href="css/formato.css" />
<script type="text/javascript" src="js/validacion.js" >
</script>
</style>
<script type="text/javascript">
	function validacion() {
		
		var idequipo=document.getElementById("idReserva");
		var miformulario=document.getElementById("miformulario");
		if(idequipo.value==""){
		alert("datos no validos");
		return false;
		}
		else{
		miformulario.submit();
		}
								
	}

</script>
</head>

<body>
<form action="destino.html" onsubmit="return validacion();">
<fieldset>
<legend>Formulario alta Reserva Hotel</legend>

<p><label for="nrohabitacion">Nro Habitacion:</label>
<input id="nrohabitacion" type="text" name="nrohabitacion"/>
</p>
<p>
<label for="fechadesde">Fecha Desde:</label>
<input id="fechadesde" type="text" name= "fechadesde"/>
</p>
<p>
<label for="fechahasta">Fecha Hasta :</label>
<input id="fechahasta"type="text" name="fechahasta"/>
</p>
<p>
<label for="cliente">Dni Cliente:</label>
<input id="cliente" type="text" name="cliente"/>
</p>
<p>
<label for="razonsocial">Raz&oacuten Social:</label>
<input id="razonsocial" type="text" name="razonsocial"/>
</p>

<label for="tipohabitacion">Tipo Habitaci&oacuten:</label>
<input id="tipohabitacion" type="text" name="tipohabitacion"/>
</p>

<label for="cantidadpersonas">Cantidad de Personas:</label>
<input id="cantidadpersonas" type="text" name="cantidadpersonas"/>
</p>
<p>
<label for="precio">Precio:</label>
<input id="precio" type="text" name="precio"/>
</p>
<p>
<label for="observaciones">observaciones :</label>
<input id="observaciones" type="text" name="observaciones"/>
</p>
<p>
<input type="submit" value="Insertar" />
</p>
</fieldset>

</form>
</body>
</html>