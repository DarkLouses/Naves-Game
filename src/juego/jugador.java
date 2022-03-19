package juego;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * 
 * Esta clase contiene el jugador y sus metodos
 * 
 * @author Gabriel Vargas y Hodei Axpe
 * 
 * @apiNote sus movimiento por botones estan hecho en juego
 *
 */
 class jugador {

	// ************************************************ Variables *************************************************************** //

	// variables de objetos de otras clases //
	juego jueguito;
	enemigo enemigo;
	paredes pared;
	rayito rayo = new rayito(jueguito);
	ArrayList<rayito> municion = new ArrayList<>();

	// variables de clases de java //
	ImageIcon nave = new ImageIcon();
	Area naves;
	
	// posicion por defecto //
	int x_defecto = 284;
	int y_defecto = 700;

	// manipulacion de movimiento //
	int x_movimiento = 0;

	// disparo //
	boolean disparar = false;
	
	// ************************************************ Constructor ************************************************************ //
	
	public jugador(juego navesita) {

		this.jueguito = navesita;

	}

	// ************************************************ Metodos *************************************************************** //
	
	/**
	 * 
	 *Este metodo hace que mueva los jugador
	 *
	 *@apiNote tiene implementado colisiones de la paredes invicibles
	 *
	 */
	public void mover() {

		if (colisionderecha()) {

			x_defecto = x_defecto - 5;
			
			if (jueguito.vidaenemiga == 1 || jueguito.vidaenemiga == 0) {
				
				x_defecto = x_defecto - 9;
			}
		}

		if (colisionizquierda()) {

			x_defecto = x_defecto + 2;

		}

		else {

			x_defecto += x_movimiento;
		}

	}

	/**
	 * Construye la imagen de el Jugador
	 */
	public void inicializar() {

		nave = new ImageIcon("multimedia/nave.png");
	}

	/**
	 * 
	 * Pinta la imagen en el plano
	 * 
	 * @param g = pintar
	 */
	public void paint(Graphics2D g) {

		g.drawImage(nave.getImage(), x_defecto, y_defecto, 112 , 78 , null);

	}

	/**
	 * crea la hitbox del jugador
	 * 
	 * @return devuelve las hitbox de la nave del jugador
	 */
	public Area getBounds() {

		Rectangle formal = new Rectangle(x_defecto + 44, y_defecto, 46, 20);
		naves = new Area(formal);

		return naves;

	}
	
	/**
	 * 
 	 * Toma las hitbox de la pared derecha
	 * 
	 * @return devuelve true si las dos hitbox chocan
	 */
	public boolean colisionderecha() {

		Area areaA = jueguito.paredes.getBounds();
		areaA.intersect(getBounds());

		return !areaA.isEmpty();

	}

	/**
	 * 
 	 * Toma las hitbox de la pared izquierda
	 * 
	 * @return devuelve true si las dos hitbox chocan
	 */
	public boolean colisionizquierda() {

		Area areaA = jueguito.paredes.getBounds1();
		areaA.intersect(getBounds());

		return !areaA.isEmpty();

	}

	/**
	 * 
 	 * Este metodo es el cargador del jugador para que pueda "disparar" rayos
	 * 
	 * @return Devuelve un arraylist de 4 rayos para el jugdador
	 */
	public ArrayList<rayito> cargador() {

		for (int i = 0; i < 5; i++) {

			rayito rayo = new rayito(jueguito);

			rayo.setX_defecto(x_defecto + 46);
			rayo.setY_defecto(y_defecto - 40);
			rayo.getY_movimiento();

			System.out.println(municion);
			municion.add(rayo);
		}

		return municion;

	}

	

}
