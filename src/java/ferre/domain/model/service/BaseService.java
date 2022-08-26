/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.service;

import ferre.domain.model.repository.Repository;
import java.util.Collection;

/**
 *
 * @author Matias
 * @param <TE>
 * @param <T>
 */
public abstract class BaseService<TE, T> extends ReadOnlyBaseService<TE, T> {

    private Repository<TE, T> _repository;

    BaseService(Repository<TE, T> repository) {
        super(repository);
        _repository = repository;
    }

    /**
     *
     * @param entity
     * @throws Exception
     */
    public void add(TE entity) throws Exception {
        _repository.add(entity);
    }

    /**
     *
     * @return Collection<TE>
     */
    public Collection<TE> getAll() {
        return _repository.getAll();
    }
}
