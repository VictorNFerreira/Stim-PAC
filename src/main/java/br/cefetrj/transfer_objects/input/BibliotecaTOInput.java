package br.cefetrj.transfer_objects.input;

import br.cefetrj.model.Biblioteca;

public class BibliotecaTOInput
{
    private Integer id;

    public Integer getId()
    {
        return id;

    }

    public void setId(Integer id)
    {
        this.id = id;
        
    }

    public Biblioteca build()
    {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setId(id);
        return biblioteca;

    }

}
