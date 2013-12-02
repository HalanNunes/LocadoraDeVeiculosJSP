<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
    <head>
        <title>Editar ve�culo</title>
        <link href="<c:url value="/resources/css/form.css"/>" rel="stylesheet" type="text/css" />
    </head>
</head>
<body>
    <jsp:include page="/WEB-INF/jsp/menu.jsp" />
    <form:form action="../editar" method="put" commandName="carro">
        <form:hidden path="id" />
        <h1>Editar ve�culo</h1>
        <label>Nome:</label>
        <form:input path="nome" placeholder="Nome do ve�culo"/>
        <label>Ano:</label>
        <form:input path="ano" placeholder="Ano" pattern="[0-9]{4}"/>
        <label>Categoria:</label>
        <select id="categoria" name="categoria">
            <c:forEach items="${carro.listaCategorias}" var="categoria">
                <option value="${categoria.id}">${categoria.nome}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Gravar">
    </form:form>
</body>
</html>