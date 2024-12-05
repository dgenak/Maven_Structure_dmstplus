package com.dmstplus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.List;

public class App extends Application {

    private UniData unidata = new UniData();
    private User user = new User();

    public void start(Stage primaryStage) {
        primaryStage.setTitle("DMST+");

        // ### PHASE 1
        Label periodLabel = new Label("Choose which period you prefer to go:");
        ComboBox<String> periodComboBox = new ComboBox<>();
        periodComboBox.getItems().addAll("Spring", "Winter");
        Button nextButton1 = new Button("Next");
        VBox phase1Layout = new VBox(10, periodLabel, periodComboBox, nextButton1);
        Scene scene1 = new Scene(phase1Layout, 300, 200);

        // ### PHASE 2
        Label langLabel = new Label("Choose the languages you know:");
        ListView<String> langListView = new ListView<>();
        langListView.getItems().addAll(unidata.getLang());
        Button nextButton2 = new Button("Next");
        VBox phase2Layout = new VBox(10, langLabel, langListView, nextButton2);
        Scene scene2 = new Scene(phase2Layout, 300, 200);

        // ### PHASE 3
        Label countryLabel = new Label("Choose which country you would like to go to:");
        ComboBox<String> countryComboBox = new ComboBox<>();
        countryComboBox.getItems().addAll(unidata.getCountries());
        Button nextButton3 = new Button("Next");
        VBox phase3Layout = new VBox(10, countryLabel, countryComboBox, nextButton3);
        Scene scene3 = new Scene(phase3Layout, 300, 200);

        // ### PHASE 4
        Label budgetLabel = new Label("Set your preferred maximum monthly budget:");
        TextField budgetTextField = new TextField();
        Button nextButton4 = new Button("Next");
        VBox phase4Layout = new VBox(10, budgetLabel, budgetTextField, nextButton4);
        Scene scene4 = new Scene(phase4Layout, 300, 200);

        // ### PHASE 5
        Label roommateLabel = new Label("Would you like to have a roommate?");
        ComboBox<String> roommateComboBox = new ComboBox<>();
        roommateComboBox.getItems().addAll("YES", "NO");
        Button nextButton5 = new Button("Next");
        VBox phase5Layout = new VBox(10, roommateLabel, roommateComboBox, nextButton5);
        Scene scene5 = new Scene(phase5Layout, 300, 200);

        // ### PHASE 6
        Label resultsLabel = new Label("Here are the universities that match your preferences:");
        ListView<String> resultsListView = new ListView<>();
        Button finishButton = new Button("Finish");
        VBox phase6Layout = new VBox(10, resultsLabel, resultsListView, finishButton);
        Scene scene6 = new Scene(phase6Layout, 300, 400);

        // Button actions
        nextButton1.setOnAction(e -> {
            user.setPreferredPeriod(periodComboBox.getValue());
            primaryStage.setScene(scene2);
        });

        nextButton2.setOnAction(e -> {
            user.setUserslang(langListView.getSelectionModel().getSelectedItems());
            primaryStage.setScene(scene3);
        });

        nextButton3.setOnAction(e -> {
            user.setPreferredCountry(countryComboBox.getValue());
            primaryStage.setScene(scene4);
        });

        nextButton4.setOnAction(e -> {
            user.setMaxMonthlyCost(Double.parseDouble(budgetTextField.getText()));
            primaryStage.setScene(scene5);
        });

        nextButton5.setOnAction(e -> {
            boolean sharedAccom = roommateComboBox.getValue().equals("YES");
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
