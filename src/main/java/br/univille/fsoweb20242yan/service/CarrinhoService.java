package br.univille.fsoweb20242yan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.fsoweb20242yan.entity.ItemPedido;
import br.univille.fsoweb20242yan.entity.Produto;

@Service
public class CarrinhoService {

    private final List<ItemPedido> itens = new ArrayList<>();

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        for (ItemPedido item : itens) {
            if (item.getProduto().getId() == produto.getId()) {
                item.setQuantidade(item.getQuantidade() + quantidade);
                return;
            }
        }
        ItemPedido novoItem = new ItemPedido();
        novoItem.setProduto(produto);
        novoItem.setQuantidade(quantidade);
        novoItem.setValor(produto.getValor());
        itens.add(novoItem);
    }

    public void atualizarQuantidade(long produtoId, int quantidade) {
        for (ItemPedido item : itens) {
            if (item.getProduto().getId() == produtoId) {
                item.setQuantidade(quantidade);
                return;
            }
        }
    }

    public void removerItem(long produtoId) {
        itens.removeIf(item -> item.getProduto().getId() == produtoId);
    }

    public double calcularTotal() {
        return itens.stream()
                    .mapToDouble(item -> item.getQuantidade() * item.getValor())
                    .sum();
    }
}