/*
 * Copyright (c) 2024-2025 DMSTPLUS
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
        uniData = new UniData();

        // εκχώρηση συγκεκριμένων προτιμήσεων
        user = new User();
        user.setPreferredCountry(List.of("Belgium", "France"));
        user.setUserslang(List.of("French", "English"));

        user.setMaxMonthlyCost(1000);
        user.setPreferredPeriod("Spring");
        user.setSharedAccomondation(false);
    }

    @Test
    void testGetCountries() {
        // εδω ελέγχουμε αν οι χώρες επιστρέφονται σωστά μεσω της assertTrue
        List<String> countries = uniData.getCountries();
        assertNotNull(countries);

        assertTrue(countries.contains("Belgium"));
        assertTrue(countries.contains("France"));
        assertTrue(countries.contains("Germany"));
    }

    @Test
    void testGetLanguages() {
        // εδω ελέγχουμε αν οι γλώσσες επιστρέφονται σωστά μεσω της assertTrue
        List<String> languages = uniData.getLang();
        assertNotNull(languages);

        assertTrue(languages.contains("French"));
        assertTrue(languages.contains("German"));
        assertTrue(languages.contains("Greek"));
    }

    @Test
    void testGetUniversities() {
        // εδω ελέγχουμε αν τα πανεπιστήμια επιστρέφονται σωστά μεσω της assertTrue/False/Equals
        List<University> universities = uniData.getUniversities();
        assertNotNull(universities);
        assertFalse(universities.isEmpty());
        assertEquals("Hasselt University", universities.get(0).getUniName());
    }

    @Test
    void testLetsGoErasmus_AtLeastOneMatch() {
        // Έλεγχος για πανεπιστήμια που ταιριάζουν στις προτιμήσεις του χρήστη
        TripleList<List<University>, List<University>, List<University>> matches = uniData.letsGoErasmus(user);
    
        List<University> exactMatches = matches.getFirst();
        List<University> periodMatches = matches.getSecond();
        List<University> languageMatches = matches.getThird();
    
        assertNotNull(exactMatches);
        assertNotNull(periodMatches);
        assertNotNull(languageMatches);
    
        // Έλεγχος αν τουλάχιστον μία από τις λίστες δεν είναι κενή
        boolean atLeastOneNonEmpty = !exactMatches.isEmpty() || !periodMatches.isEmpty() || !languageMatches.isEmpty();
    
        assertTrue(atLeastOneNonEmpty, "At least one is not be empty");
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
