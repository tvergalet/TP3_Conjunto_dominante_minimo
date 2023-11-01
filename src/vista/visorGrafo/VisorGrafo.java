package vista.visorGrafo;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class VisorGrafo {

	private JPanel mainPanel;

	public VisorGrafo() {
		mainPanel = new JPanel();
		crearPanelPrincipal();

	}

	private void crearPanelPrincipal() {
		mainPanel.setLayout(null);
		mainPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				agregarVertice(e);
			}
		});

	}

	private void agregarVertice(MouseEvent e) {
		String ID = "";
		ID = (String) JOptionPane.showInputDialog(mainPanel, "Ingrese el nombre:", "Nombre del vértice",
				JOptionPane.PLAIN_MESSAGE, null, null, ID);
		if (!(ID.equals(""))) {
			System.out.println("Entro");
			FormaVertice vertice = new FormaVertice(e.getX(), e.getY(), ID);
			mainPanel.add(vertice);
			mainPanel.setComponentZOrder(vertice, 0);
			mainPanel.revalidate();
			mainPanel.repaint();
		}

	}

	public JPanel getMainPanel() {
		return this.mainPanel;
	}

}
