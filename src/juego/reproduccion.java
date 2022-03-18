package juego;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 * @author Gabriel Vargas y Hodei Axpe 
 *
 * @apiNote esta clase es el main de todas las clases toma como objeto a juego ya que implementa toda las clases anteriores 
 */
public class reproduccion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ************************************************ Variables *************************************************************** //
		JFrame ventana = new JFrame("naves pium pium ");
		juego jueguito = new juego();

		// definicion del Jframe
		ventana.add(jueguito);
		ventana.setSize(713, 1000);
		ventana.setLocation(700, 10);
		ventana.setVisible(true);
		ventana.setResizable(false);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ************************************************ Bucle Game *************************************************************** //
		while (true) {

			// apena empieza el Game pinta todo y lo mueve //
			jueguito.repaint();
			jueguito.mover();

			try {
				// para controlar los frame de ejecucion //
				Thread.sleep(8);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Cuando pierdes la ronda //
			if (jueguito.perdervidajugador) {

				JOptionPane.showMessageDialog(null, "por dios te gano una ronda");

				jueguito.reiniciarronda();
			}

			// Cuando ganas la ronda //
			if (jueguito.perdervidaenemigo) {

				JOptionPane.showMessageDialog(null, "le ganaste 1 ronda felicidades");

				jueguito.reiniciarronda();

			}

			// cuando pierdes el juego //
			if (jueguito.perderpartida) {

				jueguito.reiniciarjuego = JOptionPane.showConfirmDialog(null,
						"no puede ser que hayas perdido contra la maquina mal programada dios, quieres volver a intentarlo por favor",
						"perdiste", JOptionPane.YES_NO_OPTION);

				// si le das que si //
				if (jueguito.reiniciarjuego == 0) {
					
					jueguito.ganarpartida = false;
					jueguito.perderpartida = false;
					jueguito.reiniciarronda();

				}

				// si le das que no //
				else if (jueguito.reiniciarjuego == 1) {

					JOptionPane.showMessageDialog(null,
							"quiero que recuerdes antes de irte que la ludopatia es mala ");

					System.exit(0);
				}

			}

			// cuando ganas el juego //
			if (jueguito.ganarpartida) {

				jueguito.reiniciarjuego = JOptionPane.showConfirmDialog(null,
						"por fin pudiste hacer algo bien en tu vida este jueguito es el mejor juego del mundo merece un 10, sus programadores en especial gabriel es el mejor",
						"ganaste", JOptionPane.YES_NO_OPTION);

				// si le das que si //
				if (jueguito.reiniciarjuego == 0) {

					jueguito.ganarpartida = false;
					jueguito.reiniciarronda();

				}

				// si le das que no //
				else if (jueguito.reiniciarjuego == 1) {

					JOptionPane.showMessageDialog(null,
							"quiero que recuerdes que gabriel es el mejor programador del mundo y hodei no");

					System.exit(0);
				}

			}

		}

	}
	
	// ************************************************ Fin *************************************************************** //
}
