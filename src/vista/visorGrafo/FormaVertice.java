package vista.visorGrafo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class FormaVertice extends JPanel implements MouseMotionListener {
	private Color colorFondo = Color.decode("#ED94FF");
	private int tamanio = 50;
	
	private int id, posX, posY;
	private String nombre, vecinos;
	

	public FormaVertice(int id, int posX, int posY, String nombre, String vecinos) {
		this.id = id;
		this.posX = posX;
		this.posY = posY;
		this.nombre = nombre;
		this.vecinos = vecinos;
		
		asignarAtributos();
		agregarEventoClic();
		agregarTitulo();
	}
	
	private void asignarAtributos() {
		setToolTipText(generarDescripcion());
		setBackground(colorFondo);
		setPreferredSize(new Dimension(tamanio, tamanio));
		setLayout(new GridBagLayout());
		setBounds(posX - tamanio / 2, posY - tamanio / 2, tamanio, tamanio);
		setOpaque(false);
		addMouseMotionListener(this);
	}
	
	private String generarDescripcion() {
		StringBuilder descripcion = new StringBuilder();
		descripcion.append("Vertice " + id + "\n");
		descripcion.append("Nombre: " + nombre + "\n");
		descripcion.append("Vecinos: " + vecinos);
		return descripcion.toString();
	}
	
	private void agregarEventoClic() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Vertice " + nombre);
			}
		});
	}
	
	private void agregarTitulo() {
		JLabel titulo = new JLabel(String.valueOf(id));
		titulo.setName("VerticeLabel: " + id);
		titulo.setForeground(Color.BLACK);
		add(titulo);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// Dibuja en pantalla un circulo que representa el vertice
		super.paintComponent(g);
		g.setColor(colorFondo);
		g.fillOval(0, 0, tamanio, tamanio);
		g.setColor(Color.BLACK);
		g.drawOval(0, 0, tamanio, tamanio);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// Actualiza la posición del vértice al arrastrarlo:
		Point nuevoPunto = SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), getParent());
		int x = nuevoPunto.x - tamanio / 2;
		int y = nuevoPunto.y - tamanio / 2;
		setLocation(x, y);
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// No se sobreescribe, pero se implementa por la interfaz MouseMotionListener.
	}

}
