<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="br.cefetrj.model.Conta" %>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Contas</title>
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
                <h1>Lista de Contas</h1> 
                <a href="<%= request.getAttribute("urlSubmit") %>?acao=inserir">Adicionar Conta</a>
             </div>

            <dl>
                <%
                    List<Conta> contas = (List<Conta>) request.getAttribute("lista");
                    for(Conta conta : contas)
                    {
                %>
                <div class="lista-registro">
                    <div class="lista-dados">
                        <dt>
                            <p>Id: <%= conta.getId() %></p>
                            <p>Nome: <%=conta.getNome() %></p>
                        </dt>
                        <dd>Email: <%= conta.getEmail() %></dd>
                        <dd>Senha: <%= conta.getSenha() %></dd>
                        <dd>Saldo: R$<%= conta.getSaldo() %></dd>
                    </div> 

                    <div class="lista-botoes">
                        <a href="<%= request.getAttribute("urlSubmit") %>?acao=listarPorId&id=<%= conta.getId() %>">Editar Conta</a>
                        <a href="<%= request.getAttribute("urlSubmit") %>?acao=deletar&id=<%= conta.getId() %>" onclick="return confirm('Tem certeza que deseja remover?');">Remover Conta</a>
                    </div>
                </div>
                <% } %>
            </dl>
        </main>
    </body>
</html>
