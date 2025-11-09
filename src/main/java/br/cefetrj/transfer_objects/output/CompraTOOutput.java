package br.cefetrj.transfer_objects.output;

import br.cefetrj.model.Compra;

public class CompraTOOutput
{
    private Integer id;
    private ContaTOOutput conta;
    private ProdutoTOOutput produto;
    private double valor;
    //private LocalDate dataCompra;
    private String formaDePagamento;

    public CompraTOOutput(Compra compra)
    {
        this.id = compra.getId();
        this.conta = new ContaTOOutput(compra.getConta());
        this.produto = new ProdutoTOOutput(compra.getProduto());
        this.valor = compra.getValor();
        this.formaDePagamento = compra.getFormaDePagamento();

    }

    public Integer getId()
    {
        return id;

    }

    public void setId(Integer id)
    {
        this.id = id;

    }

    public ContaTOOutput getConta()
    {
        return conta;

    }

    public void setConta(ContaTOOutput conta)
    {
        this.conta = conta;

    }

    public ProdutoTOOutput getProduto()
    {
        return produto;

    }

    public void setProduto(ProdutoTOOutput produto)
    {
        this.produto = produto;

    }

    public double getValor()
    {
        return valor;

    }

    public void setValor(double valor)
    {
        this.valor = valor;

    }

    public String getFormaDePagamento()
    {
        return formaDePagamento;

    }

    public void setFormaDePagamento(String formaDePagamento)
    {
        this.formaDePagamento = formaDePagamento;

    }

}
