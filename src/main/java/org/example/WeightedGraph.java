package org.example;

import java.util.*;

public class WeightedGraph<V> {
    private Map<V, Vertex<V>> vertices = new HashMap<>();

    public void addEdge(V source, V destination, double num) {
        Vertex<V> sourceV = vertices.get(source);
        Vertex<V> destinationV= vertices.get(destination);
        if (sourceV!=null && destinationV!=null) {
            sourceV.addAdjVertex(destinationV, num);
            destinationV.addAdjVertex(sourceV, num);
        }
    }

    public void addVertex(V value) {
        vertices.putIfAbsent(value, new Vertex<>(value));
    }

    public Vertex<V> getVertex(V data) {
        return vertices.get(data);
    }

    public Collection<Vertex<V>> getAllVertices() {
        return vertices.values();
    }

}

