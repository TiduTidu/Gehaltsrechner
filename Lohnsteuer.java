import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lohnsteuer {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Lohnsteur rechner | Monatsgehalt");
        System.out.println("------------------------------");

        System.out.println("Bitte geben Sie ihren Lohn ein");

        String lohn = reader.readLine();
    }
}