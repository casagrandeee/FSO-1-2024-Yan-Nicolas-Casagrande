package br.univille.fsoweb20242yan.service;

import java.util.List;

import br.univille.fsoweb20242yan.entity.Produto;

public interface ProdutoService {
    List<Produto> getAll();
    Produto save(Produto produto);
    Produto delete(long id);
    Produto getById(long id);
}
