package com.dmstplus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountriesTest {

    @Test
    void testConstructorAndGetCountry() {
        // Δημιουργία ενός αντικειμένου Countries
        Countries country = new Countries("Belgium");

        // Έλεγχος αν ο κατασκευαστής αποθηκεύει σωστά την τιμή
        assertEquals("Belgium", country.getCountry());
    }

    @Test
    void testGetCountryWithDifferentValues() {
        // Δημιουργία πολλαπλών αντικειμένων Countries με διαφορετικές τιμές
        Countries country1 = new Countries("France");
        Countries country2 = new Countries("Germany");
        Countries country3 = new Countries("Italy");

        // Έλεγχος αν οι τιμές επιστρέφονται σωστά
        assertEquals("France", country1.getCountry());
        assertEquals("Germany", country2.getCountry());
        assertEquals("Italy", country3.getCountry());
    }
}
