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

    private Document doc;

    public AcessoInsta() {

    }

    public boolean acesso(String url) {
        String[] textoSeparado;
        String[] seguidoresMil;
        String[] seguindoMil;
        List<String> nomes = new ArrayList<>();
        Double numeroSeguidores = 0.0;
        Double numeroSeguindo = 0.0;
        int indiceSeguidores;
        int indiceSeguindo;
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

            int indiceVirgulaSeguidores = seguidores.indexOf(",");
            System.out.println("Numero de vírgulas nos Seguidores: " + indiceVirgulaSeguidores);

            int indiceVirgulaSeguindo = seguindo.indexOf(",");
            System.out.println("Numero de virgulas nos Seguindo: " + indiceVirgulaSeguindo);

            if (indiceSeguidores != -1) {

                if (indiceVirgulaSeguidores == -1) {
                    seguidoresMil = seguidores.split("k");

                    numeroSeguidores = Double.parseDouble(seguidoresMil[0]);
                    numeroSeguidores = numeroSeguidores * 1000;
                    System.out.println("Número real de seguidores: " + numeroSeguidores);
                } else if (indiceVirgulaSeguidores != -1) {
                    String[] a = seguidores.split(",");
                    seguidores = a[0] + a[1];
                    System.out.println("Tem vírgula! " + seguidores);

                    seguidoresMil = seguidores.split("k");
                    numeroSeguidores = Double.parseDouble(seguidoresMil[0]);
                    numeroSeguidores = numeroSeguidores * 1000;
                    System.out.println("Número real de seguidores: " + numeroSeguidores);

                }

            } else if (indiceSeguidores == -1) {
                if (indiceVirgulaSeguidores == -1) {

                    numeroSeguidores = Double.parseDouble(seguidores);
                    System.out.println("Número real de seguidores: " + numeroSeguidores);

                } else if (indiceVirgulaSeguidores != -1) {

                    String[] a = seguidores.split(",");
                    seguidores = a[0] + a[1];
                    System.out.println("Tem vírgula! " + seguidores);
                    numeroSeguidores = Double.parseDouble(seguidores);
                    System.out.println("Número real de seguidores: " + numeroSeguidores);

                }
            }

            if (indiceSeguindo != -1) {
                if (indiceVirgulaSeguindo == -1) {
                    seguindoMil = seguidores.split("k");
                    for (String g : seguindoMil) {
                        System.out.println(g);
                    }

                    numeroSeguindo = Double.parseDouble(seguindoMil[0]);
                    numeroSeguindo = numeroSeguindo * 1000;
                    System.out.println("Número real de pessoas que você segue: " + numeroSeguindo);
                } else if (indiceVirgulaSeguindo != -1) {
                    String[] a = seguindo.split(",");
                    seguindo = a[0] + a[1];
                    System.out.println("Tem vírgula!" + seguindo);

                    seguindoMil = seguidores.split("k");
                    for (String g : seguindoMil) {
                        System.out.println(g);
                    }

                    numeroSeguindo = Double.parseDouble(seguindoMil[0]);
                    numeroSeguindo = numeroSeguindo * 1000;
                    System.out.println("Número real de pessoas que você segue: " + numeroSeguindo);

                }

            } else if (indiceSeguindo == -1) {
                if (indiceVirgulaSeguindo == -1) {
                    numeroSeguindo = Double.parseDouble(seguindo);
                    System.out.println("Número real de pessoas que você segue: " + numeroSeguindo);
                } else if (indiceVirgulaSeguindo != -1) {
                    String[] a = seguindo.split(",");
                    seguindo = a[0] + a[1];
                    System.out.println("Tem vírgula!" + seguindo);

                    numeroSeguindo = Double.parseDouble(seguindo);
                    System.out.println("Número real de pessoas que você segue: " + numeroSeguindo);

                }
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

}
