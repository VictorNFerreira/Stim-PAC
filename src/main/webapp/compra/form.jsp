<!DOCTYPE html>
<%@ page import="br.cefetrj.model.Compra" %>
<% Compra compra = (Compra)request.getAttribute("entidade"); %>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cadastro de compra</title>
        <link rel="stylesheet" href="./css/style.css">
    </head>

    <body>
        <form action="<%= request.getAttribute("urlSubmit") %>" method="post">
            <input type="hidden" name="id" value="<%= compra != null ? compra.getId() : "" %>">
            <input type="hidden" name="acao" value="<%= compra != null ? "atualizar" : "cadastrar" %>">

            <div>
                <label for="conta">Id da conta: </label>
                <input id="conta" type="text" name="conta">
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
                <label for="produto">Id do produto: </label>
                <input id="produto" type="text" name="produto">
            </div>
            
            <div>
                <label for="valor">Valor da compra: </label>
                <input id="valor" type="text" name="valor">
            </div>

            <div>
                <label for="forma-pagamento">Forma de pagamento: </label>
                <input id="forma-pagamento" type="text" name="forma-pagamento">
            </div>

            <button>Cadastrar</button>
        </form>
    </body>
</html>
