package modelo.grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Grafo {
	
	private Map<Integer, Vertice> vertices = new HashMap<>();
	
	public Vertice agregarVertice(int id, int posicionX, int posicionY, String nombre) {
		Vertice nuevoVertice = new Vertice(id, posicionX, posicionY, nombre);
		vertices.put(nuevoVertice.id(), nuevoVertice);
		return nuevoVertice;
	}
	
	public void agregarVertice(Vertice nuevoVertice) {
		vertices.put(nuevoVertice.id(), nuevoVertice);
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

	public void actualizarPosicionVertice(int id, int posicionX, int posicionY) {
		if(vertices.containsKey(id)) {
			Vertice verticePorModificar = vertices.get(id);
			verticePorModificar.actualizarPosicion(posicionX, posicionY);
			vertices.put(id, verticePorModificar);
		}
	}
	
}