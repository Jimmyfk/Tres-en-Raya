package acciones;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import botones.BotonMorado;
import botones.BotonVerde;
import grafico.TableroGrafico;
import interfaz.InterfazTablero;
import juego.MachineActualizada;
import pojo.Tablero;

public class Acciones implements InterfazTablero {
	
	private BotonVerde [][] jbtVerde = null;
	private BotonMorado [][] jbtMorado = null;
	private JFrame jfrFondo = null;
	
	private Tablero objTablero = null;
	private TableroGrafico objGrp = null;
	private MachineActualizada objMaquina = null; 
	
	private boolean fin;
	
	public Acciones(BotonVerde[][] verde, Tablero tbl, MachineActualizada machine, JFrame jfrPrincipal) {
		jbtVerde = verde;
		objTablero = tbl;
		objMaquina = machine;
		jfrFondo = jfrPrincipal;
		jfrFondo.
		
	}
	
	public Acciones(BotonMorado[][] morado, Tablero tbl, TableroGrafico tableroGrafico) {
		jbtMorado = morado;
		objTablero = tbl;
		objGrp = tableroGrafico;
	}
	
	//Inicio MODO1
		public void pulsar1(int i, int j) {
			jbtVerde[i][j].setIcon(new ImageIcon(getClass().getResource(URL_JUGADOR_1)));
			jbtVerde[i][j].setDisabledIcon(new ImageIcon(getClass().getResource(URL_JUGADOR_1)));
			jbtVerde[i][j].setEnabled(false);
			comprobacionesIguales(i, j);
			objTablero.setTurno((byte) 2);
			if(!fin)
				jugadaMaquina();
			else
				objTablero.setTurno((byte) 1);
		}
		
		public void jugadaMaquina() {
			objTablero.sumarContador();
			objMaquina.movimientoMaquina();
			//objTablero.visualizarTablero();
			visualizarMaquina();
			comprobarFinal();
			objTablero.setTurno((byte) 1);
		}
		
		public void visualizarMaquina() {
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					if(objTablero.getValor(i, j) == CASILLA_JUGADOR_2)
						jbtVerde[i][j].setDisabledIcon(new ImageIcon(getClass().getResource(URL_JUGADOR_2)));
				}
			}
		}
		
		public void empate() {
			
			if (objTablero.empate())
			{
				JOptionPane.showMessageDialog(null, "EMPATE",
						"¡Empate!",-1);
				objTablero.setEmpates(objTablero.getEmpates() + 1);
				objGrp.jlbEmpates.setText(String.valueOf(objTablero.getEmpates()));
			}
		}
		
		public void inicio() {
			objTablero.reiniciar();
			iniciarModo1();
			if (objTablero.generarTurno())
				jugadaMaquina();
			
		}
		
		public void comprobarFinal() {
		
			if (objTablero.isGanador())
			{
				if (objTablero.getTurno() == 1)
				{	JOptionPane.showMessageDialog(null, new ImageIcon(getClass().getResource(VICTORIA)),
						"¡HAS GANADO! ¡ENHORABUENA!",-1);
				objGrp.jlbVictorias.setText(String.valueOf(objTablero.getVictoriasJugador1()));
				}
				else
				{	JOptionPane.showMessageDialog(null, "Lose",
							"¡Has perdido! ¡Victoria CPU!",-1);
				objGrp.jlbDerrotas.setText(String.valueOf(objTablero.getVictoriasJugador2()));
				}
			}
			else
				empate();
			if(objTablero.isGanador() || objTablero.isFin()) {
				fin = true;
				inicio();
			}
		}
		//Fin MODO1
		
		public void comprobacionesIguales(int y, int x) {
			
			objTablero.setValor(y,x);
				
			if (objGrp.jpnPanel1.isVisible())
			{
				objTablero.sumarContador();
				comprobarFinal();
			}
			else comprobarVictoria2();
			
		}
		
		//Inicio MODO2
		public void pulsar2(int i, int j) {
		
			if (objTablero.getTurno() == 1)
			{
				
				if (jbtMorado[i][j].getIcon() == null)
				{
					objGrp.jlbTurno.setIcon(new ImageIcon(getClass().getResource(URL_JUGADOR_2)));
					jbtMorado[i][j].setIcon(new ImageIcon(getClass().getResource(URL_JUGADOR_1)));
					jbtMorado[i][j].setDisabledIcon(new ImageIcon(getClass().getResource(DESACTIVADO1)));
					comprobacionesIguales(i,j);
					if (!objTablero.isGanador())
						jbtMorado[i][j].setEnabled(false);
				}
				else
				{
					jbtMorado[i][j].setIcon(null);
					objTablero.ponerCero(i, j);
					activar(CASILLA_JUGADOR_1);
					desactivarPropias(CASILLA_JUGADOR_1);
				}
			}
			else if (objTablero.getTurno() == 2)
			{
				
				if (jbtMorado[i][j].getIcon() == null)
				{
					objGrp.jlbTurno.setIcon(new ImageIcon(getClass().getResource(URL_JUGADOR_1)));
					jbtMorado[i][j].setIcon(new ImageIcon(getClass().getResource(URL_JUGADOR_2)));
					jbtMorado[i][j].setDisabledIcon(new ImageIcon(getClass().getResource(DESACTIVADO2)));
					comprobacionesIguales(i, j);
					if (!objTablero.isGanador())
						jbtMorado[i][j].setEnabled(false);
				}
				else
				{
					jbtMorado[i][j].setIcon(null);
					objTablero.ponerCero(i, j);
					activar(CASILLA_JUGADOR_2);
					desactivarPropias(CASILLA_JUGADOR_2);
				}
			}
			
			if (objTablero.getFichasJugador1() == 3 && objTablero.getTurno() == 1)
			{
				activar(CASILLA_JUGADOR_1);
				desactivar(CASILLA_JUGADOR_1);
			}
			else if (objTablero.getFichasJugador2() == 3 && objTablero.getTurno() == 2)
			{
				activar(CASILLA_JUGADOR_2);
				desactivar(CASILLA_JUGADOR_2);
			}
		}
		
		public void activar(char turno) {
			
			int i, j;
			
			for (i=0; i<3; i++)
				for (j=0; j<3; j++) {
					if (objTablero.getValor(i, j) == turno || objTablero.getValor(i, j) == CASILLA_VACIA) {
						jbtMorado[i][j].setEnabled(true);
					}
				}
		}
		
		public void desactivar(char turno) {
			
			int i, j;
			
			for (i=0; i<3; i++)
				for (j=0; j<3; j++) {
					if (objTablero.getValor(i, j) != turno) {
						jbtMorado[i][j].setEnabled(false);
					}
				}
		}
		
		public void desactivarPropias(char turno) { 
			
			/* Después de quitar uno de los botones selecionados
			 * hay que volver a desactivar los otros para que no deje
			 * quitar más de uno
			 */
			int i, j;
			
			for (i=0; i<3; i++)
				for (j=0; j<3; j++) {
					if (objTablero.getValor(i, j) == turno) {
						jbtMorado[i][j].setEnabled(false);
					}
				}
		}

		public void comprobarVictoria2() {
			
			if (objTablero.isGanador())
				{
					activar(objTablero.getCaracter());
					JOptionPane.showMessageDialog(objGrp.jpnPanel2, "VICTORIA JUGADOR "+ objTablero.getTurno(),
					"¡Hay ganador!",-1);
					if (objTablero.getTurno() == 1) {
						objGrp.jlbVictorias1.setText(String.valueOf(objTablero.getVictoriasJugador1()));
						objGrp.jlbTurno.setIcon(new ImageIcon(getClass().getResource(URL_JUGADOR_1)));
					}	
					else {
						objGrp.jlbVictorias2.setText(String.valueOf(objTablero.getVictoriasJugador2()));
						objGrp.jlbTurno.setIcon(new ImageIcon(getClass().getResource(URL_JUGADOR_2)));
						
					}
					objTablero.reiniciar();
					iniciarModo2();
				}
		}

		public void iniciarModo1() {
			
			if (!objGrp.jpnPanel1.isVisible()) {
				objGrp.jpnPanel1.setVisible(true);
				objGrp.jpnPanel2.setVisible(false);
				objGrp.jlbVictoriaJugador.setVisible(true);
				objGrp.jlbVictoriaCPU.setVisible(true);
				objGrp.jlbEmpate.setVisible(true);
				objGrp.jlbVictorias.setVisible(true);
				objGrp.jlbDerrotas.setVisible(true);
				objGrp.jlbEmpates.setVisible(true);
				objGrp.jlbVictoriaJugador1.setVisible(false);
				objGrp.jlbVictoriaJugador2.setVisible(false);
				objGrp.jlbVictorias1.setVisible(false);
				objGrp.jlbVictorias2.setVisible(false);
				objGrp.jlbTurno.setVisible(false);
			}
			for (int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					jbtVerde[i][j].setEnabled(true);
					jbtVerde[i][j].setIcon(null);
					jbtVerde[i][j].setBackground(COLOR_BOTONES_MODO1);
				}
			}
		}
		
		public void iniciarModo2() {
			
			if (!objGrp.jpnPanel2.isVisible()) {
				objGrp.jpnPanel2.setVisible(true);
				objGrp.jpnPanel1.setVisible(false);
				objGrp.jlbVictoriaJugador.setVisible(false);
				objGrp.jlbVictoriaCPU.setVisible(false);
				objGrp.jlbEmpate.setVisible(false);
				objGrp.jlbVictorias.setVisible(false);
				objGrp.jlbDerrotas.setVisible(false);
				objGrp.jlbEmpates.setVisible(false);
				objGrp.jlbVictoriaJugador1.setVisible(true);
				objGrp.jlbVictoriaJugador2.setVisible(true);
				objGrp.jlbVictorias1.setVisible(true);
				objGrp.jlbVictorias2.setVisible(true);
				objGrp.jlbTurno.setIcon(new ImageIcon(getClass().getResource(URL_JUGADOR_1)));
				objGrp.jlbTurno.setVisible(true);
			}
			for (int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					jbtMorado[i][j].setEnabled(true);
					jbtMorado[i][j].setIcon(null);
				}
			}
		}
}
