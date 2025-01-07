package com.dmstplus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LanguagesTest {

    @Test
    void testConstructorAndGetLang() {
        // Δημιουργία ενός αντικειμένου Languages
        Languages language = new Languages("English");

        // Έλεγχος αν ο κατασκευαστής αποθηκεύει σωστά την τιμή
        assertEquals("English", language.getLang());
    }

    @Test
    void testGetLangWithDifferentValues() {
        // Δημιουργία πολλαπλών αντικειμένων Languages με διαφορετικές τιμές
        Languages lang1 = new Languages("French");
        Languages lang2 = new Languages("German");
        Languages lang3 = new Languages("Greek");

        // Έλεγχος αν οι τιμές επιστρέφονται σωστά
        assertEquals("French", lang1.getLang());
        assertEquals("German", lang2.getLang());
        assertEquals("Greek", lang3.getLang());
    }
}
