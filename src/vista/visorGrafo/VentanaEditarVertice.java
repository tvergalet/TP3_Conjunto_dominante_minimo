package vista.visorGrafo;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import coordinador.Coordinador;
import modelo.grafo.Vertice;

@SuppressWarnings("serial")
public class VentanaEditarVertice extends JFrame {

	private Coordinador coordinador;
	private Vertice vertice;

	public VentanaEditarVertice(Coordinador coordinador, int id) {
		this.coordinador = coordinador;
		this.vertice = this.coordinador.obtenerVertice(id);

		System.out.println(vertice.toString());

		setSize(500, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		getContentPane().setLayout(null);

		asignarTitulo();
		asignarBotonCerrar();
		generarPanelTabs();
	}

	private void asignarBotonCerrar() {
		JButton btn_Cerrar = new JButton();
		btn_Cerrar.setToolTipText("Cerrar ventana");
		btn_Cerrar.setBackground(null);
		btn_Cerrar.setBorder(null);
		btn_Cerrar.setBounds(467, 11, 23, 21);
		btn_Cerrar.setIcon(new ImageIcon(VentanaEditarVertice.class.getResource("/img/cerrar.png")));
		btn_Cerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cerrarVentana();
			}
		});
		getContentPane().add(btn_Cerrar);
	}

	private void asignarTitulo() {
		JLabel lbl_Titulo = new JLabel("Editar Vertice");
		lbl_Titulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Titulo.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_Titulo.setBounds(10, 11, 480, 21);
		getContentPane().add(lbl_Titulo);
	}

	private void generarPanelTabs() {
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(10, 40, 480, 388);

		tabbedPane.addTab("Actualizar", panelActualizar());
		tabbedPane.addTab("Generar Arista", panelGenerarArista());
		tabbedPane.addTab("Eliminar", panelEliminar());

		getContentPane().add(tabbedPane);
	}

	private JPanel panelActualizar() {
		JPanel panel = new JPanel();
		// GENERAR MENU PARA EDITAR
		return panel;
	}

	private JPanel panelGenerarArista() {
		JPanel panel = new JPanel();
		// GENERAR MENU PARA ASIGNAR ARISTA
		return panel;
	}

	private JPanel panelEliminar() {
		JPanel panel = new JPanel();
		
		JButton btn_Eliminar = new JButton("Eliminar vertice");
		btn_Eliminar.setBounds(20, 20, 50, 22);
		btn_Eliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				coordinador.eliminarVertice(vertice.id());
			}
		});
		panel.add(btn_Eliminar);
		
		return panel;
	}

	private void limpiarCampos() {

	}

	public void mostrarVentana() {
		setVisible(true);
	}

	public void cerrarVentana() {
		limpiarCampos();
		setVisible(false);
	}

}