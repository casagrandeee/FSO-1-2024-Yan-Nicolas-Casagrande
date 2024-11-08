package br.univille.fsoweb20242yan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.univille.fsoweb20242yan.service.ThreadService;

@Controller
@RequestMapping("/threads/{threadId}/comentarios")
public class ComentariosController {
    @Autowired
    private ThreadService threadService;

    // Página para listar os comentários de uma Thread
    @GetMapping
    public ModelAndView listarComentarios(@PathVariable Long threadId) {
        var thread = threadService.buscarThreadPorId(threadId)
                .orElseThrow(() -> new RuntimeException("Thread não encontrada"));
        return new ModelAndView("comentarios/lista", "comentarios", thread.getComentarios());
    }

    // Página para adicionar um novo comentário em uma Thread
    @GetMapping("/novo")
    public ModelAndView novoComentario(@PathVariable Long threadId) {
        var modelAndView = new ModelAndView("comentarios/novo");
        modelAndView.addObject("threadId", threadId);
        return modelAndView;
    }

    // Método para salvar um novo comentário
    @PostMapping("/salvar")
    public ModelAndView salvarComentario(@PathVariable Long threadId, @RequestParam String conteudo) {
        threadService.adicionarComentario(threadId, conteudo);
        return new ModelAndView("redirect:/threads/" + threadId);
    }
}
