package br.univille.fsoweb20242yan.service;

import java.util.List;

import br.univille.fsoweb20242yan.entity.Refeicao;

public interface RefeicaoService {
    Refeicao registrarRefeicao(Refeicao refeicao);
    List<Refeicao> listarRefeicoesPorCliente(Long clienteId);
    void deletarRefeicao(Long id);
}
