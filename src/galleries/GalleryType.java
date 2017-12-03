/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galleries;

/**
 *
 * @author Lukas
 */
public enum GalleryType {
    GALLERY1(GlobalConstants.GALL1),
    GALLERY2(GlobalConstants.GALL2),
    GALLERY3(GlobalConstants.GALL3),
    GALLERY4(GlobalConstants.GALL4);
    
    private int count;
    
    GalleryType(int count){
        this.count = count;
    }
    
    public int getCount(){
        return count;
    }
    
}
