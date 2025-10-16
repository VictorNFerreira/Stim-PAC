package br.cefetrj.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("desenvolvedora")
public class Desenvolvedora extends Empresa
{
    @OneToMany(targetEntity = Produto.class, mappedBy = "desenvolvedora", fetch = FetchType.EAGER)
    private List<Produto> produtosDesenvolvidos;

    public Desenvolvedora()
    {
        super();

    }

    public Desenvolvedora(String nome)
    {
        super(nome);

    }

    public List<Produto> getProdutosDesenvolvidos()
    {
        return this.produtosDesenvolvidos;

    }

    public void setProdutosDesenvolvidos(List<Produto> produtosDesenvolvidos)
    {
        this.produtosDesenvolvidos = produtosDesenvolvidos;
        
    }

}
