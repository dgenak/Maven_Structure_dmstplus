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
