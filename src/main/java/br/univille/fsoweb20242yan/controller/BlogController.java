package br.univille.fsoweb20242yan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.univille.fsoweb20242yan.entity.Blog;
import br.univille.fsoweb20242yan.entity.Comentario;
import br.univille.fsoweb20242yan.service.BlogService;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService service;

    @GetMapping
    public ModelAndView index(){
        List<Blog> listaBlogs = service.getAll();
        return new ModelAndView("blog/index", "listaBlogs", listaBlogs);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var blog = new Blog();
        return new ModelAndView("blog/form", "blog", blog);
    }

    @PostMapping
    public ModelAndView save(Blog blog){
        service.save(blog);
        return new ModelAndView("redirect:/blog");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var blog = service.getById(id);
        return new ModelAndView("blog/form", "blog", blog);
    }
    
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        service.delete(id);
        return new ModelAndView("redirect:/blog");
    }

    @PostMapping("/like/{id}")
    public ModelAndView like(@PathVariable("id") long id) {
        var post = service.getById(id);
        post.setLikes(post.getLikes() + 1);
        service.save(post);
        return new ModelAndView("redirect:/blog");
    }

    @PostMapping("/dislike/{id}")
    public ModelAndView dislike(@PathVariable("id") long id) {
        var post = service.getById(id);
        post.setDislikes(post.getDislikes() + 1);
        service.save(post);
        return new ModelAndView("redirect:/blog");
    }

    @PostMapping("/comentar/{id}")
    public ModelAndView comentar(@PathVariable("id") long id, @RequestParam("autor") String autor, @RequestParam("conteudo") String conteudo) {
        var post = service.getById(id);
        var comentario = new Comentario();
        comentario.setAutor(autor);
        comentario.setConteudo(conteudo);
        comentario.setDataComentario(new java.util.Date());
        post.getComentarios().add(comentario);
        service.save(post);
        return new ModelAndView("redirect:/blog");
    }
}