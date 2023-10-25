public class User {

    int bruttoLohn;
    int steuerKlasse;
    int alter;
    boolean kirchenSteuer;
    String versicherung;
    String bundesland;
    


    //Konstruktor für neuen User/Steuerzahler
    public User(int bruttoLohn, int steuerKlasse, int alter, boolean kirchenSteuer, String versicherung, String bundesland)
    {
        this.bruttoLohn = bruttoLohn;
        this.steuerKlasse = steuerKlasse;
        this.alter = alter;
        this.kirchenSteuer = kirchenSteuer;
        this.versicherung = versicherung;
        this.bundesland = bundesland;
    }
}
