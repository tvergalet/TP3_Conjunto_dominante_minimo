package vista.visorGrafo;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import coordinador.Coordinador;
import modelo.grafo.Vertice;

public class VisorGrafo {

	private Coordinador coordinador;
	private JPanel panelPrincipal;
	private Color backgroudColor;

	public VisorGrafo(Coordinador coordinador) {
		this.coordinador = coordinador;
		this.panelPrincipal = new JPanel();
		this.backgroudColor = new Color(41, 58, 86);
		
		crearPanelPrincipal();
		agregarVerticesPrecargados();
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
		String inputNombre = "";
		inputNombre = (String) JOptionPane.showInputDialog(
				panelPrincipal,
				"Ingrese el nombre:",
				"Nombre del vértice",
				JOptionPane.PLAIN_MESSAGE,
				null,
				null, 
				inputNombre);
		if (inputNombre != null &&  !inputNombre.isEmpty()) {
			Vertice vertice =  coordinador.agregarVertice(e.getX(), e.getY(), inputNombre);
			if(vertice != null) {
				agregarVertice(vertice);
			} else {
				JOptionPane.showMessageDialog(panelPrincipal, "NO SE PUDO GRAFICAR ARISTA");
			}

		}
	}
	
	private void agregarVerticesPrecargados() {
		coordinador.obtenerVerticesDesdeGrafo().forEach( vertice ->{
			agregarVertice(vertice);
		});
	}
	
	public void agregarVertice(Vertice vertice) {
		FormaVertice formaVertice = new FormaVertice(
				vertice.id(),
				vertice.posX(),
				vertice.posY(),
				vertice.nombre(),
				vertice.vecinos().toString()
		);
		panelPrincipal.add(formaVertice);
		panelPrincipal.setComponentZOrder(formaVertice, 0);
		panelPrincipal.revalidate();
		panelPrincipal.repaint();
	}

	public JPanel obtenerPanelPrincipal() {
		return panelPrincipal;
	}

}
