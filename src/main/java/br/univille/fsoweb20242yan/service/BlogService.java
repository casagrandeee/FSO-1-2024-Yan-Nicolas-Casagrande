package br.univille.fsoweb20242yan.service;

import java.util.List;

import br.univille.fsoweb20242yan.entity.Blog;

public interface BlogService {
    List<Blog> getAll();
    Blog save(Blog blog);
    Blog getById(long id);
    void delete(long id);
}
