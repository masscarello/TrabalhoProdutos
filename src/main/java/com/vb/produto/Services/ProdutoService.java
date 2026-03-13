package com.vb.produto.Services;

import com.vb.produto.Models.ProdutoModel;
import com.vb.produto.Repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public void excluirProduto(@PathVariable Long id){
        produtoRepository.deleteById(id);

    }

    public ProdutoModel criarProduto(@RequestBody ProdutoModel produtoModel) {
        return produtoRepository.save(produtoModel);
    }

    public List<ProdutoModel> listarProdutos(){
        return produtoRepository.findAll();
    }

    public ProdutoModel atualizarProduto(Long id, ProdutoModel produtoModel){
        ProdutoModel produtoNovo = produtoRepository.findById(id).get();
        produtoNovo.setNome(produtoModel.getNome());
        return produtoRepository.save(produtoNovo);


    }




}
