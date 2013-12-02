<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
    <head>
        <title>Adicionar veículo</title>
        <link href="<c:url value="/resources/css/form.css"/>" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/menu.jsp" />
        <form:form action="novo" method="post" commandName="carro">
            <h1>Novo veículo</h1>
            <label>Nome:</label>
            <form:input path="nome" placeholder="Nome do veículo"/>
            <label>Ano:</label>
            <form:input path="ano" placeholder="Ano" pattern="[0-9]{4}"/>
            <label>Categoria:</label>
            <form:select path="categoria">
                <form:options items="${getListaCategorias}" itemLabel="nome" itemValue="nome" />
            </form:select>
            <input type="submit" value="Adicionar">
        </form:form>
    </body>

</html>