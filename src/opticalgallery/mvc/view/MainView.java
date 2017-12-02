/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opticalgallery.mvc.view;
import galleries.GalleryType;
import java.awt.Color;
import java.awt.Component;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Lukas
 */
public class MainView extends javax.swing.JFrame {
    
    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        prepareView(4);
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

    

    private void prepareView(int max) {
        for(int i = 0; i < max; i++){
            JButton jb = new JButton("Gallery"+(i+1));
            jb.setFocusable(true);
            jb.setFocusTraversalKeysEnabled(false);
            jb.setFont(new java.awt.Font("Arial", 2, 24));
            jb.setBackground(Color.WHITE);
            jb.addActionListener(ac ->{
                try {
                    loadGallery(getGalleryType(jb.getText().toUpperCase()));
                } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            jPanel1.add(jb,i);
        }
    }
    
    private void viewGallery(int num){
        switch(num){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }

    private void loadGallery(GalleryType gt) {
        System.out.println(gt);
    }

    private GalleryType getGalleryType(String text) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
       Field fd = GalleryType.class.getDeclaredField(text);
       return (GalleryType)fd.get(null);
    }
}
