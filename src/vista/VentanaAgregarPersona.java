package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class VentanaAgregarPersona extends JFrame {

	private JTextField txt_Nombre;

	public VentanaAgregarPersona() {

		setTitle("Agregar Persona");
		setSize(515, 250);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/agregarPersona32.png")));
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);

		agregarComponentes();
	}

	public void mostrarVentana() {
		setVisible(true);
	}

	public void cerrarVentana() {
		limpiarCampos();
		setVisible(false);
	}

	private void limpiarCampos() {
		txt_Nombre.setText("");

	}

	private void agregarComponentes() {
		JPanel pnl_AgregarPersona = new JPanel();
		pnl_AgregarPersona.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnl_AgregarPersona.setLayout(null);
		getContentPane().add(pnl_AgregarPersona);

		JLabel lbl_Titulo = new JLabel("Agregar Persona");
		lbl_Titulo.setBounds(0, 7, 515, 22);
		lbl_Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Titulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		pnl_AgregarPersona.add(lbl_Titulo);

		JLabel lbl_Nombre = new JLabel("Nombre");
		lbl_Nombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_Nombre.setBounds(52, 39, 133, 22);
		pnl_AgregarPersona.add(lbl_Nombre);

		txt_Nombre = new JTextField();
		txt_Nombre.setBounds(184, 39, 282, 22);
		pnl_AgregarPersona.add(txt_Nombre);

		JButton btn_AgregarPersona = new JButton("Agregar");
		btn_AgregarPersona.setFont(new Font("Tahoma", Font.BOLD, 10));
		btn_AgregarPersona.setBounds(152, 179, 100, 30);
		pnl_AgregarPersona.add(btn_AgregarPersona);

		JButton btn_Cancelar = new JButton("Cancelar");
		btn_Cancelar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btn_Cancelar.setBounds(271, 179, 100, 30);
		btn_Cancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cerrarVentana();
			}
		});
		pnl_AgregarPersona.add(btn_Cancelar);
	}

}
