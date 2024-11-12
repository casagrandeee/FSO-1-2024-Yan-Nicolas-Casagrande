package br.univille.fsoweb20242yan.service;

import java.util.Map;

import br.univille.fsoweb20242yan.entity.Cliente;

public interface RelatorioProgressoService {
    Map<String, Object> gerarRelatorioDiario(Cliente cliente);
    Map<String, Object> gerarRelatorioSemanal(Cliente cliente);
    Map<String, Object> gerarRelatorioMensal(Cliente cliente);

}
