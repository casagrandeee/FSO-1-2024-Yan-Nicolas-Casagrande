package br.univille.fsoweb20242yan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.univille.fsoweb20242yan.service.ThreadService;

@Controller
@RequestMapping("/threads")
public class ThreadController {

    @Autowired
    private ThreadService threadService;

    @GetMapping
    public ModelAndView listarThreads() {
        var threads = threadService.listarTodasThreads();
        return new ModelAndView("thread/lista", "threads", threads);
    }

    // Página de detalhes de uma Thread
    @GetMapping("/{id}")
    public ModelAndView detalhesThread(@PathVariable Long id) {
        var thread = threadService.buscarThreadPorId(id)
                .orElseThrow(() -> new RuntimeException("Thread não encontrada"));
        return new ModelAndView("threads/detalhes", "thread", thread);
    }

    // Página para criar uma nova Thread
    @GetMapping("/nova")
    public ModelAndView novaThread() {
        return new ModelAndView("threads/nova");
    }

    // Método para salvar uma nova Thread com mensagens flash
    @PostMapping("/salvar")
    public String salvarThread(@RequestParam String titulo, RedirectAttributes redirectAttributes) {
        try {
            threadService.criarThread(titulo);
            redirectAttributes.addFlashAttribute("mensagemSucesso", "Thread criada com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Erro ao criar a Thread.");
        }
        return "redirect:/threads";
    }
}
