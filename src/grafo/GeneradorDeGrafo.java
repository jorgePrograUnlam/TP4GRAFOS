package grafo;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class GeneradorDeGrafo {

	public static GrafoNDNP AleatorioConProbabilidadDeAristaFijo(int cantidadNodos, double probabilidadDeArista) {

		Random rnd = new Random();
		MatrizSimetrica matrizAdy = new MatrizSimetrica(cantidadNodos);

		int aristas = 0;
		int maxAristas = matrizAdy.getTam();
		SortedSet<Integer> grados = new TreeSet<>();

		for (int i = 0; i < cantidadNodos; i++) {
			Integer grado = 0;

			for (int j = i + 1; j < cantidadNodos; j++) {

				double probabilidadAleatoria = rnd.nextDouble();
				if (probabilidadAleatoria <= probabilidadDeArista) {
					matrizAdy.setIJ(i, j, true);
					aristas++;
					grado++;
				}
			}
			grados.add(grado);
		}

		double porcentajeAdy = ((double) aristas / maxAristas) * 100;
		int gradoMaximo = grados.last();
		int gradoMinimo = grados.first();
		return new GrafoNDNP(cantidadNodos, matrizAdy, aristas, porcentajeAdy, gradoMaximo, gradoMinimo);
	}

	public static GrafoNDNP AleatorioConPorcentajeAdyacenciaFijo(int cantidadNodos, double porcentajeAdy) {

		Random rnd = new Random();
		MatrizSimetrica m = new MatrizSimetrica(cantidadNodos);
		double probAdy = porcentajeAdy / 100;

		int aristas = (int) Math.round((cantidadNodos * (cantidadNodos - 1) * probAdy) / 2);
		SortedSet<Integer> grados = new TreeSet<>();
		int a = 0;
		while (a < aristas) {
			for (int i = 0; i < cantidadNodos && a < aristas; i++) {
				Integer grado = 0;

				for (int j = i + 1; j < cantidadNodos && a < aristas; j++) {

					double probabilidadAleatoria = rnd.nextDouble();
					if (probabilidadAleatoria <= 0.5 && m.getIJ(i, j) == false) {
						m.setIJ(i, j, true);
						a++;
						grado++;
					}
				}
				grados.add(grado);
			}
		}

		int gradoMaximo = grados.last();
		int gradoMinimo = grados.first();
		return new GrafoNDNP(cantidadNodos, m, aristas, porcentajeAdy, gradoMaximo, gradoMinimo);
	}

	public static GrafoNDNP regularDeNnodosyGradoFijos(int cantidadNodos, int grado) {

		MatrizSimetrica m = new MatrizSimetrica(cantidadNodos);
		int aristas = 0;

		int salto = (cantidadNodos - 1 - grado) / 2 + 1;
		if (grado != 0 && grado != 1 && grado != 2) {
			m.setIJ(0, cantidadNodos - 1, true);
			aristas++;
			for (int i = 0; i < cantidadNodos - 1; i++) {
				int j = i + 1;
				int contGrado = 1;
				m.setIJ(i, j, true);
				aristas++;
				j += salto;
				while (j < cantidadNodos && contGrado < grado / 2) {
					m.setIJ(i, j, true);
					aristas++;
					j++;
					contGrado++;
				}
				if (cantidadNodos % 2 == 0 && grado % 2 == 0)
					j++;
				while (j < cantidadNodos && contGrado < grado - 1) {
					m.setIJ(i, j, true);
					aristas++;
					j++;
					contGrado++;
				}

			}
		} else {
			if (grado == 1)
				for (int i = 0; i < cantidadNodos - 1; i += 2) {
					m.setIJ(i, i + 1, true);
					aristas++;
				}
			else {
				if (grado == 2) {
					m.setIJ(0, cantidadNodos - 1, true);
					aristas++;
					for (int i = 0; i < cantidadNodos - 1; i++) {
						m.setIJ(i, i + 1, true);
						aristas++;
					}
				}
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

		/*
		 * if (grado >= cantidadNodos) { System.out.println("grado de " + cantidadNodos
		 * + " nodos y " + grado + "grado no es posible"); return null; }
		 * 
		 * for (int x = 0; x < cantidadNodos - 1; x++) m.setIJ(x, x + 1, true); if
		 * (cantidadNodos > 2) { m.setIJ(0, cantidadNodos - 1, true); grado -= 2;
		 * 
		 * if (grado % 2 != 0) { for (int x = 0; x < cantidadNodos / 2; x++) m.setIJ(x,
		 * x + (cantidadNodos / 2), true); grado--; }
		 * 
		 * int cantVeces = grado / 2; int saltear = 2; for (int x = 0; x < cantVeces;
		 * x++) { for (int nodoActual = 0; nodoActual < cantidadNodos; nodoActual++) {
		 * int aux = nodoActual + saltear; if (aux > cantidadNodos - 1) aux -=
		 * cantidadNodos; m.setIJ(nodoActual, aux, true); } saltear++; } }
		 * 
		 * int aristas = Math.abs((cantidadNodos * grado) / 2); double percADj =
		 * ((double) aristas / m.getTam()) * 100; return new GrafoNDNP(cantidadNodos, m,
		 * aristas, porcentajeAdy);
		 */
		return GeneradorDeGrafo.regularDeNnodosyGradoFijos(cantidadNodos, grado);

	}

	public static GrafoNDNP nPartitoDeNnodosYnPartes(int cantidadNodos, int n) {
		int aristas = 0;
		int grados[] = new int[cantidadNodos];
		int contador = 0;
		MatrizSimetrica m = new MatrizSimetrica(cantidadNodos);
		int salto = cantidadNodos / n;
		for (int i = 0; i < cantidadNodos - 1; i++) {
			int j = i + salto;
			while (j < cantidadNodos && contador < n - 1) {
				m.setIJ(i, j, true);
				grados[i]++;
				grados[j]++;
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
