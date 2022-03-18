package juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

/**
 * 
 * Esta clase contendra todas las clases anteriores menos el main 
 * 
 * @author Gabriel Vargas y Hodei Axpe
 * 
 * @apiNote tiene que extender de Jpanel para que pueda pintar sin problema en la reproducccion
 *
 */
public class juego extends JPanel {

	private static final long serialVersionUID = -166819071789321133L;

	// ************************************************ Variables *************************************************************** //

	// variables de objetos de otras clases //
	jugador jugador = new jugador(this);
	fondo fondo = new fondo(this);
	enemigo enemigo = new enemigo(this);
	rayito rayo = new rayito(this);
	paredes paredes = new paredes(this);

	// posiciones de disparo del ArrayList del jugador //
	int posicion1 = 0;
	int posicion2 = -1;
	int posicion3 = -2;
	int posicion4 = -3;


	// timer de disparo de ambos //
	int timer = 0;
	int timer_enemigo = 0;

	// vida de ambos //
	int Tuvida = 3;
	int vidaenemiga = 3;

	// booleanos de ganar o perder //
	boolean perderpartida = false;
	boolean ganarpartida = false;

	// booleanos de perder vida para ambos //
	boolean perdervidaenemigo = false;
	boolean perdervidajugador = false;

	// booleanos para los paints //
	boolean recargando = false;
	boolean puedesdisparar = false;
	
	// para reiniciar el juego en el Frame //
	int reiniciarjuego;
	
	// ************************************************ Constructor ************************************************************ //

	public juego() {

		enemigo.inicializar();
		fondo.inicializar();
		jugador.inicializar();

		// ************ Cargadores **************** //
		jugador.municion = jugador.cargador();
		enemigo.municionenemiga = enemigo.cargadorenemigo();

		for (int i = 0; i < 5; i++) {

			enemigo.municionenemiga.get(i).inicializarenemigo();
			jugador.municion.get(i).inicializaraliada();

		}

		// ************* Botones ************** //

		addKeyListener(new KeyListener() {

			// Botones cuando mantienes //
			@Override
			public void keyPressed(KeyEvent s) {

				// Espacio ("Disparar") //
				
				if (s.getKeyCode() == KeyEvent.VK_SPACE && timer > 150) {

					recargando = false;
					puedesdisparar = false;

					timer = 0;
					jugador.disparar = true;

					posicion1++;
					posicion2++;
					posicion3++;
					posicion4++;
		

					// para el rayo se dispare en la posicion que esta el jugador //
					jugador.municion.get(posicion1).setX_defecto(jugador.x_defecto + 46);

					// cuando llega al maximo de tiros //
					if (posicion1 == 4) {

						// Resetea la posicion de los rayos lanzado y las variables de uso //
	
						timer = 150;

						posicion1 = 0;
						posicion2 = -1;
						posicion3 = -2;
						posicion4 = -3;
			

						
						for (int i = 0; i < 4; i++) {
							if (jugador.municion.get(i).getY_defecto() < 100) {
								jugador.municion.get(i).setY_defecto(jugador.y_defecto + -50);

							}
						}

					}

				}

				// A ("Moverse a la Izquierda) //
				if (s.getKeyCode() == KeyEvent.VK_A) {

					jugador.x_movimiento = -4;

				}

				// D ("Moverse a la Derecha) //
				 if (s.getKeyCode() == KeyEvent.VK_D) {

					jugador.x_movimiento = 4;

				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				
				// Cuando dejas de presionar la tecla (Liberas) //

				if (e.getKeyCode() == KeyEvent.VK_A) {

					jugador.x_movimiento = 0;

				}

				if (e.getKeyCode() == KeyEvent.VK_D) {

					jugador.x_movimiento = 0;
				}

			}

		});

		setFocusable(true);
	}
	
	// ************************************************ Metodos *************************************************************** //


	/**
	 * 
	 * Implementara el movimiento de todas las clases anteriores 
	 * 
	 * 
	 */
	public void mover() {

		// ****************************** Enemigo *********************************** //
		
		timer_enemigo++;
		enemigo.movervida3();
		
		// para que se mueva con la nave //
		enemigo.municionenemiga.get(0).setX_defecto(enemigo.x_defecto + 46);
		enemigo.municionenemiga.get(1).setX_defecto(enemigo.x_defecto + 46);
		enemigo.municionenemiga.get(2).setX_defecto(enemigo.x_defecto + 46);
		enemigo.municionenemiga.get(3).setX_defecto(enemigo.x_defecto + 46);
		enemigo.municionenemiga.get(4).setX_defecto(enemigo.x_defecto + 46);
		
		// las variantes de movimiento //
		if (vidaenemiga == 2) {

			enemigo.movervida2();
		}

		if (vidaenemiga == 1) {

			enemigo.movervida1();
		}

		if (vidaenemiga == 0) {

			enemigo.movervida0();
		}
		
		// el movimiento de los rayos y en que momento se moveran
		enemigo.municionenemiga.get(1).mover();

		if (timer_enemigo > 150) {
			enemigo.municionenemiga.get(2).mover();
		}

		if (timer_enemigo > 300) {
			enemigo.municionenemiga.get(3).mover();
		}

		if (timer_enemigo > 450) {
			enemigo.municionenemiga.get(4).mover();
		}

		// cuando llega el timer a 700 resetea las posiciones
		if (timer_enemigo > 700) {

			for (int i = 0; i < 4; i++) {
				if (enemigo.municionenemiga.get(i).getY_defecto() > 500) {
					enemigo.municionenemiga.get(i).setY_defecto(enemigo.y_defecto + 50);
				}
			}

			timer_enemigo = 0;
		}
		
		// ****************************** Jugador *********************************** //

		jugador.mover();
		timer++;
		recargando = true;

		// El conteo para que pueda disparar //
		if (timer > 150) {

			recargando = false;
			puedesdisparar = true;
		}
		
		// para que no haya errores de textura en los disparos estas condiciciones //
		if (jugador.disparar) {

			if (posicion1 == 1 || posicion2 == 1 || posicion3 == 1 || posicion4 == 1) {

				jugador.municion.get(1).mover();
			}

			if (posicion1 == 2 || posicion2 == 2 || posicion3 == 2 || posicion4 == 2) {

				jugador.municion.get(2).mover();
			}

			if (posicion1 == 3 || posicion2 == 3 || posicion3 == 3 || posicion4 == 3) {

				jugador.municion.get(3).mover();
			}

			if (posicion1 == 4 || posicion2 == 4 || posicion3 == 4 || posicion4 == 4) {

				jugador.municion.get(4).mover();
			}

		}

		fondo.mover();

	}

	/**
	 * Pinta el juego y los texto del juego
	 * 
	 * @param g = pintar
	 */
	public void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		paint(g2);
		dibujarTexto(g2);

	}

	/**
	 * 
	 * Pinta todos los objetos del juego
	 * 
	 * @param g = pintar
	 */
	public void paint(Graphics2D g) {

		fondo.paint(g);
		jugador.paint(g);
		enemigo.paint(g);

		// ****************************** Enemigo *********************************** //
		
		enemigo.municionenemiga.get(1).paint(g);

		if (timer_enemigo > 150) {
			enemigo.municionenemiga.get(2).paint(g);

		}

		if (timer_enemigo > 300) {

			enemigo.municionenemiga.get(3).paint(g);

		}

		if (timer_enemigo > 450) {

			enemigo.municionenemiga.get(4).paint(g);

		}

		// ****************************** Jugador *********************************** //
		
		if (jugador.disparar) {

			if (posicion1 == 1 || posicion2 == 1 || posicion3 == 1 || posicion4 == 1) {

				jugador.municion.get(1).paint(g);
			}

			if (posicion1 == 2 || posicion2 == 2 || posicion3 == 2 || posicion4 == 2) {

				jugador.municion.get(2).paint(g);
			}

			if (posicion1 == 3 || posicion2 == 3 || posicion3 == 3 || posicion4 == 3) {

				jugador.municion.get(3).paint(g);
			}

			if (posicion1 == 4 || posicion2 == 4 || posicion3 == 4 || posicion4 == 4) {

				jugador.municion.get(4).paint(g);
			}

		}

	}

	/**
	 * 
	 * pinta el texto de el juego como la vida etc
	 * 
	 * @param g = pintar
	 */
	public void dibujarTexto(Graphics2D g) {

		Graphics2D g1 = g, g2 = g;
		Font score = new Font("Arial", Font.BOLD, 30);
		g.setFont(score);
		g.setColor(Color.LIGHT_GRAY);

		g1.drawString("tu vida : " + Tuvida, 20, 830);
		g1.drawString("vida enemigo : " + vidaenemiga, 450, 40);

		if (recargando) {

			g2.setColor(Color.red);
			g2.drawString(" Cargando Disparo ", 360, 830);

		}

		if (puedesdisparar) {

			g2.setColor(Color.cyan);
			g2.drawString(" ¡¡Dispara!!", 360, 830);
		}

	}

	/**
	 * 
	 * cuando finaliza el juego o pierdes vida reinicia todos los valores por default 
	 * 
	 * 
	 */
	public void reiniciarronda() {

		if (perdervidaenemigo) {

			vidaenemiga--;
		}

		if (perdervidajugador) {

			Tuvida--;
		}

		if (ganarpartida || perderpartida) {

			vidaenemiga = 3;
			Tuvida = 3;
		}

		recargando = false;
		puedesdisparar = false;

		perdervidaenemigo = false;
		perdervidajugador = false;

		posicion1 = 0;
		posicion2 = -1;
		posicion3 = -2;
		posicion4 = -3;

		
		timer = 0;
		timer_enemigo = 0;

		jugador.x_defecto = 284;
		jugador.y_defecto = 700;
		
		jugador.x_movimiento = 0;

		enemigo.x_defecto = 284;
		enemigo.y_defecto = 80;
		
		enemigo.x_movimiento = -4;

		for (int i = 0; i < 4; i++) {

			jugador.municion.get(i).setY_defecto(jugador.y_defecto + -50);
			enemigo.municionenemiga.get(i).setY_defecto(enemigo.y_defecto + 50);

		}

	}

}
