package br.univille.fsoweb20242yan.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.univille.fsoweb20242yan.entity.Avaliacao;
import br.univille.fsoweb20242yan.service.AvaliacaoService;
import br.univille.fsoweb20242yan.service.ClienteService;
import br.univille.fsoweb20242yan.service.ProdutoService;

@Controller
@RequestMapping("/avaliacoes")
public class AvaliacaoController {
    @Autowired
    private AvaliacaoService avaliacaoService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ModelAndView salvarAvaliacao(
            @RequestParam("produtoId") long produtoId,
            @RequestParam("nota") int nota,
            @RequestParam("comentario") String comentario) {
        var cliente = clienteService.getClienteLogado();
        var produto = produtoService.getById(produtoId);

        // Verificar se o cliente já avaliou o produto
        var avaliacoes = avaliacaoService.findByProdutoId(produtoId);
        for (Avaliacao avaliacao : avaliacoes) {
            if (avaliacao.getCliente().getId() == cliente.getId()) {
                return new ModelAndView("redirect:/loja/produto/" + produtoId + "?erro=duplicado");
            }
        }

        Avaliacao novaAvaliacao = new Avaliacao();
        novaAvaliacao.setCliente(cliente);
        novaAvaliacao.setProduto(produto);
        novaAvaliacao.setNota(nota);
        novaAvaliacao.setComentario(comentario);
        novaAvaliacao.setData(new Date());

        avaliacaoService.save(novaAvaliacao);

        return new ModelAndView("redirect:/loja/produto/" + produtoId);
    }
}