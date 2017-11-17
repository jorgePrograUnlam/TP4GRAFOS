package grafo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class GeneradorDeGrafo {

    public static GrafoNDNP AleatorioConProbabilidadDeAristaFijo(int cantidadNodos, double probabilidadDeArista) {

        Random rnd = new Random();
        MatrizSimetrica matrizAdy = new MatrizSimetrica(cantidadNodos);

        int aristas = 0;
        int maxAristas = matrizAdy.getTam();

        for (int i = 0; i < cantidadNodos; i++) {
            for (int j = i + 1; j < cantidadNodos; j++) {
                double probabilidadAleatoria = rnd.nextDouble();
                if (probabilidadAleatoria <= probabilidadDeArista) {
                    matrizAdy.setIJ(i, j, true);
                    aristas++;
                }
            }
        }

        double porcentajeAdy = ((double) aristas / maxAristas) * 100;
        return new GrafoNDNP(cantidadNodos, matrizAdy, aristas, porcentajeAdy);
    }

    public static GrafoNDNP AleatorioConPorcentajeAdyacenciaFijo(int cantidadNodos, double porcentajeAdy) {

        MatrizSimetrica m = new MatrizSimetrica(cantidadNodos);
        double probAdy = porcentajeAdy / 100;

        LinkedList<Arista> listArista = new LinkedList<Arista>();
        for (int i = 0; i < cantidadNodos; i++) {
            for (int j = i + 1; j < cantidadNodos; j++) {
                listArista.add(new Arista(i, j, Math.random()));
            }
        }
        Collections.sort(listArista);
        int aristasTotal = (int) (probAdy * (cantidadNodos * (cantidadNodos - 1) / 2));
        for (int i = 0; i < aristasTotal; i++) {
            Arista aris = listArista.pollFirst();
            m.setIJ(aris.getFila(), aris.getCol(), true);
        }

        return new GrafoNDNP(cantidadNodos, m, aristasTotal, porcentajeAdy);
    }

    public static GrafoNDNP regularDeNnodosyGradoFijos(int cantidadNodos, int grado) {

        if (grado % 2 != 0 && cantidadNodos % 2 != 0) {
            System.out.println("grafo regular de grado impar y nodo impar");
            return null;
        }
        if (grado >= cantidadNodos) {
            System.out.println("grafo regular de grado mayor o igual a los nodos");
            return null;
        }

        MatrizSimetrica m = new MatrizSimetrica(cantidadNodos);
        int aristas = 0;

        for (int i = 0; i < cantidadNodos; i++) {
            for (int j = 1; j <= grado / 2; j++) {
                m.setIJ(i, (i + j) % cantidadNodos, true);
                aristas++;
            }
            if (i < (cantidadNodos / 2) && grado % 2 == 1) {
                m.setIJ(i, i + (cantidadNodos / 2), true);
                aristas++;
            }
        }

        int gradoMaximo = grado;
        int gradoMinimo = grado;
        double porcentajeAdy = (aristas * 100) / ((cantidadNodos * (cantidadNodos - 1)) / 2);
        GrafoNDNP g = new GrafoNDNP(cantidadNodos, m, aristas, porcentajeAdy, gradoMaximo, gradoMinimo);
        return g;
    }

    public static GrafoNDNP regularDeNnodosyPorcentajeAdyacenciaFijos(int cantidadNodos, double porcentajeAdy) {
        MatrizSimetrica m = new MatrizSimetrica(cantidadNodos);
        double probAdy = porcentajeAdy / 100;

        int grado = (int) Math.ceil(probAdy * (cantidadNodos - 1));

        return GeneradorDeGrafo.regularDeNnodosyGradoFijos(cantidadNodos, grado);

    }

    public static GrafoNDNP nPartitoDeNnodosYnPartes(int cantidadNodos, int n) {
        int aristas = 0;
        int contador = 0;
        MatrizSimetrica m = new MatrizSimetrica(cantidadNodos);
        int salto = cantidadNodos / n;
        for (int i = 0; i < cantidadNodos - 1; i++) {
            int j = i + salto;
            while (j < cantidadNodos && contador < n - 1) {
                m.setIJ(i, j, true);
                aristas++;
                j++;
            }
            salto--;
            if (salto == 0) {
                salto = cantidadNodos / n;
                contador++;
            }
        }
        double porcAdy = (aristas / (cantidadNodos * ((double) cantidadNodos - 1) / 2)) * 100;
        return new GrafoNDNP(cantidadNodos, m, aristas, porcAdy);
    }

}
