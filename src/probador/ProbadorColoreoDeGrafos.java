package probador;

import org.junit.Assert;
import org.junit.Test;

import grafo.GrafoNDNP;

public class ProbadorColoreoDeGrafos {

	@Test
	public void algoritmoSecuencialAleatorio() {
		String entrada = "pruebas\\programa probador\\entrada\\600NodosCon40PorcientoAdyacencia.in";

		GrafoNDNP grafo = new GrafoNDNP(entrada);
		grafo.coloreoSecuencialAleatorio();

		Assert.assertTrue(grafo.comprobarColoreo());
	}

	@Test
	public void algoritmoWelshPowell() {
		String entrada = "pruebas\\programa probador\\entrada\\600NodosCon40PorcientoAdyacencia.in";

		GrafoNDNP grafo = new GrafoNDNP(entrada);
		grafo.coloreoWelshPowell();

		Assert.assertTrue(grafo.comprobarColoreo());
	}

	@Test
	public void algoritmoMatula() {
		String entrada = "pruebas\\programa probador\\entrada\\600NodosCon40PorcientoAdyacencia.in";

		GrafoNDNP grafo = new GrafoNDNP(entrada);
		grafo.coloreoMatula();

		Assert.assertTrue(grafo.comprobarColoreo());
	}

}
