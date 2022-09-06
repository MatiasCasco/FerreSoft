/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.service;

/**
 *
 * @author User
 */
public interface ImageService {
    /**
     * 
     * @param id
     * @return
     * @throws Exception
     */
    public byte[] image(int id) throws Exception;

}
