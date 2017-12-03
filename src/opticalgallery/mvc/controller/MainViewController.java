/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opticalgallery.mvc.controller;

import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import opticalgallery.mvc.view.MainView;
/**
 *
 * @author Lukas
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
               lastSelected = pos;
              
               switch(ke.getKeyCode()){
                    case KeyEvent.VK_UP:
                        if(pos - 2 > 0){
                            pos -= 2;
                        }else{
                            pos = MV.getComponentCount() - 1;
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
               
               if(ke.getExtendedKeyCode() == KeyEvent.VK_F1
                ||ke.getExtendedKeyCode() == KeyEvent.VK_F2
                ||ke.getExtendedKeyCode() == KeyEvent.VK_F3
                ||ke.getExtendedKeyCode() == KeyEvent.VK_F4){
                   JButton jb = ((JButton)MV.getComponent(ke.getExtendedKeyCode() - 112));
                   if(jb != null){
                        jb.doClick();
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
           //System.out.println(pos);
           
           JButton last = (JButton)MV.getComponent(lastSelected);
           last.setSelected(false);
           last.setBackground(null);
           MV.revalidate();
    }
    
}
