/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opticalgallery.mvc.view;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;

/**
 *
 * @author Lukas
 */
public class MainView extends javax.swing.JFrame {
    private int pos = 0;
    private int lastSelected = 0;
    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        this.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
               lastSelected = pos;
              
               switch(ke.getKeyCode()){
                    case KeyEvent.VK_UP:
                        pos -= 2;
                        moveCursor();
                        break;
                    case KeyEvent.VK_DOWN:
                        pos += 2;
                        moveCursor();
                        break;
                    case KeyEvent.VK_RIGHT:
                        pos++;
                        moveCursor();
                        break;
                    case KeyEvent.VK_LEFT:
                        pos--;
                        moveCursor();
                        break;
                    case KeyEvent.VK_ENTER:
                        JButton jb = (JButton)MainView.this.jPanel1.getComponent(pos);
                        jb.doClick();
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent ke) {
            }
        });
        prepareView(4);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });
        jPanel1.setLayout(new java.awt.GridLayout(2, 2));

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
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        // TODO add your handling code here:
        //System.out.println("key pressed");
        
    }//GEN-LAST:event_jPanel1KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void moveCursor() {
       if(pos >= 0 && pos < jPanel1.getComponentCount()){
           JButton b = (JButton)jPanel1.getComponent(pos);
           
           b.setSelected(true);
           b.setBackground(Color.yellow);
           System.out.println(pos);
           JButton last = (JButton)jPanel1.getComponent(lastSelected);
           last.setSelected(false);
           last.setBackground(null);
           jPanel1.revalidate();
           jPanel1.updateUI();
       }else{
           
       }
    }

    private void prepareView(int max) {
        for(int i = 0; i < max; i++){
            JButton jb = new JButton(""+i);
            jb.setFocusable(true);
            jb.setFocusTraversalKeysEnabled(false);
            jb.addActionListener(ac ->{
                System.out.println(jb.getText());
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
}
