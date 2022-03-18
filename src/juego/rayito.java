package juego;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import javax.swing.ImageIcon;
/**
 * 
 * Esta clase contiene los rayo del enemigo y del jugador 
 * 
 * @author Gabriel Vargas y Hodei Axpe
 * 
 * @apiNote Se implementara en jugador y en enemigo de forma de ArrayList
 *
 */
public class rayito {

	// ************************************************ Variables  *************************************************************** //
	

	// variables de objetos de otras clases //
	jugador jugador;
	enemigo enemigo;
	juego juego;

	// variables de clases de java //
	ImageIcon imagen = new ImageIcon();
	Area rayito, palo;

	// variables de posicion //
	int x_defecto = 0;
	int y_defecto = 0;

	// variable de movimiento //
	int y_movimiento = -9;
	
	
	// ************************************************ Constructor ************************************************************ //
	public rayito(juego rayito) {

		this.juego = rayito;

	}

	// ************************************************ Metodos *************************************************************** //
	
	/**
	 * 
	 *Este metodo hace que mueva los rayos
	 *
	 *@apiNote tiene implementado colisiones enemigas y aliadas 
	 *
	 */
	public void mover() {

		if (colisionaliada()) {

			juego.perdervidajugador = true;

			if (juego.Tuvida == 0) {

				juego.perderpartida = true;

			}

			else {
				y_defecto += y_movimiento;

			}

		}

		if (colisionenemigo()) {

			juego.perdervidaenemigo = true;

			if (juego.vidaenemiga == 0) {

				juego.ganarpartida = true;
			}

		}

		else {
			
			y_defecto += y_movimiento;

		}

	}

	/**
	 * Construye la imagen de el rayo del jugador
	 * 
	 */
	public void inicializaraliada() {

		imagen = new ImageIcon("multimedia/Rayo-azul.png");

	}
	
	/**
	 * Construye la imagen de el rayo del enemigo
	 * 
	 * 
	 */
	public void inicializarenemigo() {

		imagen = new ImageIcon("multimedia/Rayo-rojo.png");

	}

	/**
	 * 
	 * Pinta la imagen en el plano
	 * 
	 * @param g = pintar
	 */
	public void paint(Graphics2D g) {

		g.drawImage(imagen.getImage(), x_defecto, y_defecto + 13, 20, 40, null);

	}
		
	/**
	 * 
	 * crea las la hitbox del rayo
	 * 
	 * @return Devuelve la hitbox del rayo
	 */
	public Area getBounds() {

		Rectangle formal = new Rectangle(x_defecto, y_defecto, 40, 20);

		rayito = new Area(formal);

		return rayito;

	}

	/**
	 * Toma las hitbox del jugador y las hitbox del rayo
	 * 
	 * @return devuelve true si las dos hitbox chocan
	 */
	public boolean colisionaliada() {

		Area areaA = juego.jugador.getBounds();
		areaA.intersect(getBounds());

		return !areaA.isEmpty();

	}

	/**
	 * 
 	 *Toma las hitbox del enemigo y las hitbox del rayo
	 * 
	 * @return devuelve true si las dos hitbox chocan
	 */
	public boolean colisionenemigo() {

		Area areaA = juego.enemigo.getBounds();
		areaA.intersect(getBounds());

		return !areaA.isEmpty();

	}
	
	// ************************************************ Getter and Setter *************************************************************** //
	

		public int getY_movimiento() {
			return y_movimiento;
		}

		public void setY_movimiento(int y_movimiento) {
			this.y_movimiento = y_movimiento;
		}

		public int getX_defecto() {
			return x_defecto;
		}

		public void setX_defecto(int x_defecto) {
			this.x_defecto = x_defecto;
		}

		public int getY_defecto() {
			return y_defecto;
		}

		public void setY_defecto(int y_defecto) {
			this.y_defecto = y_defecto;
		}

	


}
