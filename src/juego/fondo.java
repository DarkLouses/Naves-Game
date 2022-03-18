package juego;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

/**
 * 
 * Esta clase es el fondo del juego 
 * 
 * @author Gabriel Vargas y Hodei Axpe
 * 
 * @apiNote Son dos fondo porque se va a ir moviendo entonces para que no suceda un error en la textura del fondo
 *
 */
public class fondo {
	
	// ************************************************ Variables *************************************************************** //


	// variables de objetos de otras clases //
	juego jueguito;
	
	// variables de clases de java //
	ImageIcon fondo = new ImageIcon();

	// posicion por defecto //
	int x1 = 0;
	int x2 = 0;
	int y1 = 1300;
	int y2 = 0;

	// variable del tamaño del fondo // 
	int anchoFondo = 700;
	int alto_fondo = 1300;

	// ************************************************ Constructor ************************************************************ //
	
	public fondo(juego juego) {

		this.jueguito = juego;
	}
	
	// ************************************************ Metodos *************************************************************** //

	/**
	 * 
	 *Este metodo hace que mueve el fondo
	 *
	 *@apiNote Cuando llega a un cierto limite resetea las posiciones para que el fondo no se destruya en el movimiento
	 *
	 */
	public void mover() {

		y1 -= 4;
		y2 -= 4;

		if (y1 == 0 && y2 == -1300) {

			y1 = 1300;
			y2 = 0;
		}
	}

	/**
	 * Construye la imagen de el fondo
	 */
	public void inicializar() {

		fondo = new ImageIcon("multimedia/fondo1.jpg");
	}
	
	/**
	 * 
	 * Pinta la imagen en el plano
	 * 
	 * @param g = pintar
	 * 
	 * @apiNote pinta dos porque son dos fondos
	 */
	public void paint(Graphics2D g) {

		g.drawImage(fondo.getImage(), x1, y1, anchoFondo, alto_fondo, null);
		g.drawImage(fondo.getImage(), x2, y2, anchoFondo, alto_fondo, null);
	}

}