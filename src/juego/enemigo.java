package juego;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * 
 * Esta clase contiene el enemigo y sus metodos
 * 
 * @author Gabriel Vargas y Hodei Axpe
 * 
 * @apiNote la forma de disparo esta en juego
 * 
 */
public class enemigo {
	
	// ************************************************ Variables *************************************************************** //

	// variables de objetos de otras clases //
	juego juego;
	rayito rayoenemigo = new rayito(juego);
	ArrayList<rayito> municionenemiga = new ArrayList<>();

	// variables de clases de java //
	ImageIcon nave = new ImageIcon();
	Area naves;
	
	// posicion por defecto //
	int x_defecto = 284;
	int y_defecto = 80;

	// variable de movimiento //
	int x_movimiento = -4;
	
	// ************************************************ Constructor ************************************************************ //

	public enemigo(juego navesita) {

		this.juego = navesita;

	}
	
	// ************************************************ Metodos *************************************************************** //

	/**
	 * 
	 * es el movimiento de la nave enemiga cuando tiene tres vidas
	 * 
	 */
	public void movervida3() {

		if (x_defecto < -20) {

			x_movimiento = +3;

		}

		else if (x_defecto > 608) {

			x_movimiento = -3;

		}

		x_defecto += x_movimiento;

	}

	/**
	 * 
	 * es el movimiento de la nave enemiga cuando tiene dos vidas
	 * 
	 */
	public void movervida2() {

		if (x_defecto < -20) {

			x_movimiento = +5;

		}

		else if (x_defecto > 608) {

			x_movimiento = -5;

		}

		x_defecto += x_movimiento;

	}

	/**
	 * 
	 * es el movimiento de la nave enemiga cuando tiene una vidas
	 * 
	 */
	public void movervida1() {

		if (x_defecto < -20) {

			x_movimiento = +6;

		}

		else if (x_defecto > 608) {

			x_movimiento = -6;

		}

		x_defecto += x_movimiento;

	}

	/**
	 * 
	 * es el movimiento de la nave enemiga cuando ya no tiene vida
	 * 
	 */
	public void movervida0() {

		if (x_defecto < -20) {

			x_movimiento = +7;

		}

		else if (x_defecto > 608) {

			x_movimiento = -7;

		}

		x_defecto += x_movimiento;

	}

	/**
	 * Construye la imagen de el enemigo
	 */
	public void inicializar() {

		nave = new ImageIcon("multimedia/nave-enemiga.png");
	}

	/**
	 * 
	 * Pinta la imagen en el plano
	 * 
	 * @param g = pintar
	 */
	public void paint(Graphics2D g) {

		g.drawImage(nave.getImage(), x_defecto, y_defecto, 112, 78, null);

	}


	/**
	 * crea la hitbox del enemigo
	 * 
	 * @return devuelve las hitbox de la nave del enemigo
	 */
	public Area getBounds() {

		Rectangle formal = new Rectangle(x_defecto + 44, y_defecto, 46, 20);
		naves = new Area(formal);

		return naves;

	}

	/**
	 * 
 	 * Este metodo es el cargador del enemigo para que pueda "disparar" rayos
	 * 
	 * @return Devuelve un arraylist de 4 rayos para el enemigo
	 */
	public ArrayList<rayito> cargadorenemigo() {

		for (int i = 0; i < 5; i++) {

			rayito rayo = new rayito(juego);

			rayo.setX_defecto(x_defecto + 46);
			rayo.setY_defecto(y_defecto + 40);
			rayo.setY_movimiento(+4);

			System.out.println(municionenemiga);
			municionenemiga.add(rayo);
		}

		return municionenemiga;

	}

}
