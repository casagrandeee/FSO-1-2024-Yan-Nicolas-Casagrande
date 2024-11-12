package br.univille.fsoweb20242yan.service.impl;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.fsoweb20242yan.entity.Cliente;
import br.univille.fsoweb20242yan.entity.PlanoAlimentar;
import br.univille.fsoweb20242yan.entity.Receita;
import br.univille.fsoweb20242yan.entity.Refeicao;
import br.univille.fsoweb20242yan.repository.ClienteRepository;
import br.univille.fsoweb20242yan.service.ClienteService;
import br.univille.fsoweb20242yan.service.PlanoAlimentarService;
import br.univille.fsoweb20242yan.service.ReceitaService;
import br.univille.fsoweb20242yan.service.RefeicaoService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private PlanoAlimentarService planoAlimentarService;

    @Autowired
    private RefeicaoService refeicaoService;

    @Autowired
    private ReceitaService receitaService;

    @Override
    public List<Cliente> getAll() {
        return repository.findAll();
    }

    @Override
    public Cliente save(Cliente cliente) {
        repository.save(cliente);
        return cliente;
    }

    @Override
    public Cliente delete(long id) {
        var retorno = repository.findById(id);
        if (retorno.isPresent()) {
            repository.deleteById(id);
            return retorno.get();
        }
        return null;
    }

    @Override
    public Cliente getById(long id) {
        var retorno = repository.findById(id);
        if (retorno.isPresent())
            return retorno.get();
        return null;
    }

    @Override
    public String sugerirMetaNutricional(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo.");
        }
        int idade = calcularIdade(cliente);
        int metaCalorica = calcularMetaCalorica(cliente.getPeso(), cliente.getAltura(), idade);
        cliente.setMetaCalorias(metaCalorica);
        repository.save(cliente);
    
        return "Meta calórica sugerida: " + metaCalorica + " kcal";
    }

    private int calcularMetaCalorica(double peso, double altura, int idade) {
        return (int) ((10 * peso) + (6.25 * altura) - (5 * idade) + 5);
    }

    private int calcularIdade(Cliente cliente) {
        if (cliente.getDataNascimento() == null) {
            throw new IllegalArgumentException("Data de nascimento não pode ser nula para calcular a idade."); 
        }
        LocalDate nascimento = cliente.getDataNascimento().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        return Period.between(nascimento, LocalDate.now()).getYears();
    }

    @Override
    public PlanoAlimentar criarPlanoAlimentar(Cliente cliente, PlanoAlimentar planoAlimentar) {
        if (cliente == null || planoAlimentar == null) {
            throw new IllegalArgumentException("Cliente e Plano Alimentar não podem ser nulos.");
        }
        planoAlimentar.setCliente(cliente);
        return planoAlimentarService.criarPlano(planoAlimentar);
    }

    @Override
    public Refeicao registrarRefeicao(Cliente cliente, Refeicao refeicao) {
        if (cliente == null || refeicao == null) {
            throw new IllegalArgumentException("Cliente e Refeição não podem ser nulos.");
        }
        refeicao.setCliente(cliente);
        return refeicaoService.registrarRefeicao(refeicao);
    }

    @Override
    public PlanoAlimentar atualizarPlanoAlimentar(Cliente cliente) {
        PlanoAlimentar planoAtual = planoAlimentarService.obterPlanoPorCliente(cliente.getId());
        if (planoAtual == null) {
            throw new IllegalStateException("Nenhum plano alimentar encontrado para o cliente.");
        }
        planoAtual.setCaloriasDiarias(cliente.getMetaCalorias());
        planoAtual.setCarboidratos(cliente.getMetaCarboidratos());
        planoAtual.setProteinas(cliente.getMetaProteinas());
        planoAtual.setGorduras(cliente.getMetaGorduras());
        return planoAlimentarService.criarPlano(planoAtual);
    }

    @Override
    public List<Receita> sugerirReceitas(Cliente cliente) {
        return receitaService.sugerirReceitas(cliente.getPreferenciasAlimentares());
    }
}
