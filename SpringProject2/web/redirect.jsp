<%--
Este deve ser o único .jsp fora do WEB-INF por questão de segurança
Todas demais views devem se submeter a um controller.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% response.sendRedirect("index.htm"); %>
