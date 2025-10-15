<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="br.cefetrj.model.Conta" %>
<% Conta conta = (Conta)request.getAttribute("entidade"); %>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Formulário de Conta</title>
        <link rel="stylesheet" href="./css/style.css">
    </head>

    <body>
        <main class="principal">
            <div class="principal-titulo">
                <h1><%= conta == null ? "Cadastro" : "Edição" %> de Conta</h1>
            </div>

            <form action="<%= request.getAttribute("urlSubmit") %>" method="post">
                <div class="principal-formulario">
                    <input type="hidden" name="id" value="<%= conta != null ? conta.getId() : "" %>">
                    <input type="hidden" name="acao" value="<%= conta != null ? "atualizar" : "cadastrar" %>">

                    <div>
                        <label for="nome">Nome</label>
                        <input id="nome" type="text" name="nome" value="<%= conta != null ? conta.getNome() : "" %>">
                    </div>
                    
                    <div>
                        <label for="email">Email</label>
                        <input id="email" type="email" name="email" value="<%= conta != null ? conta.getEmail() : "" %>"> 
                    </div>
                    
                    <div>
                        <label for="senha">Senha</label>
                        <input id="senha" type="password" name="senha" value="<%= conta != null ? conta.getSenha() : "" %>">    
                    </div>

                    <div>
                        <button><%= conta == null ? "Cadastrar" : "Editar" %></button> 
                    </div>
                </div>
            </form>
        </main>
    </body>
</html>
