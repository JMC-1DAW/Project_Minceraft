package bloque;

import juego.Jugador;

public abstract class Bloque {

	//Tipos de bloques posibles.
	public static final int PLANTA = 0;
	public static final int ARBOL = 1;
	public static final int ARCILLA = 2;
	public static final int ALBERO = 3;
	public static final int HIERRO = 4;
	public static final int COBRE = 5;
	
	public static final int NUM_MATERIAS = 6; //Pues contamos desde 0.

	int x, y, z;
	
	protected int tipo;

	public Bloque(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.tipo = -1;
	}

	public void destruir() {
		this.x = -1;
		this.y = -1;
		this.z = -1;
	}
	
	public abstract void destruir(String herramienta, Jugador jugador);

	public abstract boolean spawnCheck();

	@Override
	public String toString() {
		
		String exact;
		int get = tipo;
		
		switch (get) {
		case 0: exact = "Planta "; break;
		case 1: exact = "Árbol  "; break;
		case 2: exact = "Arcilla"; break;
		case 3: exact = "Albero "; break;
		case 4: exact = "Hierro "; break;
		case 5: exact = "Cobre  "; break;
		default: exact = "Vacío  "; break;
		}
		
		return "[x=" + x + ", y=" + y + ", z=" + z + ", tipo=" + exact + "]";
	}

}
