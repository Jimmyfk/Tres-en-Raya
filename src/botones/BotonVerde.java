package botones;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.JButton;

import interfaz.InterfazTablero;

public class BotonVerde extends JButton implements InterfazTablero {

	private static final long serialVersionUID = 5792467147325785190L;

	public BotonVerde() {
		super();
		setBackground(COLOR_BOTONES_MODO1);
		setBorder(BORDE_BOTONES1);
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (arg0.getComponent().isEnabled())
					arg0.getComponent().setBackground(COLOR_BOTONES_MODO1);
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (arg0.getComponent().isEnabled())
					arg0.getComponent().setBackground(FONDO_BOTONES_1);
			}
		});
	}
}
