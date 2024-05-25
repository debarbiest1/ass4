package org.example;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<Integer> g = new WeightedGraph<>();
        g.addVertex(546);
        g.addVertex(444);
        g.addVertex(10);
        g.addEdge(546, 444, 2.4);
        g.addEdge(546, 10, 4.7);
        g.addEdge(444, 10, 7.5);


        BFS<Integer> bfs = new BFS<>(g);
        bfs.search(444);


    }
}