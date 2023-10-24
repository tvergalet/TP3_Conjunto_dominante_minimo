package vista;

import java.awt.Toolkit;
import javax.swing.JFrame;
import coordinador.Coordinador;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame {
	
	private Coordinador coordinador;

	public VentanaPrincipal(Coordinador coord) {
		coordinador = coord;

		setSize(1280, 720);
		setTitle("Conjunto Dominante Minimo");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/appIcon_32.png")));
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// Designamos los metodos para cargar la interfaz
	}

	public void mostrarVentana() {
		setVisible(true);
	}
	
	
}
