<!DOCTYPE html>
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
                    <li><a href="Produto">Produtos</a></li>
                    <li><a href="Empresa">Empresas</a></li>
                    <li><a href="Compra">Compras</a></li>
                    <li><a href="biblioteca">Bibliotecas</a></li>
                </ul>
            </nav>
        </header>

        <main class="principal">
            <div class="principal-titulo">
                <h1>Lista de Produtos</h1> 
                <a href="cadastro-produto.jsp">Adicionar Produto</a>
             </div>

            <dl>
                <%
                    List<Produto> produtos = (List<Produto>) request.getAttribute("produtos");
                    for(Produto produto : produtos)
                    {
                %>
                <div class="lista-registro">
                    <div class="lista-dados">
                        <dt><%= produto.getNome() %></dt>
                        <dd>R$<%= produto.getPreco() %></dd>
                        
                        <%
                            if(produto instanceof Jogo)
                            {
                                Jogo jogo = (Jogo) produto;
                        %>
                        <dd><%= jogo.getGenero() %></dd>
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
                        <dd>Jogo: <%= dlc.getJogoAssociado().getNome() %></dd>
                        <% } %>
                    </div>
                </div>
                <% } %>
            </dl>
        </main>
    </body>
</html>
