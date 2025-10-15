<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="br.cefetrj.model.Compra" %>
<% Compra compra = (Compra)request.getAttribute("entidade"); %>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Formulário de Compra</title>
        <link rel="stylesheet" href="./css/style.css">
    </head>

    <body>
        <main class="principal">
            <div class="principal-titulo">
                <h1><%= compra == null ? "Cadastro" : "Edição" %> de Compra</h1>
            </div>

            <form action="<%= request.getAttribute("urlSubmit") %>" method="post">
                <div class="principal-formulario">
                    <input type="hidden" name="id" value="<%= compra != null ? compra.getId() : "" %>">
                    <input type="hidden" name="acao" value="<%= compra != null ? "atualizar" : "cadastrar" %>">

                    <div class="formulario-duplo">
                        <div>
                            <label for="conta">Id da Conta</label>
                            <input id="conta" type="text" name="conta" value="<%= compra != null ? compra.getConta().getId() : "" %>">
                        </div>

                        <div>
                            <label for="produto">Id do Produto</label>
                            <input id="produto" type="text" name="produto" value="<%= compra != null ? compra.getProduto() : "" %>">
                        </div>
                    </div>
                    
                    <div>
                        <label for="tipo">Tipo do Produto</label>
                        <select id="tipo" name="tipo">
                            <option value="">Escolha...</option>
                            <option value="jogo">Jogo</option>
                            <option value="dlc">Dlc</option>
                        </select>  
                    </div>
                    
                    <div>
                        <label for="valor">Valor da compra</label>
                        <input id="valor" type="text" name="valor" value="<%= compra != null ? compra.getValor() : "" %>">
                    </div>

                    <div>
                        <label for="forma-pagamento">Forma de pagamento</label>
                        <input id="forma-pagamento" type="text" name="forma-pagamento" value="<%= compra != null ? compra.getFormaDePagamento() : "" %>">
                    </div>

                    <div>
                        <button><%= compra == null ? "Cadastrar" : "Editar" %></button>
                    </div>
                </div>
            </form>
        </main>
    </body>
</html>
