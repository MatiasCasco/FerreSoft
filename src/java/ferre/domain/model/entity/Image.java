/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.entity;

/**
 *
 * @author User
 */
public class Image {
     
    private byte[]  image;

    public Image() {
    }

    public Image(byte[] image) {
        this.image = image;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
 
     @Override
    public String toString() {
       return new StringBuilder("{image: ").append(image)
                .append("}").toString();
    }
}
