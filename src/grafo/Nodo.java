package grafo;

public class Nodo {
	private int i;
	private int color;
	private int grado;

	public Nodo(int i, int grado) {
		this.color = 0;
		this.grado = grado;
		this.i = i;
	}

	public int getI() {
		return i;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getGrado() {
		return grado;
	}

	public void setGrado(int grado) {
		this.grado = grado;
	}

}
