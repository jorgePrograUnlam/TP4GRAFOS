package analisis;

public class Corrida implements Comparable<Corrida> {

	public int ejecucion;
	public int minimoColores;

	public Corrida(int ejecucion, int numeroCromatico) {
		this.ejecucion = ejecucion;
		this.minimoColores = numeroCromatico;
	}

	public int getMinimoColores() {
		return minimoColores;
	}

	public int getEjecucion() {
		return ejecucion;
	}

	@Override
	public int compareTo(Corrida otro) {
		return (this.minimoColores - otro.minimoColores);
	}

}