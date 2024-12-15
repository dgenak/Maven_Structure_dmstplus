package com.dmstplus;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Φόρτωση του FXML αρχείου
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/dmstplus/app.fxml"));
            Parent root = loader.load();  // Φορτώνει το FXML αρχείο και το μετατρέπει σε αντικείμενο Parent

            // Δημιουργία σκηνής
            Scene scene = new Scene(root, 800, 600); // Προαιρετικά, δώστε διαστάσεις

            // Προσθήκη του CSS αρχείου
            String cssPath = getClass().getResource("/com/dmstplus/styles.css").toExternalForm();
            scene.getStylesheets().add(cssPath);

            // Ορισμός σκηνής και εμφάνιση της
            primaryStage.setScene(scene);
            primaryStage.setTitle("DMST+ ERASMUS");
            primaryStage.show();
        } catch (Exception e) {
            System.err.println("Error loading application: ");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
