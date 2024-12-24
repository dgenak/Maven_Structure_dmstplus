package com.dmstplus;

public abstract class PairList<T, U> {
    private T first;
    private U second;

    // Κατασκευαστής για την αρχικοποίηση των first και second
    public PairList(T first, U second) {
        this.first = first;
        this.second = second;
    }

    // Μέθοδοι για την επιστροφή των first και second
    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
}
