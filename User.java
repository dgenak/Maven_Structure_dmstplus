import java.util.Scanner;
public class User {
        // Δημιουργία ενός αντικειμένου Scanner
    Scanner scanner = new Scanner(System.in); 
    public String foreignLanguages;
    public int referredPeriod;
        // Ρωτάει και διαβάζει τις ξένες γλώσσες που γνωρίζει ο φοιτητής
    System.out.println("Ποιές ξένες γλώσσες γνωρίζεις;");
    String foreignLanguage = scanner.nextLine();
        // Ρωτάει και διαβάζει τη περίοδο που προτιμάει να πάει ο φοιτητής (Χειμερινή περίοδο ή Εαρινή περίοδο) 
    System.out.println("Ποιά περίοδο θα προτιμούσες να πας: ΧΕΙΜΕΡΙΝΗ(1) ή ΕΑΡΙΝΗ(2);");
    Int preferredPeriod = scanner.nextLine();
    
}