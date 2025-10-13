package br.cefetrj.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@MappedSuperclass
public class Entidade
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private LocalDate dataCriacao;

    @Column(nullable = true)
    private LocalDate dataUltimaAlteracao;

    @ManyToOne(optional = true)
    private Conta criadoPor;

    @ManyToOne(optional = true)
    private Conta alteradoPor;

    public Integer getId()
    {
        return this.id;

    }

    public void setId(Integer id)
    {
        this.id = id;

    }

    public LocalDate getDataCriacao()
    {
        return dataCriacao;

    }

    public void setDataCriacao(LocalDate dataCriacao)
    {
        this.dataCriacao = dataCriacao;

    }

    public LocalDate getDataUltimaAlteracao()
    {
        return dataUltimaAlteracao;

    }

    public void setDataUltimaAlteracao(LocalDate dataUltimaAlteracao)
    {
        this.dataUltimaAlteracao = dataUltimaAlteracao;

    }

    public Conta getCriadoPor()
    {
        return criadoPor;

    }

    public void setCriadoPor(Conta criadoPor)
    {
        this.criadoPor = criadoPor;

    }

    public Conta getAlteradoPor()
    {
        return alteradoPor;

    }

    public void setAlteradoPor(Conta alteradoPor)
    {
        this.alteradoPor = alteradoPor;
        
    }

}
