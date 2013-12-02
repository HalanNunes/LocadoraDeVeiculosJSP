<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="count" value="0" scope="page" />
<html>
    <head>
        <title>Veículos disponíveis</title>
        <link href="/resources/css/bootstrap.css" rel="stylesheet" type="text/css" />
        <link href="/resources/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" />
        <link href="/resources/css/bootstrap-responsive.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/menu.jsp" />
        <h1>Lista de Locações</h1>
        <div class="table-responsive">
            <table class="table table-striped table-hover table-condensed">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nome</th>
                        <th>Ano de fabricação</th>
                        <th>Categoria</th>
                        <th>Ação</th>
                        <th>Excluir</th>
                    </tr>
                </thead>
                <tbody>
                    <c:set var="count" value="0" scope="page" />
                    <c:forEach items="${carroList}" var="carro">
                        <c:set var="count" value="${count + 1}" scope="page"/>
                        <c:choose>
                            <c:when test="${(count % 2)==0}">
                                <tr class="alt">
                                </c:when>
                                <c:otherwise>
                                <tr>
                                </c:otherwise>
                            </c:choose>
                            <td>${carro.id}</td>
                            <td>${carro.nome}</td>
                            <td>${carro.ano}</td>
                            <td>${carro.categoria}</td>
                            <td><a href="editar/${carro.id}">Editar</a></td>
                            <td><a href="excluir/${carro.id}">Excluir?</a></td>
                        </tr>
                    </c:forEach> 
                </tbody>
            </table>
        </div>
    </body>
</html>