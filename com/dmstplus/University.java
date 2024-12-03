package com.dmstplus;

public class University {
    private String uniName;
    // Οι τιμές των μεταβλητών monthlyCost, CostWithSh_Accommondation είναι ο μέσος όρος που υπολογίσαμε απο τα δεδομένα μας
    // Το κόστος του φοιτητή αμα μένει μόνος του
    private double monthlyCost;
    // Το κόστος του φοιτήτη ανά μήνα αμα διαλέξει διαμονή με συγκάτοικο 
    private double costWithSh_Accomondation; 
    private String country;
    private String city;
    // Η καλύτερη περίοδος να πας σε αυτή τη συγκεκριμένη πόλη
    private String bestPeriodToVisit;
    // Η γλώσσα που μιλάνε στη συγκεκριμένη χώρα
    private String countrysLang;

    // Δημιουργία του κατασκευαστή της Universities
    public University(String uniName, String country, String city, double monthlyCost, double costWithSh_Accomondation, String countrysLang, String bestPeriodToVisit) {
        this.uniName = uniName;
        this.monthlyCost = monthlyCost;
        this.costWithSh_Accomondation = costWithSh_Accomondation;
        this.country = country;
        this.city = city;
        this.bestPeriodToVisit = bestPeriodToVisit;
        this.countrysLang = countrysLang;
    }
    // TODO Εδώ πρέπει να γίνουν μέθοδοι GET για κάθε όρισμα του κατασκευαστή
    public String getUniName() {
        return uniName;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    public double getCostWithSh_Accomondation() {
        return costWithSh_Accomondation;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getBestPeriodToVisit() {
        return bestPeriodToVisit;
    } 

    public String getCountrysLang() {
        return countrysLang;
    }
}