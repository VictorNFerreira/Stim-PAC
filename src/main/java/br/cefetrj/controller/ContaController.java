package br.cefetrj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.cefetrj.model.Conta;
import br.cefetrj.service.ContaService;
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

    @Autowired
    public ContaController(ContaService contaService)
    {
        this.contaService = contaService;

    }
    
    @PostMapping
    @ApiOperation(value = "Adicionar conta", notes = "Adiciona uma nova conta no banco de dados")
    public ResponseEntity<ContaTOOutput> adicionar(@RequestBody ContaTOInput input)
    {
        Conta conta = input.build();
        conta.setSaldo(0);
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

}
