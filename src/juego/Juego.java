package juego;

import java.util.Random;
import java.util.Scanner;

import bloque.Bloque;
import bloque.categoria.BloqueMineral;
import bloque.categoria.BloqueTierra;
import bloque.categoria.BloqueVegetal;
import bloque.material.BloqueAlbero;
import bloque.material.BloqueArbol;
import bloque.material.BloqueArcilla;
import bloque.material.BloqueCobre;
import bloque.material.BloqueHierro;
import bloque.material.BloquePlanta;
import bloque.material.BloqueVacio;

/**
 * IES Cristobal de Monroy CFGS - Desarrollo de Aplicaciones Multiplataforma
 * Modulo - Programación
 * 
 * @category Practica V - MineMonroy
 * @author y0rg
 * @version 1.1
 */

public class Juego {

	// Indica el tamano del cub que contendra el mapa que vamos a crear
	public static final int TAMANO_MUNDO = 10;

	private static final Scanner in = new Scanner(System.in);

	/**
	 * Metodo principal, ejecuta el juego
	 */
	public static void main(String[] args) {

		System.out.println("{<=========[Minceraft]=========>}");
		System.out.println("{<                             >}");
		System.out.println("{<      Creando mundo...       >}");
		System.out.println("{<                             >}");
		System.out.println("{<=========[Minceraft]=========>}");
		System.out.println("");

		// Creamos el mapa del juego
		Bloque[][][] mundo3D = new Bloque[TAMANO_MUNDO][TAMANO_MUNDO][TAMANO_MUNDO];

		// Lo rellenamos de bloques aleatorios de cualquir tipo, incluso tipo Bloque
		// (vacio)
		for (int i = 0; i < TAMANO_MUNDO; i++) {
			for (int j = 0; j < TAMANO_MUNDO; j++) {
				for (int k = 0; k < TAMANO_MUNDO; k++) {
					mundo3D[i][j][k] = generaBloqueAleatorio(i, j, k);
				}
			}
		}

		// Creamos el jugador
		Jugador yo = new Jugador("Jorge");

		boolean spawned = false;

		System.out.println("{<=========[Minceraft]=========>}");
		System.out.println("{<                             >}");
		System.out.println("{<       Posicionando...       >}");
		System.out.println("{<                             >}");
		System.out.println("{<=========[Minceraft]=========>}");
		System.out.println("");

		int i = 0, j = 0, k = 1;

		do {

			if (mundo3D[i][j][k].spawnCheck()) {
				yo.coords(i, j, k);
				spawned = true;
			} else {
				if (i == 9) {
					i = 0;
					j++;
					if (j == 9) {
						j = 0;
						k++;
					}
				} else {
					i++;
				}
			}

		} while (!spawned);

		String pos = yo.getCoords();

		System.out.println("{<=========[Minceraft]=========>}");
		System.out.println("{<                             >}");
		System.out.println("{< Posición actual = " + pos + "  >}");
		System.out.println("{<                             >}");
		System.out.println("{<=========[Minceraft]=========>}");
		System.out.println("");

		int act = 0;

		do {

			if (!yo.victory()) {

				System.out.println("{<=========[Minceraft]=========>}");
				System.out.println("{<                             >}");
				System.out.println("{<       [MENÚ PRINCIPAL]      >}");
				System.out.println("{<                             >}");
				System.out.println("{<          (1) Mover          >}");
				System.out.println("{<    (2) Crear herramientas   >}");
				System.out.println("{<          (3) Estado         >}");
				System.out.println("{<          (4) Salir          >}");
				System.out.println("{<      (5) Teletransporte     >}");
				if (yo.blindness) {
					System.out.println("{<       (6) Beber leche       >}");
				} else {
					System.out.println("{<         (6) Cegarse         >}");
				}
				System.out.println("{<                             >}");
				System.out.println("{<=========[Minceraft]=========>}");
				System.out.println("");

				act = in.nextInt();

				switch (act) {
				case 0: {
					mostrarMapa(mundo3D);
					break;
				}
				case 1: {

					int move;

					pos = yo.getCoords();

					System.out.println("{<=========[Minceraft]=========>}");
					System.out.println("{<                             >}");
					System.out.println("{<   ¿Hacia donde te moverás?  >}");
					System.out.println("{<                             >}");
					System.out.println("{<          (1) /\\             >}");
					System.out.println("{<          (2) ^              >}");
					System.out.println("{<        (3) < O > (4)        >}");
					System.out.println("{<          (5) v              >}");
					System.out.println("{<          (6) \\/             >}");
					System.out.println("{<                             >}");
					System.out.println("{< Posición actual = " + pos + "  >}");
					System.out.println("{<                             >}");
					System.out.println("{<=========[Minceraft]=========>}");
					System.out.println("");

					move = in.nextInt();

					switch (move) {
					case 1: {
						k++;
						if (k > 9) {
							k = 0;
						}

						if (!movimientoJugador(mundo3D, yo, i, j, k)) {
							k--;
						}
						break;
					}
					case 2: {
						i++;
						if (i > 9) {
							i = 0;
						}

						if (!movimientoJugador(mundo3D, yo, i, j, k)) {
							i--;
						}
						break;
					}
					case 3: {
						j--;
						if (j < 0) {
							j = 9;
						}

						if (!movimientoJugador(mundo3D, yo, i, j, k)) {
							j++;
						}
						break;
					}
					case 4: {
						j++;
						if (j > 9) {
							j = 0;
						}

						if (!movimientoJugador(mundo3D, yo, i, j, k)) {
							j--;
						}
						break;
					}
					case 5: {
						i--;
						if (i < 0) {
							i = 9;
						}

						if (!movimientoJugador(mundo3D, yo, i, j, k)) {
							i++;
						}
						break;
					}
					case 6: {
						k--;
						if (k < 0) {
							k = 9;
						}

						if (!movimientoJugador(mundo3D, yo, i, j, k)) {
							k++;
						}
						break;
					}
					default: {
						System.out.println("{<=========[Minceraft]=========>}");
						System.out.println("{<                             >}");
						System.out.println("{<     (Decides no moverte)    >}");
						System.out.println("{<                             >}");
						System.out.println("{<=========[Minceraft]=========>}");
						System.out.println("");
					}
					}

					break;
				}
				case 2: {
					yo.repairTools();
					break;
				}
				case 3: {
					pos = yo.getCoords();
					yo.stats();
					break;
				}
				case 4: {
					break;
				}
				case 5: {

					pos = yo.getCoords();

					int tpx, tpy, tpz;

					System.out.println("{<=========[Minceraft]=========>}");
					System.out.println("{<                             >}");
					System.out.println("{<     ¿Hacia dónde quieres    >}");
					System.out.println("{<      teletransportarte?     >}");
					System.out.println("{<                             >}");
					System.out.println("{<   Introduce uno a la vez:   >}");
					System.out.println("{<        ( x / y / z )        >}");
					System.out.println("{<                             >}");
					System.out.println("{< Posición actual = " + pos + "  >}");
					System.out.println("{<                             >}");
					System.out.println("{<=========[Minceraft]=========>}");
					System.out.println("");

					tpx = in.nextInt();
					tpy = in.nextInt();
					tpz = in.nextInt();

					if (movimientoJugador(mundo3D, yo, tpx, tpy, tpz)) {
						i = tpx;
						j = tpy;
						k = tpz;
					}

					break;
				}
				case 6: {
					if (yo.blindness) {
						System.out.println("{<=========[Minceraft]=========>}");
						System.out.println("{<                             >}");
						System.out.println("{<    Bebes un cubo de leche   >}");
						System.out.println("{<                             >}");
						System.out.println("{< Tu ceguera se ha eliminado! >}");
						System.out.println("{<                             >}");
						System.out.println("{<        (Modo fácil)         >}");
						System.out.println("{<                             >}");
						System.out.println("{<=========[Minceraft]=========>}");
						System.out.println("");

						yo.milk();
					} else {
						System.out.println("{<=========[Minceraft]=========>}");
						System.out.println("{<                             >}");
						System.out.println("{<    Acercas la punta de tu   >}");
						System.out.println("{<      pico a tus ojos y      >}");
						System.out.println("{< ########################### >}");
						System.out.println("{<                             >}");
						System.out.println("{<    Tu ceguera ha vuelto!    >}");
						System.out.println("{<                             >}");
						System.out.println("{<        (Modo normal)        >}");
						System.out.println("{<                             >}");
						System.out.println("{<=========[Minceraft]=========>}");
						System.out.println("");

						yo.blind();
					}

					break;
				}
				case 616: {
					yo.debugWin();
					break;
				}
				default: {
					System.err.println("{<=========[Minceraft]=========>}");
					System.err.println("{<                             >}");
					System.err.println("{<     Eso no es una acción    >}");
					System.err.println("{<                             >}");
					System.err.println("{<=========[Minceraft]=========>}");
					System.out.println("");
					break;
				}
				}
			} else {
				System.out.println("{<=========[Minceraft]=========>}");
				System.out.println("{<                             >}");
				System.out.println("{<     HAS GANADO EL JUEGO!    >}");
				System.out.println("{<                             >}");
				System.out.println("{<=========[Minceraft]=========>}");
				System.out.println("");

				act = 4;
			}
		} while (act != 4);

	}

	private static void mostrarMapa(Bloque[][][] mundo3D) {

		System.out.println("");
		System.out.println("Capa 0");

		for (int k = 0; k < TAMANO_MUNDO; k++) {
			for (int j = 0; j < TAMANO_MUNDO; j++) {
				for (int i = 0; i < TAMANO_MUNDO; i++) {
					System.out.print(mundo3D[i][j][k].toString());
					if (i == 9) {
						System.out.println("");
					}
				}

				if (j == 9 && k != 9) {
					System.out.println("");
					System.out.println("Capa " + (k + 1));
				}
			}
		}

		System.out.println("");

	}

	private static boolean movimientoJugador(Bloque[][][] mundo3D, Jugador yo, int i, int j, int k) {

		boolean moved = true;

		if (!yo.blindness) {
			System.out.println("{<=========[Minceraft]=========>}");
			System.out.println("{<                             >}");
			System.out.println("{<     Encuentras un bloque    >}");
			System.out.println("{<" + mundo3D[i][j][k].toString() + ">}");
			System.out.println("{<                             >}");
			System.out.println("{<=========[Minceraft]=========>}");
			System.out.println("");
		}

		if (mundo3D[i][j][k].spawnCheck()) {

			System.out.println("{<=========[Minceraft]=========>}");
			System.out.println("{<                             >}");
			System.out.println("{<  (No hay nada frente a ti)  >}");
			System.out.println("{<                             >}");
			System.out.println("{<=========[Minceraft]=========>}");
			System.out.println("");

			yo.coords(i, j, k);
		} else {

			System.out.println("{<=========[Minceraft]=========>}");
			System.out.println("{<                             >}");
			System.out.println("{<       ¿Herramienta con      >}");
			System.out.println("{<       la que romper el      >}");
			System.out.println("{<           bloque?           >}");
			System.out.println("{<                             >}");
			System.out.println("{<          (1) Pico           >}");
			System.out.println("{<          (2) Hacha          >}");
			System.out.println("{<          (3) Pala           >}");
			System.out.println("{<                             >}");
			System.out.println("{<=========[Minceraft]=========>}");
			System.out.println("");

			int usable = in.nextInt();

			switch (usable) {
			case 1: {
				if (yo.pick > 0) {
					mundo3D[i][j][k].destruir(BloqueMineral.HERRAMIENTA, yo);
					yo.coords(i, j, k);
					yo.uso(BloqueMineral.HERRAMIENTA);
				} else {
					System.out.println("{<=========[Minceraft]=========>}");
					System.out.println("{<                             >}");
					System.out.println("{<     (Tu pico está roto)     >}");
					System.out.println("{<   (No has podido avanzar)   >}");
					System.out.println("{<                             >}");
					System.out.println("{<=========[Minceraft]=========>}");
					System.out.println("");

					moved = false;
				}
				break;
			}
			case 2: {
				if (yo.axe > 0) {
					mundo3D[i][j][k].destruir(BloqueVegetal.HERRAMIENTA, yo);
					yo.coords(i, j, k);
					yo.uso(BloqueVegetal.HERRAMIENTA);
				} else {
					System.out.println("{<=========[Minceraft]=========>}");
					System.out.println("{<                             >}");
					System.out.println("{<     (Tu hacha está rota)    >}");
					System.out.println("{<   (No has podido avanzar)   >}");
					System.out.println("{<                             >}");
					System.out.println("{<=========[Minceraft]=========>}");
					System.out.println("");

					moved = false;
				}
				break;
			}
			case 3: {
				if (yo.shov > 0) {
					mundo3D[i][j][k].destruir(BloqueTierra.HERRAMIENTA, yo);
					yo.coords(i, j, k);
					yo.uso(BloqueTierra.HERRAMIENTA);
				} else {
					System.out.println("{<=========[Minceraft]=========>}");
					System.out.println("{<                             >}");
					System.out.println("{<     (Tu hacha está rota)    >}");
					System.out.println("{<   (No has podido avanzar)   >}");
					System.out.println("{<                             >}");
					System.out.println("{<=========[Minceraft]=========>}");
					System.out.println("");

					moved = false;
				}
				break;
			}
			default: {
				System.out.println("{<=========[Minceraft]=========>}");
				System.out.println("{<                             >}");
				System.out.println("{<    (Decides no romperlo)    >}");
				System.out.println("{<   (No has podido avanzar)   >}");
				System.out.println("{<                             >}");
				System.out.println("{<=========[Minceraft]=========>}");
				System.out.println("");

				moved = false;
			}
			}
		}
		return moved;

	}

	/**
	 * Metodo para generar bloques de tipo aleatorio
	 * 
	 * @param x posicion x en la que se encuentra el bloque
	 * @param y posicion y en la que se encuentra el bloque
	 * @param z posicion z en la que se encuentra el bloque
	 * @return el bloque creado
	 */
	public static Bloque generaBloqueAleatorio(int x, int y, int z) {

		Bloque bloque;
		Random rd = new Random();

		// Ponemos el numero de materias +2, se sale del rango (default)
		// para que los casos +1 y +2 que no estan contemplados, generen bloques vacios

		// En este caso poniendo un +6 podemos asegurar que al menos la mitad de los
		// bloques en total sean bloques vacíos

		// Ya que se estableció la regla de que los bloques por debajo de z = 1
		// no pueden ser vacíos, separamos el aleatorio en 2 y elegimos el que
		// encaje mejor, si z es 1 o 0 no podrá generar un bloque vacío y si
		// z es mayor funcionará igual que antes
		int tipo;

		if (z <= 1) {
			tipo = rd.nextInt(Bloque.NUM_MATERIAS);
		} else {
			tipo = rd.nextInt(Bloque.NUM_MATERIAS + 6);
		}

		switch (tipo) {
		case Bloque.ALBERO: {
			bloque = new BloqueAlbero(x, y, z);
			break;
		}
		case Bloque.ARBOL: {
			bloque = new BloqueArbol(x, y, z);
			break;
		}
		case Bloque.ARCILLA: {
			bloque = new BloqueArcilla(x, y, z);
			break;
		}
		case Bloque.COBRE: {
			bloque = new BloqueCobre(x, y, z);
			break;
		}
		case Bloque.HIERRO: {
			bloque = new BloqueHierro(x, y, z);
			break;
		}
		case Bloque.PLANTA: {
			bloque = new BloquePlanta(x, y, z);
			break;
		}
		default: {
			bloque = new BloqueVacio(x, y, z);
		}

		}
		return bloque;
	}

}
