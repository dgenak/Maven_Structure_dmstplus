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
        universities.add(new University("Hasselt University", "Belgium", "Hasselt", 1000, 500.0, "French", "Spring"));
        universities.add(new University("University of Antwerpen", "Belgium", "Antwerp", 1050, 550.0, "French", "Spring"));
        universities.add(new University("University of Cyprus", "Cyprus", "Nicosia", 850, 350.0, "Greek", "Spring"));
        universities.add(new University("University of Nicosia", "Cyprus", "Nicosia", 850, 350.0, "Greek", "Spring"));
        universities.add(new University("Cyprus University of Technology", "Cyprus", "Limassol", 1000, 500.0, "Greek", "Spring"));
        universities.add(new University("University of Southern Denmark", "Denmark", "Odense", 1250, 0, "Danish", "Spring"));
        universities.add(new University("Abo Akademi University", "Finland", "Turku", 1000, 400.0, "Finnish", "Winter"));
        universities.add(new University("Lahti University of Applied Sciences - LUT University - Lahti Campus", "Finland", "Lahti", 900, 0, "Finnish", "Winter"));
        universities.add(new University("University of Vaasa", "Finland", "Vaasa", 900, 0, "Finnish", "Winter"));
        universities.add(new University("University of Jyvaskyla", "Finland", "Jyvaskyla", 900, 0, "Finnish", "Winter"));
        universities.add(new University("Audencia Group - Audencia Nantes School of Management", "France", "Nantes", 1000, 500.0, "French", "Spring"));
        universities.add(new University("ESC DIJON BOURGOGNE BSB/ Burgundy School of Business", "France", "Dijon", 900, 400.0, "French", "Spring"));
        universities.add(new University("University of Clermont Auvergne", "France", "Clermont-Ferrand", 850, 0, "French", "Spring"));
        universities.add(new University("Universite Paris Nanterre", "France", "Nanterre (Paris)", 1250, 700.0, "French", "Spring"));
        universities.add(new University("Universite de Strasbourg Ecole de Management Strasbourg - EM Strasbourg Business School", "France", "Strasbourg", 1000, 0, "French", "Spring"));
        universities.add(new University("Institut d'Etudes Politique 'Sciences Po Toulouse'", "France", "Toulouse", 1000, 500.0, "French", "Spring"));
        universities.add(new University("University of Tours", "France", "Tours", 900, 0, "French", "Spring"));
        universities.add(new University("SKEMA Business School", "France", "Sophia Antipolis", 1100, 0, "French", "Spring"));
        universities.add(new University("University of Cologne", "Germany", "Cologne", 1050, 500.0, "German", "Spring"));
        universities.add(new University("University of Mannheim", "Germany", "Mannheim", 1000, 0, "German", "Spring"));
        universities.add(new University("Philipps-University Marburg", "Germany", "Marburg", 850, 0, "German", "Spring"));
        universities.add(new University("University of Siegen", "Germany", "Siegen", 850, 0, "German", "Spring"));
        universities.add(new University("Technische Univeristat Hamburg - Hamburg TUHH", "Germany", "Hamburg", 1200, 0, "German", "Spring"));
        universities.add(new University("Technische Univeristat Munchen", "Germany", "Munich", 1400, 700.0, "German", "Spring"));
        universities.add(new University("Univeristat ULM", "Germany", "Ulm", 950, 0, "German", "Spring"));
        universities.add(new University("Technische Univeristat Dortmund", "Germany", "Dortmund", 950, 0, "German", "Spring"));
        universities.add(new University("Universität Hamburg", "Germany", "Hamburg", 900, 0, "German", "Spring"));
        universities.add(new University("SRH Hochshule Berlin - The International Management University", "Germany", "Berlin", 1150, 0, "German", "Spring"));
        universities.add(new University("Univeristat Koblenz", "Germany", "Koblenz", 950, 450.0, "German", "Spring"));
        universities.add(new University("Univeristat of Munster, School of Business and Economics", "Germany", "Munster", 1050, 0, "German", "Spring"));
        universities.add(new University("Universita degli Studi di Catania", "Italy", "Catania", 700, 300.0, "Italian", "Spring"));
        universities.add(new University("Universita degli Studi di Pavia - University of Pavia", "Italy", "Pavia", 850, 400.0, "Italian", "Spring"));
        universities.add(new University("Universita Cattolica del Sacro Cuore", "Italy", "Milan", 1150, 600.0, "Italian", "Spring"));
        universities.add(new University("Universita degli Studi di Torino", "Italy", "Turin", 850, 0, "Italian", "Spring"));
        universities.add(new University("The Hague University of Applied Sciences - ESCM European Studies", "Netherlands", "The Hague", 1200, 600.0, "Dutch", "Spring"));
        universities.add(new University("BI - Norwegian Business School", "Norway", "Oslo", 1500, 0, "Norwegian", "Winter"));
        universities.add(new University("Norwegian School of Economics - NHH", "Norway", "Bergen", 1350, 0, "Norwegian", "Winter"));
        universities.add(new University("Instituto Politecnico Da Guarda (IPG)", "Portugal", "Guarda", 600, 0, "Portuguese", "Spring"));
        universities.add(new University("Univerzita Pavla Jozefa Safarika v Kosiciach", "Slovakia", "Kosice", 600, 250.0, "Slovak", "Spring"));
        universities.add(new University("Stockholm University - Stockholm Business School", "Sweden", "Stockholm", 1300, 650.0, "Swedish", "Spring"));
        universities.add(new University("Linnaeus University", "Sweden", "Vaxjo", 1000, 500.0, "Swedish", "Spring"));
        universities.add(new University("Kristianstad University", "Sweden", "Kalmar", 1000, 0, "Swedish", "Spring"));
        universities.add(new University("Sodertorn University", "Sweden", "Kristianstad", 1000, 500.0, "Swedish", "Spring"));
        // Λίστα languages που περιέχει όλες τις γλώσσες των συνεργαζόμεων χωρών
        languages.add(new Languages("French"));
        languages.add(new Languages("Greek"));
        languages.add(new Languages("Danish"));
        languages.add(new Languages("Finnish"));
        languages.add(new Languages("German"));
        languages.add(new Languages("Italian"));
        languages.add(new Languages("Dutch"));
        languages.add(new Languages("Norwegian"));
        languages.add(new Languages("Portuguese"));
        languages.add(new Languages("Slovak"));
        languages.add(new Languages("Swedish"));
        
        // Λίστα countries που περιέχει όλες τις συνεργαζόμενες χώρες
        countries.add(new Countries("Belgium"));
        countries.add(new Countries("Cyprus"));
        countries.add(new Countries("Denmark"));
        countries.add(new Countries("Finland"));
        countries.add(new Countries("France"));
        countries.add(new Countries("Germany"));
        countries.add(new Countries("Italy"));
        countries.add(new Countries("Netherlands"));
        countries.add(new Countries("Norway"));
        countries.add(new Countries("Portugal"));
        countries.add(new Countries("Slovakia"));
        countries.add(new Countries("Sweden"));

        // Λίστα με τις επιλογές του user ως μέγιστο ποσό δαπάνης ανά μήνα
        costpermonth.add(new CostOfLiving(250.00));
        costpermonth.add(new CostOfLiving(500.00));
        costpermonth.add(new CostOfLiving(750.00));
        costpermonth.add(new CostOfLiving(1000.00));
        costpermonth.add(new CostOfLiving(1250.00));
        costpermonth.add(new CostOfLiving(1500.00));
    }

    // Μέθοδος για να επιστρέψουμε την λίστα των χωρών
    public List<String> getCountries() {
        List<String> countryNames = new ArrayList<>();
        for (Countries country : countries) {
            countryNames.add(country.getCountry()); // Παίρνουμε το όνομα της χώρας
        }
        return countryNames;
    }

    // Μέθοδος για να επιστρέψουμε την λίστα των γλωσσών
    public List<String> getLang() {
        List<String> ulang = new ArrayList<>();
        for (Languages lang : languages) {
            ulang.add(lang.getLang());
        }
        return ulang;
    }

        // Μέθοδος για να επιστρέψουμε την λίστα των πανεπιστημίων
    public List<University> getUniversities() {
        return universities;
    }

    // Μέθοδος για να επιστρέψουμε την λίστα του κόστους διαβίωσης
    public List<CostOfLiving> getAmount() {
        return costpermonth;
    }


    public List<String> letsGoErasmus(User user) {
        // Στη λίστα uni_match θα αποθηκεύονται τα πανεπιστήμια που ταιριάζουν με κάθε user
        List<String> uni_match = new ArrayList<>();
        
        for (University university : universities) {
            boolean is_it_a_match = true;
            // Εδώ ελέγχουμε αν ο user γνωρίζει τη γλώσσα της συγκεκριμένης χώρας
            if (!user.getUserslanguages().contains(university.getCountrysLang())) {
                is_it_a_match = false;
            }

            // Εδώ ελέγχουμε αν το συγκεκριμένο πανεπιστήμιο βρίσκεται στη χώρα που επιθυμεί ο user
            if (!user.getPreferredCountry().contains(university.getCountry())) {
                is_it_a_match = false;
            }

            if (user.getSharedAccomondation()) {
                // Εδώ ελέγχουμε αν διατίθεται ο user να δαπανά το μηνιαίο μέσο κόστος ζωής (με συγκατοίκηση) της συγκεκριμένης πόλης 
                if ((university.getCostWithSh_Accomondation() == 0.0) && (user.getMaxMonthlyCost() < university.getCostWithSh_Accomondation())) {
                    is_it_a_match = false;
                }
            } else {
                // Εδώ ελέγχουμε αν διατίθεται ο user να δαπανά το μηνιαίο μέσο κόστος ζωής της συγκεκριμένης πόλης 
                if (user.getMaxMonthlyCost() < university.getMonthlyCost()) {
                    is_it_a_match = false;
                }
            }
            /*
             * Ελέγχουμε αν το getcostWith_Accomondation είναι ίσο με 0 γιατί τότε σημαίνει πως δεν βρήκαμε το μηνιαίο μέσο κόστος 
             * ζωής για εκείνη τη πόλη 
             */
            // Τέλος αν το πανεπιστήμιο πληρεί τις προϋποθέσεις του user τότε το αποθηκεύουμε στη λίστα uni_match
            if (is_it_a_match) {
                uni_match.add(university.getUniName());
            }
            
        }
        return uni_match;
    }
}