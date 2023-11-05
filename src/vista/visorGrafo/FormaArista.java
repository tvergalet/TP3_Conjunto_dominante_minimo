package vista.visorGrafo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

//import java.awt.Color;
//import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FormaArista extends JPanel {

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(3)); // Ancho de la línea
		System.out.println("Llega aca");
		g2d.setColor(new Color(255, 0, 0));
		g2d.drawLine(50, 50, 200, 200); // Coordenadas x1, y1, x2, y2
	}
	
}
