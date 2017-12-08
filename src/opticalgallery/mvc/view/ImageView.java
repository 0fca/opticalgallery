/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opticalgallery.mvc.view;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import java.util.*;
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
    private List<Image> imageObj = new ArrayList<>();
    
    public void setDataModel(GalleryDataModel mdl){
        this.gdm = mdl;
        prepare();
    }
    
    private void view(){
            this.removeAll();
            Image selected = imageObj.get(shown);
            ImageObject imo = new ImageObject(selected);
            imo.setIndex(gdm.getImages().indexOf(imageObj.indexOf(selected)));
            this.add(imo);
            this.updateUI();
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
        imageObj.clear();
        gdm.getImages().forEach(image ->{ 
            imageObj.add(image);
        });
    }

    private class ImageObject extends JPanel{
        private int index,x,y;
        private Image img;
        
        private ImageObject(Image img){
            this.img = img;
            
        }
        
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
        
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            img = img.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
            g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), this);
            this.revalidate();
            this.updateUI();
        }
    }
    
    public void setOffset(int offset){
        this.offset = offset;
    }
}
