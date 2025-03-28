package juego;

import bloque.Bloque;
import bloque.categoria.BloqueMineral;
import bloque.categoria.BloqueTierra;
import bloque.categoria.BloqueVegetal;

/**
 * Clase que representa el jugador del MineMonroy
 * 
 * @author y0rg
 *
 */
public class Jugador {

	// Nombre del jugador
	String nombre;
	int x;
	int y;
	int z;

	int pick;
	int axe;
	int shov;

	boolean blindness = true;

	// Lista de materias primas del jugador
	int[] materiasPrimas = new int[Bloque.NUM_MATERIAS];

	public Jugador(String nombre) {
		this.nombre = nombre;
		pick = 5;
		axe = 5;
		shov = 5;
	}

	/**
	 * No hace falta explicarlo... o si?
	 */
	public String toString() {
		return this.nombre + "\nMaterias primas recolectadas:\n" + "Plantas: " + materiasPrimas[Bloque.PLANTA]
				+ "\nArboles: " + materiasPrimas[Bloque.ARBOL] + "\nArcilla: " + materiasPrimas[Bloque.ARCILLA]
				+ "\nAlbero: " + materiasPrimas[Bloque.ALBERO] + "\nHierro: " + materiasPrimas[Bloque.HIERRO]
				+ "\nCobre: " + materiasPrimas[Bloque.COBRE] + "\nHerramientas:" + "\nHacha: " + axe + "\nPico: " + pick
				+ "\nPala: " + shov;
	}

	/**
	 * Metodo que añade una unidad de una materia "tipo"
	 * 
	 * @param tipo, entero que representa el tipo de Materia.
	 * @see bloque.Bloque.java
	 */
	public void sumaMateria(int tipo) {
		switch (tipo) {
		case Bloque.ALBERO: {
			materiasPrimas[Bloque.ALBERO]++;
			break;
		}
		case Bloque.ARBOL: {
			materiasPrimas[Bloque.ARBOL]++;
			break;
		}
		case Bloque.ARCILLA: {
			materiasPrimas[Bloque.ARCILLA]++;
			break;
		}
		case Bloque.COBRE: {
			materiasPrimas[Bloque.COBRE]++;
			break;
		}
		case Bloque.HIERRO: {
			materiasPrimas[Bloque.HIERRO]++;
			break;
		}
		case Bloque.PLANTA: {
			materiasPrimas[Bloque.PLANTA]++;
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + tipo);
		}

	}

	public void coords(int i, int j, int k) {
		x = i;
		y = j;
		z = k;
	}

	public String getCoords() {
		return "x" + x + " " + "y" + y + " " + "z" + z;
	}

	public void uso(String herramienta) {
		if (herramienta.equals(BloqueMineral.HERRAMIENTA)) {
			pick--;
			if (pick == 0) {
				System.out.println("{<=========[Minceraft]=========>}");
				System.out.println("{<                             >}");
				System.out.println("{<    (Tu pico se ha roto!)    >}");
				System.out.println("{<                             >}");
				System.out.println("{<=========[Minceraft]=========>}");
				System.out.println("");
			}
		}

		if (herramienta.equals(BloqueVegetal.HERRAMIENTA)) {
			axe--;
			if (axe == 0) {
				System.out.println("{<=========[Minceraft]=========>}");
				System.out.println("{<                             >}");
				System.out.println("{<    (Tu hacha se ha roto!)   >}");
				System.out.println("{<                             >}");
				System.out.println("{<=========[Minceraft]=========>}");
				System.out.println("");
			}
		}

		if (herramienta.equals(BloqueTierra.HERRAMIENTA)) {
			shov--;
			if (shov == 0) {
				System.out.println("{<=========[Minceraft]=========>}");
				System.out.println("{<                             >}");
				System.out.println("{<    (Tu pala se ha roto!)    >}");
				System.out.println("{<                             >}");
				System.out.println("{<=========[Minceraft]=========>}");
				System.out.println("");
			}
		}
	}

	public void repairTools() {

		if (materiasPrimas[Bloque.HIERRO] >= 1 && materiasPrimas[Bloque.ARBOL] >= 2
				&& materiasPrimas[Bloque.COBRE] >= 1) {
			materiasPrimas[Bloque.HIERRO]--;
			materiasPrimas[Bloque.ARBOL]--;
			materiasPrimas[Bloque.ARBOL]--;
			materiasPrimas[Bloque.COBRE]--;
			pick = 5;
			System.out.println("Tu pico ha sido reparado!");
		} else {
			System.err.println("Tu pico no ha podido ser reparado!");
		}

		if (materiasPrimas[Bloque.HIERRO] >= 1 && materiasPrimas[Bloque.ARBOL] >= 1) {
			materiasPrimas[Bloque.HIERRO]--;
			materiasPrimas[Bloque.ARBOL]--;
			axe = 5;
			System.out.println("Tu hacha ha sido reparada!");
		} else {
			System.err.println("Tu hacha no ha podido ser reparada!");
		}

		if (materiasPrimas[Bloque.HIERRO] >= 2 && materiasPrimas[Bloque.ARBOL] >= 2) {
			materiasPrimas[Bloque.HIERRO]--;
			materiasPrimas[Bloque.HIERRO]--;
			materiasPrimas[Bloque.ARBOL]--;
			materiasPrimas[Bloque.ARBOL]--;
			shov = 5;
			System.out.println("Tu pala ha sido reparada!");
		} else {
			System.err.println("Tu pala no ha podido ser reparada!");
		}

	}

	public void stats() {
		System.out.println("{<=========[Minceraft]=========>}");
		System.out.println("{<                             >}");
		System.out.println("{<           [" + nombre + "]           >}");
		System.out.println("{<                             >}");
		System.out.println("{<    Materias recolectadas:   >}");
		System.out.println("{<          PLANTA: " + materiasPrimas[Bloque.PLANTA] + "          >}");
		System.out.println("{<          ÁRBOL: " + materiasPrimas[Bloque.ARBOL] + "           >}");
		System.out.println("{<          ARCILLA: " + materiasPrimas[Bloque.ARCILLA] + "         >}");
		System.out.println("{<          ALBERO: " + materiasPrimas[Bloque.ALBERO] + "          >}");
		System.out.println("{<          HIERRO: " + materiasPrimas[Bloque.HIERRO] + "          >}");
		System.out.println("{<          COBRE: " + materiasPrimas[Bloque.COBRE] + "           >}");
		System.out.println("{<                             >}");
		System.out.println("{<    Herramientas actuales:   >}");
		System.out.println("{<                             >}");
		System.out.println("{<        PICO: " + pick + " usos         >}");
		System.out.println("{<        HACHA: " + axe + " usos        >}");
		System.out.println("{<        PALA: " + shov + " usos         >}");
		System.out.println("{<                             >}");
		System.out.println("{<    Coordenadas actuales:    >}");
		System.out.println("{<          " + this.getCoords() + "           >}");
		System.out.println("{<                             >}");
		System.out.println("{<=========[Minceraft]=========>}");
		System.out.println("");

	}

	public void milk() {
		this.blindness = false;

	}

	public void blind() {
		this.blindness = true;

	}

	public boolean victory() {

		boolean won = false;

		if (materiasPrimas[Bloque.PLANTA] >= 7 && materiasPrimas[Bloque.ARBOL] >= 7
				&& materiasPrimas[Bloque.ARCILLA] >= 7 && materiasPrimas[Bloque.ALBERO] >= 7
				&& materiasPrimas[Bloque.HIERRO] >= 7 && materiasPrimas[Bloque.COBRE] >= 7) {
			won = true;
		}

		return won;

	}

	public void debugWin() {
		materiasPrimas[Bloque.PLANTA] = 7;
		materiasPrimas[Bloque.ARBOL] = 7;
		materiasPrimas[Bloque.ARCILLA] = 7;
		materiasPrimas[Bloque.ALBERO] = 7;
		materiasPrimas[Bloque.HIERRO] = 7;
		materiasPrimas[Bloque.COBRE] = 7;
	}

}
