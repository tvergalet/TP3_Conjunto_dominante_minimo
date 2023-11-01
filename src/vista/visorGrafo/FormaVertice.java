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
	private Color colorDeVertice = Color.decode("#ED94FF");
	private int V_SIZE = 50;
	private String ID;

	public FormaVertice(int x, int y, String ID) {
		this.ID = ID;
		setName("Vertice " + ID);
		setBackground(colorDeVertice);
		setPreferredSize(new Dimension(V_SIZE, V_SIZE));
		setLayout(new GridBagLayout());
		setBounds(x - V_SIZE / 2, y - V_SIZE / 2, V_SIZE, V_SIZE);
		setOpaque(false);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Vertice");
			}
		});

		JLabel vertexLabel = new JLabel(String.valueOf(ID));
		vertexLabel.setName("VerticeLabel: " + ID);
		vertexLabel.setForeground(Color.BLACK);
		add(vertexLabel);
		addMouseMotionListener(this);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(colorDeVertice);
		g.fillOval(0, 0, V_SIZE, V_SIZE);
		g.setColor(Color.BLACK);
		g.drawOval(0, 0, V_SIZE, V_SIZE);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// Actualiza la posición del vértice al arrastrarlo:
		Point nuevoPunto = SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), getParent());
		int x = nuevoPunto.x - V_SIZE / 2;
		int y = nuevoPunto.y - V_SIZE / 2;
		setLocation(x, y);
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// No se sobreescribe, pero se implementa por la interfaz MouseMotionListener.
		
	}
	
	public String getID() {
		return this.ID;
	}

}
