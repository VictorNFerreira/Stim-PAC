<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cadastro de empresa</title>
        <link rel="stylesheet" href="./css/style.css">
    </head>

    <body>
        <form action="Empresa" method="post">
            <label for="nome">Nome: </label>
            <input id="nome" type="text" name="nome">

            <label for="tipo">Tipo da empresa: </label>
            <select id="tipo" name="tipo">
                <option value="">Escolha...</option>
                <option value="desenvolvedora">Desenvolvedora</option>
                <option value="distribuidora">Distribuidora</option>
            </select>

            <button>Cadastrar</button>
        </form>
    </body>
</html>
