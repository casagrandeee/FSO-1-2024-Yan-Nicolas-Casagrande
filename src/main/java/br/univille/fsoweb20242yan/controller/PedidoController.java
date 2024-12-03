package br.univille.fsoweb20242yan.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.univille.fsoweb20242yan.entity.ItemPedido;
import br.univille.fsoweb20242yan.entity.Pedido;
import br.univille.fsoweb20242yan.entity.Produto;
import br.univille.fsoweb20242yan.service.PedidoService;
import br.univille.fsoweb20242yan.service.ProdutoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ModelAndView index() {
        var listaPedidos = service.getAll();
        return new ModelAndView("pedido/index", "listaPedidos", listaPedidos);
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        var pedido = new Pedido();

        var listaProdutos = produtoService.getAll();

        HashMap<String, Object> dados = new HashMap<>();
        dados.put("pedido", pedido);
        dados.put("novoItem", new ItemPedido());
        dados.put("listaProdutos", listaProdutos);

        return new ModelAndView("pedido/form", dados);
    }

    @PostMapping(params = "incitem")
    public ModelAndView incluirItem(Pedido pedido, ItemPedido novoItem) {
        pedido.getItens().add(novoItem);

        var listaProdutos = produtoService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("pedido", pedido);
        dados.put("novoItem", new ItemPedido());
        dados.put("listaProdutos", listaProdutos);

        return new ModelAndView("pedido/form", dados);
    }

    @PostMapping(params = "save")
    public ModelAndView save(Pedido pedido) {
        Pedido savedPedido = service.save(pedido);
        return new ModelAndView("redirect:/pedidos/finalizar/" + savedPedido.getId());
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id) {
        var pedido = service.getById(id);

        var listaProdutos = produtoService.getAll();

        HashMap<String, Object> dados = new HashMap<>();
        dados.put("pedido", pedido);
        dados.put("novoItem", new ItemPedido());
        dados.put("listaProdutos", listaProdutos);

        return new ModelAndView("pedido/form", dados);
    }

    @PostMapping(params = "removeitem")
    public ModelAndView removerItem(@RequestParam("removeitem") int index, Pedido pedido) {
        pedido.getItens().remove(index);

        var listaProdutos = produtoService.getAll();

        HashMap<String, Object> dados = new HashMap<>();
        dados.put("pedido", pedido);
        dados.put("novoItem", new ItemPedido());
        dados.put("listaProdutos", listaProdutos);

        return new ModelAndView("pedido/form", dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id) {
        var pedido = service.getById(id);
        if (pedido != null) {
            service.delete(id);
        }
        return new ModelAndView("redirect:/pedidos");
    }

    //exibir formulário de finalização de pedido
    @GetMapping("/finalizar/{id}")
    public ModelAndView exibirFormularioFinalizacao(@PathVariable("id") long id) {
        var pedido = service.getById(id);
        if (pedido == null) {
            return new ModelAndView("redirect:/pedidos");
        }

        HashMap<String, Object> dados = new HashMap<>();
        dados.put("pedido", pedido);
        dados.put("enderecoEntrega", "");
        dados.put("metodoPagamento", "");

        return new ModelAndView("pedido/finalizar", dados);
    }

    //finalizar pedido e salvar informações adicionais
    @PostMapping("/finalizar")
    public ModelAndView finalizarPedido(Pedido pedido) {
        //var pedido = service.getById(id);
        if (pedido == null) {
            return new ModelAndView("redirect:/pedidos");
        }
        service.save(pedido);

        return new ModelAndView("redirect:/pedidos/sucesso");
    }

    @GetMapping("/sucesso")
    public ModelAndView exibirPaginaSucesso() {
        return new ModelAndView("pedido/sucesso");
    }

    //exibir status do pedido para o cliente
    @GetMapping("/status/{id}")
    public ModelAndView exibirStatus(@PathVariable("id") long id) {
        Pedido pedido = service.getById(id);
        if (pedido == null) {
            return new ModelAndView("redirect:/pedidos");
        }
        return new ModelAndView("pedido/status", "pedido", pedido);
    }

    @PostMapping("/comprar")
public ModelAndView comprarAgora(@RequestParam("produtoId") long produtoId) {
    Produto produto = produtoService.getById(produtoId);
    if (produto == null) {
        return new ModelAndView("redirect:/loja");
    }

    Pedido pedido = new Pedido();
    ItemPedido novoItem = new ItemPedido();
    novoItem.setProduto(produto);
    novoItem.setQuantidade(1);
    novoItem.setValor(produto.getValor());
    pedido.getItens().add(novoItem);

    HashMap<String, Object> dados = new HashMap<>();
    dados.put("pedido", pedido);
    dados.put("novoItem", new ItemPedido());
    dados.put("listaProdutos", produtoService.getAll());

    return new ModelAndView("pedido/form", dados);
    }
}