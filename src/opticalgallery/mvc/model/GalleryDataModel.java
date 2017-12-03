/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opticalgallery.mvc.model;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Obsidiam
 */
public class GalleryDataModel {
    private volatile List<Image> images = new ArrayList<>();
    
    public GalleryDataModel(List<Image> images){
        this.images = images;
    }
    
    public List<Image> getImages(){
        return images;
    }
    
    public Image getImageAt(int index){
        return images.get(index);
    }
    
    public int getCount(){
        return images.size();
    }
}
