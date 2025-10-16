package br.cefetrj.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("jogo")
public class Jogo extends Produto
{
    @Column(name = "genero")
    private String genero;

    @OneToMany(targetEntity = Dlc.class, mappedBy = "jogoAssociado", fetch = FetchType.EAGER)
    private List<Dlc> dlcs = new ArrayList<Dlc>();

    public Jogo()
    {
        super();

    }

    public Jogo(String nome, Desenvolvedora desenvolvedora, Distribuidora distribuidora, String genero)
    {
        super(nome, desenvolvedora, distribuidora);
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

    public void setDlcs(List<Dlc> dlcs)
    {
        this.dlcs = dlcs;
        
    }

}
