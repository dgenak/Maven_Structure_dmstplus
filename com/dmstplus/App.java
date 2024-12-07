package com.dmstplus;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.util.List;
import java.util.Scanner;


// δημιουργια μιας λιστας με τα μηνιαια κόστοι
public class App extends Application {
    public void start(Stage primaryStage) {
        Label label = new Label("Γεια σου");
        Scene scene = new Scene(label, 300, 200);

        primaryStage.setTitle("DMST+");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {

        launch(args);
        
        Scanner scanner = new Scanner(System.in);
        UniData unidata = new UniData();
        //### PHASE 1
        System.out.println("Choose which period you prefer to go");
        System.out.println("Spring,Winter");
        
        //Αναγνωση της επιλογης του χρηστη και εκχωριση στην μεταβλητη uperiod
        String uperiod = scanner.nextLine();
        System.out.println("You chose:" + uperiod);

        /* ### PHASE 2
         * Εκχώρηση των ξένων γλωσσών που γνωρίζει ο user
        */
        List<String> ulang = unidata.getLang();
        System.out.println("Choose the languages you know");
        for (String lang : ulang) {
            System.out.println("- " + ulang);
        }
        String userslang = scanner.nextLine();
        //### PHASE 3
        // Διαβάζει απο τον χρηστη σε ποια χώρα προτιμάει να παει
        
        List<String> countries = unidata.getCountries();
        System.out.println("Here are the countries you can go");
        for (String country : countries) {
            System.out.println("- " + country);
        }
        System.out.println("choose which country you would like to go to");
        String ucountry = scanner.nextLine();

        //### PHASE 4
        //Διαβασμα της επιλογης χρηστη
        System.out.println("Set your preferred maximum monthly budget");
        double maxcost = scanner.nextDouble();

        scanner.nextLine();

        //### PHASE 5
        System.out.println("Would you like to have a roomate");
        System.out.println("YES OR NO");
        String answer = scanner.nextLine();
        System.out.println("You answered" + answer);
        boolean sharedaccom = false;
        if (answer.equalsIgnoreCase("YES")) {
            sharedaccom = true;
        }
        
        /* PHASE 6
         * Καλούμε την letsGoErasmus και εκτυπωνουμε την uni_match
         */
        User user  = new User();
        user.setUserslang(ulang);
        user.setPreferredCountry(countries);
        user.setMaxMonthlyCost(maxcost);
        user.setSharedAccomondation(sharedaccom);

        List<University> matchingUniversities = unidata.letsGoErasmus(user);

        /* 
         * Εδώ ελέγχουμε αν η λίστα που επιστρέφει η letsGoErasmus είναι κενή ή όχι
         * Δηλαδή ελέγχουμε αν υπάρχει κάποιο πανεπιστήμιο που να ταιριάζει με τις προτιμήσεις του user
         */
        if (matchingUniversities.isEmpty()) {
            System.out.println("There are no universities that match your preferences");
        } else {
            System.out.println("Here are the universities that match your preferences:");
            for (University university : matchingUniversities) {
                System.out.println(university);
            }
        }
        scanner.close();
    }
}