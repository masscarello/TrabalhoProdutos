package com.vb.produto.Controllers;

import com.vb.produto.Models.ProdutoModel;
import com.vb.produto.Services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoModel> criarProduto(@RequestBody ProdutoModel produtoModel){
        ProdutoModel requeste = produtoService.criarProduto(produtoModel);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(produtoModel.getId())
                .toUri();
        return ResponseEntity.created(uri).body(requeste);
    }

    @DeleteMapping
    public ResponseEntity<?> excluirProduto(@PathVariable Long id){
        produtoService.excluirProduto(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> listarProdutos(){
        List<ProdutoModel> requeste = produtoService.listarProdutos();
        return ResponseEntity.ok().body(requeste);
    }

    @PutMapping
    public ResponseEntity<ProdutoModel> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoModel produtoModel){
        ProdutoModel requeste = produtoService.atualizarProduto(id, produtoModel);
        return ResponseEntity.ok().body(requeste);


    }




}
