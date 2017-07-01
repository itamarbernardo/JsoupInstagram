/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itamarbernardo.jsoupinstagram;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ANAFLAVIA
 */
public class Controlador {

    private List<String> users;
    private List<String> usuariosValidos;
    private String retorno = "";
    private String script = "";
    private LeitorArquivo leitor;
    private String nomeArquivo;

    public Controlador(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        this.usuariosValidos = new ArrayList<>();
        this.leitor = new LeitorArquivo(nomeArquivo);
        if (leitor.verificarQuantidadeLinhas() % 2 == 0) {
            users = leitor.lerArquivo();
            System.out.println(users.toString());
        }else{
            JOptionPane.showMessageDialog(null, "Reveja sua lista! Ela possivelmente está errada.");
            System.exit(0);
        }
    }

    public String usuariosParaSeguir() {
        AcessoInsta a = new AcessoInsta();

        for (String u : users) {
            System.out.println("User: " + u);
            boolean chave = a.acesso(u);
            if (chave == true) {
                retorno = retorno + u + "\n";
                usuariosValidos.add(u);
            }
        }

        return retorno;
    }

    public void abrirSugestoes() {
        try {
            AbrirLink abrir = new AbrirLink();
            abrir.abrirLink("www.google.com");

            Thread.sleep(2000);

            if (!usuariosValidos.isEmpty()) {
                for (String link : usuariosValidos) {
                    abrir.abrirLink("https://www.instagram.com/" + link);
                }
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String geraScriptImacros() {
        for (String link : usuariosValidos) {
            script = script + "URL GOTO=https://instagram.com/" + link + "\nTAG POS=1 TYPE=BUTTON ATTR=TXT:Seguir\nWAIT SECONDS=2\n";
        }

        return script;
    }
}
