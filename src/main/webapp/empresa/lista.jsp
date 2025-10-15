<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="br.cefetrj.model.Empresa" %>
<%@ page import="br.cefetrj.model.Desenvolvedora" %>
<%@ page import="br.cefetrj.model.Distribuidora" %>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Empresas</title>
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
                <h1>Lista de Empresas</h1> 
                <a href="<%= request.getAttribute("urlSubmit") %>?acao=inserir">Adicionar Empresa</a>
             </div>

        <h2>Desenvolvedoras</h2>
            <dl>
                <%
                    List<Empresa> empresas = (List<Empresa>) request.getAttribute("lista");
                    for(Empresa empresa : empresas)
                    {
                        if(empresa instanceof Desenvolvedora)
                        {
                %>
                <div class="lista-registro">
                    <div class="lista-dados">
                        <dt>
                            <p>Id: <%= empresa.getId() %></p>
                            <p>Nome: <%=empresa.getNome() %></p>
                        </dt>
                    </div>

                    <div class="lista-botoes">
                        <a href="<%= request.getAttribute("urlSubmit") %>?acao=listarPorId&id=<%= empresa.getId() %>">Editar Empresa</a>
                        <a href="<%= request.getAttribute("urlSubmit") %>?acao=deletar&id=<%= empresa.getId() %>" onclick="return confirm('Tem certeza que deseja remover?');">Remover Empresa</a>
                    </div>
                </div>
                <%
                    }
                    } 
                %>
            </dl>

            <h2>Distribuidoras</h2>
            <dl>
                <%
                    for(Empresa empresa : empresas)
                    {
                        if(empresa instanceof Distribuidora)
                        {
                %>
                <div class="lista-registro">
                    <div class="lista-dados">
                        <dt>
                            <p>Id: <%= empresa.getId() %></p>
                            <p>Nome: <%=empresa.getNome() %></p>
                        </dt>
                    </div>

                    <div class="lista-botoes">
                        <a href="<%= request.getAttribute("urlSubmit") %>?acao=listarPorId&id=<%= empresa.getId() %>">Editar Empresa</a>
                        <a href="<%= request.getAttribute("urlSubmit") %>?acao=deletar&id=<%= empresa.getId() %>" onclick="return confirm('Tem certeza que deseja remover?');">Remover Empresa</a>
                    </div>
                </div>
                <%
                    }
                    } 
                %>
            </dl>
        </main>
    </body>
</html>
