<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="br.cefetrj.model.Conta" %>
<% Conta conta = (Conta)request.getAttribute("entidade"); %>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cadastro de conta</title>
        <link rel="stylesheet" href="./css/style.css">
    </head>

    <body>
        <form action="<%= request.getAttribute("urlSubmit") %>" method="post">
            <input type="hidden" name="id" value="<%= conta != null ? conta.getId() : "" %>">
            <input type="hidden" name="acao" value="<%= conta != null ? "atualizar" : "cadastrar" %>">

            <label for="nome">Nome: </label>
            <input id="nome" type="text" name="nome">

            <label for="email">Email: </label>
            <input id="email" type="email" name="email">

            <label for="senha">Senha: </label>
            <input id="senha" type="password" name="senha">

            <button>Cadastrar</button>
        </form>
    </body>
</html>
