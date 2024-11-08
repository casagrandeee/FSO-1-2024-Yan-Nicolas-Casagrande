package br.univille.fsoweb20242yan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.fsoweb20242yan.entity.Receita;
import br.univille.fsoweb20242yan.repository.ReceitaRepository;
import br.univille.fsoweb20242yan.service.ReceitaService;

@Service
public class ReceitaServiceImpl implements ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    @Override
    public List<Receita> sugerirReceitas(String preferenciasAlimentares) {
        return receitaRepository.findByPreferencias(preferenciasAlimentares);
    }
}