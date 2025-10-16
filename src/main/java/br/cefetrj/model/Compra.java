package br.cefetrj.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "compra")
public class Compra extends Entidade
{
    @ManyToOne
    private Conta conta;

    @ManyToOne
    private Produto produto;

    @Column(name = "valor")
    private double valor;

    @Transient
    private LocalDate dataCompra;

    @Column(name = "forma_de_pagamento")
    private String formaDePagamento;

    public Compra()
    {

    }

    public Compra(Conta conta, Produto produto, double valor/* , LocalDate dataCompra*/)
    {
        this.setConta(conta);
        this.setProduto(produto);
        this.setValor(valor);
        /*this.setDataCompra(dataCompra);*/

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

    public LocalDate getDataCompra()
    {
        return this.dataCompra;

    }

    public void setDataCompra(LocalDate dataCompra)
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
