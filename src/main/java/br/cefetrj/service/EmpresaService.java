package br.cefetrj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.cefetrj.model.Empresa;
import br.cefetrj.repository.EmpresaRepository;

@Service
public class EmpresaService
{
    protected EmpresaRepository repositorio;

    public EmpresaService(EmpresaRepository repositorio)
    {
        this.repositorio = repositorio;

    }

    public Empresa adicionar(Empresa empresa)
    {
        return repositorio.save(empresa);

    }

    public List<Empresa> listar()
    {
        return repositorio.findAll();

    }

    public Optional<Empresa> listarPorId(Integer id)
    {
        return repositorio.findById(id);

    }

    public Empresa editar(Empresa empresa)
    {
        return repositorio.save(empresa);

    }

    public void deletar(Integer id)
    {
        repositorio.deleteById(id);

    }

}
