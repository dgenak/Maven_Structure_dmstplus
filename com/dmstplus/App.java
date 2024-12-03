package com.dmstplus;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.util.Arrays;
import java.util.Scanner;

// δημιουργια μιας λιστας με τα μηνιαια κόστοι
public class App extends Application {
    public void start(Stage primaryStage) {
        Label label = new Label("Γεια σου ρε μητσάρα");
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

        /*
        * TODO #1 Εδώ θα εκχωρίσουμε τη προτίμηση του user ως προς την περίοδο:
        * 1. Εκτύπωση του μηνύματος: "Choose which period you prefer to go: Spring, Winter"
        * 2. Έπειτα διαβάζει την επιλογή του user και την εκχωρεί στην μεταβλητή τύπου String uperiod
        */

        /*
        * TODO #2 Εδώ θα εκχωρίσουμε τη προτίμηση του user ως προς την χώρα:
        * 1. Εκτύπωση του μηνύματος: "choose which country you would like to go to"
        * 2. Εκτύπωση της λίστας countries
        * 3. Έπειτα διαβάζει την επιλογή του user και την εκχωρεί στην μεταβλητή τύπου String ucountry
        */

        /*
        * TODO #3 Εδώ θα εκχωρίσουμε το μέγιστο ποσό που είναι διατεθειμένος ο user να ξοδεύει μηνιαίως
        * 1. Εκτύπωση του μηνύματος: "Set your preferred maximum monthly budget."
        * 2. Εκτύπωση της λίστας costpermonth
        * 3. Έπειτα διαβάζει την επιλογή του user και την εκχωρεί στην μεταβλητή τύπου double maxcost
        */

        /*
        * TODO #4 Εδώ θα εκχωρίσουμε την επιλογή του user αν θέλει να συγκατοικήσει ή όχι
        * 1. Εκτύπωση του μηνύματος: "Would you like to have a roommate?"
        * 2. Εκτύπωση του μηνύματος: "YES OR NO"
        * 3. Έπειτα διαβάζει την επιλογή του user και την εκχωρεί στην μεταβλητή τύπου String answer
        * 4. Δημιουρία μιας if όπου θα εκχωρεί στην μεταβλητή boolean sharedaccom true αν απάντησε YES και false αν απάντησε NO
        */

        /*
        * TODO #5
        * Εδώ θα εκχωρίσουμε την επιλογή του user ως προς τις γλώσσες που γνωρίζει
        * 1. Εκτύπωση του μηνύματος: "What languages ​​do you know?"
        * 2. Εκτύπωση της λίστας languages
        * 3. Έπειτα διαβάζει την επιλογή του user και την εκχωρεί στην λίστα τύπου String ulang
        */
    }
}