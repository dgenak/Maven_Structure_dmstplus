package com.dmstplus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CostOfLivingTest {

    @Test
    void testConstructorAndGetAmount() {
        // Δημιουργία ενός αντικειμένου CostOfLiving
        CostOfLiving cost = new CostOfLiving(750.0);

        // Έλεγχος αν ο κατασκευαστής αποθηκεύει σωστά την τιμή
        assertEquals(750.0, cost.getAmount());
    }

    @Test
    void testGetAmountWithDifferentValues() {
        // Δημιουργία πολλαπλών αντικειμένων CostOfLiving με διαφορετικές τιμές
        CostOfLiving cost1 = new CostOfLiving(250.0);
        CostOfLiving cost2 = new CostOfLiving(500.0);
        CostOfLiving cost3 = new CostOfLiving(1000.0);

        // Έλεγχος αν οι τιμές επιστρέφονται σωστά
        assertEquals(250.0, cost1.getAmount());
        assertEquals(500.0, cost2.getAmount());
        assertEquals(1000.0, cost3.getAmount());
    }
}
