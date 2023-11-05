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
import java.awt.Component;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class VentanaOpcionesVertice extends JFrame {

	private Coordinador coordinador;
	private Vertice vertice;
	private JPanel panelPrincipal;
	private JTextField txt_Nombre;

	public VentanaOpcionesVertice(Coordinador coordinador, int id) {
		this.coordinador = coordinador;
		this.vertice = this.coordinador.obtenerVertice(id);

		setSize(400, 300);
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
		
		JButton btn_Cerrar = new JButton(new ImageIcon("src/img/cerrar.png"));
		btn_Cerrar.setToolTipText("Cerrar ventana");
		btn_Cerrar.setBackground(null);
		btn_Cerrar.setBorder(null);
		btn_Cerrar.setBounds(321, 11, 23, 21);
		btn_Cerrar.addActionListener((evento) -> cerrarVentana());
		panelPrincipal.add(btn_Cerrar);
		
		JLabel lbl_Titulo = new JLabel("Editar Vertice");
		lbl_Titulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Titulo.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_Titulo.setBounds(10, 11, 334, 21);
		panelPrincipal.add(lbl_Titulo);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(10, 40, 380, 207);
		tabbedPane.addTab("Detalle", panelDetalle());
		tabbedPane.addTab("Actualizar", panelActualizar());
		tabbedPane.addTab("Generar Arista", panelGenerarArista());
		tabbedPane.addTab("Eliminar", panelEliminar());

		panelPrincipal.add(tabbedPane);
	}
	
	private JPanel panelDetalle() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel lbl_Id = new JLabel("Id:");
		lbl_Id.setLocation(25, 12);
		lbl_Id.setSize(162, 19);
		panel.add(lbl_Id);
		
		JTextField txt_Id = new JTextField( String.valueOf(vertice.id()) );
		txt_Id.setLocation(121, 10);
		panel.add(txt_Id);
		
		JLabel lbl_Nombre = new JLabel("Nombre:");
		lbl_Nombre.setLocation(25, 37);
		lbl_Nombre.setSize(162, 19);
		panel.add(lbl_Nombre);
		
		JTextField txt_Nombre = new JTextField( vertice.nombre() );
		txt_Nombre.setLocation(121, 35);
		panel.add(txt_Nombre);
		
		JLabel lbl_Vecinos = new JLabel("Vecinos:");
		lbl_Vecinos.setLocation(25, 62);
		panel.add(lbl_Vecinos);
		
		JTextField txt_Vecinos = new JTextField( vertice.vecinos().toString() );
		txt_Vecinos.setLocation(121, 60);
		panel.add(txt_Vecinos);
		
		JLabel lbl_PosicionX = new JLabel("Posicion X:");
		lbl_PosicionX.setLocation(25, 88);
		panel.add(lbl_PosicionX);
		
		JTextField txt_PosicionX = new JTextField( String.valueOf(vertice.posX()) );
		txt_PosicionX.setLocation(121, 85);
		panel.add(txt_PosicionX);
		
		JLabel lbl_PosicionY = new JLabel("Posicion Y:");
		lbl_PosicionY.setLocation(25, 113);
		panel.add(lbl_PosicionY);
		
		JTextField txt_PosicionY = new JTextField( String.valueOf(vertice.posY()) );
		txt_PosicionY.setLocation(121, 111);
		panel.add(txt_PosicionY);
		
		// Asignamos los atributos generales/compartidos a los componentes
		for(Component c : panel.getComponents()) {
			if(c instanceof JLabel ) {
				((JLabel) c).setHorizontalAlignment(SwingConstants.RIGHT);
				((JLabel) c).setFont(new Font("Tahoma", Font.BOLD, 12));
				((JLabel) c).setSize(162, 19);
			}
			if(c instanceof JTextField) {
				((JTextField) c).setEditable(false);
				((JTextField) c).setSize(92, 13);
			}
		}	
		
		return panel;
	}

	private JPanel panelActualizar() {

		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel lbl_Nombre = new JLabel("Nombre:");
		lbl_Nombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_Nombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_Nombre.setBounds(88, 7, 51, 15);
		panel.add(lbl_Nombre);
		
		txt_Nombre = new JTextField( vertice.nombre() );
		txt_Nombre.setColumns(10);
		txt_Nombre.setBounds(144, 5, 96, 19);
		panel.add(txt_Nombre);
		
		JButton btn_GuardarCambios = new JButton("Guardar Cambios");
		btn_GuardarCambios.setBounds(108, 31, 111, 21);
		btn_GuardarCambios.addActionListener((evento) -> {
			vertice.actualizarNombre(txt_Nombre.getText());
			coordinador.actualizarVertice(vertice);
		});
		panel.add(btn_GuardarCambios);
		
		return panel;
	}

	private JPanel panelGenerarArista() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
			
		JComboBox<Integer> listaVertices = new JComboBox<Integer>();
		listaVertices.setFont(new Font("Tahoma", Font.PLAIN, 11));
		listaVertices.setBounds(182, 10, 77, 21);
		panel.add(listaVertices);
		
		JLabel lbl_ListaVertice = new JLabel("Vertice a conectar:");
		lbl_ListaVertice.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_ListaVertice.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_ListaVertice.setBounds(63, 13, 121, 13);
		panel.add(lbl_ListaVertice);
		
		JButton btn_GenerarArista = new JButton("Generar Arista");
		btn_GenerarArista.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn_GenerarArista.setBounds(99, 41, 121, 21);
		btn_GenerarArista.addActionListener((evento) -> {
			int idSeleccionado = (int) listaVertices.getSelectedItem();
			coordinador.generarArista( vertice.id(), idSeleccionado );
			coordinador.actualizarVerticesEnVentanaPrincipal();
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
		JPanel panel = new JPanel();

		JButton btn_Eliminar = new JButton("Eliminar vertice");
		btn_Eliminar.setBounds(101, 10, 122, 21);
		btn_Eliminar.addActionListener((evento) -> {
			coordinador.eliminarVertice( vertice.id() );
			coordinador.mostrarAvisoEnVentanaPrincipal("Vertice " + vertice.id() + " eliminado");
			cerrarVentana();
		});
		panel.setLayout(null);
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