/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opticalgallery.mvc.controller;

import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Toolkit;
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
    private int lastSelected = 0;
    static final GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
    private MainViewController(){}
    
    public static synchronized MainViewController getInstance(){
        return mvc;
    }
    
    public void view(){
        prepare();
        MV.setVisible(true);
        
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
                            if(pos - 2 > 0){
                                pos -= 2;
                            }else{
                                pos = 0;
                            }
                            moveCursor();
                            break;
                        case KeyEvent.VK_DOWN:
                            if(pos + 2 < MV.getComponentCount()){
                                pos += 2;
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

                   if(ke.getExtendedKeyCode() == KeyEvent.VK_1
                    ||ke.getExtendedKeyCode() == KeyEvent.VK_2
                    ||ke.getExtendedKeyCode() == KeyEvent.VK_3
                    ||ke.getExtendedKeyCode() == KeyEvent.VK_4){
                       JButton jb = ((JButton)MV.getComponent(ke.getExtendedKeyCode() - 49));
                       if(jb != null){
                            jb.doClick();
                       }
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
                        case KeyEvent.VK_E:
                            if(ke.isControlDown()){
                                MV.resetView();
                            }
                            break;
                        case KeyEvent.VK_RIGHT:
                            MV.getImageView().viewNext();
                            break;
                        case KeyEvent.VK_LEFT:
                            MV.getImageView().viewPrevious();
                            break;
                    }
                    
                    if(ke.getExtendedKeyCode() == KeyEvent.VK_1
                    ||ke.getExtendedKeyCode() == KeyEvent.VK_2
                    ||ke.getExtendedKeyCode() == KeyEvent.VK_3
                    ||ke.getExtendedKeyCode() == KeyEvent.VK_4){
                       MV.getImageView().viewAt((int)((char)ke.getExtendedKeyCode()));
                   }
                }
            }

            @Override
            public void keyReleased(KeyEvent ke) {
            }
        });
        
    } 
    
    private void moveCursor() {
           JButton b = (JButton)MV.getComponent(pos);
           b.setSelected(true);
           b.setBackground(Color.WHITE);
           JButton last = (JButton)MV.getComponent(lastSelected);
           if(last != null){
               last.setSelected(false);
               last.setBackground(null);
           }
           MV.revalidate();
    }
    
}
