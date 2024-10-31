package br.univille.fsoweb20242yan.service;

import java.util.List;
import br.univille.fsoweb20242yan.entity.Cidade;

public interface CidadeService {
    Cidade save(Cidade cidade);
    Cidade getById(long Id);
    List<Cidade> getAll();
}
