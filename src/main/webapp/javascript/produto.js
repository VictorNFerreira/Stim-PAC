const tipo = document.getElementById("tipo");
const generoContainer = document.querySelector(".genero-container");
const jogoAssociadoContainer = document.querySelector(".jogo-associado-container");

function verificarTipo()
{
    if(tipo.value == "jogo")
    {
        generoContainer.style.display = "grid";
        jogoAssociadoContainer.style.display = "none";

    }
    
    else if(tipo.value == "dlc")
    {
        jogoAssociadoContainer.style.display = "grid";
        generoContainer.style.display = "none";
        
    }

    else
    {
        jogoAssociadoContainer.style.display = "none";
        generoContainer.style.display = "none";

    }

}

verificarTipo();
tipo.addEventListener("change", verificarTipo);
