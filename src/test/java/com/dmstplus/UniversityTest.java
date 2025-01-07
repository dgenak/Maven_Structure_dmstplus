package com.dmstplus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniversityTest {

    @Test
    void testConstructorAndGetters() {
        // Δημιουργία ενός αντικειμένου University
        University university = new University(
            "Hasselt University", 
            "Belgium", 
            "Hasselt", 
            1000.0, 
            500.0, 
            "French", 
            "Spring", 
            "C:\\Users\\dim\\PDFs\\Hasselt_University.pdf"
        );

        // Έλεγχος τιμών μέσω των μεθόδων getter
        assertEquals("Hasselt University", university.getUniName());
        assertEquals("Belgium", university.getCountry());
        assertEquals("Hasselt", university.getCity());
        assertEquals(1000.0, university.getMonthlyCost());
        assertEquals(500.0, university.getCostWithSh_Accomondation());
        assertEquals("French", university.getCountrysLang());
        assertEquals("Spring", university.getBestPeriodToVisit());
        assertEquals("C:\\Users\\dim\\PDFs\\Hasselt_University.pdf", university.getPdfLink());
    }

    @Test
    void testSetPdfLink() {
        // Δημιουργία ενός αντικειμένου University
        University university = new University(
            "University of Antwerp",
            "Belgium",
            "Antwerp",
            1050.0,
            550.0,
            "French",
            "Spring",
            "C:\\Users\\dim\\PDFs\\University_of_Antwerp.pdf"
        );

        // Αλλαγή του pdfLink μέσω της setPdfLink
        university.setPdfLink("C:\\Users\\dim\\PDFs\\Updated_Link.pdf");

        // Έλεγχος ότι το pdfLink ενημερώθηκε σωστά
        assertEquals("C:\\Users\\dim\\PDFs\\Updated_Link.pdf", university.getPdfLink());
    }
}
