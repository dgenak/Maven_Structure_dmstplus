package com.dmstplus;

public class TripleList<T, U, V> {
    private T first;
    private U second;
    private V third;

    public TripleList(T first, U second, V third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public V getThird() {
        return third;
    }
}
