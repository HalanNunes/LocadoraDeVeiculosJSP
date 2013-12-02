<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
    <head>
        <title>Adicionar cliente</title>
        <link href="<c:url value="/resources/css/form.css"/>" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/menu.jsp" />
        <form:form action="novo" method="post" commandName="cliente">
            <h1>Adicionar cliente</h1>
            <label>Nome:</label>
            <form:input path="nome" placeholder="nome do cliente"/>
            <label>CPF:</label>
            <form:input path="cpf" placeholder="cpf"/>
            <input type="submit" value="Adicionar">
        </form:form>
    </body>
</html>