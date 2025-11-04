package br.cefetrj.transfer_objects.input;

import br.cefetrj.model.Desenvolvedora;
import br.cefetrj.model.Distribuidora;
import br.cefetrj.model.Empresa;

public class EmpresaTOInput
{
    private Integer id;
    private String nome;
    private String tipo;

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

    public Empresa build()
    {
        if(tipo.equals("desenvolvedora"))
        {
            Desenvolvedora empresa = new Desenvolvedora();
            empresa.setId(id);
            empresa.setNome(nome);
            return empresa;

        }

        else if(tipo.equals("distribuidora"))
        {
            Distribuidora empresa = new Distribuidora();
            empresa.setId(id);
            empresa.setNome(nome);
            return empresa;

        }

        else
            return null;

    }
    
}
