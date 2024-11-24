package com.dmstplus;

import java.util.List;
public class User {
    private List<String> languages;
    private String preferredPeriod;
    private String preferredCountry;
    private double maxMonthlyCost;
    private boolean SharedAccomondation;
    
    // Δημιουργία κατασκευαστή της User 
    public User(List<String> languages, preferredPeriod, preferredCountry, maxMonthlyCost, SharedAccomondation) {
        this.languages = languages;
        this.preferredPeriod = preferredPeriod;
        this.preferredCountry = preferredCountry;
        this.maxMonthlyCost = maxMonthlyCost;
        this.SharedAccomondation = SharedAccomondation;
    }
    // TODO Εδώ πρέπει να γίνουν μέθοδοι GET για κάθε αντικείμενο που δηλώσαμε στον κατασκευαστή
    
}