package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import modelo.grafo.Grafo;

public class ConjuntoDominanteMinimo_Test {

	Grafo grafo = new Grafo();

	@Test
	void obtenerConjuntoDominante() {

		grafo.agregarVertice(1, 1, "6");
		grafo.agregarVertice(2, 2, "4");
		grafo.agregarVertice(3, 3, "5");
		grafo.agregarVertice(4, 4, "1");
		grafo.agregarVertice(5, 5, "2");
		grafo.agregarVertice(6, 6, "3");

		grafo.agregarArista(6, 4);
		grafo.agregarArista(4, 5);
		grafo.agregarArista(4, 3);
		grafo.agregarArista(5, 2);
		grafo.agregarArista(5, 1);
		grafo.agregarArista(2, 3);
		grafo.agregarArista(2, 1);

		String conjuntoDominante = grafo.obtenerConjuntoDominanteMinimo().toString();

		assertEquals("[2, 4]", conjuntoDominante);

	}
}
