package com.dmstplus;

import java.util.ArrayList;
import java.util.List;

public class UniData {
    
    // Δημιουργία της λίστας των πανεπιστημίων και των στατικών πληροφοριών τους
    private List<University> universities = new ArrayList<>();
    private List<Languages> languages = new ArrayList<>();
    private List<Countries> countries = new ArrayList<>();
    private List<CostOfLiving> costpermonth = new ArrayList<>();

    // Εκχώρηση των πληροφοριών στη βάση δεδομένων
    public UniData() {
        // Λίστα universities με όλα τα πανεπιστήμια και τις πληροφορίες τους
        universities.add(new University(1, "Hasselt University", "Belgium", "Hasselt", 1000, 500.0, "French", "Spring"));
        universities.add(new University(2, "University of Antwerpen", "Belgium", "Antwerp", 1050, 550.0, "French", "Spring"));
        universities.add(new University(3, "University of Cyprus", "Cyprus", "Nicosia", 850, 350.0, "Greek", "Spring"));
        universities.add(new University(4, "University of Nicosia", "Cyprus", "Nicosia", 850, 350.0, "Greek", "Spring"));
        universities.add(new University(5, "Cyprus University of Technology", "Cyprus", "Limassol", 1000, 500.0, "Greek", "Spring"));
        universities.add(new University(6, "University of Southern Denmark", "Denmark", "Odense", 1250, null, "Danish", "Spring"));
        universities.add(new University(7, "Abo Akademi University", "Finland", "Turku", 1000, 400.0, "Finnish", "Winter"));
        universities.add(new University(8, "Lahti University of Applied Sciences - LUT University - Lahti Campus", "Finland", "Lahti", 900, null, "Finnish", "Winter"));
        universities.add(new University(9, "University of Vaasa", "Finland", "Vaasa", 900, null, "Finnish", "Winter"));
        universities.add(new University(10, "University of Jyvaskyla", "Finland", "Jyvaskyla", 900, null, "Finnish", "Winter"));
        universities.add(new University(11, "Audencia Group - Audencia Nantes School of Management", "France", "Nantes", 1000, 500.0, "French", "Spring"));
        universities.add(new University(12, "ESC DIJON BOURGOGNE BSB/ Burgundy School of Business", "France", "Dijon", 900, 400.0, "French", "Spring"));
        universities.add(new University(13, "University of Clermont Auvergne", "France", "Clermont-Ferrand", 850, null, "French", "Spring"));
        universities.add(new University(14, "Universite Paris Nanterre", "France", "Nanterre (Paris)", 1250, 700.0, "French", "Spring"));
        universities.add(new University(15, "Universite de Strasbourg Ecole de Management Strasbourg - EM Strasbourg Business School", "France", "Strasbourg", 1000, null, "French", "Spring"));
        universities.add(new University(16, "Institut d'Etudes Politique 'Sciences Po Toulouse'", "France", "Toulouse", 1000, 500.0, "French", "Spring"));
        universities.add(new University(17, "University of Tours", "France", "Tours", 900, null, "French", "Spring"));
        universities.add(new University(18, "SKEMA Business School", "France", "Sophia Antipolis", 1100, null, "French", "Spring"));
        universities.add(new University(19, "University of Cologne", "Germany", "Cologne", 1050, 500.0, "German", "Spring"));
        universities.add(new University(20, "University of Mannheim", "Germany", "Mannheim", 1000, null, "German", "Spring"));
        universities.add(new University(21, "Philipps-University Marburg", "Germany", "Marburg", 850, null, "German", "Spring"));
        universities.add(new University(22, "University of Siegen", "Germany", "Siegen", 850, null, "German", "Spring"));
        universities.add(new University(23, "Technische Univeristat Hamburg - Hamburg TUHH", "Germany", "Hamburg", 1200, null, "German", "Spring"));
        universities.add(new University(24, "Technische Univeristat Munchen", "Germany", "Munich", 1400, 700.0, "German", "Spring"));
        universities.add(new University(25, "Univeristat ULM", "Germany", "Ulm", 950, null, "German", "Spring"));
        universities.add(new University(26, "Technische Univeristat Dortmund", "Germany", "Dortmund", 950, null, "German", "Spring"));
        universities.add(new University(27, "Universität Hamburg", "Germany", "Hamburg", 900, null, "German", "Spring"));
        universities.add(new University(28, "SRH Hochshule Berlin - The International Management University", "Germany", "Berlin", 1150, null, "German", "Spring"));
        universities.add(new University(29, "Univeristat Koblenz", "Germany", "Koblenz", 950, 450.0, "German", "Spring"));
        universities.add(new University(30, "Univeristat of Munster, School of Business and Economics", "Germany", "Munster", 1050, null, "German", "Spring"));
        universities.add(new University(31, "Universita degli Studi di Catania", "Italy", "Catania", 700, 300.0, "Italian", "Spring"));
        universities.add(new University(32, "Universita degli Studi di Pavia - University of Pavia", "Italy", "Pavia", 850, 400.0, "Italian", "Spring"));
        universities.add(new University(33, "Universita Cattolica del Sacro Cuore", "Italy", "Milan", 1150, 600.0, "Italian", "Spring"));
        universities.add(new University(34, "Universita degli Studi di Torino", "Italy", "Turin", 850, null, "Italian", "Spring"));
        universities.add(new University(35, "The Hague University of Applied Sciences - ESCM European Studies", "Netherlands", "The Hague", 1200, 600.0, "Dutch", "Spring"));
        universities.add(new University(36, "BI - Norwegian Business School", "Norway", "Oslo", 1500, null, "Norwegian", "Winter"));
        universities.add(new University(37, "Norwegian School of Economics - NHH", "Norway", "Bergen", 1350, null, "Norwegian", "Winter"));
        universities.add(new University(38, "Instituto Politecnico Da Guarda (IPG)", "Portugal", "Guarda", 600, null, "Portuguese", "Spring"));
        universities.add(new University(39, "Univerzita Pavla Jozefa Safarika v Kosiciach", "Slovakia", "Kosice", 600, 250.0, "Slovak", "Spring"));
        universities.add(new University(40, "Stockholm University - Stockholm Business School", "Sweden", "Stockholm", 1300, 650.0, "Swedish", "Spring"));
        universities.add(new University(41, "Linnaeus University", "Sweden", "Vaxjo", 1000, 500.0, "Swedish", "Spring"));
        universities.add(new University(42, "Kristianstad University", "Sweden", "Kalmar", 1000, null, "Swedish", "Spring"));
        universities.add(new University(43, "Sodertorn University", "Sweden", "Kristianstad", 1000, 500.0, "Swedish", "Spring"));
        // Λίστα languages που περιέχει όλες τις γλώσσες των συνεργαζόμεων χωρών
        languages.add(new Languages(French));
        languages.add(new Languages(Greek));
        languages.add(new Languages(Danish));
        languages.add(new Languages(Finnish));
        languages.add(new Languages(German));
        languages.add(new Languages(Italian));
        languages.add(new Languages(Dutch));
        languages.add(new Languages(Norwegian));
        languages.add(new Languages(Portuguese));
        languages.add(new Languages(Slovak));
        languages.add(new Languages(Swedish));
        // Λίστα countries που περιέχει όλες τις συνεργαζόμενες χώρες
        countries.add(new Countries(Belgium));
        countries.add(new Countries(Cyprus));
        countries.add(new Countries(Denmark));
        countries.add(new Countries(Finland));
        countries.add(new Countries(France));
        countries.add(new Countries(Germany));
        countries.add(new Countries(Germany));
        countries.add(new Countries(Italy));
        countries.add(new Countries(Netherlands));
        countries.add(new Countries(Norway));
        countries.add(new Countries(Portugal));
        countries.add(new Countries(Slovakia));
        countries.add(new Countries(Sweden));
        // Λίστα με τις επιλογές του user ως μέγιστο ποσό δαπάνης ανά μήνα
        costpermonth.add(new CostOfLiving(250.00));
        costpermonth.add(new CostOfLiving(500.00))
        costpermonth.add(new CostOfLiving(750.00))
        costpermonth.add(new CostOfLiving(1000.00))
        costpermonth.add(new CostOfLiving(1250.00))
        costpermonth.add(new CostOfLiving(1500.00))
    }
    

    public List<University> letsGoErasmus(User user) {
        // Στη λίστα uni_match θα αποθηκεύονται τα πανεπιστήμια που ταιριάζουν με κάθε user
        List<University> uni_match = new ArrayList<>();
        private boolean is_it_a_match = true;
        for (University university : universities) {
            int pl = 0;

            // Εδώ ελέγχουμε αν ο user γνωρίζει τη γλώσσα της συγκεκριμένης χώρας
            if (user.getuserslanguages().contains(university.getcountrysLanguage())) {
                is_it_a_match = false;
            }

            // Εδώ ελέγχουμε αν το συγκεκριμένο πανεπιστήμιο βρίσκεται στη χώρα που επιθυμεί ο user
            if ( user.getpreferredCountry().equals(university.getcountry())) {
                is_it_a_match = false;
            }

            if (university.getSharedAccomondation()) {
                // Εδώ ελέγχουμε αν διατίθεται ο user να δαπανά το μηνιαίο μέσο κόστος ζωής (με συγκατοίκηση) της συγκεκριμένης πόλης 
                if ((university.getcostWithSh_Accommondation() != null) && (user.getmaxMonthlyCost() <= university.getcostWithSh_Accommondation())) {
                    is_it_a_match = false;
                }
            } else {
                // Εδώ ελέγχουμε αν διατίθεται ο user να δαπανά το μηνιαίο μέσο κόστος ζωής της συγκεκριμένης πόλης 
                if (user.getmaxMonthlyCost() <= university.getmonthlyCost()) {
                    is_it_a_match = false;
                }
            }

            // Δεν χρειάζεται να ελέγχουμε κάθε στήλη της λίστας αν θα επιστρέψει null
            // γιατί ξέρουμε απο την βάση δεδομένων πως μόνο στη στήλη "costWithSh_Accommondation" υπάρχουν null τιμές 

            // Τέλος αν το πανεπιστήμιο πληρεί τις προϋποθέσεις του user τότε το αποθηκεύουμε στη λίστα uni_match
            if (is_it_a_match) {
                uni_match.add(university);
            }
            
        }
        return uni_match;
    }
}