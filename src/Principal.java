import com.formdev.flatlaf.intellijthemes.FlatGradiantoDeepOceanIJTheme;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import bd.AdmBaseDatos;
import coordinador.Coordinador;
import modelo.Logica;
import vista.VentanaPrincipal;
import vista.VentanaEmergente;

public class Principal {

	private Coordinador coordinador;
	private Logica logica;
	private AdmBaseDatos admBD;
	private VentanaPrincipal vPrincipal;
	private VentanaEmergente vEmergente;
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new FlatGradiantoDeepOceanIJTheme());
			Principal miPrincipal = new Principal();
			miPrincipal.iniciar();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
	
	private void iniciar() {
		// Se instancian las clases y se relacionan con el coordinador.
		coordinador = new Coordinador();
		
		admBD = new AdmBaseDatos();
		coordinador.setAdministradorBD(admBD);
		
		logica = new Logica(coordinador);
		coordinador.setLogica(logica);
		
		vPrincipal = new VentanaPrincipal(coordinador);
		coordinador.setVentanaPrincipal(vPrincipal);
		
		vEmergente = new VentanaEmergente(coordinador);
		coordinador.setVentanaEmergente(vEmergente);

		// Iniciamos la interfaz principal
		vPrincipal.mostrarVentana();
	}

}
