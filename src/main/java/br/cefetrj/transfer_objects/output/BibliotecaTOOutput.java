package br.cefetrj.transfer_objects.output;

import br.cefetrj.model.Biblioteca;

public class BibliotecaTOOutput
{
    private Integer id;
    private int quantidadeItens;

    public BibliotecaTOOutput(Biblioteca biblioteca)
    {
    
        this.id = biblioteca.getId();
        this.quantidadeItens = biblioteca.getQuantidadeItens();
   
      

    }

    public Integer getId()
    {
        return id;

    }

    public void setId(Integer id)
    {
        this.id = id;

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
