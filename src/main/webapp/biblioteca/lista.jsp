<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <li><a href="conta">Contas</a></li>
                    <li><a href="Produto">Produtos</a></li>
                    <li><a href="empresa">Empresas</a></li>
                    <li><a href="compra">Compras</a></li>
                    <li><a href="biblioteca">Bibliotecas</a></li>
                </ul>
            </nav>
        </header>

        <main class="principal">
            <div class="principal-titulo">
                <h1>Lista de Bibliotecas</h1> 
             </div>

            <dl>
                <%
                    List<Biblioteca> bibliotecas = (List<Biblioteca>) request.getAttribute("lista");
                    for(Biblioteca biblioteca : bibliotecas)
                    {
                %>
                <div class="lista-registro">
                    <div class="lista-dados">
                        <dt>Id: <%= biblioteca.getId() %></dt>
                        <dd>Id da conta: <%= biblioteca.getConta().getId() %></dd>
                        <dd>Quantidade de itens: <%= biblioteca.getQuantidadeItens() %></dd>
                    </div>
                </div>
                <% } %>
            </dl>
        </main>
    </body>
</html>
