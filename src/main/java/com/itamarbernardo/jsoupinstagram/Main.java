/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itamarbernardo.jsoupinstagram;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ANAFLAVIA
 */
public class Main {

    public static void main(String[] args) {

        //AcessoInsta a = new AcessoInsta();
        
        List<String> users = new ArrayList<>();
        
        users.add("itamar_bernardo");
        users.add("erwesonshow");
        users.add("helya_barroso");
        
        Controlador c = new Controlador(users);
        String nomes = c.usuariosParaSeguir();
        System.out.println("Seguidores para seguir:\n" + nomes);
        c.abrirSugestoes();
    }
 
            
            
    }
