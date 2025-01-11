package com.dmstplus;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Callback;
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

/**
 * Η κλάση App είναι η κύρια κλάση της εφαρμογής DMST+ Erasmus.
 * Επεκτείνει την κλάση Application (JavaFX) και είναι υπεύθυνη
 * για τη δημιουργία και εμφάνιση όλων των γραφικών διεπαφών (GUI) μέσω JavaFX.
 */
public class App extends Application {

    /**
     * Αντιπροσωπεύει τον τρέχοντα χρήστη, όπου αποθηκεύονται
     * όλες οι προτιμήσεις και τα προσωπικά του στοιχεία.
     */
    private User user = new User();

    /**
     * Φορτώνει δεδομένα για πανεπιστήμια, γλώσσες, κ.λπ.
     * από τη βοηθητική κλάση UniData.
     */
    private UniData uniData = new UniData();

    /**
     * Πίνακες (Pane) που παριστάνουν τις διαφορετικές φάσεις (Phases) της εφαρμογής.
     */
    private Pane phaseInfo, phaseCv, phase0, phase1, phase2, phase3, phase4, phase5, phase6;

    /**
     * ListView για την εμφάνιση και επιλογή γλωσσών.
     */
    private ListView<String> languagesListView;

    /**
     * ListView για την εμφάνιση και επιλογή χωρών.
     */
    private ListView<String> countriesListView;

    /**
     * ListView για την εμφάνιση της λίστας των προτεινόμενων πανεπιστημίων.
     */
    private ListView<University> uniMatches;

    /**
     * Πεδία κειμένου TextFields ή Label για να εμφανίζονται 
     * και να λαμβάνονται τιμές/μηνύματα από τον χρήστη.
     */
    private TextField budgetTextField;
    private Label messageLabel, errorLabel;

    /**
     * Σημείο εκκίνησης της JavaFX εφαρμογής.
     * Υλοποιεί τη μέθοδο start, δημιουργώντας τη σκηνή (Scene)
     * και ορίζοντας το αρχικό μέγεθος του παραθύρου.
     *
     * Το primaryStage  κύριο Stage που παρέχει η πλατφόρμα JavaFX.
     */
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(createMainLayout(), 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("DMST+ ERASMUS");
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.setFullScreen(false);
    }

    /**
     * Δημιουργεί ένα νέο Pane με προκαθορισμένο πλάτος και ύψος,
     * ώστε να χρησιμοποιείται από τις διάφορες φάσεις της εφαρμογής.
     *
     * Επιστρέφει Ένα Pane με πλάτος 400px και ύψος 300px.
     */
    private Pane createPane() {
        Pane pane = new Pane();
        pane.setPrefWidth(400);
        pane.setPrefHeight(300);
        return pane;
    }

    /**
     * Δημιουργεί ένα VBox που περιέχει όλες τις φάσεις (Pane) της εφαρμογής.
     * Αρχικά ορίζει το στυλ του VBox και έπειτα δημιουργεί και προσθέτει
     * τα Pane (phaseInfo, phaseCv, phase0, κ.λπ.) σε ένα κοινό container.
     *
     * @return Το VBox το οποίο περιέχει όλες τις φάσεις του προγράμματος.
     */
    private VBox createMainLayout() {
        VBox mainLayout = new VBox();
        mainLayout.setStyle("-fx-background-color:rgba(135, 198, 234, 0.88);");

        phaseInfo = erInfo();
        phaseCv = cvHelper();
        phase0 = createPhase0();
        phase1 = createPhase1();
        phase2 = createPhase2();
        phase3 = createPhase3();
        phase4 = createPhase4();
        phase5 = createPhase5();
        phase6 = createPhase6();

        mainLayout.getChildren().addAll(
            phaseInfo, phaseCv, phase0, phase1,
            phase2, phase3, phase4, phase5, phase6
        );

        showPhase(phase0);

        return mainLayout;
    }

    /**
     * Ελέγχει ποια φάση (Pane) θα εμφανιστεί ορατή, ενώ
     * κρύβει όλες τις υπόλοιπες. Μηχανισμός εναλλαγής μεταξύ οθονών.
     */
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

    /**
     * PHASE 0
     * 
     * Η αρχική φάση (phase0) που εμφανίζει ένα καλωσόρισμα
     * και δίνει πρόσβαση σε επιπλέον επιλογές (π.χ. δημιουργία CV, info, apply).
     * Επεξήγηση των επιλογών MENU:
     *      Δημιουργία CV: Σου εμφανίζει έναν πίνακα με ένα κειμενάκι όπου περιέχει συμβουλές για το πώς να 
     *                     φτιάξεις το βιοφραφικό σου για την αίτηση σου για ERASMUS. (Δίνεται και η επιλογή 
     *                     να κατεβάσεις το αρχείο PDF με το κείμενο αυτό)
     *      Πληροφορίες για τις φόρμες ERASMUS: Σου δίνει την επιλογή να κατεβάσεις όλα τα απαράιτητα αρχεία 
     *                                          που πρέπει να συμπληρωθούν για την υποβολή της αίτησης σου
     *      Αίτηση: Σου ανοίγει τον σύνδεσμο που θα υποβάλλεις την αίτηση σου.
     */
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
            cv.setOnAction(_ -> showPhase(phaseCv));

            Button info = new Button("Erasmus Info");
            info.setLayoutX(170);
            info.setLayoutY(190);
            info.setOnAction(_ -> showPhase(phaseInfo));

            Button apply = new Button("Apply");
            apply.setLayoutX(270);
            apply.setLayoutY(190);
            apply.setOnAction(_ -> {
                try {
                    String url = "https://www.dept.aueb.gr/en/dmst/programme-erasmus-student-application-form-dmst";
                    Desktop.getDesktop().browse(new java.net.URI(url));
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

    /**
     * BUILD YOUR CV / PHASE 
     * 
     * Φάση που δίνει στον χρήστη οδηγίες και παράδειγμα δημιουργίας ενός CV.
     * Παρέχεται επίσης η δυνατότητα λήψης ενός προτύπου CV σε μορφή PDF.
     *
     * (Ένα Pane που παρέχει χρήσιμες πληροφορίες για τη δημιουργία βιογραφικού.)
     */
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

        listView.getItems().addAll(textLines);
        listView.setPrefSize(390, 200);
        listView.setLayoutX(5);
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

    /**
     * ERASMUS Information regarding the Application / PHASE
     * 
     * Φάση που εμφανίζει πληροφορίες (σε μορφή κουμπιών) για τη λήψη
     * διάφορων εντύπων και εγγράφων που αφορούν το Erasmus (π.χ. συμφωνίες) μέσω της μεθόδου downloadAndOpen.
     *
     * (Επιστρέφει ένα Pane με κουμπιά για λήψη αρχείων και κουμπί επιστροφής.)
     */
    private Pane erInfo() {
        Pane phase = createPane();
        phase.setPrefWidth(400);
        phase.setPrefHeight(300);

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

        phase.getChildren().addAll(text1, text2, text4, text5, button1, button2, button4, button5, backButton);
        return phase;
    }

    /**
     * Κατεβάζει και ανοίγει το αρχείο που βρίσκεται στη διεύθυνση fileUrl,
     * αποθηκεύοντάς το στους Downloads του τρέχοντος χρήστη.
     * Χρησιμοποιεί HttpURLConnection για το κατέβασμα και την κλάση Desktop για το άνοιγμα.
     *
     * (Ανοίγει το URL από το οποίο θα κατέβει το αρχείο.)
     */
    private void downloadAndOpen(String fileUrl) {
        try {
            URL url = new URL(fileUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            String userHome = System.getProperty("user.home");
            String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
            Path destinationPath = Path.of(userHome, "Downloads", fileName);

            try (InputStream in = connection.getInputStream();
                 OutputStream out = new FileOutputStream(destinationPath.toFile())) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
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

    /**
     * PHASE 1
     * 
     * Φάση όπου ο χρήστης επιλέγει την περίοδο (Spring / Winter) που τον ενδιαφέρει.
     * Οι επιλογές γίνονται μέσω δύο γραφικών κουμπιών με εικόνες.
     *
     * (ένα Pane που περιέχει τα κουμπιά για την επιλογή της περιόδου και κουμπιά πλοήγησης.)
     */
    private Pane createPhase1() {
        Pane phase = createPane();
        phase.setPrefWidth(400);
        phase.setPrefHeight(300);

        Label label = new Label("Choose which period you prefer:");
        label.setLayoutX(80);
        label.setLayoutY(0);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 15));

        Image springImage = new Image("file:C:/Users/dim/JAVA/prog_II_project/Maven_Structure_dmstplus/src/main/resources/photos/summer.jpg");
        ImageView springImageView = new ImageView(springImage);
        springImageView.setFitWidth(50);
        springImageView.setFitHeight(50);
        springImageView.setPreserveRatio(true);

        Button springButton = new Button();
        springButton.setLayoutX(110);
        springButton.setLayoutY(40);
        springButton.setGraphic(springImageView);
        springButton.setOnAction(_ -> user.setPreferredPeriod("Spring"));

        Image winterImage = new Image("file:C:/Users/dim/JAVA/prog_II_project/Maven_Structure_dmstplus/src/main/resources/photos/winter.jpg");
        ImageView winterImageView = new ImageView(winterImage);
        winterImageView.setFitWidth(50);
        winterImageView.setFitHeight(50);
        winterImageView.setPreserveRatio(true);

        Button winterButton = new Button();
        winterButton.setLayoutX(220);
        winterButton.setLayoutY(40);
        winterButton.setGraphic(winterImageView);
        winterButton.setOnAction(_ -> user.setPreferredPeriod("Winter"));

        Button nextButton = new Button("Next");
        nextButton.setLayoutX(320);
        nextButton.setLayoutY(160);
        nextButton.setOnAction(_ -> showPhase(phase2));

        Button backButton = new Button("Back");
        backButton.setLayoutX(40);
        backButton.setLayoutY(160);
        backButton.setOnAction(_ -> showPhase(phase0));

        phase.getChildren().addAll(label, springButton, winterButton, nextButton, backButton);
        return phase;
    }

    /**
     * Φάση όπου ο χρήστης επιλέγει γλώσσες που γνωρίζει. Περιλαμβάνει ListView
     * με CheckBox για επιλογή πολλών γλωσσών χωρίς χρήση Ctrl/Shift (δηλαδή με τη βοήθεια του SelectionMode.MULTIPLE).
     *
     * (Επιστρέφει ένα Pane που περιέχει τη λίστα επιλογής γλωσσών και κουμπιά πλοήγησης).
     */
    private Pane createPhase2() {
        Pane phase = createPane();
        phase.setPrefWidth(400);
        phase.setPrefHeight(300);

        Label label = new Label("Choose the languages ​​you know:");
        label.setLayoutX(140);
        label.setLayoutY(-70);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 15));

        Circle clipCircle = new Circle(1000);
        clipCircle.setCenterX(10);
        clipCircle.setCenterY(-110);

        Circle backgroundCircle = new Circle(125);
        backgroundCircle.setFill(Color.WHITE);
        backgroundCircle.setCenterX(0);
        backgroundCircle.setCenterY(-10);

        Image phase2Image = new Image("file:C:\\Users\\dim\\JAVA\\prog_II_project\\Maven_Structure_dmstplus\\src\\main\\resources\\photos\\phase2.jpg");
        ImageView imageView = new ImageView(phase2Image);
        imageView.setFitWidth(80);
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

        languagesListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        languagesListView.setCellFactory(
            CheckBoxListCell.<String>forListView(new Callback<String, ObservableValue<Boolean>>() {
                @Override
                public ObservableValue<Boolean> call(String item) {
                    BooleanProperty observable = new SimpleBooleanProperty(false);
                    observable.addListener((_, _, isNowSelected) -> {
                        if (isNowSelected) {
                            languagesListView.getSelectionModel().select(item);
                        } else {
                            languagesListView.getSelectionModel().clearSelection(
                                languagesListView.getItems().indexOf(item)
                            );
                        }
                    });
                    return observable;
                }
            })
        );

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

        phase.getChildren().addAll(label, languagesListView, nextButton, backButton);
        return phase;
    }

    /**
     * Φάση για την επιλογή χωρών προτίμησης. Χρησιμοποιείται CheckBoxListCell
     * για εύκολη πολλαπλή επιλογή (ListView με checkboxes).
     *
     * (Επιστρέφει ένα Pane που περιέχει τη λίστα χωρών και κουμπιά πλοήγησης.)
     */
    private Pane createPhase3() {
        Pane phase = new Pane();
        phase.setPrefWidth(400);
        phase.setPrefHeight(300);

        Circle clipCircle = new Circle(1000);
        clipCircle.setCenterX(10);
        clipCircle.setCenterY(-140);

        Circle backgroundCircle = new Circle(130);
        backgroundCircle.setFill(Color.WHITE);
        backgroundCircle.setCenterX(0);
        backgroundCircle.setCenterY(-40);

        Image phase3Image = new Image("file:C:\\Users\\dim\\JAVA\\prog_II_project\\Maven_Structure_dmstplus\\src\\main\\resources\\photos\\phase3.jpg");
        ImageView imageView = new ImageView(phase3Image);
        imageView.setFitWidth(80);
        imageView.setFitHeight(80);
        imageView.setLayoutX(20);
        imageView.setLayoutY(-80);
        imageView.setPreserveRatio(true);
        imageView.setClip(clipCircle);

        phase.getChildren().addAll(backgroundCircle, imageView);

        Label label = new Label("Choose which countries you would prefer to go to:");
        label.setLayoutX(120);
        label.setLayoutY(-100);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 11.5));

        countriesListView = new ListView<>(FXCollections.observableArrayList(uniData.getCountries()));
        countriesListView.setLayoutX(160);
        countriesListView.setLayoutY(-60);
        countriesListView.setPrefWidth(200);
        countriesListView.setPrefHeight(130);

        countriesListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        countriesListView.setCellFactory(
            CheckBoxListCell.<String>forListView(new Callback<String, ObservableValue<Boolean>>() {
                @Override
                public ObservableValue<Boolean> call(String item) {
                    BooleanProperty observable = new SimpleBooleanProperty(false);
                    observable.addListener((_, _, isNowSelected) -> {
                        if (isNowSelected) {
                            countriesListView.getSelectionModel().select(item);
                        } else {
                            countriesListView.getSelectionModel().clearSelection(
                                countriesListView.getItems().indexOf(item)
                            );
                        }
                    });
                    return observable;
                }
            })
        );

        Button nextButton = new Button("Next");
        nextButton.setLayoutX(320);
        nextButton.setLayoutY(90);
        nextButton.setOnAction(_ -> {
            user.setPreferredCountry(countriesListView.getSelectionModel().getSelectedItems());
            showPhase(phase4);
        });

        Button backButton = new Button("Back");
        backButton.setLayoutX(40);
        backButton.setLayoutY(90);
        backButton.setOnAction(_ -> showPhase(phase2));

        phase.getChildren().addAll(label, countriesListView, nextButton, backButton);
        return phase;
    }

    /**
     * Φάση όπου ο χρήστης καλείται να εισάγει το ποσό που προτίθεται να ξοδεύει 
     * μηνιαία κατά τη διάρκεια του Erasmus. Χρησιμοποιεί TextField και έλεγχο εγκυρότητας.
     *
     * (Επιστρέφει ένα Pane για την καταχώρηση ποσού και κουμπιά πλοήγησης.)
     */
    private Pane createPhase4() {
        Pane phase = new Pane();
        phase.setPrefWidth(400);
        phase.setPrefHeight(300);

        Circle clipCircle = new Circle(1000);
        clipCircle.setCenterX(10);
        clipCircle.setCenterY(-100);

        Circle backgroundCircle = new Circle(125);
        backgroundCircle.setFill(Color.WHITE);
        backgroundCircle.setCenterX(0);
        backgroundCircle.setCenterY(-80);

        Image image = new Image("file:C:\\Users\\dim\\JAVA\\prog_II_project\\Maven_Structure_dmstplus\\src\\main\\resources\\photos\\phase4.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(80);
        imageView.setFitHeight(80);
        imageView.setLayoutX(20);
        imageView.setLayoutY(-120);
        imageView.setPreserveRatio(true);
        imageView.setClip(clipCircle);

        phase.getChildren().addAll(backgroundCircle, imageView);

        Label label = new Label("Write the amount you are willing to spend monthly:");
        label.setLayoutX(120);
        label.setLayoutY(-140);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 11.4));

        budgetTextField = new TextField();
        budgetTextField.setLayoutX(175);
        budgetTextField.setLayoutY(-90);
        budgetTextField.setPrefWidth(150);

        errorLabel = new Label();
        errorLabel.setLayoutX(50);
        errorLabel.setLayoutY(80);

        Button nextButton = new Button("Next");
        nextButton.setLayoutX(320);
        nextButton.setLayoutY(45);
        nextButton.setOnAction(_ -> {
            try {
                double budget = Double.parseDouble(budgetTextField.getText());
                user.setMaxMonthlyCost(budget);
                errorLabel.setText("");
                showPhase(phase5);
            } catch (NumberFormatException ex) {
                errorLabel.setText("Invalid number. Please enter a positive number.");
                errorLabel.setLayoutX(140);
                errorLabel.setLayoutY(-60);
                errorLabel.setFont(Font.font("Arial", FontWeight.BOLD, 11));
                errorLabel.setStyle(" -fx-text-fill: red;");
            }
        });

        Button backButton = new Button("Back");
        backButton.setLayoutX(40);
        backButton.setLayoutY(45);
        backButton.setOnAction(_ -> showPhase(phase3));

        Label infoLabel = new Label("(Answer after checking the monthly grants by country)");
        infoLabel.setLayoutX(130);
        infoLabel.setLayoutY(-45);
        infoLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 11));
        infoLabel.setStyle("-fx-text-fill: black;");

        Button monthlyGrantButton = new Button("Monthly Grant");
        monthlyGrantButton.setLayoutX(180);
        monthlyGrantButton.setLayoutY(-20);
        monthlyGrantButton.setOnAction(_ -> {
            try {
                java.awt.Desktop.getDesktop().browse(new java.net.URI("https://aueb.gr/el/erasmus/mobility/content/plirofories-ana-akadimaiko-etos"));
            } catch (Exception e) {
                errorLabel.setText("Failed to open the link. Please try again.");
                errorLabel.setStyle(" -fx-text-fill: red;");
            }
        });
    
        phase.getChildren().addAll(label, infoLabel, budgetTextField, errorLabel, nextButton, backButton, monthlyGrantButton);
        return phase;
    }

    /**
     * Φάση όπου ο χρήστης καλείται να επιλέξει αν επιθυμεί να συγκατοικεί 
     * (shared accommodation) ή όχι. Οι επιλογές δίνονται μέσω κουμπιών με εικόνες.
     *
     * (Επιστρέφει ένα Pane που περιέχει τις επιλογές συγκατοίκησης και κουμπιά πλοήγησης.)
     */
    private Pane createPhase5() {
        Pane phase = new Pane();
        phase.setPrefWidth(40);
        phase.setPrefHeight(300);

        Label label = new Label("Choose whether or not you want to have a roommate:");
        label.setLayoutX(23);
        label.setLayoutY(-180);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        Image upImage = new Image("file:C:/Users/dim/JAVA/prog_II_project/Maven_Structure_dmstplus/src/main/resources/photos/up.jpg");
        ImageView upImageView = new ImageView(upImage);
        upImageView.setFitWidth(50);
        upImageView.setFitHeight(50);
        upImageView.setPreserveRatio(true);

        Button upButton = new Button();
        upButton.setLayoutX(110);
        upButton.setLayoutY(-110);
        upButton.setPrefWidth(50);
        upButton.setPrefHeight(50);
        upButton.setGraphic(upImageView);
        upButton.setOnAction(_ -> user.setSharedAccomondation(true));

        Image downImage = new Image("file:C:/Users/dim/JAVA/prog_II_project/Maven_Structure_dmstplus/src/main/resources/photos/down.jpg");
        ImageView downImageView = new ImageView(downImage);
        downImageView.setFitWidth(50);
        downImageView.setFitHeight(50);
        downImageView.setPreserveRatio(true);

        Button downButton = new Button();
        downButton.setLayoutX(220);
        downButton.setLayoutY(-110);
        downButton.setPrefWidth(50);
        downButton.setPrefHeight(55);
        downButton.setGraphic(downImageView);
        downButton.setOnAction(_ -> user.setSharedAccomondation(false));

        Button nextButton = new Button("Next");
        nextButton.setLayoutX(320);
        nextButton.setLayoutY(5);
        nextButton.setOnAction(_ -> showPhase(phase6));

        Button backButton = new Button("Back");
        backButton.setLayoutX(40);
        backButton.setLayoutY(5);
        backButton.setOnAction(_ -> showPhase(phase4));

        phase.getChildren().addAll(label, upButton, downButton, nextButton, backButton);
        return phase;
    }

    /**
     * Τελική φάση που εμφανίζει τα αποτελέσματα των πανεπιστημίων
     * που ταιριάζουν (ή εν μέρει ταιριάζουν) στις προτιμήσεις του χρήστη.
     * Μέσω ενός Hyperlink μπορεί ο χρήστης να ανοίξει σχετικό PDF.
     *
     * (Επιστρέφει ένα Pane που περιέχει τη λίστα των τελικών πανεπιστημίων.)
     */
    private Pane createPhase6() {
        Pane phase = new Pane();
        phase.setPrefWidth(400);
        phase.setPrefHeight(300);

        messageLabel = new Label();
        uniMatches = new ListView<>();

        uniMatches.setCellFactory(_ -> new ListCell<University>() {
            private final Hyperlink link = new Hyperlink();
            {
                link.setOnAction(_ -> {
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

        uniMatches.setLayoutX(110);
        uniMatches.setLayoutY(-250);
        uniMatches.setPrefSize(250, 150);

        Button showMatchesButton = new Button("Results!");
        showMatchesButton.setLayoutX(170);
        showMatchesButton.setLayoutY(-60);
        showMatchesButton.setOnAction(_ -> {
            TripleList<List<University>, List<University>, List<University>> matches = uniData.letsGoErasmus(user);
            List<University> firstList = matches.getFirst(); // uni_match
            List<University> secondList = matches.getSecond(); // uni_match_p
            List<University> thirdList = matches.getThird();  // uni_match_l
            List<University> combinedList_l = new ArrayList<>();  // uni_match + uni_match_l 
            List<University> combinedList_l_p = new ArrayList<>(); //  uni_match_p + uni_match_l
        
            combinedList_l.addAll(firstList);
            combinedList_l.addAll(thirdList);

            combinedList_l_p.addAll(secondList);
            combinedList_l_p.addAll(thirdList); 
            
        
            if (firstList.isEmpty() && secondList.isEmpty() && thirdList.isEmpty()) {
                messageLabel.setText("There are no universities that match your preferences 😢");
                messageLabel.setLayoutX(25);
                messageLabel.setLayoutY(-125);
                messageLabel.setFont(Font.font("Arial", FontWeight.BOLD, 13));
                phase.getChildren().addAll(messageLabel);

            } else if(secondList.isEmpty() && firstList.isEmpty()) {
                messageLabel.setText("The following universities were found: ");
                messageLabel.setLayoutX(80);
                messageLabel.setLayoutY(-250);

                uniMatches.setItems(FXCollections.observableArrayList(thirdList));
                uniMatches.setLayoutX(80);
                uniMatches.setLayoutY(-220);    

                phase.getChildren().addAll(uniMatches, messageLabel);      
            } else {
                if (!secondList.isEmpty()) {
                    Text text1 = new Text("We found some universities that match your preferences");
                    text1.setLayoutX(50);
                    text1.setLayoutY(-240);

                    Text text2 = new Text("but do not match the period you chose:");
                    text2.setLayoutX(50);
                    text2.setLayoutY(-225);

                    uniMatches.setItems(FXCollections.observableArrayList(combinedList_l_p));
                    uniMatches.setLayoutX(80);
                    uniMatches.setLayoutY(-220);

                    phase.getChildren().addAll(text1, text2, uniMatches);
                } else {
                    messageLabel.setText("The following universities were found: ");
                    messageLabel.setLayoutX(80);
                    messageLabel.setLayoutY(-250);

                    uniMatches.setItems(FXCollections.observableArrayList(combinedList_l));
                    uniMatches.setLayoutX(80);
                    uniMatches.setLayoutY(-220);

                    phase.getChildren().addAll(uniMatches, messageLabel);
                }
            }
            showMatchesButton.setDisable(true);
        });

        Button backButton = new Button("Back");
        backButton.setLayoutX(40);
        backButton.setLayoutY(-20);
        backButton.setOnAction(_ -> showPhase(phase5));

        phase.getChildren().addAll(showMatchesButton, backButton);
        return phase;
    }

    /**
     * Μέθοδος main: Σημείο εκκίνησης για την εκτέλεση της εφαρμογής.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
