package br.univille.fsoweb20242yan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.univille.fsoweb20242yan.entity.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long>{

    List<Avaliacao> findByProdutoId(long produtoId);

}
