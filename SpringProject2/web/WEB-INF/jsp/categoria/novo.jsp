<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
    <head>
        <title>Adicionar categoria</title>
        <link href="<c:url value="/resources/css/form.css"/>" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/menu.jsp" />
        <form:form action="novo" method="post" commandName="categoria">
            <fieldset>
                <legend>Novo categoria</legend>
                <div>
                    <label>Nome:</label>
                    <form:input path="nome" placeholder="nome do categoria"/>
                </div>
                <div>
                    <label>Descrição:</label>
                    <form:input path="descricao" placeholder="Descrição"/>
                </div>
                <div>
                    <label>Valor:</label>
                    <form:input path="valor" placeholder="Valor"/>
                </div>
                <div>
                    <button type="submit">Adicionar</button>
                </div>
            </fieldset>
        </form:form>
    </body>


</html>