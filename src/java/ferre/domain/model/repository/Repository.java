/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.repository;

/**
 *
 * @author Matias
 * @param <TE>
 * @param <T>
 */
public interface Repository<TE, T> extends ReadOnlyRepository<TE, T> {
     /**
     *
     * @param entity
     */
    void add(TE entity);

    /**
     *
     * @param id
     */
    void remove(T id);

    /**
     *
     * @param entity
     */
    void update(TE entity); 
}
