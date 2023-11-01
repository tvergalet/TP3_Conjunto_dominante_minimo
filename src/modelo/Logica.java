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
		
	public List<Object[]> convertirListaObject(Set<Vertice> listaVertices) {
		List<Object[]> verticesFormateado = new ArrayList<>();
		
		listaVertices.forEach( vertice -> {
        	verticesFormateado.add(new Object[] { vertice.id(), vertice.vecinos().toString() });
        });
		
		return verticesFormateado;
	}

	public String conjuntoDominanteMinimo() {
		return grafo.obtenerConjuntoDominanteMinimo().toString();
	}

}
