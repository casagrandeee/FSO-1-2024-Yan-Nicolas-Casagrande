package br.univille.fsoweb20242yan.service;

import java.util.List;

import br.univille.fsoweb20242yan.entity.Pedido;

public interface PedidoService {
    List<Pedido> getAll();
    Pedido save(Pedido pedido);
    Pedido delete(long id);
    Pedido getById(long id);
}
