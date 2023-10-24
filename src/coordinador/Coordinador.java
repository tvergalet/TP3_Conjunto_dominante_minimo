package coordinador;

import bd.AdmBaseDatos;
import modelo.Logica;
import vista.VentanaPrincipal;

public class Coordinador {

	private Logica logica;
	private AdmBaseDatos administradorBD;
	private VentanaPrincipal vPrincipal;

	public void setLogica(Logica logica) {
		this.logica = logica;
	}
	
	public void setAdministradorBD(AdmBaseDatos administradorBaseDatos) {
		this.administradorBD = administradorBaseDatos; 
	}
	
	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.vPrincipal = ventanaPrincipal;
	}

}
