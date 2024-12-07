package com.dmstplus;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.List;

public class App extends Application {

    private final UniData unidata = new UniData(); // Χρήση της κλάσης δεδομένων πανεπιστημίων
    private final User user = new User(); // Αντικείμενο χρήστη για την αποθήκευση των επιλογών του

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("DMST+ Erasmus Finder");

        // *** Δημιουργία Root Layout ***
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        // *** Σκηνή 1: Επιλογή περιόδου (Spring, Winter) σε κουμπιά ***
        Label periodLabel = new Label("Choose which period you prefer:");
        Button springButton = new Button("Spring");
        Button winterButton = new Button("Winter");
        
        springButton.setOnAction(e -> user.setPreferredPeriod("Spring"));
        winterButton.setOnAction(e -> user.setPreferredPeriod("Winter"));

        // *** Σκηνή 2: Επιλογή γλωσσών (Μπορείς να επιλέξεις πολλές γλώσσες) ***
        Label langLabel = new Label("Select the languages you know:");
        ListView<String> langList = new ListView<>();
        langList.getItems().addAll(unidata.getLang());
        langList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // *** Σκηνή 3: Επιλογή χωρών (Μπορείς να επιλέξεις πολλές χώρες) ***
        Label countryLabel = new Label("Choose countries you prefer:");
        ListView<String> countryList = new ListView<>();
        countryList.getItems().addAll(unidata.getCountries());
        countryList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // *** Σκηνή 4: Προϋπολογισμός ***
        Label budgetLabel = new Label("Set your preferred maximum monthly budget:");
        TextField budgetField = new TextField();
        budgetField.setPromptText("Enter budget (e.g., 1000)");

        // *** Σκηνή 5: Κοινόχρηστη διαμονή (YES/NO σε κουμπιά) ***
        Label accomLabel = new Label("Would you like to have a roommate?");
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");
        
        yesButton.setOnAction(e -> user.setSharedAccomondation(true));
        noButton.setOnAction(e -> user.setSharedAccomondation(false));

        // *** Κουμπί Υποβολής για εύρεση πανεπιστημίων ***
        Button submitButton = new Button("Find Universities");
        Label resultLabel = new Label();

        // *** Ενέργεια στο κουμπί ***
        submitButton.setOnAction(e -> {
            // Εκχώρηση επιλογών του χρήστη
            user.setUserslang(langList.getSelectionModel().getSelectedItems());
            user.setPreferredCountry(countryList.getSelectionModel().getSelectedItems());
            user.setMaxMonthlyCost(Double.parseDouble(budgetField.getText()));

            // Αναζήτηση πανεπιστημίων
            List<String> matchingUniversities = unidata.letsGoErasmus(user);

            // Εμφάνιση αποτελεσμάτων
            if (matchingUniversities.isEmpty()) {
                resultLabel.setText("No universities match your preferences.");
            } else {
                StringBuilder results = new StringBuilder("Matching universities:\n");
                for (String university : matchingUniversities) {
                    results.append(university).append("\n");
                }
                resultLabel.setText(results.toString());
            }
        });

        // *** Προσθήκη στοιχείων στο layout ***
        root.getChildren().addAll(
                periodLabel, springButton, winterButton,
                langLabel, langList,
                countryLabel, countryList,
                budgetLabel, budgetField,
                accomLabel, yesButton, noButton,
                submitButton, resultLabel
        );

        // Δημιουργία και εμφάνιση σκηνής
        Scene scene = new Scene(root, 400, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
