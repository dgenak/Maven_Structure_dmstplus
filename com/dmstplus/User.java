package com.dmstplus;

import java.util.List;

public class User {
    private List<String> userslanguages;
    private String preferredPeriod;
    private String preferredCountry;
    private double maxMonthlyCost;
    private boolean sharedAccomondation;
    
    // Δημιουργία κατασκευαστή της User 
    public User(List<String> userslanguages, String preferredPeriod, String preferredCountry, double maxMonthlyCost, boolean sharedAccomondation) {
        this.userslanguages = userslanguages;
        this.preferredPeriod = preferredPeriod;
        this.preferredCountry = preferredCountry;
        this.maxMonthlyCost = maxMonthlyCost;
        this.sharedAccomondation = sharedAccomondation;
    }
    
    public List<String> getUserslanguages() {
        return userslanguages;
    }

    public String getPreferredPeriod() {
        return preferredPeriod;
    }

    public String getPreferredCountry() {
        return preferredCountry;
    }

    public double getMaxMonthlyCost() {
        return maxMonthlyCost;
    }

    public boolean getSharedAccomondation() {
        return sharedAccomondation;
    }
}
