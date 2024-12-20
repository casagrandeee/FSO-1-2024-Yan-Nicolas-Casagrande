package br.univille.fsoweb20242yan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.fsoweb20242yan.entity.Pedido;
import br.univille.fsoweb20242yan.repository.PedidoRepository;
import br.univille.fsoweb20242yan.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Override
    public List<Pedido> getAll() {
        return repository.findAll();
    }

    @Override
    public Pedido save(Pedido pedido) {
        return repository.save(pedido);
    }

    @Override
    public Pedido delete(long id) {
        Pedido pedido = getById(id);
        if (pedido != null) {
            repository.delete(pedido);
        }
        return pedido;
    }

    @Override
    public Pedido getById(long id) {
        return repository.findById(id).orElse(null); //Retorna o pedido pelo ID
    }
}