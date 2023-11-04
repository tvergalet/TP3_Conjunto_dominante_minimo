package vista.visorGrafo;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import coordinador.Coordinador;
import modelo.grafo.Vertice;

public class VisorGrafo {

	private Coordinador coordinador;
	private JPanel panelPrincipal;
	private Color fondoPanel;
	private Map<Integer, FormaVertice> vertices;

	public VisorGrafo(Coordinador coordinador) {
		this.coordinador = coordinador;
		this.panelPrincipal = new JPanel();
		this.fondoPanel = new Color(41, 58, 86);
		this.vertices = new HashMap<>();
		
		crearPanelPrincipal();
		actualizarVerticesDesdeBase();
	}

	private void crearPanelPrincipal() {
		panelPrincipal.setLayout(null);
		panelPrincipal.setBackground(fondoPanel);
		panelPrincipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				agregarVertice(e);
			}
		});
	}

	private void agregarVertice(MouseEvent e) {
		String nombre = solicitarEntradaUsuario("Ingrese el nombre:", "Nombre del vértice" );
		
		if (nombre != null &&  !nombre.isEmpty()) {
			Vertice vertice =  coordinador.agregarVertice(e.getX(), e.getY(), nombre);
			if(vertice != null) {
				agregarVertice(vertice);
			} else {
				JOptionPane.showMessageDialog(panelPrincipal, "No se pudo generar el vertice");
			}
		}
	}
	
	private String solicitarEntradaUsuario(String tituloVentana, String mensaje) {
		String input = "";
		input = (String) JOptionPane.showInputDialog(panelPrincipal, tituloVentana, mensaje, JOptionPane.PLAIN_MESSAGE, null, null, input);
		return input;
	}

	public void actualizarVerticesDesdeBase() {
		if(panelPrincipal.getComponentCount() > 0) {
			panelPrincipal.removeAll();
		}
		coordinador.obtenerVerticesDesdeGrafo().forEach( vertice ->{
			agregarVertice(vertice);
		});
	}
	
	private void agregarVertice(Vertice vertice) {
		FormaVertice formaVertice = new FormaVertice(
				coordinador,
				vertice.id(),
				vertice.posX(),
				vertice.posY(),
				vertice.nombre(),
				vertice.vecinos().toString()
		);
		
		vertices.put(formaVertice.id(), formaVertice);
		
		panelPrincipal.add(formaVertice);
		panelPrincipal.setComponentZOrder(formaVertice, 0);
		panelPrincipal.revalidate();
		panelPrincipal.repaint();
	}

	public JPanel obtenerPanelPrincipal() {
		return panelPrincipal;
	}

	public void resaltarVertices(Set<Integer> conjuntoDominanteMinimo) {
		conjuntoDominanteMinimo.forEach( id -> {
			((FormaVertice) vertices.get(id)).cambiarColorVertice();
		});
		panelPrincipal.repaint();
	}
	
}
