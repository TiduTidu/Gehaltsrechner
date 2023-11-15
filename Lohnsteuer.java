import java.io.IOException;
import java.util.Scanner;

public class Lohnsteuer {
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        System.out.println("Lohnsteuer rechner | Jahresgehalt");
        System.out.println("------------------------------");
        System.out.println("Bitte geben Sie ihren Lohn ein");
        float lohn = Float.parseFloat(reader.nextLine());
        System.out.println("Bitte geben Sie ihre Steuerklasse ein");
        int sk = Integer.parseInt(reader.nextLine());
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
                System.out.println("nochmal ");
                boolean repeat = true;

                while (repeat) {
                    System.out.println("ja/nein");
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
        System.out.println("- Ihre Lohnsteuer beträgt: " + String.valueOf(abzuege) + " €");
        if (kirche) {
            System.out.println("- Ihre Kirchensteuer beträgt: " + String.valueOf(user.kirchenAbzuege) + " €");
        }
        System.out
                .println("- Ihre Sozialversicherungsbeiträge betragen: " + String.valueOf(versicherungsAbzuege) + " €");
        System.out.println("------------------------------");
        System.out.println("Ihr Nettolohn beträgt: "
                + String.valueOf(lohn - abzuege - user.kirchenAbzuege - versicherungsAbzuege) + " €");
        reader.close();
    }

}
