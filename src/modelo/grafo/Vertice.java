package modelo.grafo;

import java.util.HashSet;
import java.util.Set;

import com.google.gson.annotations.SerializedName;

public class Vertice {

	@SerializedName("Id")
	private int id;
	@SerializedName("Nombre")
	private String nombre;
	@SerializedName("Vecinos")
	private Set<Integer> vecinos;
	
	public Vertice(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		this.vecinos = new HashSet<>();
	}
	
	public int id() {
		return this.id;
	}
	
	public String nombre() {
		return this.nombre;
	}
	
	public Set<Integer> vecinos() {
		return this.vecinos;
	}
	
	public void agregarVecino(int verticeVecino) {
		this.vecinos.add(verticeVecino);
	}
	
	@Override
	public String toString() {
		return "{Id: " + id + ", Nombre: " + nombre + " - Vecinos: " + vecinos + "}";
	}
	
}