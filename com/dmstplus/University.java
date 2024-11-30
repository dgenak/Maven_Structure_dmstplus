package com.dmstplus;

public class University {
    private String uniName;
    // Οι τιμές των μεταβλητών monthlyCost, CostWithSh_Accommondation είναι ο μέσος όρος που υπολογίσαμε απο τα δεδομένα μας
    // Το κόστος του φοιτητή αμα μένει μόνος του
    private double monthlyCost;
    // Το κόστος του φοιτήτη ανά μήνα αμα διαλέξει διαμονή με συγκάτοικο 
    private double costWithSh_Accommondation; 
    private String country;
    private String city;
    // Η καλύτερη περίοδος να πας σε αυτή τη συγκεκριμένη πόλη
    private String bestPeriodToVisit;
    // Η γλώσσα που μιλάνε στη συγκεκριμένη χώρα
    private String countrysLang;

    // Δημιουργία του κατασκευαστή της Universities
    public University(String uniname, String country, String city, double monthlyCost, double costWithSh_Accommondation, String countrysLang Strinng bestPeriodToVisit, ) {
        this.uniname = uniname;
        this.monthlyCost = monthlyCost;
        this.costWithSh_Accommondation = costWithSh_Accommondation;
        this.country = country;
        this.city = city;
        this.bestPeriodToVisit = bestPeriodToVisit;
        this.countrysLang = countrysLanguage;
    }
    // TODO Εδώ πρέπει να γίνουν μέθοδοι GET για κάθε όρισμα του κατασκευαστή
    public String getuniName() {
        return uniName;
    }

    public double getmonthlyCost() {
        return monthlyCost;
    }

    public double getcostWithSh_Accommondation() {
        return costWithSh_Accommondation;
    }

    public String getcountry() {
        return country;
    }

    public String getcity() {
        return city;
    }

    public String getbestPeriodToVisit() {
        return bestPeriodToVisit;
    } 

    public String getcountrysLanguage() {
        return countrysLanguage;
    }
}