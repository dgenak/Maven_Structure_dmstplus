package com.dmstplus;

import java.util.Arrays;
import java.util.Scanner;
// δημιουργια μιας λιστας με τα μηνιαια κόστοι
public class App {
    public static void main(String[] args) {
        
        private String uperiod;
        private String ucountry;
        private double maxcost;
        private String answer;
        private Boolean sharedaccom;

        /*
        * TODO #1 Εδώ θα εκχωρίσουμε τη προτίμηση του user ως προς την περίοδο:
        * 1. Εκτύπωση του μηνύματος: "Choose which period you prefer to go: Spring, Winter"
        * 2. Έπειτα διαβάζει την επιλογή του user και την εκχωρεί στην μεταβλητή τύπου String uperiod
        */
        //Εκτυπωση μηνυματος για την επιλογη περιοδου
        System.out.println("Choose which period you prefer to go");
        System.out.println("Spring,Winter");
        //Δημιουργια αντικειμενου Scanner για την αναγνωση της απαντησης του χρηστη
        Scanner scanner = new Scanner(System.in);
        //Αναγνωση της επιλογης του χρσητη και εκχωριση στην μεταβλητη uperiod
        String uperiod = scanner.nextLine();
        //Εμφανιση της επιλογης του χρηστη
        System.out.println("You chose:" + uperiod);
        //Κλεισιμο του scanner 
        scanner.close();
    }

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