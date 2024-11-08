package br.univille.fsoweb20242yan.service.impl;

import br.univille.fsoweb20242yan.entities.Thread;
import br.univille.fsoweb20242yan.entities.Comentario;
import br.univille.fsoweb20242yan.repositories.ThreadRepository;
import br.univille.fsoweb20242yan.repositories.ComentarioRepository;
import br.univille.fsoweb20242yan.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ThreadServiceImpl implements ThreadService {

    @Autowired
    private ThreadRepository threadRepository;

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Override
    public Thread criarThread(String titulo) {
        Thread thread = new Thread();
        thread.setTitulo(titulo);
        return threadRepository.save(thread);
    }

    @Override
    public Optional<Thread> buscarThreadPorId(Long id) {
        return threadRepository.findById(id);
    }

    @Override
    public List<Thread> listarTodasThreads() {
        return threadRepository.findAll();
    }

    @Override
    public Comentario adicionarComentario(Long threadId, String conteudo) {
        Thread thread = threadRepository.findById(threadId)
                .orElseThrow(() -> new RuntimeException("Thread não encontrada"));

        Comentario comentario = new Comentario();
        comentario.setConteudo(conteudo);
        comentario.setDataCriacao(LocalDateTime.now());
        comentario.setThread(thread);

        return comentarioRepository.save(comentario);
    }

    @Override
    public List<Comentario> buscarComentariosPorThread(Long threadId) {
        Thread thread = threadRepository.findById(threadId)
                .orElseThrow(() -> new RuntimeException("Thread não encontrada"));
        return thread.getComentarios();
    }

    @Override
    public void deletarThread(Long threadId) {
        Thread thread = threadRepository.findById(threadId)
                .orElseThrow(() -> new RuntimeException("Thread não encontrada"));
        threadRepository.delete(thread);
    }

    @Override
    public void deletarComentario(Long comentarioId) {
        Comentario comentario = comentarioRepository.findById(comentarioId)
                .orElseThrow(() -> new RuntimeException("Comentario não encontrado"));
        comentarioRepository.delete(comentario);
    }

    @Override
    public Thread atualizarThread(Long threadId, String novoTitulo) {
        Thread thread = threadRepository.findById(threadId)
                .orElseThrow(() -> new RuntimeException("Thread não encontrada"));
        thread.setTitulo(novoTitulo);
        return threadRepository.save(thread);
    }

    @Override
    public Comentario atualizarComentario(Long comentarioId, String novoConteudo) {
        Comentario comentario = comentarioRepository.findById(comentarioId)
                .orElseThrow(() -> new RuntimeException("Comentario não encontrado"));
        comentario.setConteudo(novoConteudo);
        comentario.setDataCriacao(LocalDateTime.now());
        return comentarioRepository.save(comentario);
    }
}