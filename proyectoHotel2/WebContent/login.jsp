


<%@page contentType="text/html; charset=iso-8859-1" 
       session="true" language="java" import="java.util.*" %>
<!DOCTYPE html>

<html>
    <head>
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proceso de login</title>
    </head>
    
<body>
<b>Proceso de identificación</B>
<p>
<%
    if(request.getParameter("error")!=null)
    { 
    out.println(request.getParameter("error"));
}
%>
<form action="checklogin.jsp" methop="post">
usuario: <input type="text" name="usuario" size=20><br>
clave: <input type="text" name="clave" size=20><br>
<input type="submit" value="enviar"><br>
</form>
</body>
</html>