package br.univille.fsoweb20242yan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.univille.fsoweb20242yan.entity.Produto;
import br.univille.fsoweb20242yan.service.CarrinhoService;
import br.univille.fsoweb20242yan.service.ProdutoService;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ModelAndView exibirCarrinho() {
        var itens = carrinhoService.getItens();
        var total = carrinhoService.calcularTotal();
        ModelAndView modelAndView = new ModelAndView("carrinho/index");
        modelAndView.addObject("itens", itens);
        modelAndView.addObject("total", total);
        return modelAndView;
    }

    @PostMapping("/adicionar")
    public String adicionarItem(@RequestParam long produtoId, @RequestParam int quantidade) {
        Produto produto = produtoService.getById(produtoId);
        carrinhoService.adicionarItem(produto, quantidade);
        return "redirect:/carrinho";
    }

    @PostMapping("/atualizar")
    public String atualizarQuantidade(@RequestParam long produtoId, @RequestParam int quantidade) {
        carrinhoService.atualizarQuantidade(produtoId, quantidade);
        return "redirect:/carrinho";
    }

    @PostMapping("/remover")
    public String removerItem(@RequestParam long produtoId) {
        carrinhoService.removerItem(produtoId);
        return "redirect:/carrinho";
    }
}