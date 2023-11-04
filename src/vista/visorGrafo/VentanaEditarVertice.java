package vista.visorGrafo;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.GridLayout;

import coordinador.Coordinador;
import modelo.grafo.Vertice;
import javax.swing.border.LineBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class VentanaEditarVertice extends JFrame {

	private Coordinador coordinador;
	private Vertice vertice;
	private JPanel panelPrincipal;

	public VentanaEditarVertice(Coordinador coordinador, int id) {
		this.coordinador = coordinador;
		this.vertice = this.coordinador.obtenerVertice(id);

		System.out.println(vertice.toString());

		setSize(500, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));

		crearPanelPrincipal();
	}
	
	private void crearPanelPrincipal() {
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new LineBorder(new Color(239, 239, 239), 2));
		panelPrincipal.setLayout(null);
		getContentPane().add(panelPrincipal);
		
		JLabel lbl_Titulo = new JLabel("Editar Vertice");
		lbl_Titulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Titulo.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_Titulo.setBounds(10, 11, 480, 21);
		panelPrincipal.add(lbl_Titulo);
		
		JButton btn_Cerrar = new JButton(new ImageIcon("src/img/cerrar.png"));
		btn_Cerrar.setToolTipText("Cerrar ventana");
		btn_Cerrar.setBackground(null);
		btn_Cerrar.setBorder(null);
		btn_Cerrar.setBounds(467, 11, 23, 21);
		btn_Cerrar.addActionListener((evento) -> cerrarVentana());
		panelPrincipal.add(btn_Cerrar);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(10, 40, 480, 388);
		tabbedPane.addTab("Actualizar", panelActualizar());
		tabbedPane.addTab("Generar Arista", panelGenerarArista());
		tabbedPane.addTab("Eliminar", panelEliminar());

		panelPrincipal.add(tabbedPane);
	}

	private JPanel panelActualizar() {
		JPanel panel = new JPanel();
		// GENERAR MENU PARA EDITAR
		return panel;
	}

	private JPanel panelGenerarArista() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
			
		JComboBox<Integer> listaVertices = new JComboBox<Integer>();
		listaVertices.setFont(new Font("Tahoma", Font.PLAIN, 11));
		listaVertices.setBounds(248, 7, 77, 21);
		panel.add(listaVertices);
		
		JLabel lbl_ListaVertice = new JLabel("Vertice a conectar:");
		lbl_ListaVertice.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_ListaVertice.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_ListaVertice.setBounds(129, 10, 121, 13);
		panel.add(lbl_ListaVertice);
		
		JButton btn_GenerarArista = new JButton("Generar Arista");
		btn_GenerarArista.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn_GenerarArista.setBounds(165, 38, 121, 21);
		btn_GenerarArista.addActionListener((evento) -> {
			int idSeleccionado = (int) listaVertices.getSelectedItem();
			coordinador.generarArista( vertice.id(), idSeleccionado );
			cerrarVentana();
		});
		
		panel.add(btn_GenerarArista);
		
		coordinador.obtenerIdVertices().forEach( id ->{
			if(id != vertice.id())
				listaVertices.addItem(id);
		});
		
		return panel;
	}

	private JPanel panelEliminar() {
		// QUEDA PENDIENTE ELIMINAR AL VERTICE DE LA LISTA DE VECINOS A LA QUE ESTA ASOCIADO
		
		JPanel panel = new JPanel();

		JButton btn_Eliminar = new JButton("Eliminar vertice");
		btn_Eliminar.setBounds(20, 20, 50, 22);
		btn_Eliminar.addActionListener((evento) -> {
			coordinador.eliminarVertice( vertice.id() );
			coordinador.mostrarAvisoEnVentanaPrincipal("Vertice " + vertice.id() + " eliminado");
			cerrarVentana();
		});
		panel.add(btn_Eliminar);

		return panel;
	}

	public void mostrarVentana() {
		setVisible(true);
	}

	public void cerrarVentana() {
		setVisible(false);
	}
}