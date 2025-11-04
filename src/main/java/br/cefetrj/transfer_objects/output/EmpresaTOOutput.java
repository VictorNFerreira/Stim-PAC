package br.cefetrj.transfer_objects.output;

import br.cefetrj.model.Empresa;

public class EmpresaTOOutput
{
    private Integer id;
    private String nome;
    private String tipo;

    public EmpresaTOOutput(Empresa empresa)
    {
        this.id = empresa.getId();
        this.nome = empresa.getNome();
        this.tipo = empresa.getClass().getSimpleName();

    }

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

}
