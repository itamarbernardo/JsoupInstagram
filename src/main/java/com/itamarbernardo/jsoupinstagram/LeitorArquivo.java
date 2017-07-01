/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itamarbernardo.jsoupinstagram;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ANAFLAVIA
 */
public class LeitorArquivo {
//Fazer de um jeito que ele guarde apenas os números ímpares: faz divisão por zero e pega o resto.

    private int cont = 1;
    private String nomeArquivo;

    public LeitorArquivo(String nomeArquivo){
        this.nomeArquivo = "C:\\Users\\ANAFLAVIA\\Documents\\" + nomeArquivo + ".txt";
    }
    
    public List<String> lerArquivo() {
        List<String> users = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));
            while (br.ready()) {
                int resto = cont % 2;

                if (cont == 1 || resto != 0) {
                    String linha = br.readLine();
                    users.add(linha);
                    System.out.println(linha + " CÓDIGO: " + cont);
                    cont++;
                } else {
                    String linha = br.readLine();
                    cont++;
                }
            }
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return users;
    }

    public int verificarQuantidadeLinhas() {
        int contagem = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));
            while (br.ready()) {
                String linha = br.readLine();
                contagem++;
            }
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return contagem;
    }

}
