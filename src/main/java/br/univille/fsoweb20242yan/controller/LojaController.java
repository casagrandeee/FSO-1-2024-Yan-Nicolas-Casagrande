package br.univille.fsoweb20242yan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.univille.fsoweb20242yan.entity.Produto;
import br.univille.fsoweb20242yan.service.ProdutoService;

@Controller
@RequestMapping("/loja")
public class LojaController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ModelAndView exibirLoja(){
        List<Produto> produtos = service.getAll();
        return new ModelAndView("loja/index", "produtos", produtos);
    }

    @GetMapping("/produto")
    public ModelAndView detalhesProduto(@RequestParam("id") long id) {
        Produto produto = service.getById(id);
        return new ModelAndView("loja/detalhes", "produto", produto);
    }

}
