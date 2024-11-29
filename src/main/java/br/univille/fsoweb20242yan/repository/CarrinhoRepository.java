package br.univille.fsoweb20242yan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.univille.fsoweb20242yan.entity.CarrinhoItem;

public interface CarrinhoRepository extends JpaRepository<CarrinhoItem, Long>{

}
