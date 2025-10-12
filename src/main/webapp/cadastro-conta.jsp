<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cadastro de conta</title>
        <link rel="stylesheet" href="./css/style.css">
    </head>

    <body>
        <form action="conta" method="post">
            <input type="hidden" name="acao" value="cadastrar">

            <label for="nome">Nome: </label>
            <input id="nome" type="text" name="nome">

            <label for="email">Email: </label>
            <input id="email" type="email" name="email">

            <label for="senha">Senha: </label>
            <input id="senha" type="password" name="senha">

            <button>Cadastrar</button>
        </form>
    </body>
</html>
