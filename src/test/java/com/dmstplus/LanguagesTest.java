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
