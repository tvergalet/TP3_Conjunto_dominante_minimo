package vista;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import coordinador.Coordinador;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame {

	private Coordinador coordinador;
	private LineBorder lineBorder;
	Color colorTextFont;

	public VentanaPrincipal(Coordinador coord) {
		colorTextFont = new Color(111, 145, 173);
		coordinador = coord;
		lineBorder = new LineBorder(new Color(39, 57, 88), 1, true);
		setSize(1280, 720);
		setTitle("Conjunto Dominante Minimo");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/appIcon_32.png")));

		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// Designamos los metodos para cargar la interfaz
		crearBarraHerramientas();

	}

	public void mostrarVentana() {
		setVisible(true);
	}

	public void crearBarraHerramientas() {
		JToolBar toolBar = new JToolBar();
		toolBar.setBorder(new TitledBorder(lineBorder, "Barra de herramientas", TitledBorder.LEFT, TitledBorder.TOP,
				null, colorTextFont));
		toolBar.setBounds(10, 10, 1246, 72);
		getContentPane().add(toolBar);
		toolBar.addSeparator();

		JButton btn_AgregarPersona = new JButton("Agregar Persona");
		btn_AgregarPersona.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/agregarPersona32.png")));
		btn_AgregarPersona.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		toolBar.add(btn_AgregarPersona);
		toolBar.addSeparator();
		JButton btn_AgregarRelacion = new JButton("Agregar Persona");
		btn_AgregarRelacion.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/crearVinculo32.png")));
		btn_AgregarRelacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		toolBar.add(btn_AgregarRelacion);
		toolBar.addSeparator();
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 93, 419, 348);
		getContentPane().add(panel);

	}
}