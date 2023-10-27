package modelo.objetos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
	private Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();

	public void addVertex(int vertex) {
		adjacencyList.put(vertex, new HashSet<>());
	}

	public void addEdge(int source, int destination) {
		adjacencyList.get(source).add(destination);
		adjacencyList.get(destination).add(source);
	}

	public Set<Integer> getVertices() {
		return adjacencyList.keySet();
	}

	public Set<Integer> getNeighbors(int vertex) {
		return adjacencyList.get(vertex);
	}
}
