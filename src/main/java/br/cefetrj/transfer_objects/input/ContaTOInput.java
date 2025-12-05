package br.cefetrj.transfer_objects.input;

import java.io.Serializable;

import br.cefetrj.model.Conta;

public class ContaTOInput implements Serializable
{
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private String papel;

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

    public String getPapel()
    {
        return papel;

    }

    public void setPapel(String papel)
    {
        this.papel = papel;

    }

    public Conta build()
    {
        Conta conta = new Conta();
        conta.setId(this.id);
        conta.setNome(this.nome);
        conta.setEmail(this.email);
        conta.setSenha(this.senha);
        conta.setPapel(this.papel);
        return conta;

    }

    
    
}
