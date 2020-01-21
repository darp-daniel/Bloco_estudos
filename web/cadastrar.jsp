<%-- 
    Document   : cadastrar
    Created on : 18/01/2020, 14:56:16
    Author     : cliente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro</title>
    </head>
    <body>
        <h1>Por favor, preencha os dados abaixo</h1>
        <form method="POST" action="cadastrar">
            <p>
                <label>Email: </label>
                <input type="email" name="email"/>
            </p>
            <p>
                <label>Senha: </label>
                <input type="password" name="senha"/>
            </p>
            <p>
                <label>Nome: </label>
                <input type="text" name="nome"/>
            </p>
            <input type="submit" value="Cadastrar"/>
        </form>
    </body>
</html>
