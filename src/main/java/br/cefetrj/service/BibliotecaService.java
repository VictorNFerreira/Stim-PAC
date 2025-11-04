package br.cefetrj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.cefetrj.model.Biblioteca;
import br.cefetrj.repository.BibliotecaRepository;

@Service
public class BibliotecaService
{
    protected BibliotecaRepository repositorio;

    public BibliotecaService(BibliotecaRepository repositorio)
    {
        this.repositorio = repositorio;

    }

    public Biblioteca adicionar(Biblioteca biblioteca)
    {
        return repositorio.save(biblioteca);

    }

    public List<Biblioteca> listar()
    {
        return repositorio.findAll();

    }

    public Optional<Biblioteca> listarPorId(Integer id)
    {
        return repositorio.findById(id);

    }

    public Biblioteca editar(Biblioteca biblioteca)
    {
        return repositorio.save(biblioteca);

    }

    public void deletar(Integer id)
    {
        repositorio.deleteById(id);

    }

}
