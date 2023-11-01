package coordinador;

import java.util.List;
import java.util.Set;

import bd.AdmBaseDatos;
import modelo.Logica;
import modelo.grafo.Vertice;
import vista.VentanaEmergente;

public class Coordinador {

	private Logica logica;
	private AdmBaseDatos admBD;
	private VentanaEmergente vEmergente;
	private boolean hayDosVentanasAbiertas;
	
	public Coordinador() {
		hayDosVentanasAbiertas = false;
	}

	public void setLogica(Logica logica) {
		this.logica = logica;
	}
	
	public void setAdministradorBD(AdmBaseDatos administradorBaseDatos) {
		this.admBD = administradorBaseDatos; 
	}
	
	public void setVentanaEmergente(VentanaEmergente ventanaEmergente) {
		this.vEmergente = ventanaEmergente;
	}
	
	public void mostrarVentanaEmergente() {
		if(!hayDosVentanasAbiertas)
			vEmergente.mostrarVentana("Conjunto Dominante Minimo", logica.conjuntoDominanteMinimo());
	}
	
	public void cerrarVentanaEmergente() {
		hayDosVentanasAbiertas = false;
		vEmergente.cerrarVentana();
	}

	public List<Object[]> obtenerVerticesEnLista() {
		return logica.convertirListaObject( obtenerVerticesDesdeBD() );
	}
	
	public Set<Vertice> obtenerVerticesDesdeBD() {
		return admBD.obtenerVertices();
	}

}
