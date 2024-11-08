package br.univille.fsoweb20242yan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.fsoweb20242yan.entity.PlanoAlimentar;
import br.univille.fsoweb20242yan.repository.PlanoAlimentarRepository;
import br.univille.fsoweb20242yan.service.PlanoAlimentarService;

@Service
public class PlanoAlimentarServiceImpl implements PlanoAlimentarService {

    @Autowired
    private PlanoAlimentarRepository planoAlimentarRepository;

    @Override
    public PlanoAlimentar criarPlano(PlanoAlimentar planoAlimentar) {
        return planoAlimentarRepository.save(planoAlimentar);
    }

    @Override
    public List<PlanoAlimentar> listarPlanosPorCliente(Long clienteId) {
        return planoAlimentarRepository.findByClienteId(clienteId);
    }

    @Override
    public void deletarPlano(Long id) {
        planoAlimentarRepository.deleteById(id);
    }

    @Override
    public PlanoAlimentar obterPlanoPorCliente(long clienteId) {
        // Busca o plano mais recente de um cliente.
        return planoAlimentarRepository.findFirstByClienteId(clienteId)
                .orElse(null);
    }
}   
