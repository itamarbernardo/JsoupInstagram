package com.itamarbernardo.jsoupinstagram;


import java.awt.Desktop;
import java.net.URI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ANAFLAVIA
 */
public class AbrirLink {
    public void abrirLink(String url) {
        
        Desktop d = Desktop.getDesktop();
        try{
            d.browse(new URI(url));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
