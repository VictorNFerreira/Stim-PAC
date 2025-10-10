<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="br.cefetrj.model.Biblioteca" %>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Bibliotecas</title>
        <link rel="stylesheet" href="./css/style.css">
    </head>
    
    <body>
        <header class="cabecalho">
            <div class="cabecalho-logo">

            </div>

            <nav class="cabecalho-menu">
                <ul>
                    <li><a href="Conta">Contas</a></li>
                    <li><a href="Produto">Produtos</a></li>
                    <li><a href="Empresa">Empresas</a></li>
                    <li><a href="Compra">Compras</a></li>
                    <li><a href="Biblioteca">Bibliotecas</a></li>
                </ul>
            </nav>
        </header>

        <main class="principal">
            <div class="principal-titulo">
                <h1>Lista de Bibliotecas</h1> 
             </div>

            <dl>
                <%
                    List<Biblioteca> bibliotecas = (List<Biblioteca>) request.getAttribute("bibliotecas");
                    for(Biblioteca biblioteca : bibliotecas)
                    {
                %>
                <div>
                    <dt>Id: <%= biblioteca.getId() %></dt>
                    <dd>Id da conta: <%= biblioteca.getConta().getId() %></dd>
                    <dd>Quantidade de itens: <%= biblioteca.getQuantidadeItens() %></dd>
                </div>
                <% } %>
            </dl>
        </main>
    </body>
</html>
