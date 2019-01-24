package juego;

import interfaz.InterfazTablero;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import pojo.Tablero;




public class MachineActualizada
  implements InterfazTablero
{
  Tablero objT = null;
  char ficha;
  JButton[][] jbtTabla = null;
  
  public MachineActualizada(JButton[][] jbtTabla, Tablero objT) {
    this.objT = objT;
    this.jbtTabla = jbtTabla;
  }
  
  public void movimientoMaquina() { ficha = 'n';
   
  	if(objT.isFin()) return;
  	atacar();
    if (ficha == 'n')
      defender();
    if (ficha == 'n') {
      ponerEnHuecoLibre();
    }
  }
  


  private void atacar()
  {
    atacarFilas();
    if (ficha == 'n')
      atacarColumnas();
    if (ficha == 'n')
      atacarDP();
    if (ficha == 'n') {
      atacarDS();
    }
  }
  
  private void atacarFilas()
  {
    for (int i = 0; (i < 3) && (ficha == 'n'); i++) {
      int c = 0;
      for (int j = 0; (j < 3) && (ficha == 'n'); j++) {
        if (objT.getValor(i, j) == CASILLA_JUGADOR_2) {
          c++;
        }
      }
      
      if (c == 2) {
        for (int j = 0; (j < 3) && (ficha == 'n'); j++) {
          if (objT.getValor(i, j) == CASILLA_VACIA) {
            objT.setValor(i, j);
            ficha = 's';
            visualizarCasillaJugada(i, j);
          }
        }
      }
    }
  }
  


  private void atacarColumnas()
  {
    for (int i = 0; (i < 3) && (ficha == 'n'); i++) {
      int c = 0;
      for (int j = 0; (j < 3) && (ficha == 'n'); j++) {
        if (objT.getValor(j, i) == CASILLA_JUGADOR_2) {
          c++;
        }
      }
      
      if (c == 2) {
        for (int j = 0; (j < 3) && (ficha == 'n'); j++) {
          if (objT.getValor(j, i) == CASILLA_VACIA) {
            objT.setValor(j, i);
            ficha = 's';
            visualizarCasillaJugada(j, i);
          }
        }
      }
    }
  }
  



  private void atacarDP()
  {
    int c = 0;
    for (int i = 0; (i < 3) && (ficha == 'n'); i++) {
      if (objT.getValor(i, i) == CASILLA_JUGADOR_2) {
        c++;
      }
    }
    
    if (c == 2) {
      for (int i = 0; (i < 3) && (ficha == 'n'); i++) {
        if (objT.getValor(i, i) == CASILLA_VACIA) {
          objT.setValor(i, i);
          ficha = 's';
          visualizarCasillaJugada(i, i);
        }
      }
    }
  }
  

  private void atacarDS()
  {
    int c = 0;
    for (int i = 0; (i < 3) && (ficha == 'n'); i++) {
      if (objT.getValor(i, 2 - i) == CASILLA_JUGADOR_2) {
        c++;
      }
    }
    

    if (c == 2) {
      for (int i = 0; (i < 3) && (ficha == 'n'); i++) {
        if (objT.getValor(i, 2 - i) == CASILLA_VACIA) {
          objT.setValor(i, 2-i);
          ficha = 's';
          visualizarCasillaJugada(i, 2 - i);
        }
      }
    }
  }
  



  private void defender()
  {
    defenderFilas();
    if (ficha == 'n')
      defenderColumnas();
    if (ficha == 'n')
      defenderDP();
    if (ficha == 'n') {
      defenderDS();
    }
  }
  
  private void defenderFilas()
  {
    for (int i = 0; (i < 3) && (ficha == 'n'); i++) {
      int c = 0;
      for (int j = 0; (j < 3) && (ficha == 'n'); j++) {
        if (objT.getValor(i, j) == CASILLA_JUGADOR_1) {
          c++;
        }
      }
      
      if (c == 2) {
        for (int j = 0; (j < 3) && (ficha == 'n'); j++) {
          if (objT.getValor(i, j) == CASILLA_VACIA) {
            objT.setValor(i, j);
            ficha = 's';
            visualizarCasillaJugada(i, j);
          }
        }
      }
    }
  }
  


  private void defenderColumnas()
  {
    for (int i = 0; (i < 3) && (ficha == 'n'); i++) {
      int c = 0;
      for (int j = 0; (j < 3) && (ficha == 'n'); j++) {
        if (objT.getValor(j, i) == CASILLA_JUGADOR_1) {
          c++;
        }
      }
      
      if (c == 2) {
        for (int j = 0; (j < 3) && (ficha == 'n'); j++) {
          if (objT.getValor(j, i) == CASILLA_VACIA) {
            objT.setValor(j, i);
            ficha = 's';
            visualizarCasillaJugada(j, i);
          }
        }
      }
    }
  }
  




  private void defenderDP()
  {
    int c = 0;
    for (int i = 0; (i < 3) && (ficha == 'n'); i++) {
      if (objT.getValor(i, i) == CASILLA_JUGADOR_1) {
        c++;
      }
    }
    
    if (c == 2) {
      for (int i = 0; (i < 3) && (ficha == 'n'); i++) {
        if (objT.getValor(i, i) == CASILLA_VACIA) {
          objT.setValor(i, i);
          ficha = 's';
          visualizarCasillaJugada(i, i);
        }
      }
    }
  }
  


  private void defenderDS()
  {
    int c = 0;
    for (int i = 0; (i < 3) && (ficha == 'n'); i++) {
      if (objT.getValor(i, 2 - i) == CASILLA_JUGADOR_1) {
        c++;
      }
    }
    

    if (c == 2) {
      for (int i = 0; (i < 3) && (ficha == 'n'); i++) {
        if (objT.getValor(i, 2 - i) == CASILLA_VACIA) {
          objT.setValor(i, 2-i);
          ficha = 's';
          visualizarCasillaJugada(i, 2 - i);
        }
      }
    }
  }
  






  private void ponerEnHuecoLibre()
  {
    int cfichas = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (objT.getValor(j, i) != CASILLA_VACIA) {
          cfichas++;
        }
      }
    }
    

    if (cfichas == 0) {
      objT.setValor(0, 0);
      ficha = 's';
      visualizarCasillaJugada(0, 0);

    }
    else if ((cfichas == 1) && (objT.getValor(1, 1) == CASILLA_VACIA)) {
      objT.setValor(1, 1);
      ficha = 's';
      visualizarCasillaJugada(1, 1);

    }
    else if ((objT.getValor(1, 1) == CASILLA_JUGADOR_2) && (objT.getValor(1, 0) == CASILLA_VACIA)) {
      objT.setValor(1, 0);
      ficha = 's';
      visualizarCasillaJugada(1, 0);

    }
    else if ((objT.getValor(1, 1) == CASILLA_JUGADOR_2) && (objT.getValor(1, 2) == CASILLA_VACIA)) {
      objT.setValor(1, 2);;
      ficha = 's';
      visualizarCasillaJugada(1, 2);

    }
    else if (objT.getValor(2, 2) == CASILLA_VACIA) {
      objT.setValor(2, 2);
      ficha = 's';
      visualizarCasillaJugada(2, 2);

    }
    else if (objT.getValor(0, 2) == CASILLA_VACIA) {
      objT.setValor(0, 2);
      ficha = 's';
      visualizarCasillaJugada(0, 2);

    }
    else if (objT.getValor(2, 0) == CASILLA_VACIA) {
      objT.setValor(2, 0);
      ficha = 's';
      visualizarCasillaJugada(2, 0);
    }
  }
  
  private void visualizarCasillaJugada(int i, int j) {
    jbtTabla[i][j].setIcon(new ImageIcon(getClass().getResource("/iconos/Jugador2.png")));
    jbtTabla[i][j].setEnabled(false);
  }
}
