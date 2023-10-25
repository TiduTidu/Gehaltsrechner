public class User {

    //Klassenvariablen
    private int bruttoLohn;
    private int steuerKlasse;
    private int alter;
    private boolean kirchenSteuer;
    private String versicherung;
    private String bundesland;
    


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

     // Getters
     public int getBruttoLohn() {
        return bruttoLohn;
    }

    public int getSteuerKlasse() {
        return steuerKlasse;
    }

    public int getAlter() {
        return alter;
    }

    public boolean isKirchenSteuer() {
        return kirchenSteuer;
    }

    public String getVersicherung() {
        return versicherung;
    }

    public String getBundesland() {
        return bundesland;
    }

    // Setters
    public void setBruttoLohn(int bruttoLohn) {
        this.bruttoLohn = bruttoLohn;
    }

    public void setSteuerKlasse(int steuerKlasse) {
        this.steuerKlasse = steuerKlasse;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public void setKirchenSteuer(boolean kirchenSteuer) {
        this.kirchenSteuer = kirchenSteuer;
    }

    public void setVersicherung(String versicherung) {
        this.versicherung = versicherung;
    }

    public void setBundesland(String bundesland) {
        this.bundesland = bundesland;
    }
}
