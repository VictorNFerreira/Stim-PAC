package br.cefetrj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import br.cefetrj.model.Empresa;
import br.cefetrj.service.EmpresaService;
import br.cefetrj.transfer_objects.input.EmpresaTOInput;
import br.cefetrj.transfer_objects.output.EmpresaTOOutput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/empresas", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "/empresas", tags = {"Empresas - EmpresaController"})
public class EmpresaController
{
    private final EmpresaService empresaService;

    @Autowired
    public EmpresaController(EmpresaService empresaService)
    {
        this.empresaService = empresaService;

    }
    
    @PostMapping
    @ApiOperation(value = "Adicionar empresa", notes = "Adiciona uma nova empresa no banco de dados")
    public ResponseEntity<EmpresaTOOutput> adicionar(@RequestBody EmpresaTOInput input)
    {
        Empresa empresa = input.build();
  
        empresa = empresaService.adicionar(empresa);
        return new ResponseEntity<>(new EmpresaTOOutput(empresa), HttpStatus.CREATED);

    }

    @GetMapping
    @ApiOperation(value = "Listar empresas", notes = "Retorna todas as empresas")
    public ResponseEntity<List<EmpresaTOOutput>>listar()
    {
        return ResponseEntity.ok(empresaService.listar().stream().map(EmpresaTOOutput::new).toList());

    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Listar por ID", notes = "Retorna uma empresa de acordo com o ID passado")
    public ResponseEntity<EmpresaTOOutput> listarPorId(@PathVariable("id") Integer id)
    {
        return ResponseEntity.ok(new EmpresaTOOutput(empresaService.listarPorId(id).orElse(null)));

    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Atualizar empresa", notes = "Atualiza uma empresa de acordo com o ID passado")
    public ResponseEntity<EmpresaTOOutput> editar(@RequestBody EmpresaTOInput input)
    {
        Empresa empresa = empresaService.editar(input.build());
        return new ResponseEntity<>(new EmpresaTOOutput(empresa), HttpStatus.OK);

    }

    @DeleteExchange(value = "/{id}")
    @ApiOperation(value = "Deletar empresa", notes = "Remove uma empresa de acordo com o ID passado")
    public ResponseEntity<Void> deletar(@PathVariable("id") Integer id)
    {
        empresaService.deletar(id);
        return ResponseEntity.noContent().build();

    }

}
