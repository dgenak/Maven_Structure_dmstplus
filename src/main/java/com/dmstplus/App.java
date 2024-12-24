package com.dmstplus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.util.Pair;
import javafx.collections.FXCollections;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;




import java.io.File;        




import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.awt.Desktop;
import java.net.URL;
import java.nio.file.Path;


public class App extends Application {

    private User user = new User();
    private UniData uniData = new UniData();

    // Πάνελ φάσεων
    private Pane phaseInfo, phaseCv, phase0, phase1, phase2, phase3, phase4, phase5, phase6;

    // Στοιχεία φάσεων
    private ListView<String> languagesListView, countriesListView;
    private ListView<University> uniMatches;
    private TextField budgetTextField;
    private Label messageLabel, errorLabel;

    @Override
    public void start(Stage primaryStage) {
        // Δημιουργία σκηνής
        Scene scene = new Scene(createMainLayout(), 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("DMST+ ERASMUS");
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.setFullScreen(false);
    }

    private Pane createPane() {
        Pane pane = new Pane();
        pane.setPrefWidth(400);
        pane.setPrefHeight(300);
        return pane;
    }
    

    private VBox createMainLayout() {
        VBox mainLayout = new VBox();
        mainLayout.setStyle("-fx-background-color:rgba(135, 198, 234, 0.88);"); // Σκούρο γκρι background

        // Δημιουργία των φάσεων
        phaseInfo = erInfo();
        phaseCv = cvHelper();
        phase0 = createPhase0();
        phase1 = createPhase1();
        phase2 = createPhase2();
        phase3 = createPhase3();
        phase4 = createPhase4();
        phase5 = createPhase5();
        phase6 = createPhase6();

        mainLayout.getChildren().addAll(phaseInfo, phaseCv, phase0, phase1, phase2, phase3, phase4, phase5, phase6);

        // Εμφάνιση μόνο της πρώτης φάσης
        showPhase(phase0);

        return mainLayout;
    }

    private void showPhase(Pane phase) {
        phase0.setVisible(phase == phase0);
        phaseCv.setVisible(phase == phaseCv);
        phaseInfo.setVisible(phase == phaseInfo);
        phase1.setVisible(phase == phase1);
        phase2.setVisible(phase == phase2);
        phase3.setVisible(phase == phase3);
        phase4.setVisible(phase == phase4);
        phase5.setVisible(phase == phase5);
        phase6.setVisible(phase == phase6);
    }

    private Pane createPhase0() {
        
        Pane phase = createPane();
        phase.setPrefWidth(400);
        phase.setPrefHeight(300);
    
        Label label1 = new Label("DMST+");
        label1.setLayoutX(150);
        label1.setLayoutY(0);
        label1.setFont(Font.font("Arial", FontWeight.BOLD, 30));

        Label label2 = new Label("Hello!!");
        label2.setLayoutX(180);
        label2.setLayoutY(70);
        label2.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        
        Label label3 = new Label("Let's find the university that suits you?");
        label3.setLayoutX(80);
        label3.setLayoutY(95);
        label3.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        Button startButton = new Button("Let's Start");
        startButton.setLayoutX(130);
        startButton.setLayoutY(140);
        startButton.setOnAction(_ -> showPhase(phase1));
        startButton.setStyle("-fx-background-color: lightgrey; -fx-text-fill: blue;");

        Button menuButton = new Button("Menu");
        menuButton.setLayoutX(220);
        menuButton.setLayoutY(140);
        menuButton.setStyle("-fx-background-color: lightgrey; -fx-text-fill: blue;");
    
        menuButton.setOnAction(_ -> {

            Button cv = new Button("Build your CV");
            cv.setLayoutX(70);
            cv.setLayoutY(190);

            cv.setOnAction(_ -> {
                showPhase(phaseCv);
            });
    
            
            Button info = new Button("Erasmus Info");
            info.setLayoutX(170);
            info.setLayoutY(190);

            info.setOnAction(_ -> {
                showPhase(phaseInfo);
            });
    
            Button apply = new Button("Apply");
            apply.setLayoutX(270);
            apply.setLayoutY(190);

            apply.setOnAction(_ -> {
                try {
                    // Άνοιγμα συνδέσμου στον προεπιλεγμένο browser
                    String url = "https://www.dept.aueb.gr/en/dmst/programme-erasmus-student-application-form-dmst";
                    java.awt.Desktop.getDesktop().browse(new java.net.URI(url));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            phase.getChildren().addAll(cv, info, apply);

            menuButton.setDisable(true);
        });

        phase.getChildren().addAll(label1, label2, label3, startButton, menuButton);
    
        return phase;
    }
    
    private Pane cvHelper() {
        Pane phase = createPane();
        phase.setPrefWidth(400);
        phase.setPrefHeight(300);

        Text text = new Text("Download PDF:");
        text.setLayoutX(170);
        text.setLayoutY(-4);

        Button download = new Button("Create your first CV");
        download.setLayoutX(260);
        download.setLayoutY(-20);

        Download pdf = new Download();
        download.setOnAction(_ -> {
            pdf.downloadPdf("C:\\Users\\dim\\JAVA\\prog_II_project\\Maven_Structure_dmstplus\\src\\main\\resources\\PDF\\CV.pdf");
        });
        Button backButton = new Button("Back");
        backButton.setLayoutX(40);
        backButton.setLayoutY(-20);
        backButton.setOnAction(_ -> showPhase(phase0));

        ListView<String> listView = new ListView<>();

        List<String> textLines = new ArrayList<>();
        textLines.add("HERE ARE SOME RECOMMENDATIONS ON WHAT YOUR RESUME SHOULD CONTAIN:");
        textLines.add("PERSONAL INFORMATION: Name, phone number, email, LinkedIn, GitHub (if available).");
        textLines.add("SUMMARY (Optional): A brief description of your goals and professional profile.");
        textLines.add("EDUCATION:");
        textLines.add(" • Degree title.");
        textLines.add(" • University and country.");
        textLines.add(" • Timeframe (e.g., 2020-2024).");
        textLines.add(" • GPA (if high).");
        textLines.add("WORK EXPERIENCE:");
        textLines.add(" • Job title, company, location.");
        textLines.add(" • Duration (e.g., Jan 2023 – Jun 2023).");
        textLines.add(" • Brief description of responsibilities and achievements.");
        textLines.add("SKILLS:");
        textLines.add(" • Technical skills (e.g., programming languages, software).");
        textLines.add(" • Soft skills (e.g., teamwork, communication).");
        textLines.add("LANGUAGES: Proficiency level (e.g., English: Fluent, Greek: Native).");
        textLines.add("CERTIFICATIONS (if any): e.g., TOEFL, technical certifications.");
        textLines.add("VOLUNTEERING (if any): Role, organization, duration.");
        textLines.add("INTERESTS (optional): Relevant to the position.");

        // Προσθήκη των στοιχείων στο ListView
        listView.getItems().addAll(textLines);

        listView.setPrefSize(390, 200); // Ρύθμιση μεγέθους του ListView
        listView.setLayoutX(5);  // Τοποθέτηση του ListView μέσα στο Pane (ξεκινά 10 pixels από αριστερά)
        listView.setLayoutY(10);

        TextFlow textFlow = new TextFlow();
        Text text1 = new Text("DISCLAIMER: The suggestions provided are based on our personal ");
        text1.setFill(Color.RED);
        text1.setLayoutX(8);
        text1.setLayoutY(225);
        Text text2 = new Text("perspective and are not a definitive guide to creating a perfect resume.");
        text2.setFill(Color.RED);
        text2.setLayoutX(8);
        text2.setLayoutY(237);
        Text text3 = new Text("Each candidate should take the initiative to research and adapt their ");
        text3.setFill(Color.RED);
        text3.setLayoutX(8);
        text3.setLayoutY(249);
        Text text4 = new Text("resume to meet their unique requirements.");
        text4.setFill(Color.RED);
        text4.setLayoutX(8);
        text4.setLayoutY(261);

        textFlow.getChildren().addAll(text1, text2, text3, text4);


        phase.getChildren().addAll(backButton, text, download, listView, text1, text2, text3, text4);
        return phase;
    }
    

    private Pane erInfo() {
        Pane phase = createPane();
        phase.setPrefWidth(400);
        phase.setPrefHeight(300);

        // Δημιουργία κειμένων
        Text text1 = new Text("1. Student Application Form");
        text1.setLayoutX(20);
        text1.setLayoutY(30);
        
        Text text2 = new Text("2. SURNAME Pre-Learning Agreement Form");
        text2.setLayoutX(20);
        text2.setLayoutY(80);

        Text text4 = new Text("3. Learning Agreement Studies Erasmus+");
        text4.setLayoutX(20);
        text4.setLayoutY(130);

        Text text5 = new Text("4. During the Mobility");
        text5.setLayoutX(20);
        text5.setLayoutY(180);

        // Δημιουργία κουμπιών
        Button button1 = new Button("Download and Open Form 1");
        button1.setLayoutX(220);
        button1.setLayoutY(40);
        button1.setOnAction(_ -> downloadAndOpen("https://www.dept.aueb.gr/sites/default/files/dmst/erasmus/Student_Application_Form_Outgoing.doc"));

        Button button2 = new Button("Download and Open Form 2");
        button2.setLayoutX(220);
        button2.setLayoutY(90);
        button2.setOnAction(_ -> downloadAndOpen("https://www.dept.aueb.gr/sites/default/files/dmst/erasmus/SURNAME_PreLearningAgreementForm.xlsx"));

        Button button4 = new Button("Download and Open Form 3");
        button4.setLayoutX(220);
        button4.setLayoutY(140);
        button4.setOnAction(_ -> downloadAndOpen("https://www.dept.aueb.gr/sites/default/files/dmst/erasmus/Learning%20Agreement%20Studies%20Erasmus%2B.docx"));

        Button button5 = new Button("Download and Open Form 4");
        button5.setLayoutX(220);
        button5.setLayoutY(190);
        button5.setOnAction(_ -> downloadAndOpen("https://www.dept.aueb.gr/sites/default/files/dmst/erasmus/During%20the%20Mobility.docx"));

        Button backButton = new Button("Back");
        backButton.setLayoutX(40);
        backButton.setLayoutY(250);
        backButton.setOnAction(_ -> showPhase(phase0));

        phase.getChildren().addAll(text1, text2, text4, text5, button1, button2, backButton, button4, button5);

        return phase;
    }

    private void downloadAndOpen(String fileUrl) {
        try {
            // Δημιουργία του URL
            URL url = new URL(fileUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            // Δημιουργία τοπικού path για αποθήκευση
            String userHome = System.getProperty("user.home");
            String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
            Path destinationPath = Path.of(userHome, "Downloads", fileName);

            // Αντιγραφή του αρχείου από το URL στον τοπικό υπολογιστή
            try (InputStream in = connection.getInputStream();
                 OutputStream out = new FileOutputStream(destinationPath.toFile())) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }

                // Άνοιγμα του αρχείου με την προεπιλεγμένη εφαρμογή
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(destinationPath.toFile());
                }

                System.out.println("File downloaded and opened successfully.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error occurred while downloading or opening the file.");
        }
    }
    private Pane createPhase1() {
        Pane phase = createPane();
        phase.setPrefWidth(400);
        phase.setPrefHeight(300);
    
        Label label = new Label("Choose which period you prefer:");
        label.setLayoutX(80);
        label.setLayoutY(0);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 15));
    
        // Φόρτωση εικόνας για το κουμπί Spring
        Image springImage = new Image("file:C:/Users/dim/JAVA/prog_II_project/Maven_Structure_dmstplus/src/main/resources/photos/summer.jpg");
        ImageView springImageView = new ImageView(springImage);
        springImageView.setFitWidth(50);  // Ρυθμίζουμε το πλάτος της εικόνας
        springImageView.setFitHeight(50); // Ρυθμίζουμε το ύψος της εικόνας
        springImageView.setPreserveRatio(true); // Διατηρούμε τις αναλογίες της εικόνας
    
        Button springButton = new Button();
        springButton.setLayoutX(110);
        springButton.setLayoutY(40);
        springButton.setGraphic(springImageView);
        springButton.setOnAction(_ -> user.setPreferredPeriod("Spring"));
    
        // Φόρτωση εικόνας για το κουμπί Winter
        Image winterImage = new Image("file:C:/Users/dim/JAVA/prog_II_project/Maven_Structure_dmstplus/src/main/resources/photos/winter.jpg");
        ImageView winterImageView = new ImageView(winterImage);
        winterImageView.setFitWidth(50);  // Ρυθμίζουμε το πλάτος της εικόνας
        winterImageView.setFitHeight(50); // Ρυθμίζουμε το ύψος της εικόνας
        winterImageView.setPreserveRatio(true); // Διατηρούμε τις αναλογίες της εικόνας
    
        Button winterButton = new Button();
        winterButton.setLayoutX(220);
        winterButton.setLayoutY(40);
        winterButton.setGraphic(winterImageView);
        winterButton.setOnAction(_ -> user.setPreferredPeriod("Winter"));
    
        // Δημιουργία του κουμπιού Next
        Button nextButton = new Button("Next");
        nextButton.setLayoutX(320);
        nextButton.setLayoutY(160);
        nextButton.setOnAction(_ -> showPhase(phase2));
    
        // Δημιουργία του κουμπιού Previous
        Button backButton = new Button("Back");
        backButton.setLayoutX(40);
        backButton.setLayoutY(160);
        backButton.setOnAction(_ -> showPhase(phase0));
    
        // Προσθήκη των κουμπιών και του label στο Pane
        phase.getChildren().addAll(label, springButton, winterButton, nextButton, backButton);
    
        return phase;
    }
    
    private Pane createPhase2() {
        Pane phase = createPane();
        phase.setPrefWidth(400);
        phase.setPrefHeight(300);
    
        Label label = new Label("Choose the languages ​​you know:");
        label.setLayoutX(140);
        label.setLayoutY(-70);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 15));
    
        Circle clipCircle = new Circle(1000);
        clipCircle.setCenterX(10);  // Κεντράρισμα του κύκλου στον οριζόντιο άξονα
        clipCircle.setCenterY(-110);  // Κεντράρισμα του κύκλου στον κατακόρυφο άξονα
    
        Circle backgroundCircle = new Circle(125);
        backgroundCircle.setFill(Color.WHITE); // Λευκό χρώμα για το φόντο
        backgroundCircle.setCenterX(0);
        backgroundCircle.setCenterY(-10);
    
        // Εισαγωγή εικόνας
        Image phase2Image = new Image("file:C:\\Users\\dim\\JAVA\\prog_II_project\\Maven_Structure_dmstplus\\src\\main\\resources\\photos\\phase2.jpg");
        ImageView imageView = new ImageView(phase2Image);
        imageView.setFitWidth(80); // Ρύθμιση πλάτους της εικόνας
        imageView.setFitHeight(80);
        imageView.setLayoutX(20);
        imageView.setLayoutY(-40);
        imageView.setPreserveRatio(true);
        imageView.setClip(clipCircle);
    
        phase.getChildren().addAll(backgroundCircle, imageView);
    
        languagesListView = new ListView<>(FXCollections.observableArrayList(uniData.getLang()));
        languagesListView.setLayoutX(160);
        languagesListView.setLayoutY(-30);
        languagesListView.setPrefWidth(200);
        languagesListView.setPrefHeight(130);
    
        Button nextButton = new Button("Next");
        nextButton.setLayoutX(320);
        nextButton.setLayoutY(120);
        nextButton.setOnAction(_ -> {
            user.setUserslang(languagesListView.getSelectionModel().getSelectedItems());
            showPhase(phase3);
        });
    
        Button backButton = new Button("Back");
        backButton.setLayoutX(40);
        backButton.setLayoutY(120);
        backButton.setOnAction(_ -> showPhase(phase1));
    
        // Προσθήκη στοιχείων στο Phase
        phase.getChildren().addAll(label, languagesListView, nextButton, backButton);
    
        return phase;
    }
    
    
    

    private Pane createPhase3() {
        Pane phase = new Pane();  // Χρησιμοποιούμε Pane για ακριβή τοποθέτηση
        phase.setPrefWidth(400);
        phase.setPrefHeight(300);

        Circle clipCircle = new Circle(1000);
        clipCircle.setCenterX(10);  // Κεντράρισμα του κύκλου στον οριζόντιο άξονα
        clipCircle.setCenterY(-140);  // Κεντράρισμα του κύκλου στον κατακόρυφο άξονα
    
        Circle backgroundCircle = new Circle(130);
        backgroundCircle.setFill(Color.WHITE); // Λευκό χρώμα για το φόντο
        backgroundCircle.setCenterX(0);
        backgroundCircle.setCenterY(-40);
    
        // Εισαγωγή εικόνας
        Image phase3Image = new Image("file:C:\\Users\\dim\\JAVA\\prog_II_project\\Maven_Structure_dmstplus\\src\\main\\resources\\photos\\phase3.jpg");
        ImageView imageView = new ImageView(phase3Image);
        imageView.setFitWidth(80); // Ρύθμιση πλάτους της εικόνας
        imageView.setFitHeight(80);
        imageView.setLayoutX(20);
        imageView.setLayoutY(-80);
        imageView.setPreserveRatio(true);
        imageView.setClip(clipCircle);
    
        phase.getChildren().addAll(backgroundCircle, imageView);
        // Ετικέτα επεξήγησης
        Label label = new Label("Choose which countries you would prefer to go to:");
        label.setLayoutX(120);  // Τοποθέτηση της ετικέτας στη θέση X
        label.setLayoutY(-100);  // Τοποθέτηση της ετικέτας στη θέση Y
        label.setFont(Font.font("Arial", FontWeight.BOLD, 11.5));
    
        // Λίστα με επιλογές χωρών
        countriesListView = new ListView<>(FXCollections.observableArrayList(uniData.getCountries()));
        countriesListView.setLayoutX(160);  // Τοποθέτηση του ListView στη θέση X
        countriesListView.setLayoutY(-60); // Τοποθέτηση του ListView στη θέση Y
        countriesListView.setPrefWidth(200); 
        countriesListView.setPrefHeight(130);
        // Κουμπιά Next και Previous
        Button nextButton = new Button("Next");
        nextButton.setLayoutX(320);  // Τοποθέτηση του κουμπιού Next στη θέση X
        nextButton.setLayoutY(90);  // Τοποθέτηση του κουμπιού Next στη θέση Y
        nextButton.setOnAction(_ -> {
            user.setPreferredCountry(countriesListView.getSelectionModel().getSelectedItems());
            showPhase(phase4);
        });
    
        Button backButton = new Button("Back");
        backButton.setLayoutX(40);  // Τοποθέτηση του κουμπιού Previous στη θέση X
        backButton.setLayoutY(90); // Τοποθέτηση του κουμπιού Previous στη θέση Y
        backButton.setOnAction(_ -> showPhase(phase2));
    
        // Προσθήκη στοιχείων στο Phase
        phase.getChildren().addAll(label, countriesListView, nextButton, backButton);
    
        return phase;
    }
    

    private Pane createPhase4() {
        Pane phase = new Pane();  // Χρησιμοποιούμε Pane για ακριβή τοποθέτηση
        phase.setPrefWidth(400);
        phase.setPrefHeight(300);
        
        Circle clipCircle = new Circle(1000);
        clipCircle.setCenterX(10);  // Κεντράρισμα του κύκλου στον οριζόντιο άξονα
        clipCircle.setCenterY(-100);  // Κεντράρισμα του κύκλου στον κατακόρυφο άξονα

        Circle backgroundCircle = new Circle(125);
        backgroundCircle.setFill(Color.WHITE); // Λευκό χρώμα για το φόντο
        backgroundCircle.setCenterX(0);
        backgroundCircle.setCenterY(-80);

        // Εισαγωγή εικόνας
        Image image = new Image("file:C:\\Users\\dim\\JAVA\\prog_II_project\\Maven_Structure_dmstplus\\src\\main\\resources\\photos\\phase4.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(80); // Ρύθμιση πλάτους της εικόνας
        imageView.setFitHeight(80); // Ρύθμιση ύψους της εικόνας
        imageView.setLayoutX(20);
        imageView.setLayoutY(-120);
        imageView.setPreserveRatio(true); // Διατήρηση αναλογίας της εικόνας
    
        // Ρύθμιση του clipping της εικόνας με βάση τον κύκλο
        imageView.setClip(clipCircle);
    
        // Δημιουργία ενός άλλου κύκλου για να εμφανιστεί ως λευκός κύκλος πίσω από την εικόνα

    
        // Προσθήκη στοιχείων στο Pane
        phase.getChildren().addAll(backgroundCircle, imageView);
    

        Label label = new Label("Write the amount you are willing to spend monthly:");
        label.setLayoutX(120);  // Τοποθέτηση της ετικέτας στη θέση X
        label.setLayoutY(-140);  // Τοποθέτηση της ετικέτας στη θέση Y
        label.setFont(Font.font("Arial", FontWeight.BOLD, 11.4));
        // Πεδίο εισαγωγής για το ποσό
        budgetTextField = new TextField();
        budgetTextField.setLayoutX(175);  // Τοποθέτηση του TextField στη θέση X
        budgetTextField.setLayoutY(-90); // Τοποθέτηση του TextField στη θέση Y
        budgetTextField.setPrefWidth(150);  // Ορισμός πλάτους για το TextField
    
        // Ετικέτα για λάθη
        errorLabel = new Label();
        errorLabel.setLayoutX(50);  // Τοποθέτηση της ετικέτας λάθους στη θέση X
        errorLabel.setLayoutY(80); // Τοποθέτηση της ετικέτας λάθους στη θέση Y
    
        // Κουμπιά Next και Previous
        Button nextButton = new Button("Next");
        nextButton.setLayoutX(320);  // Τοποθέτηση του κουμπιού Next στη θέση X
        nextButton.setLayoutY(45);  // Τοποθέτηση του κουμπιού Next στη θέση Y
        nextButton.setOnAction(_ -> {
            try {
                double budget = Double.parseDouble(budgetTextField.getText());
                user.setMaxMonthlyCost(budget);
                errorLabel.setText("");  // Καθαρίζει το μήνυμα λάθους αν είναι σωστός ο αριθμός
                showPhase(phase5);  // Πηγαίνει στην επόμενη φάση (φάση 5)
            } catch (NumberFormatException ex) {
                errorLabel.setText("Invalid number. Please enter a positive number.");
                errorLabel.setLayoutX(140);
                errorLabel.setLayoutY(-60);
                errorLabel.setFont(Font.font("Arial", FontWeight.BOLD, 11));
                errorLabel.setStyle(" -fx-text-fill: red;");
            }
        });
    
        Button backButton = new Button("Back");
        backButton.setLayoutX(40);  // Τοποθέτηση του κουμπιού Previous στη θέση X
        backButton.setLayoutY(45); // Τοποθέτηση του κουμπιού Previous στη θέση Y
        backButton.setOnAction(_ -> showPhase(phase3));
    
        // Προσθήκη στοιχείων στο Phase
        phase.getChildren().addAll(label, budgetTextField, errorLabel, nextButton, backButton);
    
        return phase;
    }
    
    private Pane createPhase5() {
        Pane phase = new Pane();  // Χρησιμοποιούμε Pane για ακριβή τοποθέτηση
        phase.setPrefWidth(40);
        phase.setPrefHeight(300);
        // Ετικέτα επεξήγησης
        Label label = new Label("Choose whether or not you want to have a roommate:");
        label.setLayoutX(23);  // Τοποθέτηση της ετικέτας στη θέση X
        label.setLayoutY(-180);  // Τοποθέτηση της ετικέτας στη θέση Y
        label.setFont(Font.font("Arial", FontWeight.BOLD, 14));
    



        Image upImage = new Image("file:C:/Users/dim/JAVA/prog_II_project/Maven_Structure_dmstplus/src/main/resources/photos/up.jpg");
        ImageView upImageView = new ImageView(upImage);
        upImageView.setFitWidth(50);  // Ρυθμίζουμε το πλάτος της εικόνας
        upImageView.setFitHeight(50); // Ρυθμίζουμε το ύψος της εικόνας
        upImageView.setPreserveRatio(true); // Διατηρούμε τις αναλογίες της εικόνας
    
        Button upButton = new Button();
        upButton.setLayoutX(110);
        upButton.setLayoutY(-110);
        upButton.setPrefWidth(50);
        upButton.setPrefHeight(50);
        upButton.setGraphic(upImageView);
        upButton.setOnAction(_ -> user.setSharedAccomondation(true));



        Image downImage = new Image("file:C:/Users/dim/JAVA/prog_II_project/Maven_Structure_dmstplus/src/main/resources/photos/down.jpg");
        ImageView downImageView = new ImageView(downImage);
        downImageView.setFitWidth(50);  // Ρυθμίζουμε το πλάτος της εικόνας
        downImageView.setFitHeight(50); // Ρυθμίζουμε το ύψος της εικόνας
        downImageView.setPreserveRatio(true); // Διατηρούμε τις αναλογίες της εικόνας
    
        Button downButton = new Button();
        downButton.setLayoutX(220);
        downButton.setLayoutY(-110);
        downButton.setPrefWidth(50);
        downButton.setPrefHeight(55);
        downButton.setGraphic(downImageView);
        downButton.setOnAction(_ -> user.setSharedAccomondation(false));

        // Κουμπιά Next και Previous
        Button nextButton = new Button("Next");
        nextButton.setLayoutX(320);  // Τοποθέτηση του κουμπιού Next στη θέση X
        nextButton.setLayoutY(5);  // Τοποθέτηση του κουμπιού Next στη θέση Y
        nextButton.setOnAction(_ -> showPhase(phase6));
    
        Button backButton = new Button("Back");
        backButton.setLayoutX(40);   // Τοποθέτηση του κουμπιού Previous στη θέση X
        backButton.setLayoutY(5);  // Τοποθέτηση του κουμπιού Previous στη θέση Y
        backButton.setOnAction(_ -> showPhase(phase4));
    
        // Προσθήκη στοιχείων στο Phase
        phase.getChildren().addAll(label, upButton, downButton, nextButton, backButton);
    
        return phase;
    }
    

    private Pane createPhase6() {
        Pane phase = new Pane();
        phase.setPrefWidth(400);
        phase.setPrefHeight(300);
    
        messageLabel = new Label();
    
        // Λίστα με τα πανεπιστήμια
        uniMatches = new ListView<University>();

        uniMatches.setCellFactory(list -> new ListCell<University>() {
            private final Hyperlink link = new Hyperlink();
            {
                link.setOnAction(evt -> {
                    University u = getItem();
                    if (u != null && u.getPdfLink() != null && !u.getPdfLink().isEmpty()) {
                        try {
                            Desktop.getDesktop().open(new File(u.getPdfLink()));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
            @Override
            protected void updateItem(University item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                    setText(null);
                } else {
                    link.setText(item.getUniName());
                    setGraphic(link);
                    setText(null);
                }
            }
        });
        

        uniMatches.setLayoutX(110);  // Τοποθέτηση του ListView στη θέση X
        uniMatches.setLayoutY(-250);
        uniMatches.setPrefSize(250, 150);
    
        // Κουμπί για την εμφάνιση των αποτελεσμάτων
        Button showMatchesButton = new Button("Results!");
        showMatchesButton.setLayoutX(200);  // Τοποθέτηση του κουμπιού στη θέση X
        showMatchesButton.setLayoutY(-60);  // Τοποθέτηση του κουμπιού στη θέση Y
        showMatchesButton.setOnAction(_ -> {

            Pair<List<University>, List<University>> matches = uniData.letsGoErasmus(user);
            List<University> firstList = matches.getKey();
            List<University> secondList = matches.getValue();
            
            // Έλεγχος αν υπάρχουν αποτελέσματα
            if (firstList.isEmpty() && secondList.isEmpty()) {
                messageLabel.setText("There are no universities that match your preferences 😢");
                messageLabel.setLayoutX(25);
                messageLabel.setLayoutY(-125);
                messageLabel.setFont(Font.font("Arial", FontWeight.BOLD, 13));
    
                phase.getChildren().addAll(messageLabel);
            } else {
                // Ελέγχουμε αν υπάρχουν πανεπιστήμια που ταιριάζουν με την περίοδο
                if (!secondList.isEmpty()) {
                    Text text1 = new Text("We found some universities that match your preferences");
                    text1.setLayoutX(50);
                    text1.setLayoutY(-240);
    
                    Text text2 = new Text("but do not match the period you chose:");
                    text2.setLayoutX(50);
                    text2.setLayoutY(-225);
    
                    // Ενημερώνουμε τη λίστα με τα πανεπιστήμια
                    uniMatches.setItems(FXCollections.observableArrayList(secondList));
                    uniMatches.setLayoutX(80);
                    uniMatches.setLayoutY(-220);
    
                    phase.getChildren().addAll(text1, text2, uniMatches);
    
                } else {
                    messageLabel.setText("The following universities were found: ");
                    messageLabel.setLayoutX(80);
                    messageLabel.setLayoutY(-250);
    
                    // Ενημερώνουμε τη λίστα με τα πανεπιστήμια που ταιριάζουν απόλυτα
                    uniMatches.setItems(FXCollections.observableArrayList(firstList));
                    uniMatches.setLayoutX(80);
                    uniMatches.setLayoutY(-220);
    
                    phase.getChildren().addAll(uniMatches, messageLabel);
                }
            }
            showMatchesButton.setDisable(true);
            
        });
    
        // Κουμπί Previous
        Button backButton = new Button("Back");
        backButton.setLayoutX(40);
        backButton.setLayoutY(-20);
        backButton.setOnAction(_ -> showPhase(phase5));
    
        // Προσθήκη στοιχείων στο Phase
        phase.getChildren().addAll(showMatchesButton, backButton);
    
        return phase;
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
