package br.univille.fsoweb20242.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.fsoweb20242yan.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ModelAndView index(){
        //chamar o banco de dados e fazer um select * from tabela
        var listaClientes = service.getAll();
        //montar a tela com os dados banco
        return new ModelAndView("cliente/index",
                "listaClientes",listaClientes);
    }

    
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        var umCliente = service.getById(id);
        if(umCliente != null){
            service.delete(id);
        }
        return new ModelAndView("redirect:/clientes");
    }
    
}