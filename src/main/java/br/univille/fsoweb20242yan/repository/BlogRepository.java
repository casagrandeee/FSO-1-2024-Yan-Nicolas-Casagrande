package br.univille.fsoweb20242yan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.fsoweb20242yan.entity.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
}
