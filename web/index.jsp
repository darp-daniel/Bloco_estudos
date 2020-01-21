<%-- 
    Document   : index
    Created on : 18/01/2020, 14:43:59
    Author     : cliente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bloco de estudos</title>
    </head>
    <body>
        <h1>Bem-vindo usuário, por favor faça seu login!</h1>
        <form method="POST" action="login">
            <p>
                <label>Email: </label>
                <input type="email" name="email"/>
            </p>
            <p>
                <label>Senha: </label>
                <input type="password" name="senha"/>
            </p>
            <p>
                <input type="submit" value="Logar"/>
            </p>
        </form>
        <p>
            Não tem um cadastro? Cadastre-se <a href="cadastrar.jsp">clicando aqui</a>
        </p>
    </body>
</html>
