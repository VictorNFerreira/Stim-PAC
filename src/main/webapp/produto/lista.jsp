<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="br.cefetrj.model.Produto" %>
<%@ page import="br.cefetrj.model.Jogo" %>
<%@ page import="br.cefetrj.model.Dlc" %>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Produtos</title>
        <link rel="stylesheet" href="./css/style.css">
    </head>

    <body>
        <header class="cabecalho">
            <div class="cabecalho-logo">

            </div>

            <nav class="cabecalho-menu">
                <ul>
                    <li><a href="conta">Contas</a></li>
                    <li><a href="produto">Produtos</a></li>
                    <li><a href="empresa">Empresas</a></li>
                    <li><a href="compra">Compras</a></li>
                    <li><a href="biblioteca">Bibliotecas</a></li>
                </ul>
            </nav>
        </header>

        <main class="principal">
            <div class="principal-titulo">
                <h1>Lista de Produtos</h1> 
                <a href="<%= request.getAttribute("urlSubmit") %>?acao=inserir">Adicionar Produto</a>
             </div>

            <dl>
                <%
                    List<Produto> produtos = (List<Produto>) request.getAttribute("lista");
                    for(Produto produto : produtos)
                    {
                %>
                <div class="lista-registro">
                    <div class="lista-dados">
                        <dt>
                            <p>Id: <%= produto.getId() %></p>
                            <p>Nome: <%= produto.getNome() %></p>
                        </dt>
                        <dd>Preço: R$<%= produto.getPreco() %></dd>
                        <%
                            if(produto instanceof Jogo)
                            {
                                Jogo jogo = (Jogo) produto;
                        %>
                        <dd>Gênero: <%= jogo.getGenero() %></dd>
                        <%
                            if(jogo.getDlcs().size() != 0)
                            {
                        %>
                        <dd>Dlcs: 
                        <%
                            for(Dlc dlc : jogo.getDlcs())
                            {
                                out.println(dlc.getNome() + ", ");
                                
                            }
                        %>
                        </dd>
                        <% 
                            }
                            }
                        %>
                        <%
                            if(produto instanceof Dlc)
                            {
                                Dlc dlc = (Dlc) produto;
                        %>
                        <dd>Jogo associado: <%= dlc.getJogoAssociado().getId() %></dd>
                        <% } %>
                        <dd>Desenvolvedora: <%= produto.getDesenvolvedora().getNome() %></dd>
                        <dd>Distribuidora: <%= produto.getDistribuidora().getNome() %></dd>
                    </div>

                    <div class="lista-botoes">
                        <a href="<%= request.getAttribute("urlSubmit") %>?acao=listarPorId&id=<%= produto.getId() %>">Editar Produto</a>
                        <a href="<%= request.getAttribute("urlSubmit") %>?acao=deletar&id=<%= produto.getId() %>" onclick="return confirm('Tem certeza que deseja remover?');">Remover Produto</a>
                    </div>
                </div>
                <% } %>
            </dl>
        </main>
    </body>
</html>
