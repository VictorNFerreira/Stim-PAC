package br.cefetrj.model;

import jakarta.persistence.*;

@Entity
@Table(name = "empresa")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Empresa extends Entidade
{
    @Column(name = "nome")
    protected String nome;

    public Empresa()
    {

    }

    public Empresa(String nome)
    {
        this.setNome(nome);

    }

    public String getNome()
    {
        return this.nome;

    }

    public void setNome(String nome)
    {
        this.nome = nome;

    }
    
}
