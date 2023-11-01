package vista.visorGrafo;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VisorGrafo {

	private JPanel panelPrincipal;
	private Color backgroudColor;

	public VisorGrafo() {
		panelPrincipal = new JPanel();
		backgroudColor = new Color(41, 58, 86);
		crearPanelPrincipal();
	}

	private void crearPanelPrincipal() {
		panelPrincipal.setLayout(null);
		panelPrincipal.setBackground(backgroudColor);
		panelPrincipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				agregarVertice(e);
			}
		});

	}

	private void agregarVertice(MouseEvent e) {
		String ID = "";
		ID = (String) JOptionPane.showInputDialog(
				panelPrincipal,
				"Ingrese el nombre:",
				"Nombre del vértice",
				JOptionPane.PLAIN_MESSAGE,
				null,
				null, 
				ID);
		if (ID != null &&  !ID.isEmpty()) {
			FormaVertice vertice = new FormaVertice(e.getX(), e.getY(), ID);
			panelPrincipal.add(vertice);
			panelPrincipal.setComponentZOrder(vertice, 0);
			panelPrincipal.revalidate();
			panelPrincipal.repaint();
		}
	}

	public JPanel getMainPanel() {
		panelPrincipal = new JPanel();
		crearPanelPrincipal();
		return panelPrincipal;
	}

}
