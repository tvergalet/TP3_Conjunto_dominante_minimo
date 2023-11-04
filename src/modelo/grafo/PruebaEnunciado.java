package modelo.grafo;

import java.util.Set;

public class PruebaEnunciado {

	public static void main(String[] args) {
		conjuntoDominanteMinimo();
	}
	
	public static void conjuntoDominanteMinimo() {
		Grafo grafo = new Grafo();

		grafo.agregarVertice(0, 0, "1");
		grafo.agregarVertice(0, 0, "2");
		grafo.agregarVertice(0, 0, "3");
		grafo.agregarVertice(0, 0, "4");
		grafo.agregarVertice(0, 0, "5");
		grafo.agregarVertice(0, 0, "6");

		grafo.agregarArista(1, 5);
		grafo.agregarArista(1, 2);
		grafo.agregarArista(2, 3);
		grafo.agregarArista(2, 5);
		grafo.agregarArista(5, 4);
		grafo.agregarArista(4, 3);
		grafo.agregarArista(4, 6);
				
		Set<Integer> minimumDominatingSet = grafo.obtenerConjuntoDominanteMinimo();
		System.out.println("Minimum Dominating Set: " + minimumDominatingSet);
	}
	
}