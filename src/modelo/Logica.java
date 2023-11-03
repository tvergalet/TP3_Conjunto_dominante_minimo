package modelo;

import java.util.ArrayList;
import java.util.List;
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
		
	public List<Object[]> convertirListaObject(ArrayList<Vertice> listaVertices) {
		List<Object[]> verticesFormateado = new ArrayList<>();
		
		listaVertices.forEach( vertice -> {
        	verticesFormateado.add(new Object[] { 
        			vertice.id(),
        			vertice.nombre(),
        			vertice.posX(),
        			vertice.posY(),
        			vertice.vecinos().toString()});
        });
		
		return verticesFormateado;
	}

	public Set<Integer> obtenerConjuntoDominanteMinimo() {
		return grafo.obtenerConjuntoDominanteMinimo();
	}

	public Vertice agregarVertice(int id, int x, int y, String nombre) {
		return grafo.agregarVertice(id, x, y, nombre);	
	}

	public ArrayList<Vertice> obtenerVertices() {
		return grafo.obtenerListaVertices();
	}

	public void actualizarPosicionVertice(int id, int posicionX, int posicionY) {
		grafo.actualizarPosicionVertice(id, posicionX, posicionY);		
	}

}
