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

    @ManyToOne
    protected Desenvolvedora desenvolvedora;

    @ManyToOne
    protected Distribuidora distribuidora;

    public Produto()
    {

    }

    public Produto(String nome, Desenvolvedora desenvolvedora, Distribuidora distribuidora)
    {
        this.setNome(nome);
        this.setDesenvolvedora(desenvolvedora);
        this.setDistribuidora(distribuidora);

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
