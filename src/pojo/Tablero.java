package pojo;

import java.util.Arrays;
import java.util.Random;

import interfaz.InterfazTablero;

public class Tablero implements InterfazTablero {

	private byte turno;
	
	private byte fichasJugador1;
	private byte fichasJugador2;
	private int victoriasJugador1;
	private int victoriasJugador2;
	private int empates;
	private short contador;
	
	private char [][] tablero;
	
	private boolean ganador;
	private boolean fin;
	
	private Random rd;
	
	public Tablero() {
		
		rd = new Random();
		contador = 0;
		turno = 1;
		tablero = new char[3][3];
		ganador = false;
		fichasJugador1 = 0;
		fichasJugador2 = 0;
		victoriasJugador1 = 0;
		victoriasJugador2 = 0;
		empates = 0;
		vaciarTablero();
	}
	
	public Tablero(char [][] tablero) {
		this.tablero = tablero;
		rd = new Random();
		contador = 0;
		turno = 1;
		ganador = false;
		fichasJugador1 = 0;
		fichasJugador2 = 0;
		victoriasJugador1 = 0;
		victoriasJugador2 = 0;
		empates = 0;
		vaciarTablero();
		
	}
	
	public void reiniciar() {
		
		contador = 0;
		vaciarTablero();
		fichasJugador1 = 0;
		fichasJugador2 = 0;
		
	}
	
	public void reiniciarTodo() {
		contador = 0;
		turno = 1;
		vaciarTablero();
		fichasJugador1 = 0;
		fichasJugador2 = 0;
		victoriasJugador1 = 0;
		victoriasJugador2 = 0;
		empates = 0;
		ganador = false;

	}
	
	public byte getTurno() {
		return turno;
	}
	
	public char getCaracter() {
		if (turno == 1)
			return CASILLA_JUGADOR_1;
		else
			return CASILLA_JUGADOR_2;
	}
	
	public void setTurno(byte turno) {
		this.turno = turno;
	}
	
	public char[][] getTablero() {
		return tablero;
	}
	
	public char getValor(int i, int j) {
		return tablero[i][j];
	}
	
	public void setTablero(char[][] tablero) {
		this.tablero = tablero;
	}
	
	public short getContador() {
		return contador;
	}

	public void setContador(short contador) {
		this.contador = contador;
	}

	public byte getFichasJugador1() {
		return fichasJugador1;
	}

	public void setFichasJugador1(byte fichasJugador1) {
		this.fichasJugador1 = fichasJugador1;
	}

	public byte getFichasJugador2() {
		return fichasJugador2;
	}

	public void setFichasJugador2(byte fichasJugador2) {
		this.fichasJugador2 = fichasJugador2;
	}

	public int getVictoriasJugador1() {
		return victoriasJugador1;
	}

	public void setVictoriasJugador1(int victoriasJugador1) {
		this.victoriasJugador1 = victoriasJugador1;
	}

	public int getVictoriasJugador2() {
		return victoriasJugador2;
	}

	public void setVictoriasJugador2(int victoriasJugador2) {
		this.victoriasJugador2 = victoriasJugador2;
	}

	public boolean isGanador() {
		return ganador;
	}

	public void setGanador(boolean ganador) {
		this.ganador = ganador;
	}

	public int getEmpates() {
		return empates;
	}

	public void setEmpates(int empates) {
		this.empates = empates;
	}
	

	public boolean isFin() {
		if(empate())
			fin = true;
		else
			fin = false;
		
		return fin;
	}

	public void setValor(int i, int j) {
		
		if (turno == 1)
		{
			tablero[i][j] = CASILLA_JUGADOR_1;
			fichasJugador1++;
			if (!comprobarVictoria() && !empate())
			turno = 2;
		}
		else
		{
			tablero[i][j] = CASILLA_JUGADOR_2;
			fichasJugador2++;
			if (!comprobarVictoria() && !empate())
			turno = 1;
		}
	}
	
	public void ponerCero(int i, int j) {
		tablero[i][j] = CASILLA_VACIA;
		if (turno == 1)
			fichasJugador1--;
		else
			fichasJugador2--;
	}
	
	public void sumarContador() {
		contador++;
	}
	

	public int generarRandom() {
		
		return rd.nextInt(3);
	}
	
	public boolean generarTurno() {
		
		boolean turnoMaquina = rd.nextBoolean();
		if (turnoMaquina) turno = 2;
		else turno = 1;
		return turnoMaquina;
	}
	
	public boolean comprobarVictoria() {
		
		ganador = false;
		int contarUno = 0;
		int contarDos = 0;
		
		for(int i=0; i<tablero.length; i++) {
			contarUno = contarDos = 0;
			for(int j=0; j<tablero.length; j++) {
				if (tablero[i][j] == CASILLA_JUGADOR_1) contarUno++;
				else if (tablero[i][j] == CASILLA_JUGADOR_2) contarDos++;
			}
			if (contarUno == tablero.length || contarDos == tablero.length)
				ganador = true;
		}
		
		for(int i=0; i<tablero.length; i++) {
			contarUno = contarDos = 0;
			for(int j=0; j<tablero.length; j++) {
				if (tablero[j][i] == CASILLA_JUGADOR_1) contarUno++;
				else if (tablero[j][i] == CASILLA_JUGADOR_2) contarDos++;
			}
			if (contarUno == tablero.length || contarDos == tablero.length)
				ganador = true;
		}
		
		contarUno = contarDos = 0;
		for(int i=0; i<tablero.length; i++) {
			if (tablero[i][i] == CASILLA_JUGADOR_1) contarUno++;
			else if (tablero[i][i] == CASILLA_JUGADOR_2) contarDos++;
		}
		if (contarUno == tablero.length || contarDos == tablero.length)
			ganador = true;
		
		contarUno = contarDos = 0;
		for(int i=tablero.length-1, j=0; i>=0 && j<tablero.length; i--, j++) {
			if (tablero[j][i] == CASILLA_JUGADOR_1) contarUno++;
			else if (tablero[j][i] == CASILLA_JUGADOR_2) contarDos++;
		}
		if (contarUno == tablero.length || contarDos == tablero.length)
			ganador = true;
		
		if (ganador && turno == 1)
			victoriasJugador1++;
		else if (ganador && turno == 2)
			victoriasJugador2++;
		
		return ganador;
	}
	
	public boolean empate() {
		
		return contador > 7;
	}
	
	public void vaciarTablero() {
		for (int i=0; i<tablero.length; i++) {
			Arrays.fill(tablero[i], CASILLA_VACIA);
		}
	}
	
	public void visualizarTablero() {
		System.out.println("\n");
		for (int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print("\t"+tablero[i][j]);
			}
			System.out.println();
				
		}
	}

}