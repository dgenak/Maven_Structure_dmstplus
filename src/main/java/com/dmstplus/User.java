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

// Η κλάση αυτή με τον κατασκευαστή αντιπροσοπεύουν τις προτιμήσεις του χρήστη

package com.dmstplus;

import java.util.List;

public class User {
    private List<String> userslanguages;
    private String preferredPeriod;
    private List<String> preferredCountry;
    private double maxMonthlyCost;
    private boolean sharedAccomondation;
    
    // Δημιουργία κατασκευαστή της User 
    public User() {
        this.userslanguages = null;
        this.preferredPeriod = "";
        this.preferredCountry = null;
        this.maxMonthlyCost = 0.0;
        this.sharedAccomondation = false;
    }

    //Μέθοδοι get και set για κάθε μια προτίμηση του χρήστη
    
    public List<String> getUserslanguages() {
        return userslanguages;
    }

    public String getPreferredPeriod() {
        return preferredPeriod;
    }

    public List<String> getPreferredCountry() {
        return preferredCountry;
    }

    public double getMaxMonthlyCost() {
        return maxMonthlyCost;
    }

    public boolean getSharedAccomondation() {
        return sharedAccomondation;
    }

    public void setUserslang(List<String> userslanguages) {
        this.userslanguages = userslanguages;
    }
    
    public void setPreferredPeriod(String preferredPeriod) {
        this.preferredPeriod = preferredPeriod;
    }
    
    public void setPreferredCountry(List<String> preferredCountry) {
        this.preferredCountry = preferredCountry;
    }

    public void setMaxMonthlyCost(double maxMonthlyCost) {
        this.maxMonthlyCost = maxMonthlyCost;
    }
    
    public void setSharedAccomondation(boolean sharedAccomondation) {
        this.sharedAccomondation = sharedAccomondation;
    }
}
