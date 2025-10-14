<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cadastro de produto</title>
        <link rel="stylesheet" href="./css/style.css">
    </head>

    <body>
        <form action="Produto" method="post">
            <label for="tipo">Tipo de produto: </label>
            <select id="tipo" name="tipo">
                <option value="">Escolha...</option>
                <option value="jogo">Jogo</option>
                <option value="dlc">Dlc</option>
            </select>

            <label for="nome">Nome: </label>
            <input id="nome" type="text" name="nome">

            <label for="preco">Preco: </label>
            <input id="preco" type="text" name="preco">

            <div class="genero-container">
                <label for="genero">Genero: </label>
                <input id="genero" type="text" name="genero">
            </div>
            
            <div class="jogo-associado-container">
                <label for="jogo-associado">Jogo associado: </label>
                <input id="jogo-associado" type="text" name="jogo-associado">
            </div>

            <button>Cadastrar</button>
        </form>

        <script src="./javascript/produto.js"></script>
    </body>
</html>
