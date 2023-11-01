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
import javax.swing.JScrollPane;
import javax.swing.JTable;

import coordinador.Coordinador;
import vista.visorGrafo.VisorGrafo;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame {

	private Coordinador coordinador;
	private LineBorder lineBorder;
	private Color colorTextFont;
	private JTable tbl_Vertices;
	private AdmTablas admTablas;
	private VisorGrafo visorGrafo;

	public VentanaPrincipal(Coordinador coordinador) {
		this.admTablas = new AdmTablas();
		this.visorGrafo = new VisorGrafo();
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
		crearGrillaVertices();
	}

	public void mostrarVentana() {
		setVisible(true);
	}

	public void agregarVisorGrafo() {
		JPanel panelVisorGrafo = new JPanel();
		panelVisorGrafo.setBorder(new TitledBorder(lineBorder, "Visor Grafo", TitledBorder.LEFT, TitledBorder.TOP, null, colorTextFont));
		panelVisorGrafo.setBounds(10, 93, 970, 577);
		panelVisorGrafo.add(visorGrafo.getMainPanel());
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
				if (e.getSource() == btn_AgregarRelacion) {

					// VentanaAgregarVertice ventana = new VentanaAgregarVertice();
					// ventana.setVisible(true);

				}
			}
		});
		toolBar.add(btn_AgregarRelacion);
		toolBar.addSeparator();

		JButton btn_ConjuntoDominanteMinimo = new JButton("Conjunto Dominante Minimo");
		btn_ConjuntoDominanteMinimo
				.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/advertencia_32.png")));
		btn_ConjuntoDominanteMinimo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				coordinador.mostrarVentanaEmergente();
			}
		});
		toolBar.add(btn_ConjuntoDominanteMinimo);
		toolBar.addSeparator();
	}

	public void crearGrillaVertices() {
		JPanel pnl_Vertices = new JPanel();
		pnl_Vertices.setBorder(
				new TitledBorder(lineBorder, "Vertices", TitledBorder.LEFT, TitledBorder.TOP, null, colorTextFont));
		pnl_Vertices.setBounds(990, 93, 264, 577);
		pnl_Vertices.setLayout(null);
		getContentPane().add(pnl_Vertices);

		tbl_Vertices = new JTable();
		admTablas.establecerModeloNoEditable(tbl_Vertices);
		admTablas.establecerTituloColumnas(tbl_Vertices, new String[] { "ID", "Vecinos" });
		admTablas.establecerValores(tbl_Vertices, coordinador.obtenerVerticesEnLista());
		admTablas.centrarValoresEnCeldas(tbl_Vertices);
		admTablas.ajustarAnchoColumna(tbl_Vertices, 0, 20);

		JScrollPane spl_TablaVertices = new JScrollPane(tbl_Vertices);
		spl_TablaVertices.setBounds(10, 20, 244, 546);
		pnl_Vertices.add(spl_TablaVertices);
	}

}