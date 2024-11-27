package br.univille.fsoweb20242yan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.fsoweb20242yan.entity.Produto;

@Repository
public
 interface ProdutoRepository extends JpaRepository<Produto, Long>{

    List<Produto> findByCategoriaAndValorBetween(String categoria, float precoMin, float precoMax);

}


