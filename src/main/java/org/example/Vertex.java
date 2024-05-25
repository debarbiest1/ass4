package org.example;

import java.util.*;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>,Double> adjVertices;

    public void addAdjVertex(Vertex<V> destination, double weight) {
        adjVertices.put(destination, weight);
    }
    public Vertex(V data) {
        this.data = data;
        this.adjVertices = new HashMap<>();
    }

    public V getData() {
        return data;
    }
    public Map<Vertex<V>, Double> getAdjacentVertices()
    {
        return adjVertices;
    }

}
