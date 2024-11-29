package br.univille.fsoweb20242yan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.fsoweb20242yan.entity.Avaliacao;
import br.univille.fsoweb20242yan.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository repository;

    public List<Avaliacao> findByProdutoId(long produtoId){
        return repository.findByProdutoId(produtoId);
    }

    public Avaliacao save(Avaliacao avaliacao){
        return repository.save(avaliacao);
    }
}
