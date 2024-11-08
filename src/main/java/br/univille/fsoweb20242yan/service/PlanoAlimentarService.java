package br.univille.fsoweb20242yan.service;

import java.util.List;

import br.univille.fsoweb20242yan.entity.PlanoAlimentar;

public interface PlanoAlimentarService {
    PlanoAlimentar criarPlano(PlanoAlimentar planoAlimentar);
    List<PlanoAlimentar> listarPlanosPorCliente(Long clienteId);
    void deletarPlano(Long id);
    PlanoAlimentar obterPlanoPorCliente(long id);
}