package br.cefetrj.model;

import java.util.Date;

import jakarta.persistence.*;


@Entity
@Table(name = "compra")
public class Compra
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Conta conta;

    @Transient
    private Produto produto;

    @Column(name = "valor")
    private double valor;

    @Transient
    private Date dataCompra;

    @Column(name = "forma_de_pagamento")
    private String formaDePagamento;

    public Compra()
    {

    }

    public Compra(Conta conta, /*Produto produto,*/ double valor/* , Date dataCompra*/)
    {
        this.setConta(conta);
        /*this.setProduto(produto);*/
        this.setValor(valor);
        /*this.setDataCompra(dataCompra);*/

    }

    public int getId()
    {
        return this.id;

    }

    public void setId(int id)
    {
        this.id = id;

    }

    public Conta getConta()
    {
        return this.conta;

    }

    public void setConta(Conta conta)
    {
        this.conta = conta;

    }

    public Produto getProduto()
    {
        return this.produto;

    }

    public void setProduto(Produto produto)
    {
        this.produto = produto;

    }

    public double getValor()
    {
        return this.valor;

    }

    public void setValor(double valor)
    {
        this.valor = valor;
        
    }

    public Date getDataCompra()
    {
        return this.dataCompra;

    }

    public void setDataCompra(Date dataCompra)
    {
        this.dataCompra = dataCompra;

    }

    public String getFormaDePagamento()
    {
        return this.formaDePagamento;

    }

    public void setFormaDePagamento(String formaDePagamento)
    {
        this.formaDePagamento = formaDePagamento;

    }

}
