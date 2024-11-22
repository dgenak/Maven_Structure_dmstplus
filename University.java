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
    public University(String uniname, double monthlyCost, double costWithSh_Accommondation, String country, String city, Strinng bestPeriodToVisit, String countrysLang) {
        this.uniname = uniname;
        this.monthlyCost = monthlyCost;
        this.costWithSh_Accommondation = costWithSh_Accommondation;
        this.country = country;
        this.city = city;
        this.bestPeriodToVisit = bestPeriodToVisit;
        this.countrysLang = countrysLang;
    }
    // TODO Εδώ πρέπει να γίνουν μέθοδοι GET για κάθε όρισμα του κατασκευαστή
}