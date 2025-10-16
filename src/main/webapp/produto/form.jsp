<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="br.cefetrj.model.Produto" %>
<%@ page import="br.cefetrj.model.Jogo" %>
<%@ page import="br.cefetrj.model.Dlc" %>
<% Produto produto = (Produto) request.getAttribute("entidade"); %>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Formulário de Produto</title>
        <link rel="stylesheet" href="./css/style.css">
    </head>

    <body>
        <main class="principal">
            <div class="principal-titulo">
                <h1><%= produto == null ? "Cadastro" : "Edição" %> de Produto</h1>
            </div>

            <form action="<%= request.getAttribute("urlSubmit") %>" method="post">
                <div class="principal-formulario">
                    <input type="hidden" name="id" value="<%= produto != null ? produto.getId() : "" %>">
                    <input type="hidden" name="acao" value="<%= produto != null ? "atualizar" : "cadastrar" %>">

                    <div>
                        <label for="nome">Nome: </label>
                        <input id="nome" type="text" name="nome" value="<%= produto != null ? produto.getNome() : "" %>">
                    </div>
                    
                    <div>
                        <label for="tipo">Tipo do produto: </label>
                        <select id="tipo" name="tipo">
                            <option value="">Escolha...</option>
                            <option value="jogo">Jogo</option>
                            <option value="dlc">Dlc</option>
                        </select>
                    </div>
                    
                    <div>
                        <label for="preco">Preço: </label>
                        <input id="preco" type="text" name="preco" value="<%= produto != null ? produto.getPreco() : "" %>">
                    </div>
                    
                    <div class="genero-container">
                        <label for="genero">Gênero: </label>
                        <input id="genero" type="text" name="genero">
                    </div>
                    
                    <div class="jogo-associado-container">
                        <label for="jogo-associado">Id do Jogo associado: </label>
                        <input id="jogo-associado" type="text" name="jogo-associado">
                    </div>

                    <div class="formulario-duplo">
                        <div>
                            <label for="desenvolvedora">Id da Desenvolvedora: </label>
                            <input id="desenvolvedora" type="text" name="desenvolvedora" value="<%= produto != null ? produto.getDesenvolvedora().getId() : "" %>">
                        </div>
                        
                        <div>
                            <label for="distribuidora">Id da Distribuidora: </label>
                            <input id="distribuidora" type="text" name="distribuidora" value="<%= produto != null ? produto.getDistribuidora().getId() : "" %>">
                        </div>
                    </div>
                    
                    <div>
                        <button><%= produto == null ? "Cadastrar" : "Editar" %></button>
                    </div>
                </div>
            </form>
        </main>

        <script src="./javascript/produto.js"></script>
    </body>
</html>
