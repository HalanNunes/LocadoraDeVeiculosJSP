<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Adicionar categoria</title>
        <link href="<c:url value="/resources/css/form.css"/>" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/menu.jsp" />
        <form:form action="novo" method="post" commandName="locacao">
            <h1>Nova Locação</h1>
            <div>
                <label>Cliente:</label>
                <form:select path="cliente">
                    <form:options items="${getListaClientes}" itemLabel="nome" itemValue="nome" />
                </form:select>
            </div>
            <div>
                <label>Carro:</label>
                <form:select path="carro">
                    <form:options items="${getListaCarros}" itemLabel="nome" itemValue="nome" />
                </form:select>
            </div>
            <div>
                <label>Preço:</label>
                <form:input path="valor" placeholder="Valor" pattern="[0-9]{0,255}"/>
            </div>
            <input type="submit" value="Adicionar">
        </form:form>
    </body>


</html>