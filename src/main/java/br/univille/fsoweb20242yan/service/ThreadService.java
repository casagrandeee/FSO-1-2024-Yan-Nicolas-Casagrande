package br.univille.fsoweb20242yan.service;

import java.util.List;
import java.util.Optional;

import br.univille.fsoweb20242yan.entity.Comentarios;
import br.univille.fsoweb20242yan.entity.Thread;

public interface ThreadService {

    Thread criarThread(String titulo);

    Optional<Thread> buscarThreadPorId(Long id);

    List<Thread> listarTodasThreads();

    Comentarios adicionarComentario(Long threadId, String conteudo);

    List<Comentarios> buscarComentariosPorThread(Long threadId);

    void deletarThread(Long threadId);

    void deletarComentario(Long comentarioId);

    Thread atualizarThread(Long threadId, String novoTitulo);

    Comentarios atualizarComentario(Long comentarioId, String novoConteudo);
}