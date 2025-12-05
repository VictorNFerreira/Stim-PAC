package br.cefetrj.transfer_objects.output;

import br.cefetrj.model.Conta;

public class ContaTOOutput
{
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private double saldo;
    private String papel;
    private BibliotecaTOOutput biblioteca;

    public ContaTOOutput(Conta conta)
    {
        this.id = conta.getId();
        this.nome = conta.getNome();
        this.email = conta.getEmail();
        this.senha = conta.getSenha();
        this.saldo = conta.getSaldo();
        this.papel = conta.getPapel();
        if(conta.getBiblioteca() != null)
            this.biblioteca = new BibliotecaTOOutput(conta.getBiblioteca());

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

    public String getEmail()
    {
        return email;

    }

    public void setEmail(String email)
    {
        this.email = email;

    }

    public String getSenha()
    {
        return senha;

    }

    public void setSenha(String senha)
    {
        this.senha = senha;

    }

    public double getSaldo()
    {
        return saldo;

    }

    public void setSaldo(double saldo)
    {
        this.saldo = saldo;

    }

    public String getPapel()
    {
        return papel;
        
    }

    public void setPapel(String papel)
    {
        this.papel = papel;

    }

    public BibliotecaTOOutput getBiblioteca()
    {
        return biblioteca;

    }

    public void setBiblioteca(BibliotecaTOOutput biblioteca)
    {
        this.biblioteca = biblioteca;

    }

}
