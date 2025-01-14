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

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TripleListTest {

    @Test
    void testConstructorAndGetters() {
        // Δημιουργία ενός TripleList με διαφορετικούς τύπους δεδομένων
        TripleList<String, Integer, List<String>> tripleList = new TripleList<>(
            "First Element",
            42,
            List.of("A", "B", "C")
        );

        // Έλεγχος αν τα στοιχεία αποθηκεύονται σωστά
        assertEquals("First Element", tripleList.getFirst());
        assertEquals(42, tripleList.getSecond());
        assertEquals(List.of("A", "B", "C"), tripleList.getThird());
    }

    @Test
    void testGettersWithDifferentTypes() {
        // Δημιουργία ενός TripleList με διαφορετικούς τύπους
        TripleList<Double, String, Boolean> tripleList = new TripleList<>(
            3.14,
            "Hello",
            true
        );

        // Έλεγχος αν τα στοιχεία επιστρέφονται σωστά
        assertEquals(3.14, tripleList.getFirst());
        assertEquals("Hello", tripleList.getSecond());
        assertTrue(tripleList.getThird());
    }
}
