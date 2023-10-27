package modelo.algoritmos;
import java.util.*;

import modelo.objetos.Graph;

public class ConjuntoDominanteMinimo {
	public static Set<Integer> findMinimumDominatingSet(Graph graph) {
		Set<Integer> dominatingSet = new HashSet<>();
		List<Integer> vertices = new ArrayList<>(graph.getVertices());

		while (!vertices.isEmpty()) {
			int bestVertex = findBestVertex(vertices, dominatingSet, graph);
			if (bestVertex != -1) {
				dominatingSet.add(bestVertex);
				removeAdjacentVertices(bestVertex, vertices, graph);
			}
		}

		return dominatingSet;
	}

	private static int findBestVertex(List<Integer> remainingVertices, Set<Integer> dominatingSet, Graph graph) {
		int bestVertex = -1;
		int bestScore = -1;

		for (int vertex : remainingVertices) {
			Set<Integer> neighbors = graph.getNeighbors(vertex);
			neighbors.retainAll(remainingVertices); // Only consider neighbors that are not yet in the dominating set
			int score = neighbors.size();

			if (score > bestScore) {
				bestScore = score;
				bestVertex = vertex;
			}
		}

		return bestVertex;
	}

	private static void removeAdjacentVertices(int vertex, List<Integer> remainingVertices, Graph graph) {
		Set<Integer> neighbors = graph.getNeighbors(vertex);
		neighbors.retainAll(remainingVertices);

		remainingVertices.remove((Integer) vertex);
		remainingVertices.removeAll(neighbors);
	}

	public static void main(String[] args) {
		Graph graph = new Graph();

		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addVertex(5);
		graph.addVertex(6);

		graph.addEdge(1, 5);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(2, 5);
		graph.addEdge(5, 4);
		graph.addEdge(4, 3);
		graph.addEdge(4, 6);

		Set<Integer> minimumDominatingSet = findMinimumDominatingSet(graph);
		System.out.println("Minimum Dominating Set: " + minimumDominatingSet);
	}
}


