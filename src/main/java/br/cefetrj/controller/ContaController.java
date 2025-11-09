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

import br.cefetrj.model.Biblioteca;
import br.cefetrj.model.Conta;
import br.cefetrj.service.BibliotecaService;
import br.cefetrj.service.ContaService;
import br.cefetrj.transfer_objects.input.BibliotecaTOInput;
import br.cefetrj.transfer_objects.input.ContaTOInput;
import br.cefetrj.transfer_objects.output.ContaTOOutput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/contas", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "/contas", tags = {"Contas - ContaController"})
public class ContaController
{
    private final ContaService contaService;
    private final BibliotecaService bibliotecaService;

    @Autowired
    public ContaController(ContaService contaService, BibliotecaService bibliotecaService)
    {
        this.contaService = contaService;
        this.bibliotecaService = bibliotecaService;

    }
    
    @PostMapping
    @ApiOperation(value = "Adicionar conta", notes = "Adiciona uma nova conta no banco de dados")
    public ResponseEntity<ContaTOOutput> adicionar(@RequestBody ContaTOInput input)
    {
        Conta conta = input.build();
        Biblioteca biblioteca = new BibliotecaTOInput().build();

        conta.setSaldo(0);
        biblioteca.setConta(conta);
        conta.setBiblioteca(biblioteca);
        biblioteca = bibliotecaService.adicionar(biblioteca);

        conta = contaService.adicionar(conta);
        return new ResponseEntity<>(new ContaTOOutput(conta), HttpStatus.CREATED);

    }

    @GetMapping
    @ApiOperation(value = "Listar contas", notes = "Retorna todas as contas")
    public ResponseEntity<List<ContaTOOutput>>listar()
    {
        return ResponseEntity.ok(contaService.listar().stream().map(ContaTOOutput::new).toList());

    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Listar por ID", notes = "Retorna uma conta de acordo com o ID passado")
    public ResponseEntity<ContaTOOutput> listarPorId(@PathVariable("id") Integer id)
    {
        return ResponseEntity.ok(new ContaTOOutput(contaService.listarPorId(id).orElse(null)));

    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Atualizar conta", notes = "Atualiza uma conta existente no banco de dados")
    public ResponseEntity<ContaTOOutput> editar(@RequestBody ContaTOInput input)
    {
        Conta conta = contaService.editar(input.build());
        return new ResponseEntity<>(new ContaTOOutput(conta), HttpStatus.OK);

    }

    @DeleteExchange(value = "/{id}")
    @ApiOperation(value = "Deletar conta", notes = "Remove a conta de acordo com o ID passado")
    public ResponseEntity<Void> deletar(@PathVariable("id") Integer id)
    {   
        bibliotecaService.deletar(id);
        contaService.deletar(id);
        return ResponseEntity.noContent().build();

    }

}
