package br.univille.fsoweb20242yan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.univille.fsoweb20242yan.entity.Cliente;
import br.univille.fsoweb20242yan.service.ClienteService;
import br.univille.fsoweb20242yan.service.RelatorioProgressoService;

public class RelatorioController {

    @Autowired
    private RelatorioProgressoService relatorioService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/relatorio/diario")
    public String realtorioDiario(@RequestParam long clienteId, Model model){
        Cliente cliente = clienteService.getById(clienteId);
        model.addAttribute("relatorio", relatorioService.gerarRelatorioDiario(cliente));
        return "relatorio/diario";
    }

    @GetMapping("/relatorio/semanal")
    public String relatorioSemanal(@RequestParam long clienteId, Model model){
        Cliente cliente = clienteService.getById(clienteId);
        model.addAttribute("relatorio", relatorioService.gerarRelatorioSemanal(cliente));
        return "relatorio/semanal";
    }

    @GetMapping("/relatorio/mensal")
    public String relatorioMensal(@RequestParam long clienteId, Model model){
        Cliente cliente = clienteService.getById(clienteId);
        model.addAttribute("relatorio", relatorioService.gerarRelatorioMensal(cliente));
        return "relatorio/mensal";
    }
}
