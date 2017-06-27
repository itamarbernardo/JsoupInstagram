/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itamarbernardo.jsoupinstagram;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author ANAFLAVIA
 */
public class Main {

    public static void main(String[] args) {

        AcessoInsta a = new AcessoInsta();
        String nomeUser2 = "itamarbernardo";
        String nomeUser = "erwesonshow";
        String nomeUser3 = "helya_barroso";
        boolean resposta = a.acesso(nomeUser2);
        
        
        JOptionPane.showMessageDialog(null, resposta);

    }
 
            
            
    }
