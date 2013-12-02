<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="count" value="0" scope="page" />
<html>
    <head>
        <title>Categorias</title>
        <link href="/resources/css/bootstrap.css" rel="stylesheet" type="text/css" />
        <link href="/resources/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" />
        <link href="/resources/css/bootstrap-responsive.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/menu.jsp" />
        <h1>Lista de categoria</h1>
        <div class="table-responsive">
            <table class="table table-striped table-hover table-condensed">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Descrição</th>
                        <th>Valor</th>
                        <th>Ação</th>
                    </tr>
                </thead>
                <tbody>
                    <c:set var="count" value="0" scope="page" />
                    <c:forEach items="${categoriaList}" var="categoria">
                        <c:set var="count" value="${count + 1}" scope="page"/>
                        <c:choose>
                            <c:when test="${(count % 2)==0}">
                                <tr class="alt">
                                </c:when>
                                <c:otherwise>
                                <tr>
                                </c:otherwise>
                            </c:choose>
                            <td>${categoria.nome}</td>
                            <td>${categoria.descricao}</td>
                            <td>${categoria.valor}</td>
                            <td><a href="editar/${categoria.id}">Editar</a></td>
                        </tr>
                    </c:forEach> 
                </tbody>
            </table>
        </div>
    </body>
</html>