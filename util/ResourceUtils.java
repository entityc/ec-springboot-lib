package ${domain.namespace};

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Locale;

public class ResourceUtils {

    private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
    private static SimpleDateFormat altFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    private static SimpleDateFormat alt2Formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

    public static int defaultTo(Integer value, int defaultValue) {
        return value == null ? defaultValue : value;
    }
    public static boolean defaultTo(Boolean value, boolean defaultValue) {
        return value == null ? defaultValue : value;
    }

    public static Date ParseDateString(String dateString) throws ParseException {
        Date date = null;
        try {
            date = formatter.parse(dateString);
        } catch (ParseException e) {
            try {
                date = altFormatter.parse(dateString);
            } catch (ParseException e2) {
                date = alt2Formatter.parse(dateString);
            }
        }
        return date;
    }
}
