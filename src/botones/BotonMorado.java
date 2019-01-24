package botones;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.JButton;

import interfaz.InterfazTablero;

public class BotonMorado extends JButton implements InterfazTablero {

	private static final long serialVersionUID = -396093614309677471L;

	public BotonMorado() {
		super();
		setBackground(COLOR_BOTONES_MODO2);
		setBorder(BORDE_BOTONES2);
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				arg0.getComponent().setBackground(COLOR_BOTONES_MODO2);
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (arg0.getComponent().isEnabled())
					arg0.getComponent().setBackground(FONDO_BOTONES_2);
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				arg0.getComponent().setBackground(COLOR_BOTONES_MODO2);
			}
		});
	}
}
