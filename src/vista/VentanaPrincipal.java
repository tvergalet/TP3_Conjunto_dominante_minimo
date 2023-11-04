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
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/appIcon.png")));
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

	private void agregarVisorGrafo() {		
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

		JButton btn_GuardarCambios = new JButton();
		btn_GuardarCambios.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/guardarCambios.png")));
		btn_GuardarCambios.setToolTipText("Guardar Cambios");
		btn_GuardarCambios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				coordinador.guardarVertices();
			}
		});
		toolBar.add(btn_GuardarCambios);
		toolBar.addSeparator();
		
		JButton btn_DeshacerCambios = new JButton();
		btn_DeshacerCambios.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/deshacerCambios.png")));
		btn_DeshacerCambios.setToolTipText("Deshacer Cambios");
		btn_DeshacerCambios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actualizarVerticesDesdeBase();
			}
		});
		toolBar.add(btn_DeshacerCambios);
		toolBar.addSeparator();
		
		JButton btn_ConjuntoDominanteMinimo = new JButton("Obtener Conjunto Dominante Minimo");
		btn_ConjuntoDominanteMinimo
				.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/conjuntoDominanteMinimo.png")));
		btn_ConjuntoDominanteMinimo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				coordinador.mostrarConjuntoDominanteMinimo();
				visorGrafo.resaltarVertices(coordinador.obtenerConjuntoDominanteMinimo());
			}
		});
		toolBar.add(btn_ConjuntoDominanteMinimo);
		toolBar.addSeparator();
	}
	
	public void actualizarVerticesDesdeBase() {
		visorGrafo.actualizarVerticesDesdeBase();
	}
}