package vista;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
class LineaRecta extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(3)); // Ancho de la línea
        g2d.setColor(new Color(255, 0, 0));
        g2d.drawLine(50, 50, 200, 200); // Coordenadas x1, y1, x2, y2
    }
}

public class PruebaLinea {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        LineaRecta lineaRecta = new LineaRecta();
        frame.add(lineaRecta);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
