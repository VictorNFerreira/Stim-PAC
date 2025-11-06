package br.cefetrj.transfer_objects.output;

//import java.time.LocalDate;
import java.util.List;

import br.cefetrj.model.Jogo;
import br.cefetrj.model.Produto;

public class ProdutoTOOutput
{
    private Integer id;
    private String nome;
    private String tipo;
    private double preco;
    private double avaliacoes;
    //private LocalDate dataPublicacao;
    private EmpresaTOOutput desenvolvedora;
    private EmpresaTOOutput distribuidora;
    private String genero;
    private List<ProdutoTOOutput> dlcs;

    public ProdutoTOOutput(Produto produto)
    {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.tipo = produto.getClass().getSimpleName();
        this.preco = produto.getPreco();
        this.avaliacoes = produto.getAvaliacoes();
        //this.dataPublicacao = produto.getDataPublicacao();
        this.desenvolvedora = new EmpresaTOOutput(produto.getDesenvolvedora());
        this.distribuidora = new EmpresaTOOutput(produto.getDistribuidora());

        if(produto instanceof Jogo)
        {
            Jogo jogo = (Jogo) produto;
            this.genero = jogo.getGenero();
            if(jogo.getDlcs() != null)
            {
                this.dlcs = jogo.getDlcs().stream().map(dlc ->
                {
                    ProdutoTOOutput dlcTO = new ProdutoTOOutput(dlc);
                    return dlcTO;

                }).toList();

            }

        }
        
    }

    public Integer getId()
    {
        return id;

    }

    public void setId(Integer id)
    {
        this.id = id;

    }

    public String getNome()
    {
        return nome;

    }

    public void setNome(String nome)
    {
        this.nome = nome;

    }

    public String getTipo()
    {
        return tipo;

    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;

    }

    // public LocalDate getDataPublicacao()
    // {
    //     return dataPublicacao;

    // }

    // public void setDataPublicacao(LocalDate dataPublicacao)
    // {
    //     this.dataPublicacao = dataPublicacao;

    // }

    public double getPreco() 
    {
        return preco;

    }

    public void setPreco(double preco) 
    {
        this.preco = preco;

    }

    public double getAvaliacoes()
    {
        return avaliacoes;

    }

    public void setAvaliacoes(double avaliacoes)
    {
        this.avaliacoes = avaliacoes;

    }

    public EmpresaTOOutput getDesenvolvedora()
    {
        return desenvolvedora;

    }
    
    public void setDesenvolvedora(EmpresaTOOutput desenvolvedora)
    {
        this.desenvolvedora = desenvolvedora;

    }
    
    public EmpresaTOOutput getDistribuidora()
    {
        return distribuidora;

    }

    public void setDistribuidora(EmpresaTOOutput distribuidora)
    {
        this.distribuidora = distribuidora;

    }

    public String getGenero()
    {
        return genero;

    }

    public void setGenero(String genero)
    {
        this.genero = genero;

    }

    public List<ProdutoTOOutput> getDlcs()
    {
        return dlcs;

    }

    public void setDlcs(List<ProdutoTOOutput> dlcs)
    {
        this.dlcs = dlcs;

    }

}
