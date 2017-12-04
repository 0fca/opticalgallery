/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opticalgallery.mvc;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
import opticalgallery.mvc.controller.MainViewController;
import opticalgallery.mvc.view.MainView;

/**
 *
 * @author Obsidiam
 */
public class OpticalGallery {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Metal".equals(info.getName())) {
                try {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                } catch (InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException | ClassNotFoundException ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            } else {
            }
        }
        MainViewController mvc = MainViewController.getInstance();
        mvc.view();
    }
    
}
