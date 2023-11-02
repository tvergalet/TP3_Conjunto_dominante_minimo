package modelo.grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Grafo {
	
	private Map<Integer, Vertice> vertices = new HashMap<>();
	
	public Vertice agregarVertice(int posicionX, int posicionY, String nombre) {
		Vertice nuevoVertice = new Vertice(generarIdVertice(), posicionX, posicionY, nombre);
		vertices.put(nuevoVertice.id(), nuevoVertice);
		return nuevoVertice;
	}
	
	public void agregarVertice(Vertice nuevoVertice) {
		vertices.put(nuevoVertice.id(), nuevoVertice);
	}
	
	private int generarIdVertice() {
		return vertices.size()+1;
	}

	public void agregarArista(int idVerticeOrigen, int idVerticeDestino) {
		vertices.get(idVerticeOrigen).agregarVecino(idVerticeDestino);
		vertices.get(idVerticeDestino).agregarVecino(idVerticeOrigen);
	}

	public Set<Integer> obtenerClaveVertices() {
		return vertices.keySet();
	}
	
	public ArrayList<Vertice> obtenerListaVertices(){
		ArrayList<Vertice> listaVertices = new ArrayList<>(vertices.values());
		return listaVertices;
	}

	public Set<Integer> obtenerVecinos(int idVerticeConsulta) {
		return vertices.get(idVerticeConsulta).vecinos();
	}
	
	public Set<Integer> obtenerConjuntoDominanteMinimo() {
		return ConjuntoDominanteMinimo.buscarConjuntoDominanteMinimo(this);
	}
	
}