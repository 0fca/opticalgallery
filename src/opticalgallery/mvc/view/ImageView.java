/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opticalgallery.mvc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import opticalgallery.mvc.model.GalleryDataModel;

/**
 *
 * @author obsidiam
 */
public class ImageView extends JPanel{
    {
        this.setLayout(new BorderLayout());
    }
    
    private int shown = 0, offset = 0;
    private GalleryDataModel gdm;
    private List<ImageObject> imageObj = new ArrayList<>();
    
    public void setDataModel(GalleryDataModel mdl){
        this.gdm = mdl;
        prepare();
    }
    
    private void view(){
        if(shown < imageObj.size()){
            this.removeAll();
            this.add(imageObj.get((shown + offset) * shown));
            this.updateUI();
        }
    }
    
    public void viewAt(int index){
        if(index > -1 && index < imageObj.size()){
            shown = index;
            view();
        }
    }
    
    public void viewNext(){
        shown++;
        if(shown > imageObj.size()) {
            shown = 0;
            return;
        }
        view();
    }
    
    public void viewPrevious(){
        shown--;
        if(shown < 0) {
            shown = imageObj.size() - 1;
            return;
        }
        view();
       
    }

    private void prepare() {
        gdm.getImages().forEach(image ->{
            ImageObject imo = new ImageObject();
            imo.setImgSize(image.getWidth(imo), image.getHeight(imo));
            imo.setIndex(gdm.getImages().indexOf(image));
            imo.setIcon(new ImageIcon(image));
            imo.setHorizontalAlignment(SwingConstants.CENTER);
           
            imageObj.add(imo);
        });
    }
    

    private class ImageObject extends JLabel{
        private int index,x,y;
        
        public void setIndex(int index){
            this.index = index;
        }
        
        public int getIndex(){
            return index;
        }
        
        public void setImgSize(int x,int y){
            this.x = x;
            this.y = y;
        }
        
        public Dimension getImgSize(){
            return new Dimension(x,y);
        }
        
        public ImageView getImageView(){
            return ImageView.this;
        }
    }
    
    public void setOffset(int offset){
        this.offset = offset;
    }
}
