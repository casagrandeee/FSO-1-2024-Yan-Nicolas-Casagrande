package br.univille.fsoweb20242.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.fsoweb20242yan.entity.Cliente;
import br.univille.fsoweb20242yan.entity.PlanoAlimentar;
import br.univille.fsoweb20242yan.entity.Receita;
import br.univille.fsoweb20242yan.entity.Refeicao;
import br.univille.fsoweb20242yan.repository.ClienteRepository;
import br.univille.fsoweb20242yan.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<Cliente> getAll() {
        return repository.findAll();
    }

    @Override
    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public Cliente delete(long id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Cliente getById(long id) {
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public String sugerirMetaNutricional(Cliente cliente) {
        throw new UnsupportedOperationException("Unimplemented method 'sugerirMetaNutricional'");
    }

    @Override
    public PlanoAlimentar criarPlanoAlimentar(Cliente cliente, PlanoAlimentar planoAlimentar) {
        throw new UnsupportedOperationException("Unimplemented method 'criarPlanoAlimentar'");
    }

    @Override
    public Refeicao registrarRefeicao(Cliente cliente, Refeicao refeicao) {
        throw new UnsupportedOperationException("Unimplemented method 'registrarRefeicao'");
    }

    @Override
    public PlanoAlimentar atualizarPlanoAlimentar(Cliente cliente) {
        throw new UnsupportedOperationException("Unimplemented method 'atualizarPlanoAlimentar'");
    }

    @Override
    public List<Receita> sugerirReceitas(Cliente cliente) {
        throw new UnsupportedOperationException("Unimplemented method 'sugerirReceitas'");
    }

    

     
}