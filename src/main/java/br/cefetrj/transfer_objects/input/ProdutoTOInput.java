package br.cefetrj.transfer_objects.input;

import java.io.Serializable;

//import java.time.LocalDate;

import br.cefetrj.model.Desenvolvedora;
import br.cefetrj.model.Distribuidora;
import br.cefetrj.model.Dlc;
import br.cefetrj.model.Jogo;
import br.cefetrj.model.Produto;

public class ProdutoTOInput implements Serializable
{
    private Integer id;
    private String nome;
    private String tipo;
    private double preco;
    //private LocalDate dataPublicacao;
    private EmpresaTOInput desenvolvedora;
    private EmpresaTOInput distribuidora;
    private String genero;
    private ProdutoTOInput jogoAssociado;

    public Integer getId()
    {
        return this.id;

    }

    public void setId(Integer id)
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

    public String getTipo()
    {
        return this.tipo;

    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;

    }

    public double getPreco()
    {
        return this.preco;

    }

    public void setPreco(double preco)
    {
        this.preco = preco;

    }

    // public LocalDate getDataPublicacao()
    // {
    //     return dataPublicacao;

    // }

    // public void setDataPublicacao(LocalDate dataPublicacao)
    // {
    //     this.dataPublicacao = dataPublicacao;

    // }

    public EmpresaTOInput getDesenvolvedora()
    {
        return this.desenvolvedora;

    }
    
    public void setDesenvolvedora(EmpresaTOInput desenvolvedora)
    {
        this.desenvolvedora = desenvolvedora;

    }

    public EmpresaTOInput getDistribuidora()
    {
        return this.distribuidora;

    }

    public void setDistribuidora(EmpresaTOInput distribuidora)
    {
        this.distribuidora = distribuidora;

    }

    public String getGenero()
    {
        return this.genero;

    }

    public void setGenero(String genero)
    {
        this.genero = genero;

    }

    public ProdutoTOInput getJogoAssociado()
    {
        return this.jogoAssociado;

    }

    public void setJogoAssociado(ProdutoTOInput jogoAssociado)
    {
        this.jogoAssociado = jogoAssociado;

    }

    public Produto build()
    {
        if(this.tipo.equals("jogo"))
        {
            Jogo produto = new Jogo();
            produto.setId(this.id);
            produto.setNome(this.nome);
            produto.setPreco(this.preco);
            //produto.setDataPublicacao(this.dataPublicacao);
            produto.setDesenvolvedora((Desenvolvedora) this.desenvolvedora.build());
            produto.setDistribuidora((Distribuidora) this.distribuidora.build());
            produto.setGenero(this.genero);
            return produto;

        }

        else if(this.tipo.equals("dlc"))
        {
            Dlc produto = new Dlc();
            produto.setId(this.id);
            produto.setNome(this.nome);
            produto.setPreco(this.preco);
            //produto.setDataPublicacao(this.dataPublicacao);
            produto.setDesenvolvedora((Desenvolvedora) this.desenvolvedora.build());
            produto.setDistribuidora((Distribuidora) this.distribuidora.build());
            produto.setJogoAssociado((Jogo) this.jogoAssociado.build());
            return produto;

        }

        else
            return null;
        
    }

}
