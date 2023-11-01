package vista;

import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import coordinador.Coordinador;
import javax.swing.border.LineBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class VentanaEmergente extends JFrame {

	private Coordinador coordinador;
	private JLabel lbl_Titulo;
	private JTextPane txt_Mensaje;
	private Color colorBorde;

	public VentanaEmergente(Coordinador coord) {	
		coordinador = coord;
		colorBorde = new Color(39, 57, 88);
		setSize(515, 200);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/advertencia_32.png")));
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(colorBorde, 3));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lbl_Titulo = new JLabel("New label");
		lbl_Titulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Titulo.setBounds(10, 10, 495, 21);
		panel.add(lbl_Titulo);
		
		txt_Mensaje = new JTextPane();
		txt_Mensaje.setBounds(10, 41, 495, 101);
		panel.add(txt_Mensaje);
		
		JButton btn_Cerrar = new JButton("Cerrar");
		btn_Cerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				coordinador.cerrarVentanaEmergente();
			}
		});
		btn_Cerrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_Cerrar.setBounds(202, 154, 105, 29);
		panel.add(btn_Cerrar);
				
	}
	
	public void mostrarVentana(String titulo, String mensaje) {
		establerTitulo(titulo);
		establecerMensaje(mensaje);
		setVisible(true);  
	}
	
	private void establerTitulo(String titulo) {
		setTitle(titulo);
		lbl_Titulo.setText(titulo);
	}
	
	private void establecerMensaje(String mensaje) {
		txt_Mensaje.setText(mensaje);
	}
	
	public void cerrarVentana() {
		limpiarCampos();
		setVisible(false);
	}
	
	private void limpiarCampos() {
		establerTitulo("");
		establecerMensaje("");
	}	
}