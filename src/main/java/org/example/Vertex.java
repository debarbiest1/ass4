package org.example;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>,Double> adjVertices;

    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjVertices.put(destination, weight);
    }

}
