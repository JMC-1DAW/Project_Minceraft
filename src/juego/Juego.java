package juego;

import java.util.Random;
import java.util.Scanner;

import bloque.Bloque;
import bloque.categoria.BloqueMineral;
import bloque.material.BloqueAlbero;
import bloque.material.BloqueArbol;
import bloque.material.BloqueArcilla;
import bloque.material.BloqueCobre;
import bloque.material.BloqueHierro;
import bloque.material.BloquePlanta;
import bloque.material.BloqueVacio;

/**
 * IES Cristobal de Monroy
 * CFGS - Desarrollo de Aplicaciones Multiplataforma
 * Modulo - Programación
 * @category Practica V - MineMonroy
 * @author y0rg
 * @version 1.1
 */

public class Juego {
	
	//Indica el tamano del cub que contendra el mapa que vamos a crear
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

		//Creamos el mapa del juego
		Bloque[][][] mundo3D = new Bloque[TAMANO_MUNDO][TAMANO_MUNDO][TAMANO_MUNDO];
		
		//Lo rellenamos de bloques aleatorios de cualquir tipo, incluso tipo Bloque (vacio)
		for (int i= 0; i <TAMANO_MUNDO; i++) {
			for (int j= 0; j <TAMANO_MUNDO; j++) {
				for (int k= 0; k <TAMANO_MUNDO; k++) {
					mundo3D[i][j][k] = generaBloqueAleatorio(i,j,k);
				}
			}
		}

		System.out.println("{<=========[Minceraft]=========>}");
		System.out.println("{<                             >}");
		System.out.println("{<       Posicionando...       >}");
		System.out.println("{<                             >}");
		System.out.println("{<=========[Minceraft]=========>}");
		System.out.println("");

		
		//Creamos el jugador
		Jugador yo = new Jugador("Jorge");
		
		boolean spawned = false;
		
		int i = 0, j = 0, k = 2;
		
		do {
			
			if (mundo3D[i][j][k].spawnCheck()) {
				yo.coords(i,j,k);
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
		
		System.out.println("{<=========[Minceraft]=========>}");
		System.out.println("{<                             >}");
		System.out.println("{<      Seleccione acción:     >}");
		System.out.println("{<                             >}");
		System.out.println("{<=========[Minceraft]=========>}");
		System.out.println("");
		
		int act = 0;
		
		do {

			System.out.println("{<=========[Minceraft]=========>}");
			System.out.println("{<                             >}");
			System.out.println("{<       [MENÚ PRINCIPAL]      >}");
			System.out.println("{<                             >}");
			System.out.println("{<          (1) Mover          >}");
			System.out.println("{<    (2) Crear herramientas   >}");
			System.out.println("{<          (3) Estado         >}");
			System.out.println("{<          (4) Salir          >}");
			System.out.println("{<                             >}");
			System.out.println("{<=========[Minceraft]=========>}");
			System.out.println("");
			
			act = in.nextInt();
			
			switch (act) {
				case 1: {
					
					String pos = yo.getCoords();
					int move;
					
					System.out.println("{<=========[Minceraft]=========>}");
					System.out.println("{<                             >}");
					System.out.println("{<   ¿Hacia donde se moverá?   >}");
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
							break;
						}
						case 2: {
							break;
						}
						case 3: {
							break;
						}
						case 4: {
							break;
						}
						case 5: {
							break;
						}
						case 6: {
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
					break;
				}
				case 3: {
					System.out.println(yo);
					break;
				}
				case 4: {
					break;
				}
				default: {
					System.err.println("{<=========[Minceraft]=========>}");
					System.err.println("{<                             >}");
					System.err.println("{<     Eso no es una acción    >}");
					System.err.println("{<                             >}");
					System.err.println("{<=========[Minceraft]=========>}");
					System.out.println("");
				}
			}
			
		} while (act != 4);
		
	}

	
	/**
	 * Metodo para generar bloques de tipo aleatorio
	 * @param x posicion x en la que se encuentra el bloque
	 * @param y posicion y en la que se encuentra el bloque
	 * @param z posicion z en la que se encuentra el bloque
	 * @return el bloque creado
	 */
	public static Bloque generaBloqueAleatorio(int x, int y, int z) {

		Bloque bloque;
		Random rd = new Random();

		//Ponemos el numero de materias +2, se sale del rango (default)
		//para que los casos +1 y +2 que no estan contemplados, generen bloques vacios
		
		// Ya que se estableció la regla de que los bloques por debajo de z = 1
		// no pueden ser vacíos, separamos el aleatorio en 2 y elegimos el que
		// encaje mejor, si z es 1 o 0 no podrá generar un bloque vacío y si
		// z es mayor funcionará igual que antes
		int tipo;

		if (z <= 1) {
			tipo = rd.nextInt(Bloque.NUM_MATERIAS);
		} else {
			tipo = rd.nextInt(Bloque.NUM_MATERIAS+2);
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
