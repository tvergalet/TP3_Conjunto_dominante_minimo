package modelo.grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Grafo {
	
	private Map<Integer, Vertice> vertices = new HashMap<>();
	
	public Vertice agregarVertice(int posicionX, int posicionY, String nombre) {
		Vertice nuevoVertice = new Vertice(generarID(), posicionX, posicionY, nombre);
		vertices.put(nuevoVertice.id(), nuevoVertice);
		return nuevoVertice;
	}
	
	public void agregarVertice(Vertice nuevoVertice) {
		vertices.put(nuevoVertice.id(), nuevoVertice);
	}
	
	public int generarID() {
		return vertices.size()+1;
	}

	public boolean agregarArista(int idVerticeOrigen, int idVerticeDestino) {
		if(!vertices.containsKey(idVerticeOrigen) || !vertices.containsKey(idVerticeDestino)) {
			return false;
		}
		
		vertices.get(idVerticeOrigen).agregarVecino(idVerticeDestino);
		vertices.get(idVerticeDestino).agregarVecino(idVerticeOrigen);
		System.out.println(vertices.get(idVerticeOrigen).toString() + "\n" + vertices.get(idVerticeDestino).toString() );
		return true;
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

	public Vertice obtenerVertice(int id) {
		return vertices.get(id);
	}

	public void eliminarVertice(int id) {
		vertices.remove(id);
	}
	
}