import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MoscowTime {
    public static void main(String[] args) throws ParseException {

//        LocalDateTime berlin = LocalDateTime.parse("2002-01-01T23:55");
//        String zoneBerlin = "Europe/Berlin";
//        System.out.println(toMoscowTime(berlin, zoneBerlin));

//        Date date = Date.from(Instant.now());
//        System.out.println(Instant.now());
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.'SSS'Z'");
//        String s = simpleDateFormat.format(date);
//        System.out.println(s);
        instantToDate(Instant.now());


    }

    static LocalDateTime toMoscowTime(LocalDateTime localDateTime, String zoneName) {
        // enter your code

        return localDateTime.atZone(ZoneId.of(zoneName))
                .withZoneSameInstant(ZoneId.of("Europe/Moscow"))
                .toLocalDateTime();
    }

    static Date instantToDate(Instant instant) throws ParseException {

        System.out.println("instant is " + instant);
        Date date = Date.from(instant);
        System.out.println("date from instant is " + date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.'SSS'Z'");
        String s = simpleDateFormat.format(date);
        System.out.println("formatted date string is " + s);
        Date date1 = simpleDateFormat.parse(s);
        System.out.println("date is " + date1);
        return null;
    }

}
