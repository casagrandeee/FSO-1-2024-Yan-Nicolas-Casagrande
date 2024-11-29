package br.univille.fsoweb20242yan.service;

import java.util.List;

import br.univille.fsoweb20242yan.entity.CarrinhoItem;
import br.univille.fsoweb20242yan.entity.Produto;

public interface CarrinhoService {
    List<CarrinhoItem> getAll();
    CarrinhoItem addItem(CarrinhoItem item);
    CarrinhoItem updateItem(CarrinhoItem item);
    void removeItem(long id);
    List<CarrinhoItem> getItens();
    double calcularTotal();
    void adicionarItem(Produto produto, int quantidade);
    void atualizarQuantidade(long produtoId, int quantidade);
    void removerItem(long produtoId);
}