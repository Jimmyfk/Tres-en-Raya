package interfaz;

import java.awt.Color;

import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public interface InterfazTablero {

	    final static Color COLOR_BOTONES_MODO1 = Color.decode("#00FA9A");
	    
	    final static Color COLOR_BOTONES_MODO2 = Color.decode("#D29FF9");
	    
	    final static Color FONDO_BOTONES_1 = Color.decode("#00FF7F");
	    
	    final static Color FONDO_BOTONES_2 = Color.decode("#C375FF");
	    
	    final static Color FONDO_BOTONES_NORMALES = new Color(219, 234, 255);
	    
	    final static Color COLOR_MENUBAR = new Color(220, 20, 60);
	    
	    final static Color NEGRO = Color.BLACK;
	    
	    final static Color BLANCO = Color.WHITE;
	    
	    final static Color MORADO = Color.decode("#9722F1");
	    
	    final static Color VERDE = Color.decode("#228B22");
	    
	    final static Color AZUL = new Color(135, 206, 250);
	    
	    final static LineBorder BORDE_BOTONES1 = new LineBorder(VERDE);
	    
	    final static LineBorder BORDE_BOTONES2 = new LineBorder(MORADO, 1, true);
	    
	    final static EtchedBorder BORDE_BOTONES_NORMALES = new EtchedBorder(EtchedBorder.RAISED, Color.RED, Color.BLUE);
	    
		//Nombre de las Imágenes
		final static String URL_JUGADOR_1 = "/iconos/Jugador1.png";
		
		final static String DESACTIVADO2 = "jugador2-d.png";
		
		final static String URL_JUGADOR_2 = "/iconos/Jugador2.png";
		
		final static String DESACTIVADO1 = "jugador1-d.png";
		
		final static String VICTORIA = "Victoria.gif";
		
		final static String DERROTA = "Derrota.gif";
		
		final static String EMPATE = "Empate.gif";
		
		static char CASILLA_VACIA = 'U';
		static char CASILLA_JUGADOR_1 = 'X';
		static char CASILLA_JUGADOR_2 = 'O';
		
	}
