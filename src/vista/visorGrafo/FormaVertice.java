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

import coordinador.Coordinador;

@SuppressWarnings("serial")
public class FormaVertice extends JPanel implements MouseMotionListener {
	
	private Coordinador coordinador;
	private Color colorFondoNormal, colorFondoResaltado;
	private int id, posX, posY, tamanio;
	private String nombre, vecinos;
	
	
	public FormaVertice(Coordinador coordinador, int id, int posX, int posY, String nombre, String vecinos) {
		this.coordinador = coordinador;
		this.id = id;
		this.posX = posX;
		this.posY = posY;
		this.tamanio = 50;
		this.nombre = nombre;
		this.vecinos = vecinos;
		this.colorFondoNormal = Color.decode("#ED94FF");
		this.colorFondoResaltado = Color.decode("#03fc77");
		
		asignarAtributos();
		agregarEventos();
		agregarTitulo();
	}
	
	private void asignarAtributos() {
		setToolTipText(generarDescripcion());
		setName("Vertice: " + id);
		setBackground(colorFondoNormal);
		setPreferredSize(new Dimension(tamanio, tamanio));
		setLayout(new GridBagLayout());
		setBounds(posX - tamanio / 2, posY - tamanio / 2, tamanio, tamanio);
		setOpaque(false);
		addMouseMotionListener(this);
	}
	
	private String generarDescripcion() {
		StringBuilder descripcion = new StringBuilder();
		descripcion.append("Id: " + id + "\n");
		descripcion.append("Nombre: " + nombre + "\n");
		descripcion.append("Vecinos: " + vecinos);
		return descripcion.toString();
	}
	
	private void agregarEventos() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaOpcionesVertice ventanaEditar = new VentanaOpcionesVertice(coordinador, id);
				ventanaEditar.mostrarVentana();
			}
		});
	}
	
	private void agregarTitulo() {
		JLabel titulo = new JLabel(String.valueOf(id));
		titulo.setForeground(Color.BLACK);
		add(titulo);
	}
	
	public void cambiarColorVertice() {
		this.colorFondoNormal = colorFondoResaltado;
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// Dibuja en pantalla un circulo que representa el vertice
		super.paintComponent(g);
		g.setColor(colorFondoNormal);
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
		coordinador.actualizarPosicionVertice(this.id, x, y);
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// No se sobreescribe, pero se implementa por la interfaz MouseMotionListener.
	}

	public Integer id() {
		return id;
	}

}
