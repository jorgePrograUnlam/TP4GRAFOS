package grafo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class GrafoNDNP {
    private MatrizSimetrica matrizAdyacencia;
    private int             cantidadNodos;
    private ArrayList<Nodo> nodos;
    private int             aristas;
    private double          porcentajeAdyacencia;
    private int             gradoMaximo;
    private int             gradoMinimo;
    private int             minimoColores;

    private boolean esPosibleColorearNodo(Nodo n, int color) {
        if (n.getColor() != 0)
            return false;
        for (int i = 0; i < cantidadNodos; i++) {

            if (nodos.get(i).getColor() == color) {
                if (esAdyacente(nodos.get(i), n))
                    return false;
            }
        }
        return true;
    }

    private boolean esAdyacente(Nodo nodo1, Nodo nodo2) {
        return matrizAdyacencia.getIJ(nodo1.getI(), nodo2.getI());
    }

    public GrafoNDNP(int cantNodos, MatrizSimetrica matrizAdy, int aristas, double porcentajeAdy) {
        this.cantidadNodos = cantNodos;
        this.aristas = aristas;
        this.matrizAdyacencia = matrizAdy;
        this.porcentajeAdyacencia = porcentajeAdy;

        this.nodos = new ArrayList<Nodo>(this.cantidadNodos);

        // recorro la matriz de adyacencia para iniciar los nodos con
        // su correspondiente grado
        for (int i = 0; i < cantidadNodos; i++) {
            int grado = 0;
            for (int j = 0; j < cantidadNodos; j++) {
                if (matrizAdyacencia.getIJ(i, j))
                    grado++;
            }
            nodos.add(new Nodo(i, grado));
        }

        // una vez creado el array de nodos veo el maximo y minimo grado
        this.gradoMaximo = (Collections.max(nodos, Comparator.comparingInt(Nodo::getGrado))).getGrado();
        this.gradoMinimo = (Collections.min(nodos, Comparator.comparingInt(Nodo::getGrado))).getGrado();
        this.minimoColores = 0;
    }

    public GrafoNDNP(int cantNodos, MatrizSimetrica matrizAdy, int aristas, double porcentajeAdy, int gradoMax,
            int gradoMin) {
        this.cantidadNodos = cantNodos;
        this.aristas = aristas;
        this.matrizAdyacencia = matrizAdy;
        this.porcentajeAdyacencia = porcentajeAdy;

        this.nodos = new ArrayList<Nodo>(this.cantidadNodos);

        // recorro la matriz de adyacencia para iniciar los nodos con
        // su correspondiente grado
        for (int i = 0; i < cantidadNodos; i++) {
            int grado = 0;
            for (int j = 0; j < cantidadNodos; j++) {
                if (matrizAdyacencia.getIJ(i, j))
                    grado++;
            }
            nodos.add(new Nodo(i, grado));
        }

        this.gradoMaximo = gradoMax;
        this.gradoMinimo = gradoMin;
        this.minimoColores = 0;
    }

    public GrafoNDNP(String entrada) {
        try {
            Scanner sc = new Scanner(new File(entrada));
            this.cantidadNodos = sc.nextInt();
            this.aristas = sc.nextInt();
            this.porcentajeAdyacencia = sc.nextInt();
            this.gradoMaximo = sc.nextInt();
            this.gradoMinimo = sc.nextInt();
            this.minimoColores = 0;
            sc.nextLine();

            this.matrizAdyacencia = new MatrizSimetrica(cantidadNodos);
            for (int i = 0; i < aristas; i++) {
                matrizAdyacencia.setIJ(sc.nextInt(), sc.nextInt(), true);
            }

            this.nodos = new ArrayList<Nodo>(this.cantidadNodos);
            for (int i = 0; i < cantidadNodos; i++) {
                int grado = 0;
                for (int j = i + 1; j < cantidadNodos; j++) {
                    if (matrizAdyacencia.getIJ(i, j))
                        grado += 2;
                }
                nodos.add(new Nodo(i, grado));
            }

            sc.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void mostrar() {
        matrizAdyacencia.mostrar();
    }

    public void guardarEn(String ruta) {
        try {
            FileWriter salida = new FileWriter(new File(ruta));
            salida.write(cantidadNodos + " " + aristas + " " + (int) porcentajeAdyacencia + " " + gradoMaximo + " "
                    + gradoMinimo);
            salida.write(System.lineSeparator());
            for (int i = 0; i < cantidadNodos; i++) {
                for (int j = i + 1; j < cantidadNodos; j++) {
                    if (matrizAdyacencia.getIJ(i, j)) {
                        salida.write(i + " " + j);
                        salida.write(System.lineSeparator());
                    }
                }
            }
            salida.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void guardarColoreadoEn(String ruta) {
        try {
            FileWriter salida = new FileWriter(new File(ruta));
            salida.write(cantidadNodos + " " + minimoColores + " " + aristas + " " + porcentajeAdyacencia + " "
                    + gradoMaximo + " " + gradoMinimo);
            salida.write(System.lineSeparator());
            for (int i = 0; i < cantidadNodos; i++) {
                salida.write(nodos.get(i).getI() + " " + nodos.get(i).getColor());
                salida.write(System.lineSeparator());
            }

            salida.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void ordenarRandom() {
        int random, min = 0, max = cantidadNodos;
        Nodo auxNodo;

        for (int i = 0; i < cantidadNodos; i++) {

            random = (int) (Math.random() * (max - min)) + min;
            auxNodo = nodos.get(i);
            nodos.set(i, nodos.get(random));
            nodos.set(random, auxNodo);
        }
    }

    public void coloreoSecuencialAleatorio() {

        Collections.shuffle(nodos);
        for (int i = 0; i < cantidadNodos; i++) {
            int color = 1;

            while (!esPosibleColorearNodo(nodos.get(i), color)) {
                color++;
            }

            nodos.get(i).setColor(color);
            if (color > this.minimoColores)
                this.minimoColores = color;
        }
    }

    public void coloreoWelshPowell() {

        Collections.shuffle(nodos);
        Collections.sort(nodos, Comparator.comparingInt(Nodo::getGrado));
        // Collections.reverse(nodos);
        for (int i = cantidadNodos - 1; i >= 0; i--) {
            int color = 1;

            while (!esPosibleColorearNodo(nodos.get(i), color)) {
                color++;
            }

            nodos.get(i).setColor(color);
            if (color > this.minimoColores)
                this.minimoColores = color;
        }
    }

    public void coloreoMatula() {

        Collections.shuffle(nodos);
        Collections.sort(nodos, Comparator.comparingInt(Nodo::getGrado));
        for (int i = 0; i < cantidadNodos; i++) {
            int color = 1;

            while (!esPosibleColorearNodo(nodos.get(i), color)) {
                color++;
            }

            nodos.get(i).setColor(color);
            if (color > this.minimoColores)
                this.minimoColores = color;
        }
    }

    public int getMinimoColores() {
        return minimoColores;
    }

    public int getCantidadNodos() {
        return cantidadNodos;
    }

    public ArrayList<Nodo> getNodos() {
        return nodos;
    }

    public MatrizSimetrica getMatrizAdyacencia() {
        return matrizAdyacencia;
    }

    public boolean comprobarColoreo() {

        for (Iterator<Nodo> iterator = nodos.iterator(); iterator.hasNext();) {
            Nodo nodo = iterator.next();

            if (nodo.getColor() == 0)
                return false;

            for (int i = 0; i < cantidadNodos; i++) {
                if (nodos.get(i).getColor() == nodo.getColor() && nodos.get(i).getI() != nodo.getI())
                    if (matrizAdyacencia.getIJ(nodos.get(i).getI(), nodo.getI()))
                        return false;
            }

        }

        return true;
    }

    public void despintar() {

        for (Nodo nodo : nodos) {
            nodo.setColor(0);
        }
        this.minimoColores = 0;
    }

}
