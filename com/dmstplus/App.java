package com.dmstplus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.List;

public class App extends Application {

    private UniData unidata = new UniData();
    private User user = new User();

    public void start(Stage primaryStage) {
        primaryStage.setTitle("DMST+");

        //### PHASE 1
        Label periodLabel = new Label("Choose which period you prefer to go:");
        Button springButton = new Button("Spring");
        Button winterButton = new Button("Winter");
        Button nextButton1 = new Button("Next");

        VBox phase1Layout = new VBox(10, periodLabel, springButton, winterButton, nextButton1);
        Scene scene1 = new Scene(phase1Layout, 300, 200);

        //### PHASE 2
        Label langLabel = new Label("Choose the languages you know:");
        ListView<CheckBox> langListView = new ListView<>();
        for (String lang : unidata.getLang()) {
            langListView.getItems().add(new CheckBox(lang));
        }
        Button nextButton2 = new Button("Next");
        Button backButton2 = new Button("Back");

        VBox phase2Layout = new VBox(10, langLabel, langListView, new HBox(10, backButton2, nextButton2));
        Scene scene2 = new Scene(phase2Layout, 300, 200);

        //### PHASE 3
        Label countryLabel = new Label("Choose which country you would like to go to:");
        ListView<CheckBox> countryListView = new ListView<>();
        for (String country : unidata.getCountries()) {
            countryListView.getItems().add(new CheckBox(country));
        }
        Button nextButton3 = new Button("Next");
        Button backButton3 = new Button("Back");

        VBox phase3Layout = new VBox(10, countryLabel, countryListView, new HBox(10, backButton3, nextButton3));
        Scene scene3 = new Scene(phase3Layout, 300, 200);

        //### PHASE 4
        Label budgetLabel = new Label("Set your preferred maximum monthly budget:");
        TextField budgetTextField = new TextField();
        Button nextButton4 = new Button("Next");
        Button backButton4 = new Button("Back");

        VBox phase4Layout = new VBox(10, budgetLabel, budgetTextField, new HBox(10, backButton4, nextButton4));
        Scene scene4 = new Scene(phase4Layout, 300, 200);

        //### PHASE 5
        Label roommateLabel = new Label("Would you like to have a roommate?");
        ToggleGroup roommateToggleGroup = new ToggleGroup();
        RadioButton yesButton = new RadioButton("YES");
        RadioButton noButton = new RadioButton("NO");
        yesButton.setToggleGroup(roommateToggleGroup);
        noButton.setToggleGroup(roommateToggleGroup);

        Button nextButton5 = new Button("Next");
        Button backButton5 = new Button("Back");

        VBox phase5Layout = new VBox(10, roommateLabel, yesButton, noButton, new HBox(10, backButton5, nextButton5));
        Scene scene5 = new Scene(phase5Layout, 300, 200);

        //### PHASE 6
        Label resultsLabel = new Label("Here are the universities that match your preferences:");
        ListView<String> resultsListView = new ListView<>();
        Button finishButton = new Button("Finish");

        VBox phase6Layout = new VBox(10, resultsLabel, resultsListView, finishButton);
        Scene scene6 = new Scene(phase6Layout, 300, 400);

        // Button actions
        springButton.setOnAction(e -> {
            user.setPreferredPeriod("Spring");
            nextButton1.fire();
        });

        winterButton.setOnAction(e -> {
            user.setPreferredPeriod("Winter");
            nextButton1.fire();
        });

        nextButton1.setOnAction(e -> primaryStage.setScene(scene2));

        backButton2.setOnAction(e -> primaryStage.setScene(scene1));

        nextButton2.setOnAction(e -> {
            List<String> selectedLanguages = langListView.getItems().stream()
                .filter(CheckBox::isSelected)
                .map(CheckBox::getText)
                .toList();
            user.setUserslang(selectedLanguages);
            primaryStage.setScene(scene3);
        });

        backButton3.setOnAction(e -> primaryStage.setScene(scene2));

        nextButton3.setOnAction(e -> {
            List<String> selectedCountries = countryListView.getItems().stream()
                .filter(CheckBox::isSelected)
                .map(CheckBox::getText)
                .toList();
            user.setPreferredCountry(selectedCountries);
            primaryStage.setScene(scene4);
        });

        backButton4.setOnAction(e -> primaryStage.setScene(scene3));

        nextButton4.setOnAction(e -> {
            user.setMaxMonthlyCost(Double.parseDouble(budgetTextField.getText()));
            primaryStage.setScene(scene5);
        });

        backButton5.setOnAction(e -> primaryStage.setScene(scene4));

        nextButton5.setOnAction(e -> {
            boolean sharedAccom = yesButton.isSelected();
            user.setSharedAccomondation(sharedAccom);
            List<University> matchingUniversities = unidata.letsGoErasmus(user);
            for (University university : matchingUniversities) {
                resultsListView.getItems().add(university.toString());
            }
            primaryStage.setScene(scene6);
        });

        finishButton.setOnAction(e -> primaryStage.close());

        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
