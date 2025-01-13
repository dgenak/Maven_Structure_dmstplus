# DMSTPLUS
  Η εφαρμογή dmstplus είναι μια εφαρμογή που υποστηρίζει φοιτητές του τμήματος Διοικητικής Επιστήμης και Τεχνολογίας (DMST) 
  που επιθυμούν να συμμετάσχουν στο πρόγραμμα Erasmus. Ο κύριος στόχος της είναι να διευκολύνει τη διαδικασία επιλογής πανεπιστημίων, 
  δημιουργίας βιογραφικού και υποβολής αίτησης.

# ΟΔΗΓΙΕΣ ΜΕΤΑΓΛΩΤΤΙΣΗΣ ΤΟΥ ΠΡΟΓΡΑΜΜΑΤΟΣ

  ΒΗΜΑ 1
    Ανοίξτε το τερματικό Cygwin και πηγαίνετε στον φάκελο του έργου (Maven_Structure_dmstplus) μέσω της εντολής: 
          
    cd /cygdrive/c/Users/dim/JAVA/prog_II_project/Maven_Structure_dmstplus
        
  ΒΗΜΑ 2 
    Καθαρίστε τα προηγούμενα build αρχεία και δημιουργήστε ένα νέο εκτελέσιμο αρχείο μέσω της εντολής: 
    
    mvn clean package

# ΟΔΗΓΙΕΣ ΕΚΤΕΛΕΣΗΣ ΤΟΥ ΠΡΟΓΡΑΜΜΑΤΟΣ

Αφού έχετε πραγματοποιήσει να προηγούμενα βήματα, μπορείτε να εκτελέσετε το πρόγραμμα με δυο εντολές:
  Εντολή 1: 
              
    mvn exec:java
  Αν για κάποιο λόγο δεν δουλέψει η πρώτη εντολή τότε μπορείτε να δοκιμάσετε και αυτή που είναι πιο συγκεκριμένη
  Εντολή 2:   
  
    java --module-path "C:\Users\dim\JAVA\JavaFX\openjfx-23.0.1_windows-x64_bin-sdk\javafx-sdk-23.0.1\lib" --add-               modules javafx.controls,javafx.fxml -jar target/dmstplus-1.0-SNAPSHOT.jar

# ΟΔΗΓΙΕΣ ΧΡΗΣΗΣ ΤΟΥ ΠΡΟΓΡΑΜΜΑΤΟΣ

  Για να ξεκινήσει η διαδικασία εύρεσης των πανεπιστημίων που σας ταιριάζουν πατήστε το κουμπί Let's Start και απαντήστε στις ερωτήσεις που θα σας εμφανιστούν. Για 
  παράδειγμα: θα σας ζητηθεί να εκχωρείσετε το ποσό που είστε διατεθιμένοι να δαπανάτε μηνιαία, στη περίπτωση αυτή θα απαντήσετε αφού πατήσετε το κουμπί Monthly Grant 
  και ενημερωθείτε για τις μηνιαίες επιχορηγήσεις που θα λαμβάνεται.

  (ΠΡΟΣΟΧΗ: Όταν σας ζητηθεί σε ερωτήματα να απαντήσετε, επιλέγοντας αντικείμενα λιστών κάντε double click στο τετραγωνάκι του συγκεκριμένου αντικειμένου για να επιβεβαιώσετε     την απάντηση σας.)

  Αν είστε έτοιμοι να προχωρήσετε στην επόμενη σελίδα πατήστε το κουμπί Next ενώ αν θέλετε να πάτε σε προηγούμενη σελίδα πατήστε το κουμπί Back
  
  Αν είστε έτοιμοι για να υποβάλλεται αίτηση τότε πατήστε το κουμπί Menu. Θα σας εμφανιστούν 3 νέα κουμπιά: 
      - Το Build your CV, όπου πατώντας το, σας εμφανίζεται ένας πίνακας με συμβουλές για το πώς να οργανώσετε το βιογραφικό σας (δίνεται επίσης η επιλογή λήψης του           
        αντίστοιχου κειμένου σε μορφή PDF), έτσι ώστε να αυξηθούν οι πιθανότητες να γίνεται δεκτοί 
      - το Erasmus Info, όπου σας παρέχει την δυνατότητα λήψης των απαραίτητων εγγράφων, για την υποβολή της αίτησης σας 
      - και το Apply, που σε κατευθύνει στην ιστοσελίδα της σχολής και συγκεκριμένα στο σημείο που υποβάλλεις την αίτηση σου.


# ΔΟΜΗ ΠΕΡΙΕΧΟΜΕΝΩΝ
  - src/main/java/com/dmstplus: Ο πηγαίος κώδικας της εφαρμογής.
  - src/test/java/com/dmstplus: Κώδικας για δοκιμές (junit tests) για τις αντίστοιχες λειτουργίες.
  - docs/javadoc: Οι τεκμηριώσεις των κλάσεων μέσω Javadoc.
  - resources/PDF: Αρχεία PDF που σχετίζονται με πανεπιστήμια.
  - resources/UniPDFs: Αρχεία PDF με πληροφορίες για πανεπιστήμια.
  - resources/photos: Εικόνες που χρησιμοποιούνται στην εφαρμογή.
  - lib: Βιβλιοθήκες JAR για το JavaFX framework.
  - pom.xml: Διαμόρφωση και εξαρτήσεις για την κατασκευή της εφαρμογής μέσω Maven.
  - target: Φάκελος με το παραγόμενο JAR αρχείο, τα μεταγλωττισμένα αρχεία κλάσεων, και τις αναφορές από τις δοκιμές (surefire-reports).

# ΔΙΑΓΡΑΜΜΑ UML

```mermaid
classDiagram
    Download --> App : used by
    App --> User : manages
    App --> UniData : loads data from
    User --> University : interacts with
    User --> UniData : interacts with
    User --> CostOfLiving : interacts with
    UniData --> University : gets
    UniData --> Countries : interacts with
    UniData --> TripleList : uses
    UniData --> Languages : contains
    University --> CostOfLiving : calculates
    TripleList --> Countries : supports
    TripleList --> University : supports
    TripleList --> University : supports
    Countries --> UniData : uses
    Languages --> UniData : uses

    class Download {
        +void downloadPdf(String)
    }

    class App {
        -User user
        -UniData uniData
        -ListView~String~ languagesListView
        -ListView~String~ countriesListView
        -ListView~University~ uniMatches
        +void start(Stage)
        +void createMainLayout()
        +void showPhase(Pane)
    }

    class User {
        -List~String~ userLanguages
        -String preferredPeriod
        -List~String~ preferredCountry
        -double maxMonthlyCost
        -boolean isSharedAccommodation
        +List~String~ getUserLanguages()
        +String getPreferredPeriod()
        +List~String~ getPreferredCountry()
        +double getMaxMonthlyCost()
        +boolean isSharedAccommodation()
        +void setUserLanguages(List~String~)
        +void setPreferredPeriod(String)
        +void setPreferredCountry(List~String~)
        +void setMaxMonthlyCost(double)
        +void setSharedAccommodation(boolean)
    }

    class UniData {
        -List~String~ countries
        -List~Languages~ languages
        -List~CostOfLiving~ costpermonth
        +List~String~ getCountries()
        +List~University~ getUniversities()
        +List~CostOfLiving~ getAmount()
        +TripleList~University, List~University~, List~University~~ letsGoErasmus(User)
    }

    class University {
        -String uniName
        -double monthlyCost
        -double costWithSharedAccommodation
        -String city
        -String bestPeriodToVisit
        -String countryLanguage
        +String getUniName()
        +double getMonthlyCost()
        +double getCostWithSharedAccommodation()
        +String getCity()
        +String getBestPeriodToVisit()
        +String getCountryLanguage()
        +void setPdfLink(String)
    }

    class CostOfLiving {
        -double amount
        +CostOfLiving(double)
        +double getAmount()
    }

    class Languages {
        -String lang
        +Languages(String)
        +String getLang()
    }

    class TripleList~T, U, V~ {
        -T first
        -U second
        -V third
        +TripleList(T, U, V)
        +T getFirst()
        +U getSecond()
        +V getThird()
    }

    class Countries {
        -String country
        +Countries(String)
        +String getCountry()
    }


```


# ΔΟΜΕΣ ΔΕΔΟΜΕΝΩΝ ΚΑΙ ΑΛΓΟΡΙΘΜΟΙ/ΜΕΘΟΔΟΙ

## Δομές Δεδομένων:
  Η εφαρμογή χρησιμοποιεί κυρίως λίστες ως δομές δεδομένων όπως τις:
  
  -List<String>: Χώρες και γλώσσες που γνωρίζει ο χρήστης.
    
  -List<University>: Πανεπιστήμια με πληροφορίες όπως κόστος, γλώσσα και περίοδος.
    
  -List<Languages>, List<Countries>: Γλώσσες και χώρες για τις διαθέσιμες επιλογές.
    
  Ακόμα η εφαρμογή αποτελείται και απο τις δομές δεδομένων:
  
  - TripleList η οποία είναι μια προσαρμοσμένη κλάση που αποθηκεύει τρεις διαφορετικές λίστες.
  
  - και την κλάση User που αποθηκεύει τις προτιμήσεις του χρήστη (γλώσσες, χώρες, κόστος, περίοδος,   
    κτλ.).

## Αλγόριθμοι/Μέθοδοι:
  Η κύρια μέθοδος της εφαρμογής, η letsGoErasmus, ελέγχει αν τα πανεπιστήμια ταιριάζουν με τις προτιμήσεις του χρήστη
  (χώρα, γλώσσα, κόστος, περίοδος) και τα κατηγοριοποιεί σε τρεις λίστες. Στην πρώτη εκχωρούνται τα πανεπιστήμια που
  ταιριάζουν με όλες τις προτιμήσεις του χρήστη, στην δεύτερη εκχωρούνται τα πανεπιστήμια που ταιριάζουν πλήρως εκτός απο
  την περίοδο και στην τρίτη λίστα εκχωρούνται τα πανεπιστήμια που ταιριάζουν με τις προτιμήσεις του χρήστη και ο χρήστης
  γνωρίζει αγγλικά και όχι την γλώσσα της συγκεκριμένης χώρας. Οι λίστες αυτές δημιουργήθηκαν για να απλοποιηθεί η
  διαδικασία ταξινόμησεις των πανεπιστημίων.

# Άδεια ανοιχτού κώδικα:

  Copyright (c) 2024-2025 DMSTPLUS
 
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
 
  [LICENSE](http://www.apache.org/licenses/LICENSE-2.0)


 
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
