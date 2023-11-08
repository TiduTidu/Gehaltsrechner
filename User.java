public class User {

    float bruttoLohn;
    int steuerKlasse;
    boolean kirchenSteuer;

    // Konstruktor für neuen User/Steuerzahler
    public User(float lohn, int steuerKlasse, boolean kirchenSteuer) {
        this.bruttoLohn = lohn;
        this.steuerKlasse = steuerKlasse;
        this.kirchenSteuer = kirchenSteuer;
    }
}
