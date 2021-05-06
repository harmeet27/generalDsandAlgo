package com.preparation.ds.graph.model;

public class EdgeFromNode<E> {

    public E from;
    public E to;
    public int weight;

    public EdgeFromNode(E from, E to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public String toString() {
        return "" + this.from + "|" + this.to + "|" + this.weight;
    }
}
