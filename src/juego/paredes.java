package juego;

import java.awt.Rectangle;
import java.awt.geom.Area;
import javax.swing.ImageIcon;

/**
 * Esta clase se implementara en el jugador con colisiones para que el jugador no pueda salirse del juego
 * 
 * @author Gabriel Vargas y Hodei Axpe
 * 
 * @apiNote no tiene imagenes porque son objetos invicible
 *
 */
public class paredes {

	// ************************************************ Variables *************************************************************** //
	
	// variables de objetos de otras clases //
	juego jueguito;
	
	// variables de clases de java //
	ImageIcon fondo = new ImageIcon();
	Area ancho1, ancho2;
	
	// posicion por defecto //
	int x1 = 670;
	int x2 = -8;
	int y1 = 700;
	int y2 = 700;

	// ************************************************ Constructor ************************************************************ //
	
	public paredes(juego juego) {

		this.jueguito = juego;
	}
	
	// ************************************************ Metodos *************************************************************** //

	/**
	 * crea la hitbox de la pared dechera
	 * 
	 * @return devuelve las hitbox de la pared derecha
	 */
	public Area getBounds() {

		Rectangle formal = new Rectangle(x1 + 30, y2, 65, 20);
		ancho1 = new Area(formal);

		return ancho1;

	}

	/**
	 * crea la hitbox de la pared izquierda
	 * 
	 * @return devuelve las hitbox de la pared izquierda
	 */
	public Area getBounds1() {

		Rectangle forma2 = new Rectangle(x2, y2, 20, 20);
		ancho2 = new Area(forma2);

		return ancho2;

	}

}