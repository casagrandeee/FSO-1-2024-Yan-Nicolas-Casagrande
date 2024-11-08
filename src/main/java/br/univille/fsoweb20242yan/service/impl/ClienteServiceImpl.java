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
        int idade = calcularIdade(cliente);
        double peso = cliente.getPeso();
        double altura = cliente.getAltura();

        int metaCalorica = (int) ((10 * peso) + (6.25 * altura) - (5 * idade) + 5);
        cliente.setMetaCalorias(metaCalorica);
        repository.save(cliente);

        return "Meta calórica sugerida: " + metaCalorica + " kcal";
    }

    private int calcularIdade(Cliente cliente) {
        if (cliente.getDataNascimento() == null) {
            return 0;
        }
        LocalDate nascimento = cliente.getDataNascimento().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        return Period.between(nascimento, LocalDate.now()).getYears();
    }

    @Override
    public PlanoAlimentar criarPlanoAlimentar(Cliente cliente, PlanoAlimentar planoAlimentar) {
        planoAlimentar.setCliente(cliente);
        return planoAlimentarService.criarPlano(planoAlimentar);
    }

    @Override
    public Refeicao registrarRefeicao(Cliente cliente, Refeicao refeicao) {
        refeicao.setCliente(cliente);
        return refeicaoService.registrarRefeicao(refeicao);
    }

    @Override
    public PlanoAlimentar atualizarPlanoAlimentar(Cliente cliente) {
        //Implementação para atualizar plano com base em metas e progresso
        PlanoAlimentar planoAtual = planoAlimentarService.obterPlanoPorCliente(cliente.getId());
        if (planoAtual != null) {
            planoAtual.setCaloriasDiarias(cliente.getMetaCalorias());
            planoAtual.setCarboidratos(cliente.getMetaCarboidratos());
            planoAtual.setProteinas(cliente.getMetaProteinas());
            planoAtual.setGorduras(cliente.getMetaGorduras());
            return planoAlimentarService.criarPlano(planoAtual);
        }
        return null;
    }

    @Override
    public List<Receita> sugerirReceitas(Cliente cliente) {
        //Usa o serviço de receita para buscar sugestões com base nas preferências
        return receitaService.sugerirReceitas(cliente.getPreferenciasAlimentares());
    }
}