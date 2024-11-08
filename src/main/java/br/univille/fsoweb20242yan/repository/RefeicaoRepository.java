package br.univille.fsoweb20242yan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.univille.fsoweb20242yan.entity.Refeicao;

public interface RefeicaoRepository extends JpaRepository<Refeicao, Long> {

    List<Refeicao> findByClienteId(Long clienteId);

}
