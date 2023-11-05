package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import modelo.grafo.Vertice;

class Vertice_Test {

	Vertice vertice1 = new Vertice(1, 10, 20, "Vertice 1");
	Vertice vertice2 = new Vertice(2, 10, 20, "Vertice 2");
	Vertice vertice3 = new Vertice(3, 10, 20, "Vertice 3");
	Vertice vertice4 = new Vertice(4, 10, 20, "Vertice 4");
	
	@Test
	void agregarVecino() {
		vertice1.agregarVecino(2);
		vertice1.agregarVecino(3);
		vertice1.agregarVecino(4);
		assertEquals(vertice1.cantidadVecinos(), 3);
	}
	
	@Test
	void eliminarVecino() {
		vertice1.agregarVecino(2);
		vertice1.eliminarVecino(2);
		assertEquals(vertice1.cantidadVecinos(), 0);
	}

}
