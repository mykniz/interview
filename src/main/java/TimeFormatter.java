import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TimeFormatter {

    public static void main(String[] args) {

    }

    DateTimeFormatter format() {
        // enter your code
        return DateTimeFormatter.ofPattern("yyyy-'M'M-'W'W-E:kk:mm").localizedBy(Locale.UK);

    }

}
