package test;

import modelo.grafo.Grafo;
import modelo.grafo.Vertice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class Grafo_Test {

	private Grafo grafo;

	@BeforeEach
	void setUp() {
		grafo = new Grafo();
	}

	@Test
	void agregarVertice() {
		Vertice vertice = grafo.agregarVertice(1, 2, "Vertice1");
		assertEquals(1, vertice.id());
	}

	@Test
	void agregarArista() {
		grafo.agregarVertice(1, 2, "Vertice1");
		grafo.agregarVertice(3, 4, "Vertice2");
		assertTrue(grafo.agregarArista(1, 2));
		assertEquals(1, grafo.obtenerVecinos(1).size());
		assertEquals(1, grafo.obtenerVecinos(2).size());
	}


	@Test
	void eliminarVertice() {
		grafo.agregarVertice(1, 2, "Vertice1");
		grafo.agregarVertice(3, 4, "Vertice2");
		grafo.agregarArista(1, 2);
		grafo.eliminarVertice(1);
		assertNull(grafo.obtenerVertice(1));
		assertEquals(1, grafo.obtenerListaVertices().size());
	}

	@Test
	void actualizarPosicionVertice() {
		grafo.agregarVertice(1, 2, "Vertice1");
		grafo.actualizarPosicionVertice(1, 5, 6);
		assertEquals(5, grafo.obtenerVertice(1).posX());
		assertEquals(6, grafo.obtenerVertice(1).posY());
	}

}
