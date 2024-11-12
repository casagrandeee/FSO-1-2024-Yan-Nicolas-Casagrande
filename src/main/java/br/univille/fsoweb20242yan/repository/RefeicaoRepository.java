package br.univille.fsoweb20242yan.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.univille.fsoweb20242yan.entity.Cliente;
import br.univille.fsoweb20242yan.entity.Refeicao;

public interface RefeicaoRepository extends JpaRepository<Refeicao, Long> {
    List<Refeicao> findByClienteId(long id);
    List<Refeicao> findByClienteAndData(Cliente cliente, LocalDate data);
    List<Refeicao> findByClienteAndDataBetween(Cliente cliente, LocalDate start, LocalDate end);
}

