/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opticalgallery.mvc.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import opticalgallery.mvc.view.MainView;
/**
 *
 * @author Obsidiam
 */
public final class MainViewController {
    private static volatile MainViewController mvc = new MainViewController();
    private static final MainView MV = new MainView();
    
    private int pos = 0;
    private int lastSelected = 0, columnCount = 1;
    static final GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
    private MainViewController(){}
    
    public static synchronized MainViewController getInstance(){
        return mvc;
    }
    
    public void view(){
        prepare();
        MV.setVisible(true);
        columnCount = MV.getColumnCount();
    }

    private void prepare() {
        MV.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                if(MV.getLayout() instanceof GridLayout){
                   lastSelected = pos;

                   switch(ke.getKeyCode()){
                        case KeyEvent.VK_UP:
                            if(pos - columnCount > 0){
                                pos -= columnCount;
                            }else{
                                pos = 0;
                            }
                            moveCursor();
                            break;
                        case KeyEvent.VK_DOWN:
                            if(pos + columnCount < MV.getComponentCount()){
                                pos += columnCount;
                            }else{
                                pos = 0;
                            }
                            moveCursor();
                            break;
                        case KeyEvent.VK_RIGHT:
                            if(pos + 1 < MV.getComponentCount()){
                                pos++;
                            }else{
                                pos = 0;
                            }

                            moveCursor();
                            break;
                        case KeyEvent.VK_LEFT:
                           if(pos - 1 > -1){
                                pos--;
                            }else{
                                pos = MV.getComponentCount() - 1;
                                
                            }
                            moveCursor();
                            break;
                        case KeyEvent.VK_ENTER:
                            JButton jb = (JButton)MV.getComponent(pos);
                            jb.doClick();
                            break;
                        case KeyEvent.VK_ESCAPE:
                            device.setFullScreenWindow(null);
                            break;
                        case KeyEvent.VK_F:
                            if(ke.isControlDown()){
                                device.setFullScreenWindow(MV);
                            }
                            break;
                    }
                }else{
                    switch(ke.getExtendedKeyCode()){
                        case KeyEvent.VK_ESCAPE:
                            device.setFullScreenWindow(null);
                            break;
                        case KeyEvent.VK_F:
                            if(ke.isControlDown()){
                                device.setFullScreenWindow(MV);
                            }
                            break;
                        case KeyEvent.VK_C:
                            if(ke.isControlDown()){
                                MV.resetView(true);
                            }else{
                                MV.resetView(false);
                            }
                            break;
                        case KeyEvent.VK_RIGHT:
                            MV.getImageView().viewNext();
                            break;
                        case KeyEvent.VK_LEFT:
                            MV.getImageView().viewPrevious();
                            break;
                    }
                }
                changeImage(ke.getExtendedKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent ke) {}

            private void changeImage(int extendedKeyCode) {
               if(extendedKeyCode == KeyEvent.VK_1
                    ||extendedKeyCode == KeyEvent.VK_2
                    ||extendedKeyCode == KeyEvent.VK_3
                    ||extendedKeyCode == KeyEvent.VK_4){
                    if(MV.getComponentCount() > 0){
                       Component c = MV.getComponent((int)((char)extendedKeyCode - 49));
                        if(c instanceof JButton){
                            ((JButton)(c)).doClick();
                        }

                         //System.out.println("Changing....");
                        if(device.getFullScreenWindow() == null){
                           device.setFullScreenWindow(MV);

                           MV.getImageView().viewAt((int)((char)extendedKeyCode - 49));
                        }else{
                          //System.out.println("Changing....");
                           MV.getImageView().viewAt((int)((char)extendedKeyCode - 49));
                        }
                    }
               }
            }
        });
        
    } 
    
    private void moveCursor() {
           JButton b = (JButton)MV.getComponent(pos);
           b.setSelected(true);
           b.setBackground(Color.WHITE);
           
           if(lastSelected != pos){
               JButton last = (JButton)MV.getComponent(lastSelected);
               last.setSelected(false);
               last.setBackground(null);
           }
           MV.revalidate();
    }
    
}
