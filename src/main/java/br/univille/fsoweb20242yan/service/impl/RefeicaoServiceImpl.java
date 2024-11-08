package br.univille.fsoweb20242yan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.fsoweb20242yan.entity.Refeicao;
import br.univille.fsoweb20242yan.repository.RefeicaoRepository;
import br.univille.fsoweb20242yan.service.RefeicaoService;

@Service
public class RefeicaoServiceImpl implements RefeicaoService {

    @Autowired
    private RefeicaoRepository refeicaoRepository;

    @Override
    public Refeicao registrarRefeicao(Refeicao refeicao) {
        return refeicaoRepository.save(refeicao);
    }

    @Override
    public List<Refeicao> listarRefeicoesPorCliente(Long clienteId) {
        return refeicaoRepository.findByClienteId(clienteId);
    }

    @Override
    public void deletarRefeicao(Long id) {
        refeicaoRepository.deleteById(id);
    }
}
