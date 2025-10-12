package br.cefetrj.model;

import jakarta.persistence.*;

@Entity
@Table(name="conta")
public class Conta extends Entidade
{
    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "saldo")
    private double saldo;

    @OneToOne(mappedBy = "conta")
    private Biblioteca biblioteca;

    public Conta()
    {

    }

    public Conta(String nome, String email, String senha)
    {
        this.setNome(nome);
        this.setEmail(email);
        this.setSenha(senha);

    }

    public String getNome()
    {
        return this.nome;

    }

    public void setNome(String nome)
    {
        this.nome = nome;

    }

    public String getEmail()
    {
        return this.email;

    }

    public void setEmail(String email)
    {
        this.email = email;

    }

    public String getSenha()
    {
        return this.senha;

    }

    public void setSenha(String senha)
    {
        this.senha = senha;

    }
    
    public double getSaldo()
    {
        return this.saldo;

    }

    public void setSaldo(double saldo)
    {
        this.saldo = saldo;

    }

    public Biblioteca getBiblioteca()
    {
        return this.biblioteca;

    }

    public void setBiblioteca(Biblioteca biblioteca)
    {
        this.biblioteca = biblioteca;

    }
    
}
