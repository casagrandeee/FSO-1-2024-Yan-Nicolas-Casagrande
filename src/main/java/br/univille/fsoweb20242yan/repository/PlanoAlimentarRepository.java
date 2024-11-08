package br.univille.fsoweb20242yan.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.univille.fsoweb20242yan.entity.PlanoAlimentar;

public interface PlanoAlimentarRepository extends JpaRepository<PlanoAlimentar, Long> {

    List<PlanoAlimentar> findByClienteId(Long clienteId);
    Optional<PlanoAlimentar> findFirstByClienteId(Long clienteId);
}
