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
