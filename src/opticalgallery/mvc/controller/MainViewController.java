/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opticalgallery.mvc.controller;

import opticalgallery.mvc.view.MainView;

/**
 *
 * @author Lukas
 */
public final class MainViewController {
    private static volatile MainViewController mvc = new MainViewController();
    private static final MainView MV = new MainView();
    
    private MainViewController(){}
    
    public static synchronized MainViewController getInstance(){
        return mvc;
    }
    
    public void view(){
        MV.setVisible(true);
    }
}
