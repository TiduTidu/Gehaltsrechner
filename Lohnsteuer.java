import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Lohnsteuer {
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        System.out.println("Lohnsteuer rechner | Jahresgehalt");
        System.out.println("------------------------------");
        System.out.println("Bitte geben Sie ihren Lohn ein");
        String lohnString = reader.nextLine();
        Validator.validate("^\\d+(\\.\\d{2})?$", lohnString, "Fehler: Bitte geben Sie eine Zahl ein");
        float lohn = Float.parseFloat(lohnString);
        System.out.println("Bitte geben Sie ihre Steuerklasse ein");
        String skString = reader.nextLine();
        Validator.validate("^[1-6]$", skString, "Fehler: Bitte geben Sie eine Zahl von 1 bis 6 ein.");
        int sk = Integer.parseInt(skString);
        System.out.println("Sind Sie Mitglied einer Kirche? (ja/nein)");
        String kircheStr = reader.nextLine();
        boolean kirche = false;
        switch (kircheStr) {
            case "ja":
                kirche = true;
                break;

            case "nein":
                kirche = false;
                break;

            default:
                System.out.println("Versuchen Sie es nochmal");
                boolean repeat = true;

                while (repeat) {
                    System.out.println("Bitte geben Sie 'ja' oder 'nein' ein.");
                    kircheStr = reader.nextLine();

                    switch (kircheStr) {
                        case "ja":
                            kirche = true;
                            repeat = false;
                            break;

                        case "nein":
                            kirche = repeat = false;
                            break;
                        default:
                            repeat = true;
                    }
                }
                break;

        }

        User user = new User(lohn, sk, kirche);
        float abzuege = user.nettoBerechnen();
        float versicherungsAbzuege = user.versicherungBerechnen();
        System.out.println("- Ihre Lohnsteuer beträgt: " + String.format(Locale.GERMAN, "%.2f", abzuege) + " €");
        if (kirche) {
            System.out.println("- Ihre Kirchensteuer beträgt: "
                    + String.format(Locale.GERMAN, "%.2f", user.kirchenAbzuege) + " €");
        }
        System.out
                .println("- Ihre Sozialversicherungsbeiträge betragen: "
                        + String.format(Locale.GERMAN, "%.2f", versicherungsAbzuege) + " €");
        System.out.println("------------------------------");
        System.out.println("Ihr Nettolohn beträgt: "
                + String.format(Locale.GERMAN, "%.2f", lohn - abzuege - user.kirchenAbzuege - versicherungsAbzuege)
                + " €");
        reader.close();
    }

}
