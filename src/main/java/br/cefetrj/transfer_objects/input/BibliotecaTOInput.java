package br.cefetrj.transfer_objects.input;

import java.io.Serializable;

import br.cefetrj.model.Biblioteca;

public class BibliotecaTOInput implements Serializable
{
    private Integer id;

    public Integer getId()
    {
        return this.id;

    }

    public void setId(Integer id)
    {
        this.id = id;
        
    }

    public Biblioteca build()
    {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setId(this.id);
        return biblioteca;

    }

}
