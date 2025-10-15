<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="br.cefetrj.model.Empresa" %>
<% Empresa empresa = (Empresa) request.getAttribute("entidade"); %>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Formulário de Empresa</title>
        <link rel="stylesheet" href="./css/style.css">
    </head>

    <body>
        <main class="principal">
            <div class="principal-titulo">
                <h1><%= empresa == null ? "Cadastro" : "Edição" %> de Empresa</h1>
            </div>

            <form action="<%= request.getAttribute("urlSubmit") %>" method="post">
                <div class="principal-formulario">
                    <input type="hidden" name="id" value="<%= empresa != null ? empresa.getId() : "" %>">
                    <input type="hidden" name="acao" value="<%= empresa != null ? "atualizar" : "cadastrar" %>">

                    <div>
                        <label for="nome">Nome: </label>
                        <input id="nome" type="text" name="nome" value="<%= empresa != null ? empresa.getNome() : "" %>">
                    </div>
                    
                    <div>
                       <label for="tipo">Tipo da empresa: </label>
                        <select id="tipo" name="tipo">
                            <option value="">Escolha...</option>
                            <option value="desenvolvedora">Desenvolvedora</option>
                            <option value="distribuidora">Distribuidora</option>
                        </select>
                    </div>
                    
                    <div>
                        <button><%= empresa == null ? "Cadastrar" : "Editar" %></button>  
                    </div>
                </div>
            </form>
        </main>
    </body>
</html>
