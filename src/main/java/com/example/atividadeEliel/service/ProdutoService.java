package com.example.atividadeEliel.service;

import com.example.atividadeEliel.model.Cliente;
import com.example.atividadeEliel.model.Produto;
import com.example.atividadeEliel.repository.ClienteRepository;
import com.example.atividadeEliel.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto save(Produto produto){
        return repository.save(produto);
    }

    public List<Produto> findAll(){
        return repository.findAll();
    }
    public Produto findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public Produto update(Long id, Produto produto) {
        Produto produtoExistente = findById(id);
        produtoExistente.setNome(produto.getNome());
        produtoExistente.setPreco(produto.getPreco());
        return repository.save(produtoExistente);
    }

    public void delete(Long id) {
        Produto produto = findById(id);
        repository.delete(produto);
    }

}
