package br.cefetrj.transfer_objects.output;

import java.util.List;

import br.cefetrj.model.Biblioteca;

public class BibliotecaTOOutput
{
    private Integer id;
    private int quantidadeItens;
    private List<ProdutoTOOutput> jogos;

    public BibliotecaTOOutput(Biblioteca biblioteca)
    {
        this.id = biblioteca.getId();
        this.quantidadeItens = biblioteca.getQuantidadeItens();
        if(biblioteca.getJogos() != null)
        {
            this.jogos = biblioteca.getJogos().stream().map(jogo ->
            {
                ProdutoTOOutput jogoTO = new ProdutoTOOutput(jogo);
                return jogoTO;

            }).toList();

        }

    }

    public Integer getId()
    {
        return id;

    }

    public void setId(Integer id)
    {
        this.id = id;

    }
    
    public List<ProdutoTOOutput> getJogos()
    {
        return jogos;

    }

    public void setJogos(List<ProdutoTOOutput> jogos)
    {
        this.jogos = jogos;

    }

    public int getQuantidadeItens()
    {
        return quantidadeItens;

    }

    public void setQuantidadeItens(int quantidadeItens)
    {
        this.quantidadeItens = quantidadeItens;

    }

}
