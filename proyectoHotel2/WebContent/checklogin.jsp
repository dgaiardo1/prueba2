<%-- 
    Document   : checkinglogin
    Created on : 23/11/2015, 18:55:10
    Author     : Franco
--%>
<%@ page session="true" %>
<%
String usuario = "";
String clave = "";
if (request.getParameter("usuario") != null)
    usuario = request.getParameter("usuario");
if (request.getParameter("clave") != null)
    clave = request.getParameter("clave");
if (usuario.equals("usuario") && clave.equals("clave")) {
    HttpSession sesionOk = request.getSession();
    sesionOk.setAttribute("usuario",usuario);
%>
<jsp:forward page="menu.jsp" />
<%
} else {
%>
<jsp:forward page="login.jsp">
<jsp:param name="error" value="Usuario y/o clave incorrectos.<br>Vuelve a intentarlo."/>
</jsp:forward>
<%
}
%>