import java.util.Locale;

public class Utils {
    public String EURO = " \u20ac";
    public void log(String message) {
        System.out.println(message);
    }
    public void divider() {
        this.log("------------------------------");
    }
    public String currFormat(float value) {
        return String.format(Locale.GERMAN, "%.2f", value) + EURO;
    }
}
