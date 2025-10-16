package br.cefetrj.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("distribuidora")
public class Distribuidora extends Empresa
{
    @OneToMany(targetEntity = Produto.class, mappedBy = "distribuidora", fetch = FetchType.EAGER)
    private List<Produto> produtosPublicados;

    public Distribuidora()
    {
        super();

    }

    public Distribuidora(String nome)
    {
        super(nome);

    }

    public List<Produto> getProdutosPublicados()
    {
        return this.produtosPublicados;

    }

    public void setProdutosPublicados(List<Produto> produtosPublicados)
    {
        this.produtosPublicados = produtosPublicados;

    }
    
}
