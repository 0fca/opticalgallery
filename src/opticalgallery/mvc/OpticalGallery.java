/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opticalgallery.mvc;

import opticalgallery.mvc.controller.MainViewController;

/**
 *
 * @author Lukas
 */
public class OpticalGallery {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainViewController mvc = MainViewController.getInstance();
        mvc.view();
    }
    
}
