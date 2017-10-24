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

	private static final int EJECUCIONES = 10000;

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
				salida.write(corrida.getNumeroCromatico() + "\t" + corrida.getEjecucion());
				salida.newLine();
			}

			salida.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void analisisAleatorio() {
		GrafoNDNP grafo;
		List<Corrida> corridas;

		corridas = new LinkedList<Corrida>();
		for (int i = 0; i < EJECUCIONES; i++) {
			grafo = GeneradorDeGrafo.AleatorioConPorcentajeAdyacenciaFijo(600, 40);
			grafo.coloreoSecuencialAleatorio();
			corridas.add(new Corrida(i, grafo.getNumeroCromatico()));
		}
		guardarAnalisis(corridas, "analisis\\aleatorio\\secuencial600Nodos40Adyacencia.txt");

		corridas = new LinkedList<Corrida>();
		for (int i = 0; i < EJECUCIONES; i++) {
			grafo = GeneradorDeGrafo.AleatorioConPorcentajeAdyacenciaFijo(600, 40);
			grafo.coloreoWelshPowell();
			corridas.add(new Corrida(i, grafo.getNumeroCromatico()));
		}
		guardarAnalisis(corridas, "analisis\\aleatorio\\welshPowell600Nodos40Adyacencia.txt");

		corridas = new LinkedList<Corrida>();
		for (int i = 0; i < EJECUCIONES; i++) {
			grafo = GeneradorDeGrafo.AleatorioConPorcentajeAdyacenciaFijo(600, 40);
			grafo.coloreoMatula();
			corridas.add(new Corrida(i, grafo.getNumeroCromatico()));
		}
		guardarAnalisis(corridas, "analisis\\aleatorio\\matula600Nodos40Adyacencia.txt");

		corridas = new LinkedList<Corrida>();
		for (int i = 0; i < EJECUCIONES; i++) {
			grafo = GeneradorDeGrafo.AleatorioConPorcentajeAdyacenciaFijo(600, 60);
			grafo.coloreoSecuencialAleatorio();
			corridas.add(new Corrida(i, grafo.getNumeroCromatico()));
		}
		guardarAnalisis(corridas, "analisis\\aleatorio\\secuencial600Nodos60Adyacencia.txt");

		corridas = new LinkedList<Corrida>();
		for (int i = 0; i < EJECUCIONES; i++) {
			grafo = GeneradorDeGrafo.AleatorioConPorcentajeAdyacenciaFijo(600, 60);
			grafo.coloreoWelshPowell();
			corridas.add(new Corrida(i, grafo.getNumeroCromatico()));
		}
		guardarAnalisis(corridas, "analisis\\aleatorio\\welshPowell600Nodos60Adyacencia.txt");

		corridas = new LinkedList<Corrida>();
		for (int i = 0; i < EJECUCIONES; i++) {
			grafo = GeneradorDeGrafo.AleatorioConPorcentajeAdyacenciaFijo(600, 60);
			grafo.coloreoMatula();
			corridas.add(new Corrida(i, grafo.getNumeroCromatico()));
		}
		guardarAnalisis(corridas, "analisis\\aleatorio\\matula600Nodos60Adyacencia.txt");

		corridas = new LinkedList<Corrida>();
		for (int i = 0; i < EJECUCIONES; i++) {
			grafo = GeneradorDeGrafo.AleatorioConPorcentajeAdyacenciaFijo(600, 90);
			grafo.coloreoSecuencialAleatorio();
			corridas.add(new Corrida(i, grafo.getNumeroCromatico()));
		}
		guardarAnalisis(corridas, "analisis\\aleatorio\\secuencial600Nodos90Adyacencia.txt");

		corridas = new LinkedList<Corrida>();
		for (int i = 0; i < EJECUCIONES; i++) {
			grafo = GeneradorDeGrafo.AleatorioConPorcentajeAdyacenciaFijo(600, 90);
			grafo.coloreoWelshPowell();
			corridas.add(new Corrida(i, grafo.getNumeroCromatico()));
		}
		guardarAnalisis(corridas, "analisis\\aleatorio\\welshPowell600Nodos90Adyacencia.txt");

		corridas = new LinkedList<Corrida>();
		for (int i = 0; i < EJECUCIONES; i++) {
			grafo = GeneradorDeGrafo.AleatorioConPorcentajeAdyacenciaFijo(600, 90);
			grafo.coloreoMatula();
			corridas.add(new Corrida(i, grafo.getNumeroCromatico()));
		}
		guardarAnalisis(corridas, "analisis\\aleatorio\\matula600Nodos90Adyacencia.txt");

	}

	public static void analisisRegular() {
		GrafoNDNP grafo;
		List<Corrida> corridas;

		corridas = new LinkedList<Corrida>();
		for (int i = 0; i < EJECUCIONES; i++) {
			grafo = GeneradorDeGrafo.regularDeNnodosyPorcentajeAdyacenciaFijos(1000, 50);
			grafo.coloreoSecuencialAleatorio();
			corridas.add(new Corrida(i, grafo.getNumeroCromatico()));
		}
		guardarAnalisis(corridas, "analisis\\regular\\secuencial1000Nodos50Adyacencia.txt");

		corridas = new LinkedList<Corrida>();
		for (int i = 0; i < EJECUCIONES; i++) {
			grafo = GeneradorDeGrafo.regularDeNnodosyPorcentajeAdyacenciaFijos(1000, 50);
			grafo.coloreoWelshPowell();
			corridas.add(new Corrida(i, grafo.getNumeroCromatico()));
		}
		guardarAnalisis(corridas, "analisis\\regular\\swelshPowell1000Nodos50Adyacencia.txt");

		corridas = new LinkedList<Corrida>();
		for (int i = 0; i < EJECUCIONES; i++) {
			grafo = GeneradorDeGrafo.regularDeNnodosyPorcentajeAdyacenciaFijos(1000, 50);
			grafo.coloreoMatula();
			corridas.add(new Corrida(i, grafo.getNumeroCromatico()));
		}
		guardarAnalisis(corridas, "analisis\\regular\\matula1000Nodos50Adyacencia.txt");

		corridas = new LinkedList<Corrida>();
		for (int i = 0; i < EJECUCIONES; i++) {
			grafo = GeneradorDeGrafo.regularDeNnodosyPorcentajeAdyacenciaFijos(1000, 75);
			grafo.coloreoSecuencialAleatorio();
			corridas.add(new Corrida(i, grafo.getNumeroCromatico()));
		}
		guardarAnalisis(corridas, "analisis\\regular\\secuencial1000Nodos75Adyacencia.txt");

		corridas = new LinkedList<Corrida>();
		for (int i = 0; i < EJECUCIONES; i++) {
			grafo = GeneradorDeGrafo.regularDeNnodosyPorcentajeAdyacenciaFijos(1000, 75);
			grafo.coloreoWelshPowell();
			corridas.add(new Corrida(i, grafo.getNumeroCromatico()));
		}
		guardarAnalisis(corridas, "analisis\\regular\\welshPowell1000Nodos75Adyacencia.txt");

		corridas = new LinkedList<Corrida>();
		for (int i = 0; i < EJECUCIONES; i++) {
			grafo = GeneradorDeGrafo.regularDeNnodosyPorcentajeAdyacenciaFijos(1000, 75);
			grafo.coloreoMatula();
			corridas.add(new Corrida(i, grafo.getNumeroCromatico()));
		}
		guardarAnalisis(corridas, "analisis\\regular\\matula1000Nodos75Adyacencia.txt");

	}

	public static void analisisMatulaAleatorio() {
		GrafoNDNP grafo;
		List<Corrida> corridas = new LinkedList<Corrida>();
		for (int i = 0; i < EJECUCIONES; i++) {
			grafo = GeneradorDeGrafo.AleatorioConPorcentajeAdyacenciaFijo(600, 40);
			grafo.coloreoMatula();
			corridas.add(new Corrida(i, grafo.getNumeroCromatico()));
		}
		guardarAnalisis(corridas, "analisis\\test.txt");
	}

	public static void main(String[] args) {
		analisisAleatorio();
		analisisRegular();
		// analisisMatulaAleatorio();
	}

}
