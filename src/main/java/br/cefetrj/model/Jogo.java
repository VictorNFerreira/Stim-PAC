package br.cefetrj.model;

import java.util.ArrayList;
import java.util.List;

public class Jogo extends Produto
{
    private String genero;
    private List<Dlc> dlcs = new ArrayList<Dlc>();

    public Jogo(String nome, double preco, String genero)
    {
        super(nome, preco);
        this.setGenero(genero);

    }

    public String getGenero()
    {
        return this.genero;

    }

    public void setGenero(String genero)
    {
        this.genero = genero;

    }

    public List<Dlc> getDlcs()
    {
        return this.dlcs;

    }

    public void adicionarDlc(Dlc dlc)
    {
        this.dlcs.add(dlc);

    }

    public void removerDlc(Dlc dlc)
    {
        this.dlcs.remove(dlc);

    }

}
