package br.cefetrj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.cefetrj.model.Conta;
import br.cefetrj.repository.ContaRepository;

@Service
public class ContaService
{
    protected ContaRepository repositorio;

    public ContaService(ContaRepository repositorio)
    {
        this.repositorio = repositorio;

    }

    public Conta adicionar(Conta conta)
    {
        return repositorio.save(conta);

    }

    public List<Conta> listar()
    {
        return repositorio.findAll();

    }

    public Optional<Conta> listarPorId(Integer id)
    {
        return repositorio.findById(id);

    }

    public Conta editar(Conta conta)
    {
        return repositorio.save(conta);

    }

    public void deletar(Integer id)
    {
        repositorio.deleteById(id);

    }

}
