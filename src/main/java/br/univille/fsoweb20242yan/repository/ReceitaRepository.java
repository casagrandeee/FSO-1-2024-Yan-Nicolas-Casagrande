package br.univille.fsoweb20242yan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.univille.fsoweb20242yan.entity.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    List<Receita> findByPreferencias(String preferenciasAlimentares);

}
