public class User {

    int bruttoLohn;
    int steuerKlasse;
    int alter;
    boolean kirchenSteuer;
    String versicherung;
    String bundesland;
    int lohnSteuer;

    //Konstruktor für neuen User/Steuerzahler
    public User(int bruttoLohn, int steuerKlasse, int alter, boolean kirchenSteuer, String versicherung, String bundesland, int lohnSteuer)
    {
        this.bruttoLohn = bruttoLohn;
        this.steuerKlasse = steuerKlasse;
        this.alter = alter;
        this.kirchenSteuer = kirchenSteuer;
        this.versicherung = versicherung;
        this.bundesland = bundesland;
        this.lohnSteuer = lohnSteuer;

    }

    public static void setLohnSteuer(User user) {
        int[][] lohnsteuerTabelle = LohnsteuerTabelle.getLohnsteuerTabelle();

        for(int i = 0; i < lohnsteuerTabelle.length; i++) {
            int untereGrenze = lohnsteuerTabelle[i][0];
            int obereGrenze = (i < lohnsteuerTabelle.length - 1) ? lohnsteuerTabelle[i + 1][0] : Integer.MAX_VALUE;

            if(user.bruttoLohn >= untereGrenze && user.bruttoLohn <= obereGrenze) {
                if(user.steuerKlasse >= 1 && user.steuerKlasse <= 6) {
                    user.lohnSteuer = lohnsteuerTabelle[i][user.steuerKlasse];
                }
            }

        }
    }

}
