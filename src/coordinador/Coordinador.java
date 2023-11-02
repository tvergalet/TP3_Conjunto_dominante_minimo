package coordinador;

import java.util.ArrayList;
import java.util.List;

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
	
	public void mostrarConjuntoDominanteMinimo() {
		if(!hayDosVentanasAbiertas)
			vEmergente.mostrarVentana("Conjunto Dominante Minimo", logica.conjuntoDominanteMinimo());
	}
	
	public void cerrarVentanaEmergente() {
		hayDosVentanasAbiertas = false;
		vEmergente.cerrarVentana();
	}

	// BORRAR CUANDO ELIMINEMOS LA TABLA DE LA VENTANA PRINCIPAL
	public List<Object[]> obtenerVerticesEnLista() {
		return logica.convertirListaObject( obtenerVerticesDesdeBD() );
	}
	
	public ArrayList<Vertice> obtenerVerticesDesdeBD() {
		return admBD.obtenerVertices();
	}
	
	public ArrayList<Vertice> obtenerVerticesDesdeGrafo(){
		return logica.obtenerVertices();
	}
	
	public Vertice agregarVertice(int x, int y, String nombre) {
		return logica.agregarVertice(x, y, nombre);
	}

	public void guardarVertices() {
		admBD.guardarVertices(logica.obtenerVertices());
	}

}
