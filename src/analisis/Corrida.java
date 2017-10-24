package analisis;

public class Corrida implements Comparable<Corrida> {

	public int ejecucion;
	public int numeroCromatico;

	public Corrida(int ejecucion, int numeroCromatico) {
		this.ejecucion = ejecucion;
		this.numeroCromatico = numeroCromatico;
	}

	public int getNumeroCromatico() {
		return numeroCromatico;
	}

	public int getEjecucion() {
		return ejecucion;
	}

	@Override
	public int compareTo(Corrida otro) {
		return (this.numeroCromatico - otro.numeroCromatico);
	}

}