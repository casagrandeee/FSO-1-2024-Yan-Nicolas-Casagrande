package br.univille.fsoweb20242yan.service;

import java.util.List;

import br.univille.fsoweb20242yan.entity.Receita;

public interface ReceitaService {
    List<Receita> sugerirReceitas(String preferenciasAlimentares);
}
