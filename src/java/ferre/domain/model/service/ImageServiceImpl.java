/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.service;

import ferre.domain.model.entity.Image;
import ferre.domain.model.repository.ImageRepository;


/**
 *
 * @author User
 */
public class ImageServiceImpl extends BaseService<Image, Integer> implements ImageService {

    ImageRepository<Image, Integer> ImageRepository;
    public ImageServiceImpl(ImageRepository<Image, Integer> ImageRepository) {
        super(ImageRepository);
        this.ImageRepository = ImageRepository;
    }

    @Override
    public byte[] image(int id) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return ImageRepository.image(id);
    }
}
