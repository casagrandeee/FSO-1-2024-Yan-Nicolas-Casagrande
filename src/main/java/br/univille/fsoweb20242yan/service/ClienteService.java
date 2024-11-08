package br.univille.fsoweb20242yan.service;

import java.util.List;

import br.univille.fsoweb20242yan.entity.Cliente;
import br.univille.fsoweb20242yan.entity.PlanoAlimentar;
import br.univille.fsoweb20242yan.entity.Receita;
import br.univille.fsoweb20242yan.entity.Refeicao;

public interface ClienteService {
    List<Cliente> getAll();
    Cliente save(Cliente cliente);
    Cliente delete(long id);
    Cliente getById(long id);

    String sugerirMetaNutricional(Cliente cliente);

    PlanoAlimentar criarPlanoAlimentar(Cliente cliente, PlanoAlimentar planoAlimentar);
    Refeicao registrarRefeicao(Cliente cliente, Refeicao refeicao);

    PlanoAlimentar atualizarPlanoAlimentar(Cliente cliente);
    List<Receita> sugerirReceitas(Cliente cliente);
}