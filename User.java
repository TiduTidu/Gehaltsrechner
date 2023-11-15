public class User {

    float bruttoLohn;
    int steuerKlasse;
    boolean kirchenSteuer;
    float lohnSteuer;
    float kirchenAbzuege;
    float steuerfreiBezüge;

    // Konstruktor für neuen User/Steuerzahler
    public User(float lohn, int steuerKlasse, boolean kirchenSteuer, float steuerfreiBezüge) {
        this.bruttoLohn = lohn;
        this.steuerKlasse = steuerKlasse;
        this.kirchenSteuer = kirchenSteuer;
        this.steuerfreiBezüge = steuerfreiBezüge;
    }

    public float versicherungBerechnen() {
        float kv = (float) (this.bruttoLohn * 0.073);
        float rv = (float) (this.bruttoLohn * 0.093);
        float pv = (float) (this.bruttoLohn * 0.017);
        float alv = (float) (this.bruttoLohn * 0.013);
        return kv + rv + pv + alv;
    }

    public float nettoBerechnen() {
        int[][] lohnsteuerTabelle = LohnsteuerTabelle.getLohnsteuerTabelle();

        for (int i = 0; i < lohnsteuerTabelle.length; i++) {
            int untereGrenze = lohnsteuerTabelle[i][0];
            int obereGrenze = (i < lohnsteuerTabelle.length - 1) ? lohnsteuerTabelle[i + 1][0] : Integer.MAX_VALUE;

            if (this.bruttoLohn >= untereGrenze && this.bruttoLohn <= obereGrenze) {
                if (this.steuerKlasse >= 1 && this.steuerKlasse <= 6) {
                    if (this.kirchenSteuer) {
                        this.kirchenAbzuege = (float) (this.lohnSteuer * 0.09);
                    }
                    this.lohnSteuer = lohnsteuerTabelle[i][this.steuerKlasse];
                }
            }

        }
        return this.lohnSteuer;
    }
}
