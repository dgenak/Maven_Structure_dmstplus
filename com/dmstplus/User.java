import java.util.List;
public class User {
    private List<String> Userslanguages;
    private String preferredPeriod;
    private String preferredCountry;
    private double maxMonthlyCost;
    private boolean SharedAccomondation;
    
    // Δημιουργία κατασκευαστή της User 
    public User(List<String> Userslanguages, preferredPeriod, preferredCountry, maxMonthlyCost, SharedAccomondation) {
        this.Userslanguages = Userslanguages;
        this.preferredPeriod = preferredPeriod;
        this.preferredCountry = preferredCountry;
        this.maxMonthlyCost = maxMonthlyCost;
        this.SharedAccomondation = SharedAccomondation;
    }
    // TODO Εδώ πρέπει να γίνουν μέθοδοι GET για κάθε όρισμα του κατασκευαστή
    
}