package br.univille.fsoweb20242yan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.fsoweb20242yan.entity.Blog;
import br.univille.fsoweb20242yan.repository.BlogRepository;
import br.univille.fsoweb20242yan.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    private BlogRepository repository;

    @Override
    public List<Blog> getAll() {
        return repository.findAll();
    }

    @Override
    public Blog save(Blog blog) {
        return repository.save(blog);
    }

    @Override
    public Blog getById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

}
