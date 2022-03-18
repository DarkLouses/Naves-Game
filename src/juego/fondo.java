package juego;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

public class fondo {

	juego jueguito;
	ImageIcon fondo = new ImageIcon();

	int x1 = 0;
	int x2 = 0;

	int y1 = 1300;
	int y2 = 0;

	int anchoFondo = 700;
	int alto_fondo = 1300;

	public fondo(juego juego) {

		this.jueguito = juego;
	}

	public void mover() {

		y1 -= 4;
		y2 -= 4;

		if (y1 == 0 && y2 == -1300) {

			y1 = 1300;
			y2 = 0;
		}
	}

	public void inicializar() {

		fondo = new ImageIcon("multimedia/fondo1.jpg");
	}

	// --------- paint ---------//

	// dibuja los graficos2d
	public void paint(Graphics2D g) {

		g.drawImage(fondo.getImage(), x1, y1, anchoFondo, alto_fondo, null);
		g.drawImage(fondo.getImage(), x2, y2, anchoFondo, alto_fondo, null);
	}

}