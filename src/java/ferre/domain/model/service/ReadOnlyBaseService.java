/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.service;

import ferre.domain.model.repository.Repository;

/**
 *
 * @author Matias
 * @param TE
 * @param T
 */
public abstract class ReadOnlyBaseService<TE, T> {
    private Repository<TE, T> repository;

    ReadOnlyBaseService(Repository<TE, T> repository) {
        this.repository = repository;
    }
}
