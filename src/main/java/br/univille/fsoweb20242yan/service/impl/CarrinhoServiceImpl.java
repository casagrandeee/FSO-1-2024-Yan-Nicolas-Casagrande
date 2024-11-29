package br.univille.fsoweb20242yan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.fsoweb20242yan.entity.CarrinhoItem;
import br.univille.fsoweb20242yan.entity.Produto;
import br.univille.fsoweb20242yan.repository.CarrinhoRepository;
import br.univille.fsoweb20242yan.service.CarrinhoService;

@Service
public class CarrinhoServiceImpl implements CarrinhoService {

    @Autowired
    private CarrinhoRepository repository;

    @Override
    public List<CarrinhoItem> getAll() {
        return repository.findAll();
    }

    @Override
    public List<CarrinhoItem> getItens() {
        return getAll();
    }

    @Override
    public CarrinhoItem addItem(CarrinhoItem item) {
        return repository.save(item);
    }

    @Override
    public CarrinhoItem updateItem(CarrinhoItem item) {
        return repository.save(item);
    }

    @Override
    public void removeItem(long id) {
        repository.deleteById(id);
    }

    @Override
    public double calcularTotal() {
        return repository.findAll()
                         .stream()
                         .mapToDouble(item -> item.getQuantidade() * item.getValor())
                         .sum(); //calcula o total do carrinho
    }

    @Override
    public void adicionarItem(Produto produto, int quantidade) {
        var itens = repository.findAll();
        for (CarrinhoItem item : itens) {
            if (item.getProduto().getId() == produto.getId()) {
                item.setQuantidade(item.getQuantidade() + quantidade);
                repository.save(item);
                return;
            }
        }
        CarrinhoItem novoItem = new CarrinhoItem();
        novoItem.setProduto(produto);
        novoItem.setQuantidade(quantidade);
        novoItem.setValor(produto.getValor());
        repository.save(novoItem);
    }

    @Override
    public void atualizarQuantidade(long produtoId, int quantidade) {
        var itens = repository.findAll();
        for (CarrinhoItem item : itens) {
            if (item.getProduto().getId() == produtoId) {
                item.setQuantidade(quantidade);
                repository.save(item);
                return;
            }
        }
    }

    @Override
    public void removerItem(long produtoId) {
        var itens = repository.findAll();
        for (CarrinhoItem item : itens) {
            if (item.getProduto().getId() == produtoId) {
                repository.delete(item);
                return;
            }
        }
    }
}