/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.repository;

/**
 *
 * @author Matias
 * @param <Image>
 * @param <Integer>
 */
public interface ImageRepository<Image, Integer> extends Repository<Image, Integer> {
    /**
     * Obtener Imagen
     * @param id
     * @return 
     * @throws Exception
     */
    public byte[] image(int id) throws Exception;
}
