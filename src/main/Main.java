package main;

import grafo.GeneradorDeGrafo;
import grafo.GrafoNDNP;

public class Main {

    public static void main(String[] args) {
        GrafoNDNP grafo;

        grafo = GeneradorDeGrafo.nPartitoDeNnodosYnPartes(6, 3);
        grafo.mostrar();
        grafo.guardarEn("grafo5.in");

        System.out.println();

        grafo = GeneradorDeGrafo.regularDeNnodosyPorcentajeAdyacenciaFijos(5, 60);
        grafo.mostrar();
        grafo.guardarEn("grafo4.in");
        grafo.coloreoMatula();
        grafo.guardarColoreadoEn("coloreado4.out");

        System.out.println();

        grafo = GeneradorDeGrafo.regularDeNnodosyGradoFijos(5, 4);
        grafo.mostrar();
        grafo.guardarEn("grafo3.in");

        System.out.println();

        grafo = GeneradorDeGrafo.AleatorioConPorcentajeAdyacenciaFijo(8, 40);
        grafo.mostrar();
        grafo.guardarEn("grafo2.in");
        grafo.coloreoWelshPowell();
        grafo.guardarColoreadoEn("coloreado2.out");

        System.out.println();

        grafo = GeneradorDeGrafo.AleatorioConProbabilidadDeAristaFijo(7, 0.4);
        grafo.mostrar();
        grafo.guardarEn("grafo1.in");
        grafo.coloreoSecuencialAleatorio();
        grafo.guardarColoreadoEn("coloreado1.out");

    }

}
