import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lohnsteuer {
    public static void main(String[] args) throws IOException {
        
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Lohnsteur rechner | Monatsgehalt");
        System.out.println("------------------------------");
        System.out.println("Bitte geben Sie ihren Lohn ein:");
        
        String lohnStr = reader.readLine();
        int lohnInt = Integer.valueOf(lohnStr);
        
        
      
        


        //TODO: neuen User instanziieren mit den Werten der Eingabe, z.B:
        //User user = new User(lohnInt, 0, 0, false, null, null);
    }
}