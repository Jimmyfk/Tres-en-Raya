package grafico;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import acciones.Acciones;
import botones.BotonMorado;
import botones.BotonVerde;
import interfaz.InterfazTablero;
import juego.MachineActualizada;
import pojo.Tablero;

public class TableroGrafico implements ActionListener, InterfazTablero {
	
	//Formulario
	private JFrame jfrPrincipal = null;
	
	//Paneles
	private JPanel jpnInicio = null;
	public JPanel jpnPanel1 = null;
	public JPanel jpnPanel2 = null;
	private JPanel jpnContenedor = null;
	
	private JLabel jlbFondo = null;
	public JLabel jlbVictoriaJugador = null;
	public JLabel jlbVictoriaCPU = null;
	public JLabel jlbEmpate = null;
	public JLabel jlbVictoriaJugador1 = null;
	public JLabel jlbVictoriaJugador2 = null;
	public JLabel jlbVictorias = null;
	public JLabel jlbDerrotas = null;
	public JLabel jlbEmpates = null;
	public JLabel jlbVictorias1 = null;
	public JLabel jlbVictorias2 = null;
	public JLabel jlbTurno = null;
	
	//Menú
	private JMenuBar jmbMenu = null;
	private JMenu jmModos = null;
	private JMenuItem jmiModo1 = null;
	private JMenuItem jmiModo2 = null;
	private JMenu jmOpciones = null;
	private JMenuItem jmiReiniciar = null;
	private JMenuItem jmiSalir = null;
	
	//Botones
	private BotonVerde [][] jbtBotonVerde = null;
	private BotonMorado [][] jbtBotonMorado = null;

	//Objetos
	private Tablero objPrograma = null;
	private MachineActualizada objMaquina = null;
	private Acciones objAcc = null;
	
	private boolean fin = false;
	
	public TableroGrafico() {
		
		paneldejuego();
		//PANELES y BOTONES
		panel1();
		panel2();
		panelFondo();
		objPrograma = new Tablero();
		objMaquina = new MachineActualizada(jbtBotonVerde, objPrograma);
		jfrPrincipal.setVisible(true);
		
	}
	
	public void paneldejuego() {
		
		//Formulario
		jfrPrincipal = new JFrame("Tres en Raya");
			jfrPrincipal.setSize(800, 800);
			jfrPrincipal.setLocationRelativeTo(null);
			jfrPrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			jfrPrincipal.setResizable(false);
			jfrPrincipal.setLayout(null);
			
		jpnInicio = new JPanel();
			jpnInicio.setBounds(0, 0, 800, 800);
			jpnInicio.setBackground(NEGRO);
			jfrPrincipal.add(jpnInicio);
			
		jlbFondo = new JLabel(new ImageIcon(getClass().getResource("fondo.jpg")));
			jlbFondo.setBounds(0, 0, 800, 800);
			jpnInicio.add(jlbFondo);
		
		//Menú
		jmbMenu = new JMenuBar();
			jmbMenu.setBackground(COLOR_MENUBAR);
			jmbMenu.setBorderPainted(false);
			
		jfrPrincipal.setJMenuBar(jmbMenu);
		
		jmModos = new JMenu("Modos de juego");
			jmModos.setForeground(BLANCO);
			jmbMenu.add(jmModos);
		
		jmOpciones = new JMenu("Opciones");
			jmOpciones.setForeground(BLANCO);
			jmbMenu.add(jmOpciones);
		
		jmiReiniciar = new JMenuItem("Reiniciar");
			jmOpciones.add(jmiReiniciar);
			jmiReiniciar.addActionListener(e -> reiniciar());
			jmOpciones.addSeparator();
		
		jmiSalir = new JMenuItem("Salir");
			jmOpciones.add(jmiSalir);
			jmiSalir.addActionListener(e -> System.exit(0));
		
		jmiModo1 = new JMenuItem("Modo vs la Máquina");
			jmiModo1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
				
					objPrograma.reiniciarTodo();
					jpnInicio.setVisible(false);
					objPrograma.reiniciar();
					reiniciar();	
					objAcc = new Acciones(jbtBotonVerde, objPrograma, objMaquina, jfrPrincipal);
					objAcc.inicio();
				}
			});
			jmModos.add(jmiModo1);
		
		jmiModo2 = new JMenuItem("Modo 1 vs 1");
			jmiModo2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					objPrograma.reiniciarTodo();
					objAcc.iniciarModo2();
					jpnInicio.setVisible(false);
					objPrograma.reiniciar();
					reiniciar();
				}
			});
			jmModos.add(jmiModo2);
	}
	
	public void reiniciar() {
		
		jlbDerrotas.setText("0");
		jlbVictorias.setText("0");
		jlbEmpates.setText("0");
		jlbVictorias1.setText("0");
		jlbVictorias2.setText("0");
		objPrograma.reiniciarTodo();
	}
	
	public void panel1() {
		
		jpnPanel1 = new JPanel();
		jpnPanel1.setBounds(120, 120, 550, 550);
		jpnPanel1.setLayout(new GridLayout(3, 3, 0, 0));
		jpnPanel1.setVisible(false);
		jfrPrincipal.add(jpnPanel1);
		botones1();
		
	}
	
	public void panel2() {
		
		jpnPanel2 = new JPanel();
		jpnPanel2.setBounds(120, 120, 550, 550);
		jpnPanel2.setLayout(new GridLayout(3, 3, 0, 0));
		jpnPanel2.setVisible(false);
		jfrPrincipal.add(jpnPanel2);
		botones2();
		
	}
	
	public void panelFondo() {
		
		jpnContenedor = new JPanel(null);
			jpnContenedor.setBounds(0, 0, 800, 800);
			jpnContenedor.setBackground(BLANCO);
			jfrPrincipal.add(jpnContenedor);
			
		jlbVictoriaJugador = new JLabel("Victorias:");
			jlbVictoriaJugador.setBounds(50, 50, 150, 30);
			jlbVictoriaJugador.setFont(new Font("Consolas", Font.BOLD, 23));
			jlbVictoriaJugador.setVisible(false);
			jpnContenedor.add(jlbVictoriaJugador);
			
		jlbVictorias = new JLabel("0");
			jlbVictorias.setBounds(190, 50, 50, 30);
			jlbVictorias.setFont(new Font("Consolas", Font.BOLD, 22));
			jlbVictorias.setVisible(false);
			jpnContenedor.add(jlbVictorias);
			
		jlbEmpate = new JLabel("Empates:");
			jlbEmpate.setBounds(300, 50, 120, 30);
			jlbEmpate.setFont(new Font("Consolas", Font.BOLD, 23));
			jlbEmpate.setVisible(false);
			jpnContenedor.add(jlbEmpate);
			
		jlbEmpates = new JLabel("0");
			jlbEmpates.setBounds(410, 50, 50, 30);
			jlbEmpates.setFont(new Font("Consolas", Font.BOLD, 22));
			jlbEmpates.setVisible(false);
			jpnContenedor.add(jlbEmpates);
			
		jlbVictoriaCPU = new JLabel("Derrotas:");
			jlbVictoriaCPU.setBounds(520, 50, 120, 30);
			jlbVictoriaCPU.setFont(new Font("Consolas", Font.BOLD, 23));
			jlbVictoriaCPU.setVisible(false);
			jpnContenedor.add(jlbVictoriaCPU);
			
		jlbDerrotas = new JLabel("0");
			jlbDerrotas.setBounds(645, 50, 50, 30);
			jlbDerrotas.setFont(new Font("Consolas", Font.BOLD, 22));
			jlbDerrotas.setVisible(false);
			jpnContenedor.add(jlbDerrotas);
			
		jlbVictoriaJugador1 = new JLabel("Victorias J1:");
			jlbVictoriaJugador1.setBounds(50, 50, 200, 30);
			jlbVictoriaJugador1.setFont(new Font("Consolas", Font.BOLD, 23));
			jlbVictoriaJugador1.setVisible(false);
			jpnContenedor.add(jlbVictoriaJugador1);
			
		jlbVictorias1 = new JLabel("0");
			jlbVictorias1.setBounds(230, 50, 50, 30);
			jlbVictorias1.setFont(new Font("Consolas", Font.BOLD, 22));
			jlbVictorias1.setVisible(false);
			jpnContenedor.add(jlbVictorias1);
			
		jlbVictoriaJugador2 = new JLabel("Victorias J2:");
			jlbVictoriaJugador2.setBounds(520, 50, 200, 30);
			jlbVictoriaJugador2.setFont(new Font("Consolas", Font.BOLD, 23));
			jlbVictoriaJugador2.setVisible(false);
			jpnContenedor.add(jlbVictoriaJugador2);
			
		jlbVictorias2 = new JLabel("0");
			jlbVictorias2.setBounds(700, 50, 50, 30);
			jlbVictorias2.setFont(new Font("Consolas", Font.BOLD, 22));
			jlbVictorias2.setVisible(false);
			jpnContenedor.add(jlbVictorias2);
			
		jlbTurno = new JLabel();
			jlbTurno.setBounds(350, 10, 100, 100);
			jlbTurno.setVisible(false);
			jpnContenedor.add(jlbTurno);
			
	}
	
	public void botones1() {
		
		jbtBotonVerde = new BotonVerde[3][3];
		
		for (int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				jbtBotonVerde[i][j] = new BotonVerde();
				jbtBotonVerde[i][j].addActionListener(this);
				jpnPanel1.add(jbtBotonVerde[i][j]);
			}
		}
	}

	public void botones2() {
		
		jbtBotonMorado = new BotonMorado[3][3];
		
		for (int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				jbtBotonMorado[i][j] = new BotonMorado();
				jbtBotonMorado[i][j].addActionListener(this);
				jpnPanel2.add(jbtBotonMorado[i][j]);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		for (int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if (arg0.getSource()==jbtBotonVerde[i][j]) {
					pulsar1(i, j);
				}
				else if (arg0.getSource()==jbtBotonMorado[i][j]) {
					pulsar2(i, j);
				}
			}
		}
	}
	/*
	//Inicio MODO1
	public void pulsar1(int i, int j) {
		fin = false;
		jbtBotonVerde[i][j].setIcon(new ImageIcon(getClass().getResource(URL_JUGADOR_1)));
		jbtBotonVerde[i][j].setDisabledIcon(new ImageIcon(getClass().getResource(URL_JUGADOR_1)));
		jbtBotonVerde[i][j].setEnabled(false);
		comprobacionesIguales(i, j);
		objPrograma.setTurno((byte) 2);
		if(!fin)
			jugadaMaquina();
		else
			objPrograma.setTurno((byte) 1);
	}
	
	public void jugadaMaquina() {
		objPrograma.sumarContador();
		objMaquina.movimientoMaquina();
		//objPrograma.visualizarTablero();
		visualizarMaquina();
		comprobarFinal();
		objPrograma.setTurno((byte) 1);
	}
	
	public void visualizarMaquina() {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(objPrograma.getValor(i, j) == CASILLA_JUGADOR_2)
					jbtBotonVerde[i][j].setDisabledIcon(new ImageIcon(getClass().getResource(URL_JUGADOR_2)));
			}
		}
	}
	
	public void empate() {
		
		if (objPrograma.empate())
		{
			JOptionPane.showMessageDialog(null, "EMPATE",
					"¡Empate!",-1);
			objPrograma.setEmpates(objPrograma.getEmpates() + 1);
			jlbEmpates.setText(String.valueOf(objPrograma.getEmpates()));
		}
	}
	
	public void inicio() {
		objPrograma.reiniciar();
		iniciarModo1();
		if (objPrograma.generarTurno())
			jugadaMaquina();
		
	}
	
	public void comprobarFinal() {
	
		if (objPrograma.isGanador())
		{
			if (objPrograma.getTurno() == 1)
			{	JOptionPane.showMessageDialog(null, new ImageIcon(getClass().getResource(VICTORIA)),
					"¡HAS GANADO! ¡ENHORABUENA!",-1);
				jlbVictorias.setText(String.valueOf(objPrograma.getVictoriasJugador1()));
			}
			else
			{	JOptionPane.showMessageDialog(null, "Lose",
						"¡Has perdido! ¡Victoria CPU!",-1);
				jlbDerrotas.setText(String.valueOf(objPrograma.getVictoriasJugador2()));
			}
		}
		else
			empate();
		if(objPrograma.isGanador() || objPrograma.isFin()) {
			fin = true;
			inicio();
		}
	}
	//Fin MODO1
	
	public void comprobacionesIguales(int y, int x) {
		
		objPrograma.setValor(y,x);
			
		if (jpnPanel1.isVisible())
		{
			objPrograma.sumarContador();
			comprobarFinal();
		}
		else comprobarVictoria2();
		
	}
	
	//Inicio MODO2
	public void pulsar2(int i, int j) {
	
		if (objPrograma.getTurno() == 1)
		{
			
			if (jbtBotonMorado[i][j].getIcon() == null)
			{
				jlbTurno.setIcon(new ImageIcon(getClass().getResource(URL_JUGADOR_2)));
				jbtBotonMorado[i][j].setIcon(new ImageIcon(getClass().getResource(URL_JUGADOR_1)));
				jbtBotonMorado[i][j].setDisabledIcon(new ImageIcon(getClass().getResource(DESACTIVADO1)));
				comprobacionesIguales(i,j);
				if (!objPrograma.isGanador())
					jbtBotonMorado[i][j].setEnabled(false);
			}
			else
			{
				jbtBotonMorado[i][j].setIcon(null);
				objPrograma.ponerCero(i, j);
				activar(CASILLA_JUGADOR_1);
				desactivarPropias(CASILLA_JUGADOR_1);
			}
		}
		else if (objPrograma.getTurno() == 2)
		{
			
			if (jbtBotonMorado[i][j].getIcon() == null)
			{
				jlbTurno.setIcon(new ImageIcon(getClass().getResource(URL_JUGADOR_1)));
				jbtBotonMorado[i][j].setIcon(new ImageIcon(getClass().getResource(URL_JUGADOR_2)));
				jbtBotonMorado[i][j].setDisabledIcon(new ImageIcon(getClass().getResource(DESACTIVADO2)));
				comprobacionesIguales(i, j);
				if (!objPrograma.isGanador())
					jbtBotonMorado[i][j].setEnabled(false);
			}
			else
			{
				jbtBotonMorado[i][j].setIcon(null);
				objPrograma.ponerCero(i, j);
				activar(CASILLA_JUGADOR_2);
				desactivarPropias(CASILLA_JUGADOR_2);
			}
		}
		
		if (objPrograma.getFichasJugador1() == 3 && objPrograma.getTurno() == 1)
		{
			activar(CASILLA_JUGADOR_1);
			desactivar(CASILLA_JUGADOR_1);
		}
		else if (objPrograma.getFichasJugador2() == 3 && objPrograma.getTurno() == 2)
		{
			activar(CASILLA_JUGADOR_2);
			desactivar(CASILLA_JUGADOR_2);
		}
	}
	
	public void activar(char turno) {
		
		int i, j;
		
		for (i=0; i<3; i++)
			for (j=0; j<3; j++) {
				if (objPrograma.getValor(i, j) == turno || objPrograma.getValor(i, j) == CASILLA_VACIA) {
					jbtBotonMorado[i][j].setEnabled(true);
				}
			}
	}
	
	public void desactivar(char turno) {
		
		int i, j;
		
		for (i=0; i<3; i++)
			for (j=0; j<3; j++) {
				if (objPrograma.getValor(i, j) != turno) {
					jbtBotonMorado[i][j].setEnabled(false);
				}
			}
	}
	
	public void desactivarPropias(char turno) { 
		
		/* Después de quitar uno de los botones selecionados
		 * hay que volver a desactivar los otros para que no deje
		 * quitar más de uno
		 */ 
	/*
		int i, j;
		
		for (i=0; i<3; i++)
			for (j=0; j<3; j++) {
				if (objPrograma.getValor(i, j) == turno) {
					jbtBotonMorado[i][j].setEnabled(false);
				}
			}
	}

	public void comprobarVictoria2() {
		
		if (objPrograma.isGanador())
			{
				activar(objPrograma.getCaracter());
				JOptionPane.showMessageDialog(jpnPanel2, "VICTORIA JUGADOR "+ objPrograma.getTurno(),
				"¡Hay ganador!",-1);
				if (objPrograma.getTurno() == 1) {
					jlbVictorias1.setText(String.valueOf(objPrograma.getVictoriasJugador1()));
					jlbTurno.setIcon(new ImageIcon(getClass().getResource(URL_JUGADOR_1)));
				}	
				else {
					jlbVictorias2.setText(String.valueOf(objPrograma.getVictoriasJugador2()));
					jlbTurno.setIcon(new ImageIcon(getClass().getResource(URL_JUGADOR_2)));
					
				}
				objPrograma.reiniciar();
				iniciarModo2();
			}
	}

	public void iniciarModo1() {
		
		if (!jpnPanel1.isVisible()) {
			jpnPanel1.setVisible(true);
			jpnPanel2.setVisible(false);
			jlbVictoriaJugador.setVisible(true);
			jlbVictoriaCPU.setVisible(true);
			jlbEmpate.setVisible(true);
			jlbVictorias.setVisible(true);
			jlbDerrotas.setVisible(true);
			jlbEmpates.setVisible(true);
			jlbVictoriaJugador1.setVisible(false);
			jlbVictoriaJugador2.setVisible(false);
			jlbVictorias1.setVisible(false);
			jlbVictorias2.setVisible(false);
			jlbTurno.setVisible(false);
		}
		for (int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				jbtBotonVerde[i][j].setEnabled(true);
				jbtBotonVerde[i][j].setIcon(null);
				jbtBotonVerde[i][j].setBackground(COLOR_BOTONES_MODO1);
			}
		}
	}
	
	public void iniciarModo2() {
		
		if (!jpnPanel2.isVisible()) {
			jpnPanel2.setVisible(true);
			jpnPanel1.setVisible(false);
			jlbVictoriaJugador.setVisible(false);
			jlbVictoriaCPU.setVisible(false);
			jlbEmpate.setVisible(false);
			jlbVictorias.setVisible(false);
			jlbDerrotas.setVisible(false);
			jlbEmpates.setVisible(false);
			jlbVictoriaJugador1.setVisible(true);
			jlbVictoriaJugador2.setVisible(true);
			jlbVictorias1.setVisible(true);
			jlbVictorias2.setVisible(true);
			jlbTurno.setIcon(new ImageIcon(getClass().getResource(URL_JUGADOR_1)));
			jlbTurno.setVisible(true);
		}
		for (int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				jbtBotonMorado[i][j].setEnabled(true);
				jbtBotonMorado[i][j].setIcon(null);
			}
		}
	}
	*/
}