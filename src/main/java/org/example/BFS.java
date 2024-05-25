package org.example;

import java.util.*;

public class BFS<V> implements Search<V> {
    private WeightedGraph<V> graph;

    public BFS(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    @Override
    public void search(V start) {
        System.out.println("BFS:");
        Set<V> visited = new HashSet<>();
        Queue<Vertex<V>> queue = new LinkedList<>();
        Vertex<V> startVertex = graph.getVertex(start);
        if (startVertex != null) {
            queue.add(startVertex);
            visited.add(start);
            while (!queue.isEmpty()) {
                Vertex<V> current = queue.poll();
                System.out.println(current.getData());
                for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
                    if (!visited.contains(neighbor.getData())) {
                        visited.add(neighbor.getData());
                        queue.add(neighbor);
                    }
                }
            }
        }
    }
}


