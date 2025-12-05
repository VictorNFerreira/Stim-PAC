package br.cefetrj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import br.cefetrj.model.Biblioteca;
import br.cefetrj.service.BibliotecaService;
import br.cefetrj.transfer_objects.input.BibliotecaTOInput;
import br.cefetrj.transfer_objects.output.BibliotecaTOOutput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/bibliotecas", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "/bibliotecas", tags = {"Bibliotecas - BibliotecaController"})
public class BibliotecaController
{
    private final BibliotecaService bibliotecaService;

    @Autowired
    public BibliotecaController(BibliotecaService bibliotecaService)
    {
        this.bibliotecaService = bibliotecaService;

    }
    
    @PostMapping
    @ApiOperation(value = "Adicionar biblioteca", notes = "Adiciona uma nova biblioteca no banco de dados")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<BibliotecaTOOutput> adicionar(@RequestBody BibliotecaTOInput input)
    {
        Biblioteca biblioteca = input.build();
        biblioteca.setQuantidadeItens(0);
        
        biblioteca = bibliotecaService.adicionar(biblioteca);
        return new ResponseEntity<>(new BibliotecaTOOutput(biblioteca), HttpStatus.CREATED);

    }

    @GetMapping
    @ApiOperation(value = "Listar bibliotecas", notes = "Retorna todas as bibliotecas")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<List<BibliotecaTOOutput>>listar()
    {
        return ResponseEntity.ok(bibliotecaService.listar().stream().map(BibliotecaTOOutput::new).toList());

    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Listar por ID", notes = "Retorna uma biblioteca de acordo com o ID passado")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<BibliotecaTOOutput> listarPorId(@PathVariable("id") Integer id)
    {
        return ResponseEntity.ok(new BibliotecaTOOutput(bibliotecaService.listarPorId(id).orElse(null)));

    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Atualizar biblioteca", notes = "Atualiza uma biblioteca de acordo com o ID passado")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<BibliotecaTOOutput> editar(@RequestBody BibliotecaTOInput input)
    {
        Biblioteca biblioteca = bibliotecaService.editar(input.build());
        return new ResponseEntity<>(new BibliotecaTOOutput(biblioteca), HttpStatus.OK);

    }

    @DeleteExchange(value = "/{id}")
    @ApiOperation(value = "Deletar biblioteca", notes = "Remove uma biblioteca de acordo com o ID passado")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<Void> deletar(@PathVariable("id") Integer id)
    {
        bibliotecaService.deletar(id);
        return ResponseEntity.noContent().build();

    }

}
