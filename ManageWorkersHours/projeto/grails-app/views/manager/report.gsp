<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'employer.label', default: 'Employer')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-employer" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]"/></g:link></li>
    </ul>
</div>

<div>
    Relatório de Funcionário

    Nome: ${model.name}
    Salário a receber: ${model.salary}
    Carga horária esperada: ${model.hourExpected}
    Total de horas: ${model.totalHours}
    Faltas: ${model.totalFault}

    <g:link controller="hourRegister" >Lista de pontos</g:link>

</div>

<div>
    Horas diárias

    Quadro em JS ou lista de horas por dia
</div>
</body>
</html>