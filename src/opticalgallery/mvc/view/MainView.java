/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opticalgallery.mvc.view;
import java.awt.BorderLayout;
import java.awt.Color;
import opticalgallery.galleries.GalleryType;
import opticalgallery.galleries.GlobalConstants;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JViewport;
import opticalgallery.mvc.model.GalleryDataModel;

/**
 *
 * @author Obsidiam
 */
public class MainView extends javax.swing.JFrame {
    
    /**
     * Creates new form MainView
     */
    private ImageView iv = new ImageView();
    private GalleryDataModel gdm;
    private int state = 0;
    
    public MainView() {
        initComponents();
        setFocusable(true);
        prepareView(4,false);
        
        //Toolkit.getDefaultToolkit().setDynamicLayout(true);
        //System.out.print(getClass().getResource("/opticalgallery/galleries/resources/gallery1-1.jpg"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        jFileChooser1.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OpticsGallery");
        setBackground(new java.awt.Color(0, 128, 255));
        setPreferredSize(new java.awt.Dimension(600, 500));
        setSize((int)(Toolkit.getDefaultToolkit().getScreenSize().width * 0.75), (int)(Toolkit.getDefaultToolkit().getScreenSize().height * 0.75));

        JViewport jv = new JViewport();
        jv.setView(jPanel1);
        jv.setViewSize(jPanel1.getSize());

        jPanel1.setLayout(new java.awt.GridLayout(2, 2, 15, 15));
        jScrollPane1.setViewportView(jPanel1);

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Open...");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setText("Exit");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Gallery view");

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Gallery 1");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setText("Gallery 2");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setText("Gallery 3");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem8.setText("Gallery 4");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("About");

        jMenuItem2.setText("About an app");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem4.setText("Website");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        try {
            // TODO add your handling code here:
            resetView(false);
            loadGallery(GalleryType.GALLERY1);
            prepareView(gdm.getCount(),true);
        } catch (IOException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            resetView(false);
            loadGallery(GalleryType.GALLERY2);
            prepareView(gdm.getCount(),true);
        } catch (IOException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            resetView(false);
            loadGallery(GalleryType.GALLERY3);
            prepareView(gdm.getCount(),true);
        } catch (IOException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            resetView(false);
            loadGallery(GalleryType.GALLERY4);
            prepareView(gdm.getCount(),true);
        } catch (IOException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        jFileChooser1.setCurrentDirectory(new java.io.File("."));
        jFileChooser1.setDialogTitle("Choose directory to be listed");
        jFileChooser1.setAcceptAllFileFilterUsed(false);
        
        if(jFileChooser1.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            File selectedFile = jFileChooser1.getSelectedFile();
            if(selectedFile != null){
                try {
                    System.out.println(selectedFile);
                    loadGalleryFromAbsolute(Arrays.asList(Files.list(selectedFile.toPath()).toArray()));
                    prepareView(gdm.getCount(), true);
                } catch (IOException ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "OpticalGallery by Obsidiam v1.0b6\nProgram is licensed under GPL3.0\nYou can use the code or redistribute it under the mentioned license.", "About", JOptionPane.DEFAULT_OPTION);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    @Override
    public LayoutManager getLayout(){
        return jPanel1.getLayout();
    }
    
    public int getColumnCount(){
        return ((this.getLayout() instanceof GridLayout) ? ((GridLayout)(this.getLayout())).getColumns() : 1);
    }
    
    @Override
    public Component getComponent(int index){
        return jPanel1.getComponentCount() > index ? jPanel1.getComponent(index): null;
    }
    
    
    @Override
    public int getComponentCount(){
       return jPanel1.getComponentCount();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    

    private void prepareView(int max,boolean fromImages) {
        clearView();
        if(!fromImages){
            for(int i = 0; i < max; i++){
                JButton jb = new JButton("Gallery"+(i+1));
                jb.setFocusable(true);
                jb.setFocusTraversalKeysEnabled(false);
                jb.setFont(new java.awt.Font("Arial", 2, 24));
                jb.setBackground(null);
                jb.setName(String.valueOf(i));
                if(i == 0){
                    jb.setBackground(Color.WHITE);
                }
                
                jb.addActionListener(ac ->{
                    try {
                        loadGallery(getGalleryType(jb.getText().toUpperCase()));
                        clearView();
                        prepareView(gdm.getCount(),true);
                    } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException | IOException ex) {
                        Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                jPanel1.add(jb,i);
            }
        }else{
            if(gdm != null){
                for(int i = 0; i < gdm.getCount(); i++){
                    JButton jb = new JButton();
                    jb.setIcon(new ImageIcon(gdm.getImageAt(i)));
                    //jb.setBackground(null);
                    jb.setBorder(null);
                    jb.setName(String.valueOf(i));
                    jb.addActionListener(listener ->{
                        clearView();
                        switchLayouts(new BorderLayout());
                        jPanel1.add(iv,"Center");
                        iv.viewAt(Integer.parseInt(jb.getName()));
                        jPanel1.revalidate();
                        jPanel1.updateUI();
                        state = 2;
                    });
                    jPanel1.add(jb,i);
                }
            }
        }
        jPanel1.revalidate();
        jPanel1.updateUI();
    }

    private void loadGallery(GalleryType gt) throws IOException {
        List<Image> images = new ArrayList<>();
        
        if(gt.getCount() > 0){
            for(int i = 0; i < gt.getCount(); i++){
               InputStream is = getClass().getResourceAsStream(GlobalConstants.IMG_URL+gt.name().toLowerCase()+"-"+(i+1)+".jpg");
               BufferedImage bf = ImageIO.read(is);
               images.add(bf.getScaledInstance((int)(getWidth() * 0.35), (int)(getHeight() * 0.35), Image.SCALE_SMOOTH));
            }
            gdm = new GalleryDataModel(images);
            iv.setDataModel(gdm);
            state = 1;
        }
    }
    
    private void loadGalleryFromAbsolute(List paths){
        final List<Image> images = new ArrayList<>();
        paths.forEach(path ->{
            try {
                images.add(ImageIO.read(((Path)path).toFile()).getScaledInstance((int)(getWidth() * 0.35), (int)(getHeight() * 0.35), Image.SCALE_SMOOTH));
            } catch (MalformedURLException ex) {
                Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        gdm = new GalleryDataModel(images);
        iv.setDataModel(gdm);
        state = 1;
    }
    
    private GalleryType getGalleryType(String text) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
       Field fd = GalleryType.class.getDeclaredField(text);
       return (GalleryType)fd.get(null);
    }

    private void clearView() {
        jPanel1.removeAll();
        jPanel1.revalidate();
        jPanel1.updateUI();
    }

    private void switchLayouts(LayoutManager lm) {
        jPanel1.setLayout(lm);
    }

    public ImageView getImageView(){
        return iv;
    }
    
    public void resetView(boolean full){
        clearView();
        GridLayout layout = new GridLayout();
        layout.setColumns(2);
        layout.setRows(2);
        layout.setVgap(15);
        layout.setHgap(15);
        switchLayouts(layout);
        prepareView(gdm == null && full ? 4 : gdm.getCount(), full);
    }
}
