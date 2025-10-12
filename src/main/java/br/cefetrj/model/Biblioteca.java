package br.cefetrj.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="biblioteca")
public class Biblioteca extends Entidade
{
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Conta conta;

    @Transient
    private List<Jogo> jogos;

    @Column(name = "quantidade_itens")
    private int quantidadeItens;

    public Conta getConta()
    {
        return this.conta;

    }

    public void setConta(Conta conta)
    {
        this.conta = conta;

    }

    public List<Jogo> getJogos()
    {
        return this.jogos;

    }

    public void setJogos(List<Jogo> jogos)
    {
        this.jogos = jogos;

    }

    public int getQuantidadeItens()
    {
        return this.quantidadeItens;

    }

    public void setQuantidadeItens(int quantidadeItens)
    {
        this.quantidadeItens = quantidadeItens;
        
    }
    
}
