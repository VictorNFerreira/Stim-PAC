package br.cefetrj.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "produto")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Produto extends Entidade
{
    @Column(name = "nome")
    protected String nome;

    @Column(name = "preco")
    protected double preco;

    @Transient
    protected LocalDate dataPublicacao;

    @Column(name = "avaliacoes")
    protected double avaliacoes;

    @Transient
    protected Desenvolvedora desenvolvedora;

    @Transient
    protected Distribuidora distribuidora;

    public Produto(String nome, double preco)
    {
        this.setNome(nome);
        this.setPreco(preco);

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

    public LocalDate getDataPublicacao()
    {
        return dataPublicacao;

    }

    public void setDataPublicacao(LocalDate dataPublicacao)
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
