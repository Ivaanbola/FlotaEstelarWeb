
<%
	HttpSession sesion = request.getSession();
	if (sesion.getAttribute("nombre") == null) {
		response.sendRedirect("formularioLogin.jsp");
	}
%>