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
