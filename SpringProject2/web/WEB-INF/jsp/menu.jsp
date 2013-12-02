<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->


    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

    <meta name="description" content="Exemplo de HTML com Spring Framework" />
    <meta name="author" content="Source Joe Pettersson, http://www.joepettersson.com" />
    <!-- END Meta tags -->

    <!-- BEGIN Demo CSS - You can safely ignore this part -->
    <link href="<c:url value="/resources/css/demo.css"/>" rel="stylesheet" type="text/css" />
    <!-- END Demo CSS -->

    <!-- BEGIN Navigation bar CSS - This is where the magic happens -->
    <link href="<c:url value="/resources/css/navbar.css"/>" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/css/bootstrap-responsive.css"/>" rel="stylesheet" type="text/css" />
    <!-- END Navigation bar CSS -->

    <!-- BEGIN JavaScript -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script src="/SpringProject2/resources/js/bootstrap-dropdown.js"></script>
    <script src="/SpringProject2/resources/js/bootstrap-modal.js"></script>
    <!-- END JavaScript -->

    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container">
                <a class="brand" href="#">Locação de Automóveis</a>
                <div class="nav-collapse collapse">
                    <ul class="nav">
                        <li><a href="#">Início</a></li>
                        <li class="dropdown divider-vertical">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Carros <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="/SpringProject2/carro/novo">Adicionar</a></li>
                                <li><a href="/SpringProject2/carro/lista">Listar</a></li>
                            </ul>
                        </li>
                        <li class="dropdown divider-vertical">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Clientes <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="/SpringProject2/cliente/novo">Adicionar</a></li>
                                <li><a href="/SpringProject2/cliente/lista">Listar</a></li>
                            </ul>
                        </li>
                        <li class="dropdown divider-vertical">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Locação <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="#myModal" onclick="loadUrlIntoDiv('/SpringProject2/locacao/novo')" data-toggle="modal">Alugar</a></li>
                                <li><a href="/SpringProject2/locacao/lista">Listar Todos</a></li>
                                <li><a href="/SpringProject2/locacao/listaLocados">Listar Locados</a></li>
                                <li><a href="/SpringProject2/locacao/listaDevolvidos">Lista Devolvidos</a></li>
                            </ul>
                        </li>
                        <li class="dropdown divider-vertical">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Categoria <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="/SpringProject2/categoria/novo">Novo</a></li>
                                <li><a href="/SpringProject2/categoria/lista">Listar</a></li>
                            </ul>
                        </li>
                        <li><a href="#">Sobre</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    
    
    <div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h3 id="myModalLabel">Modal header</h3>
        </div>
        <div id="bodyModal" class="modal-body"></div>
        <div class="modal-footer">
            <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
            <button class="btn btn-primary">Save changes</button>
        </div>
    </div>
    
    <script>
        function loadUrlIntoDiv(url){
            $('#bodyModal').load(url);
        }
    </script>