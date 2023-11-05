package modelo;

import java.util.ArrayList;
import java.util.Set;

import coordinador.Coordinador;
import modelo.grafo.Grafo;
import modelo.grafo.Vertice;

public class Logica {
	
	private Coordinador coordinador;
	private Grafo grafo;

	public Logica(Coordinador coordinador) {
		this.coordinador = coordinador;
		this.grafo = new Grafo();
		actualizarGrafoConBD();
	}
	
	private void actualizarGrafoConBD() {
		coordinador.obtenerVerticesDesdeBD().forEach( vertice -> {
			grafo.agregarVertice(vertice);
		});	
	}
		
	public Set<Integer> obtenerConjuntoDominanteMinimo() {
		return grafo.obtenerConjuntoDominanteMinimo();
	}

	public Vertice agregarVertice(int x, int y, String nombre) {
		return grafo.agregarVertice(x, y, nombre);	
	}

	public ArrayList<Vertice> obtenerVertices() {
		return grafo.obtenerListaVertices();
	}
	
	public ArrayList<Integer> obtenerIdVertices(){
		return new ArrayList<Integer> (grafo.obtenerClaveVertices());
	}

	public void actualizarPosicionVertice(int id, int posicionX, int posicionY) {
		grafo.actualizarPosicionVertice(id, posicionX, posicionY);		
	}

	public Vertice obtenerVertice(int id) {
		return grafo.obtenerVertice(id);
	}

	public void eliminarVertice(int id) {
		grafo.eliminarVertice(id);
	}

	public boolean generarArista(int idVerticeOrigen, int idVerticeDestino) {
		return grafo.agregarArista(idVerticeOrigen, idVerticeDestino);
	}

	public void actualizarVertice(Vertice vertice) {
		grafo.actualizarVertice(vertice);
	}

}
