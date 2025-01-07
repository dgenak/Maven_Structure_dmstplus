package com.dmstplus;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TripleListTest {

    @Test
    void testConstructorAndGetters() {
        // Δημιουργία ενός TripleList με διαφορετικούς τύπους δεδομένων
        TripleList<String, Integer, List<String>> tripleList = new TripleList<>(
            "First Element",
            42,
            List.of("A", "B", "C")
        );

        // Έλεγχος αν τα στοιχεία αποθηκεύονται σωστά
        assertEquals("First Element", tripleList.getFirst());
        assertEquals(42, tripleList.getSecond());
        assertEquals(List.of("A", "B", "C"), tripleList.getThird());
    }

    @Test
    void testGettersWithDifferentTypes() {
        // Δημιουργία ενός TripleList με διαφορετικούς τύπους
        TripleList<Double, String, Boolean> tripleList = new TripleList<>(
            3.14,
            "Hello",
            true
        );

        // Έλεγχος αν τα στοιχεία επιστρέφονται σωστά
        assertEquals(3.14, tripleList.getFirst());
        assertEquals("Hello", tripleList.getSecond());
        assertTrue(tripleList.getThird());
    }
}
