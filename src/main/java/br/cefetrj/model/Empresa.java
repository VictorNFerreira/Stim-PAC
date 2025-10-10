package br.cefetrj.model;

import jakarta.persistence.*;

@Entity
@Table(name = "empresa")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Empresa
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;

    @Column(name = "nome")
    protected String nome;

    public Empresa()
    {

    }

    public Empresa(String nome)
    {
        this.setNome(nome);

    }
   
    public int getId()
    {
        return this.id;

    }

    public void setId(int id)
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
    
}
