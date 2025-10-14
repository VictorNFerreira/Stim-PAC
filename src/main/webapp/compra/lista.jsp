<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="br.cefetrj.model.Compra" %>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Compras</title>
        <link rel="stylesheet" href="./css/style.css">
    </head>

    <body>
        <header class="cabecalho">
            <div class="cabecalho-logo">

            </div>

            <nav class="cabecalho-menu">
                <ul>
                    <li><a href="conta">Contas</a></li>
                    <li><a href="Produto">Produtos</a></li>
                    <li><a href="Empresa">Empresas</a></li>
                    <li><a href="compra">Compras</a></li>
                    <li><a href="biblioteca">Bibliotecas</a></li>
                </ul>
            </nav>
        </header>

        <main class="principal">
            <div class="principal-titulo">
                <h1>Lista de Compras</h1> 
                <a href="<%= request.getAttribute("urlSubmit") %>?acao=inserir">Adicionar Compra</a>
             </div>

            <dl>
                <%
                    List<Compra> compras = (List<Compra>) request.getAttribute("lista");
                    for(Compra compra : compras)
                    {
                %>
                <div class="lista-registro">
                    <div class="lista-dados">
                        <dt>Id: <%= compra.getId() %></dt>
                        <dd>Id da Conta: <%= compra.getConta().getId() %></dd>
                        <dd>Id do Produto: <%= compra.getProduto() %></dd>
                        <dd>Valor da compra: R$<%= compra.getValor() %></dd>
                        <dd>Forma de pagamento: <%= compra.getFormaDePagamento() %></dd>
                    </div>

                    <div class="lista-botoes">
                        <a href="<%= request.getAttribute("urlSubmit") %>?acao=listarPorId&id=<%= compra.getId() %>">Editar Compra</a>
                        <a href="<%= request.getAttribute("urlSubmit") %>?acao=deletar&id=<%= compra.getId() %>" onclick="return confirm('Tem certeza que deseja remover?');">Remover Compra</a>
                    </div>
                </div>
                <% } %>
            </dl>
        </main>
    </body>
</html>
