package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import coordinador.Coordinador;
import modelo.objetos.Arista;
import modelo.objetos.Grafo;
import modelo.objetos.Vertice;

import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame {

	// private Coordinador coordinador;
	private LineBorder lineBorder;
	Color colorTextFont;
	private static JPanel panelGrafo;
	private static JLabel infoLabel;
	// Grafo grafo;
	private static String modo = "Agregar Vértice/Arista";
	private static final Grafo GRAFO = new Grafo();
	private JPanelGrafo grafo;

	public VentanaPrincipal(Coordinador coordinador) {
		colorTextFont = new Color(111, 145, 173);
		// coordinador = coord;
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
		// visorGrafo();
		// creaMenuBar();
		panelGrafo = new JPanel();
		panelGrafo.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		panelGrafo.setBounds(20, 93, 600, 400);
		grafo = new JPanelGrafo(panelGrafo);
		getContentPane().add(panelGrafo);

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
		btn_AgregarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btn_AgregarPersona.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/agregarPersona32.png")));
		btn_AgregarPersona.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == btn_AgregarPersona) {
					VentanaAgregarPersona ventana = new VentanaAgregarPersona();
					ventana.setVisible(true);

				}
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
					VentanaAgregarPersona ventana = new VentanaAgregarPersona();
					ventana.setVisible(true);

				}
			}
		});
		toolBar.add(btn_AgregarRelacion);
		toolBar.addSeparator();

	}


	public static  JPanel getPanelGrafo() {

		return panelGrafo;

	}

	public static Grafo getGrafo() {
		return GRAFO;
	}

	public static JLabel getInfoLabel() {
		return infoLabel;
	}

	private JMenuBar creaMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new BoxLayout(menuBar, BoxLayout.X_AXIS));

		JLabel modoLabel = new JLabel(modo);
		modoLabel.setName("ModoLabel");
		// -------------------------------------------------------------------------------
		JMenu fileMenu = new JMenu("Archivo");

		JMenuItem limpiarItem = new JMenuItem("Limpiar");
		limpiarItem.setName("Limpiar");
		limpiarItem.addActionListener(e -> {
			GRAFO.clear();
			panelGrafo.removeAll();
			panelGrafo.revalidate();
			panelGrafo.repaint();
		});
		fileMenu.add(limpiarItem);

		JMenuItem exitItem = new JMenuItem("Salir");
		exitItem.setName("Exit");
		exitItem.addActionListener(event -> System.exit(0));
		fileMenu.add(exitItem);
		menuBar.add(fileMenu);
		// -------------------------------------------------------------------------------
		JMenu modoMenu = new JMenu("Modo");

		JMenuItem agregarItem = new JMenuItem("Agregar Vértice/Arista");
		agregarItem.setName("Agregar Vértice/Arista");
		agregarItem.addActionListener(e -> {
			modo = "Agregar Vértice/Arista";
			modoLabel.setText(modo);
			infoLabel.setText("Click en espacio vacío para añadir vértice o en vértice para añadir arista");
			GRAFO.descoloreaGrafo();
		});
		modoMenu.add(agregarItem);

		JMenuItem eliminarItem = new JMenuItem("Eliminar Vértice/Arista");
		eliminarItem.setName("Eliminar Vértice/Arista");
		eliminarItem.addActionListener(e -> {
			modo = "Eliminar Vértice/Arista";
			modoLabel.setText(modo);
			infoLabel.setText("Click en el elemento que quieras eliminar");
			GRAFO.descoloreaGrafo();
		});
		modoMenu.add(eliminarItem);

		JMenuItem ningunoItem = new JMenuItem("Ninguno");
		ningunoItem.setName("Ninguno");
		ningunoItem.addActionListener(e -> {
			modo = "Ninguno";
			modoLabel.setText(modo);
			infoLabel.setText("Ningún modo seleccionado");
		});
		modoMenu.add(ningunoItem);
		menuBar.add(modoMenu);
		// -------------------------------------------------------------------------------
		JMenu algoritmosMenu = new JMenu("Algoritmos");

		JMenuItem amplitudItem = new JMenuItem("Recorrido en Amplitud");
		amplitudItem.setName("Amplitud");
		amplitudItem.addActionListener(e -> {
			modo = "Recorrido en Amplitud";
			modoLabel.setText(modo);
			infoLabel.setText("Seleccione un vértice como punto de partida");
			GRAFO.crearMatrizAdyacencia();
			GRAFO.descoloreaGrafo();
		});
		algoritmosMenu.add(amplitudItem);

		JMenuItem profundidadItem = new JMenuItem("Recorrido en Profundidad");
		profundidadItem.setName("Profundidad");
		profundidadItem.addActionListener(e -> {
			modo = "Recorrido en Profundidad";
			modoLabel.setText(modo);
			infoLabel.setText("Seleccione un vértice como punto de partida");
			GRAFO.crearMatrizAdyacencia();
			GRAFO.descoloreaGrafo();
		});
		algoritmosMenu.add(profundidadItem);

		JMenuItem dijkstraItem = new JMenuItem("Algoritmo de Dijkstra");
		dijkstraItem.setName("Dijkstra");
		dijkstraItem.addActionListener(e -> {
			modo = "Algoritmo de Dijkstra";
			modoLabel.setText(modo);
			infoLabel.setText("Seleccione un vértice como punto de partida");
			GRAFO.crearMatrizAdyacencia();
			GRAFO.descoloreaGrafo();
		});
		algoritmosMenu.add(dijkstraItem);

		JMenuItem arbolItem = new JMenuItem("Árbol de expansión mínima");
		arbolItem.setName("Árbol de Expansión Mínima");
		arbolItem.addActionListener(e -> {
			modo = "Árbol de expansión mínima";
			modoLabel.setText(modo);
			infoLabel.setText("Seleccione un vértice arbitrario");
			GRAFO.descoloreaGrafo();
		});
		algoritmosMenu.add(arbolItem);

		menuBar.add(algoritmosMenu);
		// -------------------------------------------------------------------------------
		JPanel panelDerecho = new JPanel();
		panelDerecho.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelDerecho.setOpaque(false);
		panelDerecho.add(modoLabel);

		menuBar.add(Box.createHorizontalGlue());
		menuBar.add(panelDerecho);

		return menuBar;
	}

	/**
	 * Método para manejar el evento de click del mouse en el panel principal. Se
	 * evalúa el input del usuario y manda mensajes de error en caso de una entrada
	 * incorrecta. Este método solo evalúa clicks en el panel principal, pero no en
	 * Vértices o Aristas, pues estos tienen sus propios eventos.
	 * 
	 * @param e El evento de click del mouse en el panel principal de la aplicación.
	 */
	private static void leeClick(MouseEvent e) {
		Point click = SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), panelGrafo);
		Component component = panelGrafo.getComponentAt(click);
		String ID = "";
		switch (modo) {
		case "Agregar Vértice/Arista" -> {
			if (!(component instanceof Vertice) && Vertice.getvOrigen() == null) {
				ID = (String) JOptionPane.showInputDialog(panelGrafo, "Ingrese el nombre:", "Nombre del vértice",
						JOptionPane.PLAIN_MESSAGE, null, null, ID);
				if (ID == null) {
					break;
				}
				if (ID.isBlank()) {
					JOptionPane.showMessageDialog(panelGrafo, "El nombre no puede estar vacío", "Nombre inválido",
							JOptionPane.WARNING_MESSAGE);
				} else if (ID.length() > 3) {
					JOptionPane.showMessageDialog(panelGrafo, "El nombre no puede tener más de 3 caracteres",
							"Nombre muy largo", JOptionPane.WARNING_MESSAGE);
				} else {
					Vertice vertice = GRAFO.creaVertice(ID, e.getX(), e.getY());
					if (vertice != null) {
						panelGrafo.add(vertice);
						panelGrafo.setComponentZOrder(vertice, 0);
						panelGrafo.revalidate();
						panelGrafo.repaint();
					} else {
						JOptionPane.showMessageDialog(panelGrafo, "El vértice ya existe en el grafo",
								"Vértice repetido", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		}
		case "Árbol de expansión mínima" -> {
			int opcion = JOptionPane.showConfirmDialog(panelGrafo, "¿Quieres eliminar los aristas grises?",
					"Confirma eliminación", JOptionPane.YES_NO_OPTION);
			if (opcion == JOptionPane.YES_OPTION) {
				for (Arista arista : GRAFO.aristasInnecesarias()) {
					arista.getOrigen().desconectaArista(arista);
					arista.getDestino().desconectaArista(arista);
					GRAFO.eliminaArista(arista);
					panelGrafo.remove(arista.getPesoLabel());
					panelGrafo.remove(arista);
					panelGrafo.revalidate();
				}
				panelGrafo.repaint();
				panelGrafo.revalidate();
			}
		}
		default -> {
		}
		}
	}

	public static String getModo() {
		return modo;
	}

}