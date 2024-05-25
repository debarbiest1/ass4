package org.example;
import java.util.*;
class Dijkstra<V> implements Search<V> {
    private WeightedGraph<V> graph;
    private Map<V, Double> distances;
    private Map<V, V> predecessors;

    public Dijkstra(WeightedGraph<V> graph) {
        this.graph = graph;
        this.distances = new HashMap<>();
        this.predecessors = new HashMap<>();
    }

    public void search(V start) {
        for (Vertex<V> vertex : graph.getAllVertices()) {
            distances.put(vertex.getData(), Double.MAX_VALUE);
        }

        PriorityQueue<Vertex<V>> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(vertex -> distances.get(vertex.getData())));
        Vertex<V> startVertex = graph.getVertex(start);

        if (startVertex != null) {
            distances.put(start, 0.0);
            priorityQueue.add(startVertex);

            while (!priorityQueue.isEmpty()) {
                Vertex<V> current = priorityQueue.poll();
                for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                    Vertex<V> neighbor = entry.getKey();
                    double weight = entry.getValue();
                    double newDist = distances.get(current.getData()) + weight;

                    if (newDist < distances.get(neighbor.getData())) {
                        distances.put(neighbor.getData(), newDist);
                        predecessors.put(neighbor.getData(), current.getData());
                        priorityQueue.add(neighbor);
                    }
                }
            }
        }
    }

    public Map<V, Double> getDistances() {
        return distances;
    }

    public Map<V, V> getPredecessors() {
        return predecessors;
    }
}