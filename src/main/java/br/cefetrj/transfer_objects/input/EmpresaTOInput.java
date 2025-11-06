package br.cefetrj.transfer_objects.input;

import java.io.Serializable;

import br.cefetrj.model.Desenvolvedora;
import br.cefetrj.model.Distribuidora;
import br.cefetrj.model.Empresa;

public class EmpresaTOInput implements Serializable
{
    private Integer id;
    private String nome;
    private String tipo;

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

    public Empresa build()
    {
        if(this.tipo.equals("desenvolvedora"))
        {
            Desenvolvedora empresa = new Desenvolvedora();
            empresa.setId(this.id);
            empresa.setNome(this.nome);
            return empresa;

        }

        else if(this.tipo.equals("distribuidora"))
        {
            Distribuidora empresa = new Distribuidora();
            empresa.setId(this.id);
            empresa.setNome(this.nome);
            return empresa;

        }

        else
            return null;

    }
    
}
