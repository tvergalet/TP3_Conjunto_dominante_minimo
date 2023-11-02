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
import javax.swing.JPanel;

import coordinador.Coordinador;
import vista.visorGrafo.VisorGrafo;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame {

	private Coordinador coordinador;
	private LineBorder lineBorder;
	private Color colorTextFont;
	private VisorGrafo visorGrafo;

	public VentanaPrincipal(Coordinador coordinador) {
		this.visorGrafo = new VisorGrafo(coordinador);
		this.coordinador = coordinador;
		this.colorTextFont = new Color(111, 145, 173);
		this.lineBorder = new LineBorder(new Color(39, 57, 88), 1, true);

		setSize(1280, 720);
		setTitle("Conjunto Dominante Minimo");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/appIcon_32.png")));
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		crearBarraHerramientas();
		agregarVisorGrafo();
	}

	public void mostrarVentana() {
		setVisible(true);
	}

	public void agregarVisorGrafo() {		
		JPanel panelVisorGrafo = new JPanel();
		panelVisorGrafo.setBorder(new TitledBorder(lineBorder, "Visor Grafo", TitledBorder.LEFT, TitledBorder.TOP, null, colorTextFont));
		panelVisorGrafo.setBounds(10, 93, 1246, 577);
		panelVisorGrafo.add(visorGrafo.obtenerPanelPrincipal());
		panelVisorGrafo.setLayout(new GridLayout(1, 0, 0, 0));
		getContentPane().add(panelVisorGrafo);

	}

	public void crearBarraHerramientas() {
		JToolBar toolBar = new JToolBar();
		toolBar.setBorder(new TitledBorder(lineBorder, "Barra de herramientas", TitledBorder.LEFT, TitledBorder.TOP,
				null, colorTextFont));
		toolBar.setBounds(10, 10, 1246, 72);
		getContentPane().add(toolBar);
		toolBar.addSeparator();

		JButton btn_AgregarVertice = new JButton("Agregar Vertice");
		btn_AgregarVertice.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/agregarPersona32.png")));
		btn_AgregarVertice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// DESARROLLAR CODIGO
			}
		});
		toolBar.add(btn_AgregarVertice);
		toolBar.addSeparator();

		JButton btn_AgregarArista = new JButton("Agregar Arista");
		btn_AgregarArista.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/crearVinculo32.png")));
		btn_AgregarArista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// DESARROLLAR CODIGO
			}
		});
		toolBar.add(btn_AgregarArista);
		toolBar.addSeparator();

		JButton btn_ConjuntoDominanteMinimo = new JButton("Obtener Conjunto Dominante Minimo");
		btn_ConjuntoDominanteMinimo
				.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/advertencia_32.png")));
		btn_ConjuntoDominanteMinimo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				coordinador.mostrarConjuntoDominanteMinimo();
			}
		});
		toolBar.add(btn_ConjuntoDominanteMinimo);
		toolBar.addSeparator();
		
		JButton btn_GuardarModificaciones = new JButton("Guardar Modificaciones");
		btn_GuardarModificaciones.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/crearVinculo32.png")));
		btn_GuardarModificaciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				coordinador.guardarVertices();
			}
		});
		toolBar.add(btn_GuardarModificaciones);
		toolBar.addSeparator();
	}

}