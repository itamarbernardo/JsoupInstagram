/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itamarbernardo.jsoupinstagram;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author ANAFLAVIA
 */
public class AcessoInsta {

    private String[] textoSeparado;
    private String[] seguidoresMil;
    private String[] seguindoMil;
    private String seguidores;
    private String seguindo;
    private Document doc;
    private List<String> nomes = new ArrayList<>();
    private int cont = 0;
    private boolean resposta = false;
    private Double numeroSeguidores = 0.0;
    private Double numeroSeguindo = 0.0;
    private int indiceSeguidores;
    private int indiceSeguindo;

    public boolean acesso(String url) {
        boolean resposta = false;

        try {
            doc = Jsoup.connect("https://www.instagram.com/" + url).get();

            String selector = "meta[content]";
            Elements links = doc.select(selector);

            for (Element link : links) {

                // get the value from href attribute
                //System.out.println("\nlink : " + link.attr("content"));
                String palavra = link.attr("content");
                nomes.add(palavra);

            }

            String quantidades = nomes.get(15);
            textoSeparado = quantidades.split(" ");

            String seguidores = textoSeparado[0];
            String seguindo = textoSeparado[2];

            System.out.println("Seguidores: " + seguidores + "\nSeguindo: " + seguindo);
            indiceSeguidores = seguidores.indexOf("k");
            System.out.println("Numero de K's nos Seguidores: " + indiceSeguidores);
            indiceSeguindo = seguindo.indexOf("k");
            System.out.println("Número de K's nos Seguindo: " + indiceSeguindo);

            if (indiceSeguidores != -1) {

                seguidoresMil = seguidores.split("k");

                numeroSeguidores = Double.parseDouble(seguidoresMil[0]);
                numeroSeguidores = numeroSeguidores * 1000;
                System.out.println("Número real de seguidores: " + numeroSeguidores);

            } else if (indiceSeguidores == -1) {

                numeroSeguidores = Double.parseDouble(seguidores);
                System.out.println("Número real de seguidores: " + numeroSeguidores);

            }

            if (indiceSeguindo != -1) {

                seguindoMil = seguidores.split("k");
                for (String g : seguindoMil) {
                    System.out.println(g);
                }

                numeroSeguindo = Double.parseDouble(seguindoMil[0]);
                numeroSeguindo = numeroSeguindo * 1000;
                System.out.println("Número real de pessoas que você segue: " + numeroSeguindo);

            } else if (indiceSeguindo == -1) {

                numeroSeguindo = Double.parseDouble(seguindo);
                System.out.println("Número real de pessoas que você segue: " + numeroSeguindo);

            }
            //--------------------Chega até aqui...----------------------------------------------------

            if (numeroSeguidores > numeroSeguindo) {
                resposta = false;
            } else if (numeroSeguidores <= numeroSeguindo) {
                resposta = true;
            } else {
                System.out.println("Testando...");
            }

            

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resposta;
    }

    public boolean avalia() {

        String n = "";

        if (numeroSeguidores > numeroSeguindo) {
            resposta = false;
        } else if (numeroSeguidores <= numeroSeguindo) {
            resposta = true;
        } else {
            System.out.println("Testando...");
        }

        return resposta;
    }

}
