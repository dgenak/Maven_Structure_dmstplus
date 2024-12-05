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

        //### PHASE 1
        System.out.println("Choose which period you prefer to go");
        System.out.println("Spring,Winter");
        
        //Αναγνωση της επιλογης του χρηστη και εκχωριση στην μεταβλητη uperiod
        String uperiod = scanner.nextLine();
        System.out.println("You chose:" + uperiod);

        
        
        //### PHASE 2
        // Διαβάζει απο τον χρηστη σε ποια χώρα προτιμάει να παει
        UniData unidata = new UniData();
        List<String> countries = unidata.getCountries();
        System.out.println("Here are the countries you can go");
        for (String country : countries) {
            System.out.println("- " + country);
        }
        System.out.println("choose which country you would like to go to");
        String ucountry = scanner.nextLine();
        //Εκτυπωση της επιλεγμενης χωρας
        System.out.println("You have chosen:" + ucountry);

        //Κληση της λιστας costOfLiving
        List<CostOfLiving> costpermonth = unidata.getAmount();

        //Εκτυπωση της λιστας
        System.out.println("Here are the the costs per month");
        for (CostOfLiving cost : costpermonth) {
            System.out.println("- " + cost);
        }
        //Διαβασμα της επιλογης χρηστη
        System.out.println("Set your preferred maximum monthly budget");
        double maxcost = scanner.nextDouble();
        System.out.println("Your maximum monthly budget is :" + maxcost);     

        scanner.nextLine();

        System.out.println("Would you like to have a roomate");
        System.out.println("YES OR NO");
        String answer = scanner.nextLine();
        System.out.println("You answered" + answer);
        boolean sharedaccom;
        if (answer.equalsIgnoreCase("YES")) {
            sharedaccom = true;
        } else {
            sharedaccom = false;
        }
        scanner.close();
    }
}