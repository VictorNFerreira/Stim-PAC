package br.cefetrj.transfer_objects.input;

import java.io.Serializable;

import br.cefetrj.model.Compra;
import br.cefetrj.model.Dlc;
import br.cefetrj.model.Jogo;

//import java.time.LocalDate;

public class CompraTOInput implements Serializable
{
    private Integer id;
    private ContaTOInput conta;
    private ProdutoTOInput produto;
    private String produtoTipo;
    private double valor;
    //private LocalDate dataCompra;
    private String formaDePagamento;

    public Integer getId()
    {
        return id;

    }

    public void setId(Integer id)
    {
        this.id = id;

    }

    public ContaTOInput getConta()
    {
        return this.conta;

    }

    public void setConta(ContaTOInput conta)
    {
        this.conta = conta;

    }

    public ProdutoTOInput getProduto()
    {
        return this.produto;

    }

    public void setProduto(ProdutoTOInput produto)
    {
        this.produto = produto;

    }

    public String getProdutoTipo()
    {
        return this.produtoTipo;

    }

    public void setProdutoTipo(String produtoTipo)
    {
        this.produtoTipo = produtoTipo;

    }

    public double getValor()
    {
        return this.valor;

    }

    public void setValor(double valor)
    {
        this.valor = valor;
        
    }

    // public LocalDate getDataCompra()
    // {
    //     return this.dataCompra;

    // }

    // public void setDataCompra(LocalDate dataCompra)
    // {
    //     this.dataCompra = dataCompra;

    // }

    public String getFormaDePagamento()
    {
        return this.formaDePagamento;

    }

    public void setFormaDePagamento(String formaDePagamento)
    {
        this.formaDePagamento = formaDePagamento;

    }

    public Compra build()
    {
        Compra compra = new Compra();
        compra.setId(this.id);
        compra.setConta(conta.build());
        if(this.produtoTipo.equals("jogo"))
        {
            Jogo jogo = new Jogo();
            jogo.setId(this.produto.getId());
            compra.setProduto(jogo);

        }
            
        else if(this.produtoTipo.equals("dlc"))
        {
            Dlc dlc = new Dlc();
            dlc.setId(this.produto.getId());
            compra.setProduto(dlc);
        }
            
        compra.setValor(this.valor);
        compra.setFormaDePagamento(this.formaDePagamento);
        return compra;

    }

}
