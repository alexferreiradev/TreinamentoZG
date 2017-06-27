<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'manager.label', default: 'Administrador')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]"/></g:link></li>
    </ul>
</div>

<div>
    Nome: ${manager.name}
    CPF: ${manager.cpf}
    Email: ${manager.email}
</div>

<div>
    <ul>
        <li><g:link controller="hourRegister" action="allRequestedRegisters">Pontos requisitados</g:link></li>
        <li><g:link controller="manager" action="list" >Gerenciar funcionários</g:link></li>
        <li><g:link controller="hourRegister" >Gerenciar pontos</g:link></li>
    </ul>
</div>

</body>
</html>