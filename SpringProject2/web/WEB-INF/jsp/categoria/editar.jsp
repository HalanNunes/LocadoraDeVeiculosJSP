<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
    <head>
        <title>Editar categoria</title>
        <link href="<c:url value="/resources/css/form.css"/>" rel="stylesheet" type="text/css" />
    </head>
</head>
<body>
    <jsp:include page="/WEB-INF/jsp/menu.jsp" />
    <form:form action="../editar" method="put" commandName="categoria">
        <form:hidden path="id" />
        <h1>Editar categoria</h1>
        <label>Nome:</label>
        <form:input path="nome" placeholder="Nome do categoria"/>
        <label>Descri��o:</label>
        <form:input path="descricao" placeholder="Descri��o"/>
        <label>Pre�o:</label>
        <form:input path="valor" placeholder="Valor"/>
        <input type="submit" value="Gravar">
    </form:form>
</body>
</html>