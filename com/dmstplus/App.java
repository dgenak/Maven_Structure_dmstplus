package com.dmstplus;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.util.Arrays;
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
        
        final String uperiod;
        final String ucountry;
        final double maxcost;
        final String answer;
        final Boolean sharedaccom;

        System.out.println("Choose which period you prefer to go");
        System.out.println("Spring,Winter");
        Scanner scanner = new Scanner(System.in);
        //Αναγνωση της επιλογης του χρσητη και εκχωριση στην μεταβλητη uperiod
        String uperiod = scanner.nextLine();
        System.out.println("You chose:" + uperiod);
        scanner.close();

        List<String> Countries = Unidata.getcountries();
        System.out.println("choose which country you would like to go to");
        System.out.println("Here are the countries you can go");
        for (String country : countries) {
            System.out.println("- " + country);
        }
        //Δημιουργια Scanner για την αναγνωση της επιλογης του χρηστη
        Scanner scanner = new Scanner(System.in);
        String uncountry = scanner.nextLine();
        scanner.close();
        //Εκτυπωση της επιλεγμενης χωρας
        System.out.println("You have chosen:" + uncountry);

        //Κληση της λιστας costOfLiving
        List<double> costpermonth = Unidata.getCostOfLiving();
        //Εκτυπωση της λιστας
        System.out.println("Here are the the costs per month");
        for (double cost : costpermonth) {
            System.out.println("- " + cost);
        }
        //Διαβασμα της επιλογης χρηστη
        Scanner scanner = new Scanner(System.in);
        System.out.println("Set your preferred maximum monthly budget");
        double maxcost = scanner.nextDouble();
        System.out.println("Your maximum monthly budget is :" + maxcost);
        scanner.close();        

        Scanner scanner = new scanner(System.in);
        System.out.println("Would you like to have a roomate");
        System.out.println("YES OR NO");
        String answer = scanner.next.nextLine;
        System.out.println("You answered" + answer);
        boolean sharedaccom;
        if (answer.equalsIgnoreCase("YES")) {
            sharedaccom = true;
        } else {
            sharedaccom = false;
        }

        scanner.close();
        /*
        * TODO #5
        * Εδώ θα εκχωρίσουμε την επιλογή του user ως προς τις γλώσσες που γνωρίζει
        * 1. Εκτύπωση του μηνύματος: "What languages ​​do you know?"
        * 2. Εκτύπωση της λίστας languages
        * 3. Έπειτα διαβάζει την επιλογή του user και την εκχωρεί στην λίστα τύπου String ulang
        */
        //Κληση της λιστας Languages
        List<String> languages = UniData.getlanguages();
        //Εκτυπωσης μηνυματος
        System.out.println("What languages do you speak");
        //Εκτυπωση λιστας
        for (String language : languages) {
            System.out.println("- " + language);
        }
        String ulang;
        Scanner scanner = new scanner(System.in);
        String ulang = scanner.nextLine();
        System.out.println("You chose" + ulang);
        scanner.close();
    }
}