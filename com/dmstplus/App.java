package com.dmstplus;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.List;
import java.util.Scanner;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scanner scanner = new Scanner(System.in);

        //### PHASE 1 - Πρωτότυπη λογική με JavaFX GUI
        Label periodLabel = new Label("Choose which period you prefer to go");
        ComboBox<String> periodComboBox = new ComboBox<>();
        periodComboBox.getItems().addAll("Spring", "Winter");

        // Κουμπί για να συνεχίσει ο χρήστης την επιλογή του
        Button choosePeriodButton = new Button("Choose Period");
        choosePeriodButton.setOnAction(e -> {
            String uperiod = periodComboBox.getValue();
            System.out.println("You chose: " + uperiod);
        });

        //### PHASE 2 - Χώρα
        Label countryLabel = new Label("Choose which country you would like to go to");
        UniData unidata = new UniData();
        List<String> countries = unidata.getCountries();
        ComboBox<String> countryComboBox = new ComboBox<>();
        countryComboBox.getItems().addAll(countries);

        Button chooseCountryButton = new Button("Choose Country");
        chooseCountryButton.setOnAction(e -> {
            String ucountry = countryComboBox.getValue();
            System.out.println("You have chosen: " + ucountry);
        });

        // Κόστος ανά μήνα
        Label costLabel = new Label("Set your preferred maximum monthly budget");
        TextField costField = new TextField();
        Button setBudgetButton = new Button("Set Budget");
        setBudgetButton.setOnAction(e -> {
            try {
                double maxcost = Double.parseDouble(costField.getText());
                System.out.println("Your maximum monthly budget is: " + maxcost);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input for budget.");
            }
        });

        // Συγκατοίκηση
        Label sharedAccommodationLabel = new Label("Would you like to have a roommate?");
        ToggleGroup group = new ToggleGroup();
        RadioButton yesButton = new RadioButton("Yes");
        yesButton.setToggleGroup(group);
        RadioButton noButton = new RadioButton("No");
        noButton.setToggleGroup(group);

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            boolean sharedaccom = yesButton.isSelected();
            System.out.println("You answered: " + (sharedaccom ? "Yes" : "No"));
        });

        // Διάταξη και σκηνή
        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(
            periodLabel, periodComboBox, choosePeriodButton,
            countryLabel, countryComboBox, chooseCountryButton,
            costLabel, costField, setBudgetButton,
            sharedAccommodationLabel, yesButton, noButton, submitButton
        );

        Scene scene = new Scene(vbox, 300, 400);
        primaryStage.setTitle("Erasmus Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
