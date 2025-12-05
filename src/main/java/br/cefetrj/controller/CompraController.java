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

import br.cefetrj.model.Compra;
import br.cefetrj.model.Conta;
import br.cefetrj.model.Jogo;
import br.cefetrj.model.Produto;
import br.cefetrj.service.CompraService;
import br.cefetrj.service.ContaService;
import br.cefetrj.service.ProdutoService;
import br.cefetrj.transfer_objects.input.CompraTOInput;
import br.cefetrj.transfer_objects.output.CompraTOOutput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/compras", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "/compras", tags = {"Compras - CompraController"})
public class CompraController
{
    private final CompraService compraService;
    private final ProdutoService produtoService;
    private final ContaService contaService;

    @Autowired
    public CompraController(CompraService compraService, ProdutoService produtoService, ContaService contaService)
    {
        this.compraService = compraService;
        this.produtoService = produtoService;
        this.contaService = contaService;

    }
    
    @PostMapping
    @ApiOperation(value = "Adicionar compra", notes = "Adiciona uma nova compra no banco de dados")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<CompraTOOutput> adicionar(@RequestBody CompraTOInput input)
    {
        Compra compra = input.build();
        Produto produto = produtoService.listarPorId(input.getProduto().getId()).orElse(null);
        Conta conta = contaService.listarPorId(input.getConta().getId()).orElse(null);

        compra.setProduto(produto);
        compra.setConta(conta);
        if(compra.getProduto() instanceof Jogo)
        {
            compra.getConta().getBiblioteca().getJogos().add((Jogo) compra.getProduto());
            compra.getConta().getBiblioteca().setQuantidadeItens(compra.getConta().getBiblioteca().getQuantidadeItens() + 1);
        }
        
        compra = compraService.adicionar(compra);
        return new ResponseEntity<>(new CompraTOOutput(compra), HttpStatus.CREATED);

    }

    @GetMapping
    @ApiOperation(value = "Listar compras", notes = "Retorna todas as compras")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<List<CompraTOOutput>>listar()
    {
        return ResponseEntity.ok(compraService.listar().stream().map(CompraTOOutput::new).toList());

    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Listar por ID", notes = "Retorna uma compra de acordo com o ID passado")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<CompraTOOutput> listarPorId(@PathVariable("id") Integer id)
    {
        return ResponseEntity.ok(new CompraTOOutput(compraService.listarPorId(id).orElse(null)));

    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Atualizar compra", notes = "Atualiza uma compra de acordo com o ID passado")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<CompraTOOutput> editar(@RequestBody CompraTOInput input)
    {
        Compra compra = compraService.editar(input.build());
        return new ResponseEntity<>(new CompraTOOutput(compra), HttpStatus.OK);

    }

    @DeleteExchange(value = "/{id}")
    @ApiOperation(value = "Deletar compra", notes = "Remove uma compra de acordo com o ID passado")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<Void> deletar(@PathVariable("id") Integer id)
    {
        Compra compra = compraService.listarPorId(id).orElse(null);

        if(compra.getProduto() instanceof Jogo)
        {
            compra.getConta().getBiblioteca().getJogos().remove((Jogo) compra.getProduto());
            compra.getConta().getBiblioteca().setQuantidadeItens(compra.getConta().getBiblioteca().getQuantidadeItens() - 1);

        }

        compraService.deletar(id);
        return ResponseEntity.noContent().build();

    }

}
