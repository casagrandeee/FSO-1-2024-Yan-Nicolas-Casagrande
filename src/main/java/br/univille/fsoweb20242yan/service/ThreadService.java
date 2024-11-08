package br.univille.fsoweb20242yan.service;

import br.univille.fsoweb20242yan.entities.Thread;
import br.univille.fsoweb20242yan.entities.Comentario;

import java.util.List;
import java.util.Optional;

public interface ThreadService {

    Thread criarThread(String titulo);

    Optional<Thread> buscarThreadPorId(Long id);

    List<Thread> listarTodasThreads();

    Comentario adicionarComentario(Long threadId, String conteudo);

    List<Comentario> buscarComentariosPorThread(Long threadId);

    void deletarThread(Long threadId);

    void deletarComentario(Long comentarioId);

    Thread atualizarThread(Long threadId, String novoTitulo);

    Comentario atualizarComentario(Long comentarioId, String novoConteudo);
}