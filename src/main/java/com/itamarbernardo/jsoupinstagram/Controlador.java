/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itamarbernardo.jsoupinstagram;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ANAFLAVIA
 */
public class Controlador {

    private List<String> users;
    private List<String> usuariosValidos;
    private String retorno = "";

    public Controlador(List<String> users) {
        this.users = users;
        this.usuariosValidos = new ArrayList<>();
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
        AbrirLink abrir = new AbrirLink();
        if (!usuariosValidos.isEmpty()) {
            for (String link : usuariosValidos ) {
                abrir.abrirLink("https://www.instagram.com/" + link);
            }
        }

    }

}
