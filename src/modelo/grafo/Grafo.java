package modelo.grafo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Grafo {
	
	private Map<Integer, Vertice> vertices = new HashMap<>();

	public void agregarVertice(String nombre) {
		Vertice nuevoVertice = new Vertice(generarIdVertice(), nombre);
		vertices.put(nuevoVertice.id(), nuevoVertice);
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

	public Set<Integer> obtenerVertices() {
		return vertices.keySet();
	}

	public Set<Integer> obtenerVecinos(int idVerticeConsulta) {
		return vertices.get(idVerticeConsulta).vecinos();
	}
	
	public Set<Integer> obtenerConjuntoDominanteMinimo() {
		return ConjuntoDominanteMinimo.buscarConjuntoDominanteMinimo(this);
	}
	
	
}