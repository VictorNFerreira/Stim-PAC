package br.cefetrj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.cefetrj.model.Produto;
import br.cefetrj.repository.ProdutoRepository;

@Service
public class ProdutoService
{
    protected ProdutoRepository repositorio;

    public ProdutoService(ProdutoRepository repositorio)
    {
        this.repositorio = repositorio;

    }

    public Produto adicionar(Produto produto)
    {
        return repositorio.save(produto);

    }

    public List<Produto> listar()
    {
        return repositorio.findAll();

    }

    public Optional<Produto> listarPorId(Integer id)
    {
        return repositorio.findById(id);

    }

    public Produto editar(Produto produto)
    {
        return repositorio.save(produto);

    }

    public void deletar(Integer id)
    {
        repositorio.deleteById(id);

    }

}
