package com.dmstplus;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

import java.util.List;

public class AppController {

    // Εισαγωγή των FXML στοιχείων
    @FXML private Button springButton, winterButton, yesButton, noButton;
    @FXML private Button nextPhaseButton, prevPhaseButton;
    @FXML private ListView<String> uni_match;
    @FXML private ListView<String> languagesListView, countriesListView;
    @FXML private TextField budgetTextField;
    @FXML private Label errorLabel, messageLabel;
    @FXML private Pane phase1, phase2, phase3, phase4, phase5, phase6;

    private User user = new User();
    private UniData uniData = new UniData();
    /* SHOW LISTS METHOD */
    @FXML
    private void initialize() {
        languagesListView.getItems().setAll(uniData.getLang());
        countriesListView.getItems().setAll(uniData.getCountries());
    }
    
    /* PHASE 1 METHODS */
    @FXML
    private void optionS_1() {
        user.setPreferredPeriod("Spring");
    }

    @FXML
    private void optionW_1() {
        user.setPreferredPeriod("Winter");
    }

    /* PHASE 2 METHOD */
    @FXML
    private void optionL_2() {
        List<String> selectedLs = languagesListView.getSelectionModel().getSelectedItems();
        user.setUserslang(selectedLs);
    }

    /* PHASE 3 METHOD */
    @FXML
    private void ooptionC_3() {
        List<String> selectedCs = countriesListView.getSelectionModel().getSelectedItems();
        user.setPreferredCountry(selectedCs);
    }

    /* PHASE 4 METHOD */
    @FXML
    private void optionB_4() {
        try {
            double budget = Double.parseDouble(budgetTextField.getText());
            user.setMaxMonthlyCost(budget);
        } catch (NumberFormatException e) {
            errorLabel.setText("Μη έγκυρος αριθμός. Παρακαλώ εισάγετε έναν θετικό αριθμό");
        }
    }

    /* PHASE 5 METHOD */
    @FXML
    private void optionY_5() {
        user.setSharedAccomondation(true);
    }

    @FXML
    private void optionN_5() {
        user.setSharedAccomondation(false);
    }

    /* PHASE 6 AND CALL OF THE letsGoErasmus METHOD */
    @FXML
    private void MatchingUnis() {
        List<String> uni_match = uniData.letsGoErasmus(user);
        if (uni_match.isEmpty()) {
            messageLabel.setText("Δεν υπάρχουν πανεπιστήμια που να ταιριάζουν με τις προτιμήσεις σας.");
        } else {
            messageLabel.setText("Βρέθηκαν τα εξής πανεπιστήμια: ");
            this.uni_match.setItems(FXCollections.observableArrayList(uni_match));
        }
    }

    /* NEXT PHASE PROCEDURE */
    private void showNextPhase(Pane currentPhase) {

        currentPhase.setVisible(false);

        if (currentPhase == phase1) {
            phase2.setVisible(true);
        } else if (currentPhase == phase2) {
            phase3.setVisible(true);
        } else if (currentPhase == phase3) {
            phase4.setVisible(true);
        } else if (currentPhase == phase4) {
            phase5.setVisible(true);
        } else if (currentPhase == phase5) {
            phase6.setVisible(true);
        }
    }

    /* PREVIOUS PHASE PROCEDURE */
    private void showPreviusPhase(Pane currentPhase) {

        currentPhase.setVisible(false);

        if (currentPhase == phase2) {
            phase1.setVisible(true);
        } else if (currentPhase == phase3) {
            phase2.setVisible(true);
        } else if (currentPhase == phase4) {
            phase3.setVisible(true);
        } else if (currentPhase == phase5) {
            phase4.setVisible(true);
        } else if (currentPhase == phase6) {
            phase5.setVisible(true);
        }
    }

    /* NEXT PHASE METHOD */
    @FXML
    private void Prev_mth(ActionEvent event) {
        if (phase2.isVisible()) {
            showPreviusPhase(phase2);
        } else if (phase3.isVisible()) {
            showPreviusPhase(phase3);
        } else if (phase4.isVisible()) { 
            showPreviusPhase(phase4);
        } else if (phase5.isVisible()) {
            showPreviusPhase(phase5);
        } else {
            if (phase6.isVisible()) showPreviusPhase(phase6);
        }
    }

    /* PREVIOUS PHASE METHOD */
    @FXML
    private void next_mth(ActionEvent event) {
        if (phase1.isVisible()) {
            showNextPhase(phase1);
        } else if (phase2.isVisible()) {
            showNextPhase(phase2);
        } else if (phase3.isVisible()) {
            showNextPhase(phase3);
        } else if (phase4.isVisible()) {
            showNextPhase(phase4);
        } else {
            if (phase5.isVisible()) showNextPhase(phase5);
        }
    }

    
}
