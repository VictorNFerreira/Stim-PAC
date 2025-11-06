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

import br.cefetrj.model.Dlc;
import br.cefetrj.model.Jogo;
import br.cefetrj.model.Produto;
import br.cefetrj.service.ProdutoService;
import br.cefetrj.transfer_objects.input.ProdutoTOInput;
import br.cefetrj.transfer_objects.output.ProdutoTOOutput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "/produtos", tags = {"Produtos - ProdutoController"})
public class ProdutoController
{
    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService)
    {
        this.produtoService = produtoService;

    }

    @PostMapping
    @ApiOperation(value = "Adicionar produto", notes = "Adiciona um novo produto no banco de dados")
    public ResponseEntity<ProdutoTOOutput> adicionar(@RequestBody ProdutoTOInput input)
    {
        Produto produto = input.build();

        produto.setAvaliacoes(0);
        produto.getDesenvolvedora().getProdutosDesenvolvidos().add(produto);
        produto.getDistribuidora().getProdutosPublicados().add(produto);

        if(produto instanceof Dlc)
        {
            Dlc dlc = (Dlc) produto;
            Jogo jogoAssociado = (Jogo) produtoService.listarPorId(input.getJogoAssociado().getId()).orElse(null);
            dlc.setJogoAssociado(jogoAssociado);
            dlc.getJogoAssociado().getDlcs().add(dlc);

        }
  
        produto = produtoService.adicionar(produto);
        return new ResponseEntity<>(new ProdutoTOOutput(produto), HttpStatus.CREATED);

    }

    @GetMapping
    @ApiOperation(value = "Listar produtos", notes = "Retorna todos os produtos")
    public ResponseEntity<List<ProdutoTOOutput>>listar()
    {
        return ResponseEntity.ok(produtoService.listar().stream().map(ProdutoTOOutput::new).toList());

    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Listar por ID", notes = "Retorna um produto de acordo com o ID passado")
    public ResponseEntity<ProdutoTOOutput> listarPorId(@PathVariable("id") Integer id)
    {
        return ResponseEntity.ok(new ProdutoTOOutput(produtoService.listarPorId(id).orElse(null)));

    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Atualizar produto", notes = "Atualiza um produto de acordo com o ID passado")
    public ResponseEntity<ProdutoTOOutput> editar(@RequestBody ProdutoTOInput input)
    {
        Produto produto = produtoService.editar(input.build());
        return new ResponseEntity<>(new ProdutoTOOutput(produto), HttpStatus.OK);

    }

    @DeleteExchange(value = "/{id}")
    @ApiOperation(value = "Deletar produto", notes = "Remove um produto de acordo com o ID passado")
    public ResponseEntity<Void> deletar(@PathVariable("id") Integer id)
    {
        Produto produto = produtoService.listarPorId(id).orElse(null);
        produto.getDesenvolvedora().getProdutosDesenvolvidos().remove(produto);
        produto.getDistribuidora().getProdutosPublicados().remove(produto);

        produtoService.deletar(id);
        return ResponseEntity.noContent().build();

    }
    
}
