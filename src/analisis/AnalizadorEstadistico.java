package analisis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import grafo.GeneradorDeGrafo;
import grafo.GrafoNDNP;

public class AnalizadorEstadistico {

    private static final int EJECUCIONES = 1000;

    public static void crearArchivosDeGrafos() {
        GrafoNDNP grafo600_40 = GeneradorDeGrafo.AleatorioConPorcentajeAdyacenciaFijo(600, 40);
        grafo600_40.guardarEn("analisis\\aleatorio\\entrada\\600Nodos40Adyacencia.in");
        GrafoNDNP grafo600_60 = GeneradorDeGrafo.AleatorioConPorcentajeAdyacenciaFijo(600, 60);
        grafo600_60.guardarEn("analisis\\aleatorio\\entrada\\600Nodos60Adyacencia.in");
        GrafoNDNP grafo600_90 = GeneradorDeGrafo.AleatorioConPorcentajeAdyacenciaFijo(600, 90);
        grafo600_90.guardarEn("analisis\\aleatorio\\entrada\\600Nodos90Adyacencia.in");

        GrafoNDNP grafo1000_75 = GeneradorDeGrafo.regularDeNnodosyPorcentajeAdyacenciaFijos(1000, 75);
        grafo1000_75.guardarEn("analisis\\regular\\entrada\\1000Nodos75Adyacencia.in");
        GrafoNDNP grafo1000_50 = GeneradorDeGrafo.regularDeNnodosyPorcentajeAdyacenciaFijos(1000, 50);
        grafo1000_50.guardarEn("analisis\\regular\\entrada\\1000Nodos50Adyacencia.in");
    }

    private static void guardarAnalisis(List<Corrida> corridas, String ruta) {
        Collections.sort(corridas);
        Iterator<Corrida> it;

        try {
            FileWriter arch = new FileWriter(new File(ruta));
            BufferedWriter salida = new BufferedWriter(arch);

            salida.write("Minimo\tCorrida");
            salida.newLine();

            it = corridas.iterator();
            while (it.hasNext()) {
                Corrida corrida = it.next();
                salida.write(corrida.getMinimoColores() + "\t" + corrida.getEjecucion());
                salida.newLine();
            }

            salida.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void analisisAleatorio() {
        GrafoNDNP grafo;
        List<Corrida> corridas;

        grafo = new GrafoNDNP("analisis\\aleatorio\\entrada\\600Nodos40Adyacencia.in");

        corridas = new LinkedList<Corrida>();
        for (int i = 0; i < EJECUCIONES; i++) {
            grafo.coloreoSecuencialAleatorio();
            corridas.add(new Corrida(i, grafo.getMinimoColores()));
            grafo.despintar();
        }
        guardarAnalisis(corridas, "analisis\\aleatorio\\salida\\secuencial600Nodos40Adyacencia.out");

        corridas = new LinkedList<Corrida>();
        for (int i = 0; i < EJECUCIONES; i++) {
            grafo.coloreoWelshPowell();
            corridas.add(new Corrida(i, grafo.getMinimoColores()));
            grafo.despintar();
        }
        guardarAnalisis(corridas, "analisis\\aleatorio\\salida\\welshPowell600Nodos40Adyacencia.out");

        corridas = new LinkedList<Corrida>();
        for (int i = 0; i < EJECUCIONES; i++) {
            grafo.coloreoMatula();
            corridas.add(new Corrida(i, grafo.getMinimoColores()));
            grafo.despintar();
        }
        guardarAnalisis(corridas, "analisis\\aleatorio\\salida\\matula600Nodos40Adyacencia.out");

        grafo = new GrafoNDNP("analisis\\aleatorio\\entrada\\600Nodos60Adyacencia.in");
        corridas = new LinkedList<Corrida>();
        for (int i = 0; i < EJECUCIONES; i++) {
            grafo.coloreoSecuencialAleatorio();
            corridas.add(new Corrida(i, grafo.getMinimoColores()));
            grafo.despintar();
        }
        guardarAnalisis(corridas, "analisis\\aleatorio\\salida\\secuencial600Nodos60Adyacencia.out");

        corridas = new LinkedList<Corrida>();
        for (int i = 0; i < EJECUCIONES; i++) {
            grafo.coloreoWelshPowell();
            corridas.add(new Corrida(i, grafo.getMinimoColores()));
            grafo.despintar();
        }
        guardarAnalisis(corridas, "analisis\\aleatorio\\salida\\welshPowell600Nodos60Adyacencia.out");

        corridas = new LinkedList<Corrida>();
        for (int i = 0; i < EJECUCIONES; i++) {
            grafo.coloreoMatula();
            corridas.add(new Corrida(i, grafo.getMinimoColores()));
            grafo.despintar();
        }
        guardarAnalisis(corridas, "analisis\\aleatorio\\salida\\matula600Nodos60Adyacencia.out");

        grafo = new GrafoNDNP("analisis\\aleatorio\\entrada\\600Nodos90Adyacencia.in");

        corridas = new LinkedList<Corrida>();
        for (int i = 0; i < EJECUCIONES; i++) {
            grafo.coloreoSecuencialAleatorio();
            corridas.add(new Corrida(i, grafo.getMinimoColores()));
            grafo.despintar();
        }
        guardarAnalisis(corridas, "analisis\\aleatorio\\salida\\secuencial600Nodos90Adyacencia.out");

        corridas = new LinkedList<Corrida>();
        for (int i = 0; i < EJECUCIONES; i++) {
            grafo.coloreoWelshPowell();
            corridas.add(new Corrida(i, grafo.getMinimoColores()));
            grafo.despintar();
        }
        guardarAnalisis(corridas, "analisis\\aleatorio\\salida\\welshPowell600Nodos90Adyacencia.out");

        corridas = new LinkedList<Corrida>();
        for (int i = 0; i < EJECUCIONES; i++) {
            grafo.coloreoMatula();
            corridas.add(new Corrida(i, grafo.getMinimoColores()));
            grafo.despintar();
        }
        guardarAnalisis(corridas, "analisis\\aleatorio\\salida\\matula600Nodos90Adyacencia.out");

    }

    public static void analisisRegular() {
        GrafoNDNP grafo;
        List<Corrida> corridas;

        grafo = new GrafoNDNP("analisis\\regular\\entrada\\1000Nodos50Adyacencia.in");

        corridas = new LinkedList<Corrida>();
        for (int i = 0; i < EJECUCIONES; i++) {
            grafo.coloreoSecuencialAleatorio();
            corridas.add(new Corrida(i, grafo.getMinimoColores()));
            grafo.despintar();
        }
        guardarAnalisis(corridas, "analisis\\regular\\salida\\secuencial1000Nodos50Adyacencia.out");

        corridas = new LinkedList<Corrida>();
        for (int i = 0; i < EJECUCIONES; i++) {
            grafo.coloreoWelshPowell();
            corridas.add(new Corrida(i, grafo.getMinimoColores()));
            grafo.despintar();
        }
        guardarAnalisis(corridas, "analisis\\regular\\salida\\welshPowell1000Nodos50Adyacencia.out");

        corridas = new LinkedList<Corrida>();
        for (int i = 0; i < EJECUCIONES; i++) {
            grafo.coloreoMatula();
            corridas.add(new Corrida(i, grafo.getMinimoColores()));
            grafo.despintar();
        }
        guardarAnalisis(corridas, "analisis\\regular\\salida\\matula1000Nodos50Adyacencia.out");

        grafo = new GrafoNDNP("analisis\\regular\\entrada\\1000Nodos75Adyacencia.in");

        corridas = new LinkedList<Corrida>();
        for (int i = 0; i < EJECUCIONES; i++) {
            grafo.coloreoSecuencialAleatorio();
            corridas.add(new Corrida(i, grafo.getMinimoColores()));
            grafo.despintar();
        }
        guardarAnalisis(corridas, "analisis\\regular\\salida\\secuencial1000Nodos75Adyacencia.out");

        corridas = new LinkedList<Corrida>();
        for (int i = 0; i < EJECUCIONES; i++) {
            grafo.coloreoWelshPowell();
            corridas.add(new Corrida(i, grafo.getMinimoColores()));
            grafo.despintar();
        }
        guardarAnalisis(corridas, "analisis\\regular\\salida\\welshPowell1000Nodos75Adyacencia.out");

        corridas = new LinkedList<Corrida>();
        for (int i = 0; i < EJECUCIONES; i++) {
            grafo.coloreoMatula();
            corridas.add(new Corrida(i, grafo.getMinimoColores()));
            grafo.despintar();
        }
        guardarAnalisis(corridas, "analisis\\regular\\salida\\matula1000Nodos75Adyacencia.out");

    }

    public static void main(String[] args) {
        crearArchivosDeGrafos();
        analisisAleatorio();
        analisisRegular();
    }

}
