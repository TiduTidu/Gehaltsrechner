package com.c3c2;

import java.util.Scanner;



public class Main {
        public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Utils utils = new Utils();
        utils.log("Lohnsteuer rechner | Jahresgehalt");
        utils.divider();
        utils.log("Bitte geben Sie ihren Bruttolohn ein:");
        String lohnString = reader.nextLine();
        Validator.validate("^\\d+(\\.\\d{2})?$", lohnString, "Fehler: Bitte geben Sie eine Zahl ein");
        float lohn = Float.parseFloat(lohnString);
        utils.log("Bitte geben Sie ihre Steuerklasse ein: ");
        String skString = reader.nextLine();
        Validator.validate("^[1-6]$", skString, "Fehler: Bitte geben Sie eine Zahl von 1 bis 6 ein.");
        int sk = Integer.parseInt(skString);
        utils.log("Sind Sie Mitglied einer Kirche? (ja/nein): ");
        String kircheStr = reader.nextLine();
        boolean kirche = determineKircheSteuer(kircheStr, utils, reader);
        utils.divider();
        User user = new User(lohn, sk, kirche);
        float abzuege = user.nettoBerechnen();
        float[] versicherungsAbzuegeArray = user.versicherungBerechnen();
        float versicherungsAbzuege = 0;
        for (float f : versicherungsAbzuegeArray) {
            versicherungsAbzuege += f;
        }
        if (kirche) {
            System.out.println("- Ihre Kirchensteuer beträgt: " + Utils.currFormat(user.kirchenAbzuege));
        }
        utils.log("Sozialversicherungsbeiträge:");
        utils.log("- Krankenversicherung: " + Utils.currFormat(versicherungsAbzuegeArray[0]));
        utils.log("- Rentenversicherung: " + Utils.currFormat(versicherungsAbzuegeArray[1]));
        utils.log("- Pflegeversicherung: " + Utils.currFormat(versicherungsAbzuegeArray[2]));
        utils.log("- Arbeitslosenversicherung: " +  versicherungsAbzuegeArray[3]);
        utils.divider();
        utils.log("- Ihre Lohnsteuer beträgt: " + Utils.currFormat(abzuege));
        utils.log("- Ihre Sozialversicherungsbeiträge betragen insgesamt: " + Utils.currFormat(versicherungsAbzuege));
        utils.divider();
        utils.log("Ihr Nettolohn beträgt: " + Utils.currFormat(lohn - abzuege - user.kirchenAbzuege - versicherungsAbzuege));
        reader.close();


        PdfWriter.write(lohn, versicherungsAbzuegeArray, abzuege, versicherungsAbzuege,lohn - abzuege - user.kirchenAbzuege - versicherungsAbzuege);
    }


    public static boolean determineKircheSteuer(String kircheStr, Utils utils, Scanner reader) {
        boolean kirche = false;
        switch (kircheStr) {
            case "ja":
                kirche = true;
                break;

            case "nein":
                kirche = false;
                break;

            default:
                utils.log("Versuchen Sie es nochmal");
                boolean repeat = true;

                while (repeat) {
                    utils.log("Bitte geben Sie 'ja' oder 'nein' ein.");
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
        return kirche;
    }

}