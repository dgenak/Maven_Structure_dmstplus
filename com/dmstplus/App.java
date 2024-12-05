package com.dmstplus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class App extends Application {

    private UniData unidata = new UniData(); // Δημιουργία του αντικειμένου UniData για τη διαχείριση των δεδομένων

    @Override
    public void start(Stage primaryStage) {

        VBox vbox = new VBox(10);

        // Στοιχεία UI
        Label titleLabel = new Label("Welcome to DMST+ Erasmus App");
        titleLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        // Επιλογή περιόδου
        Label periodLabel = new Label("Choose which period you prefer to go");
        ComboBox<String> periodComboBox = new ComboBox<>();
        periodComboBox.getItems().addAll("Spring", "Winter");

        // Επιλογή γλωσσών
        Label langLabel = new Label("Choose the languages you know");
        List<String> languages = unidata.getLang();
        ComboBox<String> languageComboBox = new ComboBox<>();
        languageComboBox.getItems().addAll(languages);

        // Επιλογή χώρας
        Label countryLabel = new Label("Choose your preferred country");
        List<String> countries = unidata.getCountries();
        ComboBox<String> countryComboBox = new ComboBox<>();
        countryComboBox.getItems().addAll(countries);

        // Επιλογή προϋπολογισμού
        Label budgetLabel = new Label("Set your preferred maximum monthly budget");
        TextField budgetTextField = new TextField();
        budgetTextField.setPromptText("Enter amount");

        // Επιλογή συγκατοίκησης
        Label roommateLabel = new Label("Would you like to have a roommate?");
        ToggleGroup roommateGroup = new ToggleGroup();
        RadioButton yesButton = new RadioButton("Yes");
        yesButton.setToggleGroup(roommateGroup);
        RadioButton noButton = new RadioButton("No");
        noButton.setToggleGroup(roommateGroup);

        // Κουμπί αναζήτησης
        Button searchButton = new Button("Find Matching Universities");
        Label resultLabel = new Label("");

        // Κουμπί για την αναζήτηση των πανεπιστημίων
        searchButton.setOnAction(e -> {
            String selectedPeriod = periodComboBox.getValue();
            List<String> selectedLanguage = new ArrayList<>();
            String selectedCountry = countryComboBox.getValue();
            double maxBudget = Double.parseDouble(budgetTextField.getText());
            boolean hasRoommate = yesButton.isSelected();

            // Δημιουργία του χρήστη με τις επιλογές του
            User user = new User();
            user.setUserslang(selectedLanguage);
            user.setPreferredCountry(selectedCountry);
            user.setMaxMonthlyCost(maxBudget);
            user.setSharedAccomondation(hasRoommate);

            // Εύρεση πανεπιστημίων που ταιριάζουν με τις προτιμήσεις
            List<University> matchingUniversities = unidata.letsGoErasmus(user);

            // Εμφάνιση των αποτελεσμάτων
            StringBuilder resultText = new StringBuilder();
            if (matchingUniversities.isEmpty()) {
                resultText.append("No universities found that match your preferences.");
            } else {
                resultText.append("Here are the universities that match your preferences:\n");
                for (University university : matchingUniversities) {
                    resultText.append(university).append("\n");
                }
            }
            resultLabel.setText(resultText.toString());
        });

        // Προσθήκη των στοιχείων στην VBox
        vbox.getChildren().addAll(titleLabel, periodLabel, periodComboBox, langLabel, languageComboBox,
                countryLabel, countryComboBox, budgetLabel, budgetTextField, roommateLabel, yesButton, noButton,
                searchButton, resultLabel);

        // Ρύθμιση σκηνής
        Scene scene = new Scene(vbox, 400, 500);
        primaryStage.setTitle("DMST+ Erasmus");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
