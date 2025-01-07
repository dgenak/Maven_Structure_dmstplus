package com.dmstplus;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testConstructorAndGetters() {
        // Δημιουργία ενός αντικειμένου User
        User user = new User();

        // Έλεγχος της αρχικοποίησης μέσω του κατασκευαστή
        assertNull(user.getUserslanguages());
        assertEquals("", user.getPreferredPeriod());
        assertNull(user.getPreferredCountry());
        assertEquals(0.0, user.getMaxMonthlyCost());
        assertFalse(user.getSharedAccomondation());
    }

    @Test
    void testSetUserslang() {
        // Δημιουργία ενός αντικειμένου User
        User user = new User();

        // Ορισμός γλωσσών χρήστη
        user.setUserslang(List.of("English", "French", "German"));

        // Έλεγχος ότι αποθηκεύτηκαν σωστά
        assertNotNull(user.getUserslanguages());
        assertEquals(3, user.getUserslanguages().size());
        assertTrue(user.getUserslanguages().contains("English"));
        assertTrue(user.getUserslanguages().contains("French"));
        assertTrue(user.getUserslanguages().contains("German"));
    }

    @Test
    void testSetPreferredPeriod() {
        // Δημιουργία ενός αντικειμένου User
        User user = new User();

        // Ορισμός προτιμώμενης περιόδου
        user.setPreferredPeriod("Spring");

        // Έλεγχος ότι αποθηκεύτηκε σωστά
        assertEquals("Spring", user.getPreferredPeriod());
    }

    @Test
    void testSetPreferredCountry() {
        // Δημιουργία ενός αντικειμένου User
        User user = new User();

        // Ορισμός προτιμώμενων χωρών
        user.setPreferredCountry(List.of("Belgium", "France"));

        // Έλεγχος ότι αποθηκεύτηκαν σωστά
        assertNotNull(user.getPreferredCountry());
        assertEquals(2, user.getPreferredCountry().size());
        assertTrue(user.getPreferredCountry().contains("Belgium"));
        assertTrue(user.getPreferredCountry().contains("France"));
    }

    @Test
    void testSetMaxMonthlyCost() {
        // Δημιουργία ενός αντικειμένου User
        User user = new User();

        // Ορισμός μέγιστου μηνιαίου κόστους
        user.setMaxMonthlyCost(1000.0);

        // Έλεγχος ότι αποθηκεύτηκε σωστά
        assertEquals(1000.0, user.getMaxMonthlyCost());
    }

    @Test
    void testSetSharedAccomondation() {
        // Δημιουργία ενός αντικειμένου User
        User user = new User();

        // Ορισμός επιλογής συγκατοίκησης
        user.setSharedAccomondation(true);

        // Έλεγχος ότι αποθηκεύτηκε σωστά
        assertTrue(user.getSharedAccomondation());
    }
}
