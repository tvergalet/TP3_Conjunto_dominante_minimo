package vista;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
	private JTextField lbl_Mensaje;
	private Color colorBorde;

	public VentanaEmergente(Coordinador coord) {	
		coordinador = coord;
		colorBorde = new Color(39, 57, 88);
		setSize(500, 110);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(colorBorde, 3));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lbl_Titulo = new JLabel("Titulo");
		lbl_Titulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Titulo.setBounds(10, 10, 480, 21);
		panel.add(lbl_Titulo);
		
		lbl_Mensaje = new JTextField("Mensaje");
		lbl_Mensaje.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_Mensaje.setForeground(new Color(0, 0, 0));
		lbl_Mensaje.setBounds(10, 35, 480, 29);
		lbl_Mensaje.setEditable(false);
		lbl_Mensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Mensaje.setBackground(new Color(255, 255, 255));
		panel.add(lbl_Mensaje);
		
		JButton btn_Cerrar = new JButton("Cerrar");
		btn_Cerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				coordinador.cerrarVentanaEmergente();
			}
		});
		btn_Cerrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_Cerrar.setBounds(208, 71, 80, 29);
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
		lbl_Mensaje.setText(mensaje);
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