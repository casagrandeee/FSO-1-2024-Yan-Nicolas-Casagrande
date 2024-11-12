package br.univille.fsoweb20242yan.service.impl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.fsoweb20242yan.entity.Cliente;
import br.univille.fsoweb20242yan.entity.Refeicao;
import br.univille.fsoweb20242yan.repository.RefeicaoRepository;
import br.univille.fsoweb20242yan.service.RelatorioProgressoService;

@Service
public class RelatorioProgressoImpl implements RelatorioProgressoService{
    
    @Autowired
    private RefeicaoRepository refeicaoRepository;

    @Override
    public Map<String, Object> gerarRelatorioDiario(Cliente cliente){
        LocalDate hoje = LocalDate.now();
        var refeicoes = refeicaoRepository.findByClienteAndData(cliente, hoje);

        return calcularTotais(refeicoes);
    }

    @Override
    public Map<String, Object> gerarRelatorioSemanal(Cliente cliente){
        LocalDate hoje = LocalDate.now();
        LocalDate inicioSemana = hoje.minusDays(7);
        var refeicoes = refeicaoRepository.findByClienteAndDataBetween(cliente, inicioSemana, hoje);

        return calcularTotais(refeicoes);
    }

    @Override
    public Map<String, Object> gerarRelatorioMensal(Cliente cliente){
        LocalDate hoje = LocalDate.now();
        LocalDate inicioMes = hoje.minusDays(30);
        var refeicoes = refeicaoRepository.findByClienteAndDataBetween(cliente, inicioMes, hoje);

        return calcularTotais(refeicoes);
    }

    private Map<String, Object> calcularTotais(List<Refeicao> refeicoes){
        int totalCalorias = 0;
        int totalProteinas = 0;
        int totalCarboidratos = 0;
        int totalGorduras = 0;

        for (var refeicao : refeicoes){
            totalProteinas += refeicao.getProteinas();
            totalCarboidratos += refeicao.getCarboidratos();
            totalGorduras += refeicao.getGorduras();
            totalCalorias += refeicao.getCalorias();
        }

        Map<String, Object> relatorio = new HashMap<>();
        relatorio.put("TotalCalorias", totalCalorias);
        relatorio.put("TotalProteinas", totalProteinas);
        relatorio.put("TotalCarboidratos", totalCarboidratos);
        relatorio.put("TotalGorduras", totalGorduras);

        return relatorio;
    } 
}
