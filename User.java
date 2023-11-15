public class User {

    float bruttoLohn;
    int steuerKlasse;
    boolean kirchenSteuer;
    float lohnSteuer;

    // Konstruktor für neuen User/Steuerzahler
    public User(float lohn, int steuerKlasse, boolean kirchenSteuer) {
        this.bruttoLohn = lohn;
        this.steuerKlasse = steuerKlasse;
        this.kirchenSteuer = kirchenSteuer;
    }

    public float nettoBerechnen() {
        int[][] lohnsteuerTabelle = LohnsteuerTabelle.getLohnsteuerTabelle();

        for (int i = 0; i < lohnsteuerTabelle.length; i++) {
            int untereGrenze = lohnsteuerTabelle[i][0];
            int obereGrenze = (i < lohnsteuerTabelle.length - 1) ? lohnsteuerTabelle[i + 1][0] : Integer.MAX_VALUE;

            if (this.bruttoLohn >= untereGrenze && this.bruttoLohn <= obereGrenze) {
                if (this.steuerKlasse >= 1 && this.steuerKlasse <= 6) {
                    this.lohnSteuer = lohnsteuerTabelle[i][this.steuerKlasse];
                }
            }

        }
        return this.lohnSteuer;
    }
}
