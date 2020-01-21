<%-- 
    Document   : home
    Created on : 21/01/2020, 14:50:59
    Author     : cliente
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Bem vindo usuário ${usuarioLogado.getNome()}</h1>
        <h3>Suas Matérias: </h3>
        <c:if test="${materias.size() == null}">
            <p>Nenhuma Matéria adicionada</p>
        </c:if>
        <c:if test="${materias().size() > 0}">
            <table>
                <thead>
                    <tr>
                        <td>Nome: </td>
                    </tr>
                </thead>
                <tbody>  
            <c:forEach items="${materias}" var="m">
                    <tr>
                        <td><a href="materia">${m.nome}</a></td>
                    </tr>
            </c:forEach>
                </tbody>
            </table>
        </c:if>
            <p>
                <a href="adicionarMateria">Adicionar Matéria</a>
            </p>
            <p>
                <a href="excluirMateria">Excluir Matéria</a>
            </p>
    </body>
</html>
