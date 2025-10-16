package br.cefetrj.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("dlc")
public class Dlc extends Produto
{
    @ManyToOne
    private Jogo jogoAssociado;

    public Dlc()
    {
        super();

    }

    public Dlc(String nome, Desenvolvedora desenvolvedora, Distribuidora distribuidora, Jogo jogoAssociado)
    {
        super(nome, desenvolvedora, distribuidora);
        this.setJogoAssociado(jogoAssociado);

    }

    public Jogo getJogoAssociado()
    {
        return this.jogoAssociado;

    }

    public void setJogoAssociado(Jogo jogoAssociado)
    {
        this.jogoAssociado = jogoAssociado;

    }

}
