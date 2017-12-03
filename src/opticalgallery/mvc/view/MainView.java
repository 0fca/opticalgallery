/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opticalgallery.mvc.view;
import galleries.GalleryType;
import galleries.GlobalConstants;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import opticalgallery.mvc.model.GalleryDataModel;

/**
 *
 * @author Obsidiam
 */
public class MainView extends javax.swing.JFrame {
    
    /**
     * Creates new form MainView
     */
    private GalleryDataModel gdm;
    
    public MainView() {
        initComponents();
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        prepareView(4,false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OpticsGallery");
        setBackground(new java.awt.Color(0, 128, 255));
        setPreferredSize(new java.awt.Dimension(600, 500));

        jPanel1.setBackground(new java.awt.Color(0, 128, 255));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });
        jPanel1.setLayout(new java.awt.GridLayout(2, 2, 15, 15));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        // TODO add your handling code here:
        //System.out.println("key pressed");
        
    }//GEN-LAST:event_jPanel1KeyPressed

    @Override
    public Component getComponent(int index){
        return jPanel1.getComponent(index);
    }
    
    
    @Override
    public int getComponentCount(){
       return jPanel1.getComponentCount();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    

    private void prepareView(int max,boolean fromImages) {
        if(!fromImages){
            for(int i = 0; i < max; i++){
                JButton jb = new JButton("Gallery"+(i+1));
                jb.setFocusable(true);
                jb.setFocusTraversalKeysEnabled(false);
                jb.setFont(new java.awt.Font("Arial", 2, 24));
                jb.setBackground(Color.WHITE);
                jb.addActionListener(ac ->{
                    try {
                        loadGallery(getGalleryType(jb.getText().toUpperCase()));
                        viewGallery();
                    } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException | IOException ex) {
                        Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                jPanel1.add(jb,i);
            }
        }else{
            for(int i = 0; i <gdm.getCount(); i++){
                JButton jb = new JButton();
                jb.setIcon(new ImageIcon(gdm.getImageAt(i)));
                jPanel1.add(jb);
            }
        }
    }
    
    private void viewGallery(){
       if(gdm.getCount() > 0){
           jPanel1.removeAll();
           jPanel1.revalidate();
           jPanel1.updateUI();

           prepareView(gdm.getCount(),true);
       }
    }

    private void loadGallery(GalleryType gt) throws IOException {
        List<Image> images = new ArrayList<>();
        if(gt.getCount() > 0){
            for(int i = 0; i < gt.getCount(); i++){
               System.out.println(GlobalConstants.IMG_URL+gt.name().toLowerCase()+"-"+(i+1)+".jpg");
               InputStream is =  getClass().getResourceAsStream(GlobalConstants.IMG_URL+gt.name().toLowerCase()+"-"+i+".jpg");
               BufferedImage bf = ImageIO.read(is);
               images.add(bf.getSubimage(0, 0, bf.getWidth()/292 * 100, bf.getHeight()/200 * 100));
            }
            gdm = new GalleryDataModel(images);
        }
    }
    private GalleryType getGalleryType(String text) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
       Field fd = GalleryType.class.getDeclaredField(text);
       return (GalleryType)fd.get(null);
    }
    
}
