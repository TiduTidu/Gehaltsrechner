import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Lohnsteuer {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);

        //#region Bruttolohn und Steuerklasse eingabe
        System.out.println("Lohnsteur rechner | Monatsgehalt");
        System.out.println("------------------------------");

        System.out.println("Bitte geben Sie ihren Lohn ein: ");
        int bruttoLohnEingabe = scanner.nextInt(); 

        System.out.println("Bitte geben Sie ihren Steuerklasse ein: (1-6)");
        int steuerKlasseEingabe = scanner.nextInt();
        scanner.close();

        User user = new User(bruttoLohnEingabe, steuerKlasseEingabe, 29, false, "AOK", "NRW", 0);
    
        User.setLohnSteuer(user);
    
        System.out.println(user.lohnSteuer);
        
    
    }
}