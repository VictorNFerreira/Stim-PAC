package br.cefetrj.model;

import java.util.ArrayList;
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "biblioteca_jogo", joinColumns = @JoinColumn(name = "biblioteca_id"), inverseJoinColumns = @JoinColumn(name = "jogo_id"))
    private List<Jogo> jogos = new ArrayList<Jogo>();

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
