package br.univille.fsoweb20242yan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.fsoweb20242yan.entity.Produto;
import br.univille.fsoweb20242yan.repository.ProdutoRepository;
import br.univille.fsoweb20242yan.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Override
    public List<Produto> getAll() {
        return repository.findAll();
    }

    @Override
    public Produto save(Produto produto) {
        return repository.save(produto);
    }

    @Override
    public Produto delete(long id) {
        var prod = getById(id);
        repository.delete(prod);
        return prod;
    }

    @Override
    public Produto getById(long id) {
        return repository.getById(id);
    }

    @Override
    public List<Produto> filtrarPorCategoriaEPreco(String categoria, float precoMin, float precoMax) {
        return repository.findByCategoriaAndValorBetween(categoria, precoMin, precoMax);
    }
    
}