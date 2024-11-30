package com.dmstplus;

import org.junit.Test;
import static org.junit.Assert.*;

public class UniversityTest {
    @Test
    public void testUniversityCreation() {
        University university = new University(
            "Hasselt University", 
            "Belgium", 
            "Hasselt", 
            1000, 
            500.0, 
            "French", 
            "Spring"
        );

        assertEquals("Hasselt University", university.getUniName());
        assertEquals("Belgium", university.getCountry());
        assertEquals("Hasselt", university.getCity());
        assertEquals(1000, university.getMonthlyCost());
        assertEquals(500.0, university.getCostWithSh_Accommondation(), 0);
        assertEquals("French", university.getCountrysLang());
        assertEquals("Spring", university.getBestPeriodToVisit());
    }
}
