package br.cefetrj.model;

import java.util.Date;

public abstract class Produto
{
    protected int id;
    protected String nome;
    protected double preco;
    protected Date dataPublicacao;
    protected double avaliacoes;
    protected Desenvolvedora desenvolvedora;
    protected Distribuidora distribuidora;

    public Produto(String nome, double preco)
    {
        this.setNome(nome);
        this.setPreco(preco);

    }

    public int getId()
    {
        return this.id;

    }

    public void setId(int id)
    {
        this.id = id;

    }

    public String getNome()
    {
        return this.nome;

    }

    public void setNome(String nome)
    {
        this.nome = nome;

    }

    public double getPreco()
    {
        return this.preco;

    }

    public void setPreco(double preco)
    {
        this.preco = preco;

    }

    public Date getDataPublicacao()
    {
        return dataPublicacao;

    }

    public void setDataPublicacao(Date dataPublicacao)
    {
        this.dataPublicacao = dataPublicacao;

    }

    public double getAvaliacoes()
    {
        return avaliacoes;

    }

    public void setAvaliacoes(double avaliacoes)
    {
        this.avaliacoes = avaliacoes;
        
    }

    public Desenvolvedora getDesenvolvedora()
    {
        return this.desenvolvedora;

    }

    public void setDesenvolvedora(Desenvolvedora desenvolvedora)
    {
        this.desenvolvedora = desenvolvedora;

    }

    public Distribuidora getDistribuidora()
    {
        return distribuidora;

    }

    public void setDistribuidora(Distribuidora distribuidora)
    {
        this.distribuidora = distribuidora;

    }

}
