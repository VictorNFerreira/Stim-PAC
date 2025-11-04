package br.cefetrj.transfer_objects.output;

import java.util.ArrayList;
import java.util.List;

import br.cefetrj.model.Biblioteca;
import br.cefetrj.model.Jogo;

public class BibliotecaTOOutput
{
    private Integer id;
    private int quantidadeItens;
    //private List<Jogo> jogos = new ArrayList<Jogo>();

    public BibliotecaTOOutput(Biblioteca biblioteca)
    {
        this.id = biblioteca.getId();
        this.quantidadeItens = biblioteca.getQuantidadeItens();
        //this.jogos = biblioteca.getJogos();

    }

    public Integer getId()
    {
        return id;

    }

    public void setId(Integer id)
    {
        this.id = id;

    }
    
    // public List<Jogo> getJogos()
    // {
    //     return jogos;

    // }

    // public void setJogos(List<Jogo> jogos)
    // {
    //     this.jogos = jogos;

    // }

    public int getQuantidadeItens()
    {
        return quantidadeItens;

    }

    public void setQuantidadeItens(int quantidadeItens)
    {
        this.quantidadeItens = quantidadeItens;

    }

}
