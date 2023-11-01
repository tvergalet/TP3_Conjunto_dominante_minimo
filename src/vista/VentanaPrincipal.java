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
import vista.visorGrafo.VisorGrafo;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame {

	private Coordinador coordinador;
	private LineBorder lineBorder;
	private Color colorTextFont;

	public VentanaPrincipal(Coordinador coordinador) {
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
		VisorGrafo v = new VisorGrafo();
		JPanel visorGrafo = v.getMainPanel();
		visorGrafo.setBounds(10, 93, 1000, 577);
		visorGrafo.setBackground(new Color(255, 0, 0));
		getContentPane().add(visorGrafo);
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
					// VentanaAgregarVertice ventana = new VentanaAgregarVertice();
					// ventana.setVisible(true);

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

					// VentanaAgregarVertice ventana = new VentanaAgregarVertice();
					// ventana.setVisible(true);

				}
			}
		});
		toolBar.add(btn_AgregarRelacion);
		toolBar.addSeparator();

	}

}