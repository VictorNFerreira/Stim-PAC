package br.cefetrj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.cefetrj.model.Compra;
import br.cefetrj.repository.CompraRepository;

@Service
public class CompraService
{
    protected CompraRepository repositorio;

    public CompraService(CompraRepository repositorio)
    {
        this.repositorio = repositorio;

    }

    public Compra adicionar(Compra compra)
    {
        return repositorio.save(compra);

    }

    public List<Compra> listar()
    {
        return repositorio.findAll();

    }

    public Optional<Compra> listarPorId(Integer id)
    {
        return repositorio.findById(id);

    }

    public Compra editar(Compra compra)
    {
        return repositorio.save(compra);

    }

    public void deletar(Integer id)
    {
        repositorio.deleteById(id);

    }

}
