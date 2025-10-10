package br.cefetrj.model;

public class Dlc extends Produto
{
    private Jogo jogoAssociado;

    public Dlc(String nome, double preco, Jogo jogoAssociado)
    {
        super(nome, preco);
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
