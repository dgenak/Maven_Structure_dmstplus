package com.dmstplus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UniDataTest {

    private UniData uniData;
    private User user;

    @BeforeEach
    void setUp() {
        // Αρχικοποίηση του UniData
        uniData = new UniData();

        // Δημιουργία ενός χρήστη με συγκεκριμένες προτιμήσεις
        user = new User();
        user.setPreferredCountry(List.of("Belgium", "France"));
        user.setUserslang(List.of("French", "English"));
        user.setMaxMonthlyCost(1000);
        user.setPreferredPeriod("Spring");
        user.setSharedAccomondation(false);
    }

    @Test
    void testGetCountries() {
        // Έλεγχος ότι οι χώρες επιστρέφονται σωστά
        List<String> countries = uniData.getCountries();
        assertNotNull(countries);
        assertTrue(countries.contains("Belgium"));
        assertTrue(countries.contains("France"));
        assertTrue(countries.contains("Germany"));
    }

    @Test
    void testGetLanguages() {
        // Έλεγχος ότι οι γλώσσες επιστρέφονται σωστά
        List<String> languages = uniData.getLang();
        assertNotNull(languages);
        assertTrue(languages.contains("French"));
        assertTrue(languages.contains("German"));
        assertTrue(languages.contains("Greek"));
    }

    @Test
    void testGetUniversities() {
        // Έλεγχος ότι τα πανεπιστήμια επιστρέφονται σωστά
        List<University> universities = uniData.getUniversities();
        assertNotNull(universities);
        assertFalse(universities.isEmpty());
        assertEquals("Hasselt University", universities.get(0).getUniName());
    }

    @Test
    void testLetsGoErasmus_MatchesFound() {
        // Έλεγχος για πανεπιστήμια που ταιριάζουν στις προτιμήσεις του χρήστη
        TripleList<List<University>, List<University>, List<University>> matches = uniData.letsGoErasmus(user);

        List<University> exactMatches = matches.getFirst();
        List<University> periodMatches = matches.getSecond();
        List<University> languageMatches = matches.getThird();

        assertNotNull(exactMatches);
        assertNotNull(periodMatches);
        assertNotNull(languageMatches);

        // Έλεγχος αν υπάρχουν πλήρεις αντιστοιχίες
        assertFalse(exactMatches.isEmpty());
        assertEquals("Hasselt University", exactMatches.get(0).getUniName());

        // Έλεγχος αν υπάρχουν πανεπιστήμια που δεν ταιριάζουν στην περίοδο
        assertFalse(periodMatches.isEmpty());
        assertEquals("Abo Akademi University", periodMatches.get(0).getUniName());

        // Έλεγχος για πανεπιστήμια που ταιριάζουν μόνο λόγω γλώσσας
        assertFalse(languageMatches.isEmpty());
    }

    @Test
    void testLetsGoErasmus_NoMatches() {
        // Ενημέρωση χρήστη ώστε να μην υπάρχουν αντιστοιχίες
        user.setPreferredCountry(List.of("Japan"));
        user.setMaxMonthlyCost(100);

        TripleList<List<University>, List<University>, List<University>> matches = uniData.letsGoErasmus(user);

        assertTrue(matches.getFirst().isEmpty());
        assertTrue(matches.getSecond().isEmpty());
        assertTrue(matches.getThird().isEmpty());
    }
}
