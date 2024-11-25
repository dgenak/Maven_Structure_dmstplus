package com.dmstplus

import java.util.List;

public class User {
    private List<String> userslanguages;
    private String preferredPeriod;
    private String preferredCountry;
    private double maxMonthlyCost;
    private boolean sharedAccomondation;
    
    // Δημιουργία κατασκευαστή της User 
    public User(List<String> userslanguages, preferredPeriod, preferredCountry, maxMonthlyCost, SharedAccomondation) {
        this.userslanguages = userslanguages;
        this.preferredPeriod = preferredPeriod;
        this.preferredCountry = preferredCountry;
        this.maxMonthlyCost = maxMonthlyCost;
        this.sharedAccomondation = sharedAccomondation;
    }
    
    public List<String> getuserslanguages() {
        return userslanguages;
    }

    public String getpreferredPeriod() {
        return preferredPeriod;
    }

    public String getpreferredCountry() {
        return preferredCountry;
    }

    public double getmaxMonthlyCost() {
        return maxMonthlyCost;
    }

    public boolean getsharedAccomondation() {
        return sharedAccomondation;
    }
}
